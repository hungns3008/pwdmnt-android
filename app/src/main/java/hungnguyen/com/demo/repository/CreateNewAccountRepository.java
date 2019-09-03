package hungnguyen.com.demo.repository;

import android.arch.lifecycle.MutableLiveData;
import android.text.TextUtils;

import javax.inject.Inject;

import hungnguyen.com.demo.db.AccountDao;
import hungnguyen.com.demo.entity.Account;
import hungnguyen.com.demo.entity.Status;
import hungnguyen.com.demo.executor.AppExecutors;

public class CreateNewAccountRepository {
    AppExecutors appExecutors;
    AccountDao accountDao;

    @Inject
    public CreateNewAccountRepository(AppExecutors executors, AccountDao accountDao) {
        this.appExecutors = executors;
        this.accountDao = accountDao;
    }

    public MutableLiveData<Status> createNewUser(String title, String username, String password) {
        MutableLiveData<Status> result = new MutableLiveData<>();

        appExecutors.diskIO().execute(() -> {
            // process data
            Status status = processData(title, username, password);
            if (status.isSuccess()) {
                Account account = new Account();
                account.setTitle(title);
                account.setUsername(username);
                account.setPassword(password);

                accountDao.insert(account);
            }

            result.postValue(status);
        });

        return result;
    }

    public Status processData(String title, String username, String password) {
        Status status = new Status(false, null);

        if (TextUtils.isEmpty(title)) {
            status.setError("Title cannot be empty");

            return status;
        }

        if (TextUtils.isEmpty(username)) {
            status.setError("Username cannot be empty");
            return status;
        }

        if (TextUtils.isEmpty(password)) {
            status.setError("Password cannot be empty");
            return status;
        }

        Account account = accountDao.getAccountByTitleAndUsername(title, username);
        if (account != null) {
            status.setError("Username: " + username + " on " + title + " was existed\n Please fill another account");

            return status;
        }

        status.setSuccess(true);
        return status;
    }
}

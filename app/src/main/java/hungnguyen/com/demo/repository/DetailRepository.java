package hungnguyen.com.demo.repository;

import android.arch.lifecycle.LiveData;

import javax.inject.Inject;
import javax.inject.Singleton;

import hungnguyen.com.demo.db.AccountDao;
import hungnguyen.com.demo.entity.Account;
import hungnguyen.com.demo.executor.AppExecutors;

@Singleton
public class DetailRepository {
    AppExecutors executors;
    AccountDao accountDao;

    @Inject
    public DetailRepository(AppExecutors executors, AccountDao accountDao) {
        this.executors = executors;
        this.accountDao = accountDao;
    }

    public LiveData<Account> getAccountByID(long id) {
        return accountDao.getAccountByID(id);
    }
}

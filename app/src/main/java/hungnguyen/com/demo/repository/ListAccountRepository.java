package hungnguyen.com.demo.repository;

import android.arch.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import hungnguyen.com.demo.db.AccountDao;
import hungnguyen.com.demo.entity.Account;
import hungnguyen.com.demo.executor.AppExecutors;

@Singleton
public class ListAccountRepository {
    AppExecutors executors;
    AccountDao accountDao;

    @Inject
    public ListAccountRepository(AppExecutors executors, AccountDao accountDao) {
        this.executors = executors;
        this.accountDao = accountDao;
    }

    public LiveData<List<Account>> getListAccounts() {
        return accountDao.getListAccount();
    }
}



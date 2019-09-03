package hungnguyen.com.demo.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import hungnguyen.com.demo.entity.Account;
import hungnguyen.com.demo.repository.ListAccountRepository;

public class ListAccountViewModel extends ViewModel {
    ListAccountRepository repository;

    @Inject
    ListAccountViewModel(ListAccountRepository repository) {
        this.repository = repository;
    }

    public LiveData<List<Account>> getListAccounts() {
        return repository.getListAccounts();
    }
}

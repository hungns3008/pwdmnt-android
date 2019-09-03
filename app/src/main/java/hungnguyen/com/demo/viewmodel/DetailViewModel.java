package hungnguyen.com.demo.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import hungnguyen.com.demo.entity.Account;
import hungnguyen.com.demo.repository.DetailRepository;

public class DetailViewModel extends ViewModel {
    DetailRepository repository;

    @Inject
    public DetailViewModel(DetailRepository repository) {
        this.repository = repository;
    }

    public LiveData<Account> getAccount(long id) {
        return repository.getAccountByID(id);
    }
}

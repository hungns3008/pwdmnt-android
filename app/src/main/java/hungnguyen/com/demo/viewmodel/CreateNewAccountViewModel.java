package hungnguyen.com.demo.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hungnguyen.com.demo.entity.Status;
import hungnguyen.com.demo.repository.CreateNewAccountRepository;

public class CreateNewAccountViewModel extends ViewModel {
    CreateNewAccountRepository repository;
    MutableLiveData<List<String>> liveDataParams = new MutableLiveData<>();
    LiveData<Status> liveDataStatus = new MutableLiveData<>();

    @Inject
    CreateNewAccountViewModel(CreateNewAccountRepository repository) {
        this.repository = repository;
        liveDataStatus = Transformations.switchMap(liveDataParams, params -> {
           String title = params.get(0);
           String username = params.get(1);
           String password = params.get(2);

           return repository.createNewUser(title, username, password);
        });
    }

    public void createNewAccount(String title, String username, String password) {
        List<String> params = new ArrayList<>();
        params.add(title);
        params.add(username);
        params.add(password);

        liveDataParams.setValue(params);
    }

    public LiveData<Status> getLiveDataStatus() {
        return liveDataStatus;
    }
}

package hungnguyen.com.demo.fragment;

import android.arch.lifecycle.ViewModel;
import hungnguyen.com.demo.repository.SplashRepository;
import javax.inject.Inject;

public class SplashViewModel extends ViewModel {
  // TODO: Implement the ViewModel
  SplashRepository repository;

  @Inject
  public SplashViewModel(SplashRepository repository) {
    this.repository = repository;
  }
}

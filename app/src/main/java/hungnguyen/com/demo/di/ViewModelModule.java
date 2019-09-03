package hungnguyen.com.demo.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import hungnguyen.com.demo.fragment.SplashViewModel;
import hungnguyen.com.demo.viewmodel.AppViewModelFactory;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import hungnguyen.com.demo.viewmodel.CreateNewAccountViewModel;
import hungnguyen.com.demo.viewmodel.DetailViewModel;
import hungnguyen.com.demo.viewmodel.ListAccountViewModel;

@Module
abstract class ViewModelModule {
  @Binds
  abstract ViewModelProvider.Factory bindViewModelFactory(AppViewModelFactory factory);

  @Binds
  @IntoMap
  @ViewModelKey(SplashViewModel.class)
  abstract ViewModel bindSplashViewModel(SplashViewModel splashViewModel);

  @Binds
  @IntoMap
  @ViewModelKey(ListAccountViewModel.class)
  abstract ViewModel bindListAccountViewModel(ListAccountViewModel listAccountViewModel);

  @Binds
  @IntoMap
  @ViewModelKey(CreateNewAccountViewModel.class)
  abstract ViewModel bindCreateNewAccountViewModel(CreateNewAccountViewModel createNewAccountViewModel);

  @Binds
  @IntoMap
  @ViewModelKey(DetailViewModel.class)
  abstract ViewModel bindDetailViewModel(DetailViewModel detailViewModel);
}

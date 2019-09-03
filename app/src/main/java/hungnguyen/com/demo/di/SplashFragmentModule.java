package hungnguyen.com.demo.di;

import hungnguyen.com.demo.fragment.SplashFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class SplashFragmentModule {
  @ContributesAndroidInjector
  abstract SplashFragment contributeSplashFragment();
}

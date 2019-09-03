package hungnguyen.com.demo.di;

import hungnguyen.com.demo.activity.SplashActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class SplashModule {
  @ContributesAndroidInjector(modules = SplashFragmentModule.class)
  abstract SplashActivity contributeSplashActivity();
}

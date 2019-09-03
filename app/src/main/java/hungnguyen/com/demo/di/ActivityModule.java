package hungnguyen.com.demo.di;

import hungnguyen.com.demo.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {
  @ContributesAndroidInjector(modules = FragmentBuilderModule.class)
  abstract MainActivity contributeActivity();
}

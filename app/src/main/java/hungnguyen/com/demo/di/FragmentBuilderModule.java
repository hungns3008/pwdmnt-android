package hungnguyen.com.demo.di;

import hungnguyen.com.demo.fragment.CreateNewAccountFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import hungnguyen.com.demo.fragment.DetailFragment;
import hungnguyen.com.demo.fragment.ListAccountFragment;

@Module
public abstract class FragmentBuilderModule {
  @ContributesAndroidInjector
  abstract ListAccountFragment contributeListAccountFragment();

  @ContributesAndroidInjector
  abstract CreateNewAccountFragment contributeCreateNewAccountFragment();

  @ContributesAndroidInjector
  abstract DetailFragment contributeDetailFragment();
}

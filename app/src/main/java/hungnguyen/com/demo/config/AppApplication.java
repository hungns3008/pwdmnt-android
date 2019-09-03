package hungnguyen.com.demo.config;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.ProcessLifecycleOwner;
import hungnguyen.com.demo.di.AppInjector;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import javax.inject.Inject;

public class AppApplication extends Application implements HasActivityInjector, LifecycleObserver {
  @Inject
  DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;


  private static AppApplication application;

  public static AppApplication getInstance() {
    return application;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    AppInjector.init(this);

    application = this;

    ProcessLifecycleOwner.get().getLifecycle().addObserver(this);

  }

  @Override
  public AndroidInjector<Activity> activityInjector() {
    return activityDispatchingAndroidInjector;
  }
}


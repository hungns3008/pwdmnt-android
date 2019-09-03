package hungnguyen.com.demo.di;

import android.app.Application;
import hungnguyen.com.demo.config.AppApplication;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import javax.inject.Singleton;

@Singleton
@Component(modules = {
    AndroidInjectionModule.class,
    AppModule.class,
    ActivityModule.class,
    SplashModule.class
})
public interface AppComponent {
  @Component.Builder
  interface Builder {
    @BindsInstance
    Builder application(Application application);

    AppComponent build();
  }

  void inject(AppApplication app);
}


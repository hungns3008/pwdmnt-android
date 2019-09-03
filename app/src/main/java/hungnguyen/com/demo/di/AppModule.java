package hungnguyen.com.demo.di;

import android.app.Application;
import android.arch.persistence.room.Room;

import hungnguyen.com.demo.db.AccountDao;
import hungnguyen.com.demo.db.AppDB;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module(includes = ViewModelModule.class)
class AppModule {
  @Singleton
  @Provides
  AppDB provideDb(Application app) {
    return Room.databaseBuilder(app, AppDB.class, "app.db")
        .fallbackToDestructiveMigration()
        .build();
  }

  @Singleton
  @Provides
  AccountDao accountDao(AppDB db) {
    return db.accountDao();
  }
}

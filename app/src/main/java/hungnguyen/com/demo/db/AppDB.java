package hungnguyen.com.demo.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import hungnguyen.com.demo.entity.Account;

@Database(entities = {Account.class}, version = 1, exportSchema = true)
public abstract class AppDB extends RoomDatabase {
  abstract public AccountDao accountDao();
}

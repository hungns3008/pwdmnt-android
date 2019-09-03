package hungnguyen.com.demo.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import hungnguyen.com.demo.entity.Account;

@Dao
public abstract class AccountDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insert(Account account);

    @Query("SELECT * FROM Account ORDER BY id")
    public abstract LiveData<List<Account>> getListAccount();

    @Query("SELECT * FROM Account WHERE id = :id")
    public abstract LiveData<Account> getAccountByID(long id);

    @Query("SELECT * FROM Account WHERE title = :title AND username = :username")
    public abstract Account getAccountByTitleAndUsername(String title, String username);
}

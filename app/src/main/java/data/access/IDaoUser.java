package data.access;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import repository.User;
@Dao
public interface IDaoUser {


        @Query("SELECT * FROM user")
        List<User> getAll();

        @Query("SELECT * FROM user WHERE USER_ID IN (:userIds)")
        List<User> loadAllByIds(int[] userIds);

        @Query("SELECT * FROM user WHERE user_name LIKE :first ")
        User findByName(String first);

        @Insert
        void insertAll(User... users);

        @Delete
        void delete(User user);

}

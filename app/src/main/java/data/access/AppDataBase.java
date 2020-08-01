package data.access;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import repository.GoldPackage;
import repository.User;

@Database(entities = {User.class, GoldPackage.class},  version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract IDaoUser userDao();
}

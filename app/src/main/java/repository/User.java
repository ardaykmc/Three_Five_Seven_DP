package repository;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

@Entity(primaryKeys = "USER_ID")
public class User implements IUser {

    @NonNull private String USER_ID ;
    @ColumnInfo(name = "user_name")
    private String userName ;
    @Embedded
    private GoldPackage goldPackage ;

    public void setGoldPackage(GoldPackage goldPackage) {
        this.goldPackage = goldPackage;
    }

    @ColumnInfo(name = "status")
    private boolean status;
    @Override
    public String getUSER_ID() {
        return this.USER_ID;
    }

    @Override
    public String getUserName() {
        return this.userName;
    }



    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public void setUSER_ID(String userId) {
        this.USER_ID = userId;
    }

    @Override
    public GoldPackage getGoldPackage() {
        return this.goldPackage;
    }

    @Override
    public boolean isStatus() {
        return status;
    }

    @Override
    public void setStatus(boolean status) {
        this.status = status;
    }

    //Constructor for create new user
    public User(String userName,boolean status){
        this.USER_ID = Build.ID;
        this.userName = userName;
        this.status = status ;
        Gold golden = new Gold();
        GoldPackage goldPackage = new GoldPackage(golden);
        this.goldPackage = goldPackage; //initially number of Gold is zero
    }
    //Object Constructor
    @Ignore
    public User(IUser user){
        this.USER_ID = user.getUSER_ID();
        this.userName = user.getUserName();
        this.goldPackage = user.getGoldPackage();
        this.status = user.isStatus();
    }

    /**
     * Empty constructor
     */
    @Ignore
    public User(){
    }
    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == null){
            return false;
        }else if (!(obj instanceof IUser )){
            return false;
        }else{
            IUser usr = (IUser) obj;
            return usr.getUSER_ID() == this.USER_ID;
        }
    }

    @NonNull
    @Override
    public String toString() {
        String name = this.userName;
        return  name;
    }
}

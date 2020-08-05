package repository;

import android.os.Build;


public class User implements IUser {

    private String USER_ID ;

    private String userName ;

    private GoldPackage goldPackage ;

    public void setGoldPackage(GoldPackage goldPackage) {
        this.goldPackage = goldPackage;
    }


    private boolean status;

    public String getUSER_ID() {
        return this.USER_ID;
    }


    public String getUserName() {
        return this.userName;
    }




    public void setUserName(String userName) {
        this.userName = userName;
    }


    public void setUSER_ID(String userId) {
        this.USER_ID = userId;
    }


    public GoldPackage getGoldPackage() {
        return this.goldPackage;
    }


    public boolean isStatus() {
        return status;
    }


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

    public User(IUser user){
        this.USER_ID = user.getUSER_ID();
        this.userName = user.getUserName();
        this.goldPackage = user.getGoldPackage();
        this.status = user.isStatus();
    }

    /**
     * Empty constructor
     */

    public User(){
    }
    @Override
    public boolean equals( Object obj) {
        if (obj == null){
            return false;
        }else if (!(obj instanceof IUser )){
            return false;
        }else{
            IUser usr = (IUser) obj;
            return usr.getUSER_ID() == this.USER_ID;
        }
    }


    @Override
    public String toString() {
        String name = this.userName;
        return  name;
    }
}

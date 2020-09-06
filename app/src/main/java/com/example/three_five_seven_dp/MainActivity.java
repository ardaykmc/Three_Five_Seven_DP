package com.example.three_five_seven_dp;

import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import data.access.*;
import game.LayoutCreator;
import helper.BoardReader;
import repository.IUser;
import repository.User;

public class MainActivity extends AppCompatActivity {

    private DBManager dbManager;

    boolean isSign = true;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbManager = new DBManager(this);
    }

    /**
     * Redirect user to sign up page if not already registered otherwise redirect to game page
     */
    @Override
    protected void onStart() {
        super.onStart();
        try {
            dbManager.open();
            Cursor cursor = dbManager.fetch();
            IUser user = new User("first user",false);
            //dbManager.insert(user.getUserName(),"first guy");
            cursor.moveToLast();
            dbManager.close();
            if (cursor.getString(1) == null || cursor.getString(1) == ""){
                Log.d("My App","false");
            }else{
                Log.d("My App","true");
            }
            Log.d("My App",cursor.getString(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

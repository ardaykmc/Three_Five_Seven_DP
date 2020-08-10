package com.example.three_five_seven_dp;

import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;


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


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User user = new User("arda ", true);
        try {
            LayoutCreator layoutCreator = new LayoutCreator("test.txt",this);
            List<List> result  = layoutCreator.separate();
            for (List<Integer> lstdegr : result){
                Log.d("MY APP", lstdegr.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("MY APP","qwe");
        }

    }

}

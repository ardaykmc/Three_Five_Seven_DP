package com.example.three_five_seven_dp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;


import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;


import java.sql.SQLException;
import java.util.List;

import data.access.*;
import repository.IUser;
import repository.User;

public class MainActivity extends AppCompatActivity {

    private DBManager dbManager;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User user = new User("arda ", true);


    }

}

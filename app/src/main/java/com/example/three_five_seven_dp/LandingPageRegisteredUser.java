package com.example.three_five_seven_dp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FlingAnimation;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Interpolator;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import animation.AnimationProvider;
import data.access.DBManager;

public class LandingPageRegisteredUser extends AppCompatActivity {
    private float height ;
    private float width ;
    private TextView textView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page_registered_user);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels;
        width = displayMetrics.widthPixels;
        textView = (TextView) findViewById(R.id.editTextUserName);
        button = (Button) findViewById(R.id.buttonRegister);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onStart() {
        super.onStart();
        DBManager dbManager = new DBManager(this);
        try {
            dbManager.open();
            dbManager.insert(textView.getText().toString(),"100","0","0","0");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onResume() {
        super.onResume();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMapScreen();
            }
        });

    }
    private void openMapScreen(){
        Intent intent = new Intent(this,MapSelectionScreen.class);
        startActivity(intent);
    }

}

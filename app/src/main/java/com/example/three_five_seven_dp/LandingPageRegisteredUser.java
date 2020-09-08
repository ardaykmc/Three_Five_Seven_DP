    package com.example.three_five_seven_dp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.Button;

import animation.AnimationProvider;

    public class LandingPageRegisteredUser extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page_registered_user);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onResume() {
        View view =findViewById(R.id.btn1);
        Button button = (Button) view;
        Path path = new Path();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        float height = displayMetrics.heightPixels;
        float width = displayMetrics.widthPixels;
        AnimationProvider.rectangularMove(button,path,width-200,height-300,-30,0,15,15, Path.Direction.CCW,8000);
        AnimationProvider.rotatingViews(button,button.getPivotX(),button.getPivotY());
        super.onResume();
    }

}

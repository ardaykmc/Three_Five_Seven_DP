package com.example.three_five_seven_dp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LandingPageUnRegisteredUser extends AppCompatActivity {
    private Button button ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page_un_registered_user);
        button = findViewById(R.id.buttonStartGame);
    }

    @Override
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

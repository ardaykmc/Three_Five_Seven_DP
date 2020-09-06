package com.example.three_five_seven_dp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import game.Box;

public class testact extends AppCompatActivity {
private List<Box> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testact);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"connected rd succesfully",Toast.LENGTH_LONG).show();
    }

    public List<Box> getList() {
        return list;
    }
}

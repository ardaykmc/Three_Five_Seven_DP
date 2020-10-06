package com.example.three_five_seven_dp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import game.Box;
import game.Layout;
import game.LayoutCreator;

public class GameBoard extends AppCompatActivity {
    private Layout layout;
    private AssetManager assetManager;
    private List<List<Box>> layoutList;
    private String filePath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board);

        try {
            layout = new Layout("test.txt",this);


        } catch (IOException e) {
            e.printStackTrace();
        }
        layoutList = layout.getLayoutList();
        Toast.makeText(this,layoutList.get(1).get(0).toString(),Toast.LENGTH_LONG).show();
    }
}

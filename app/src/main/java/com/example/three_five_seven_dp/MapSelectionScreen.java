package com.example.three_five_seven_dp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import RecyclerViewModel.MapsAdapter;


public class MapSelectionScreen extends AppCompatActivity {
    RecyclerView recyclerView;
    MapsAdapter adapter;
    int[] images = {R.drawable.spanish,R.drawable.mars_landscape_alien_planet_martian_background_107791_781};
    String[] desc= {"spani","martian"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_selection_screen);

        recyclerView = findViewById(R.id.recyclerview);
        adapter = new MapsAdapter(this,desc,images);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();


    }
}

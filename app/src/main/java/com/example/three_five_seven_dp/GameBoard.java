package com.example.three_five_seven_dp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.icu.text.PluralRules;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import RecyclerViewModel.CardAdapter;
import game.Box;
import game.Card;
import game.Layout;
import game.LayoutCreator;
import game.Player;
import game.Referee;
import game.rules.IRule;
import game.rules.LeastOneBoxRule;
import game.rules.NotToBeEmptyRule;
import game.rules.Rule;
import game.rules.SameRawRule;

public class GameBoard extends AppCompatActivity {
    private Layout layout;
    private AssetManager assetManager;
    private List<List<Box>> layoutList;
    private String filePath;
    private LinearLayout linearLayoutRoot;
    private LinearLayout linearLayout;
    private RecyclerView recyclerView;
    private CardAdapter adapter;
    private RecyclerView recyclerViewPlayer;
    private CardAdapter adapterPlayer;
    private List<IRule> rulesList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board);
        int[] logos = {R.drawable.italy,R.drawable.turkey};
        int[] logosSecond = {R.drawable.spanish,R.drawable.sweden};
        String[] names = {"cardname","spanish"};
        String[] namesSecond = {"italy"  , "deutchland"};
        try {
            layout = new Layout("test.txt",this);


        } catch (IOException e) {
            e.printStackTrace();
        }
        layoutList = layout.getLayoutList();

        recyclerView = (RecyclerView) findViewById(R.id.recOpponent);
        adapter = new CardAdapter(this,logos,logosSecond ,names,namesSecond);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewPlayer = findViewById(R.id.playerrec);
        adapterPlayer = new CardAdapter(this,logos,logosSecond,names,namesSecond);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recyclerViewPlayer.setLayoutManager(layoutManager1);
        recyclerViewPlayer.setAdapter(adapterPlayer);
    }

    @Override
    protected void onStart() {
        super.onStart();
        setButtons();
        this.setRules();
        Player player1 = null;
        Player player2 = null;
        Referee referee = new Referee(rulesList,this,player1,player2,layout);


    }
    //set the game object
    private void setButtons(){
        linearLayoutRoot = (LinearLayout) findViewById(R.id.gamePlace);
        linearLayoutRoot.measure(View.MeasureSpec.UNSPECIFIED,View.MeasureSpec.UNSPECIFIED);

        for (List<Box> listBox : this.layoutList) {
            LinearLayout asp = new LinearLayout(this);
            asp.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            asp.setOrientation(LinearLayout.HORIZONTAL);

            linearLayoutRoot.addView(asp);
            asp.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
            int totalWidth = asp.getMeasuredWidth();
            float rowWeight = 1 / 2;
            int columnWidth = totalWidth / listBox.size();
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(columnWidth,
                    LinearLayout.LayoutParams.MATCH_PARENT, 1.0f);
            for (Box box : listBox) {

                if (box == null){
                    TextView textView = new TextView(this);
                    textView.setLayoutParams(params);
                    asp.addView(textView);
                }else{
                    Button button = new Button(this);
                    button.setLayoutParams(params);
                    float point = box.getPoint();

                    asp.addView(button);
                }

            }

        }
    }

    /**
     * Initialize the rules and add them to rule list
     */
    private void setRules(){
        IRule leastOneBox = new LeastOneBoxRule();
        IRule sameRawRule = new SameRawRule();
        IRule notToBeEmptyRule = new NotToBeEmptyRule();
        this.rulesList.add(leastOneBox);
        this.rulesList.add(sameRawRule);
        this.rulesList.add(notToBeEmptyRule);
    }
}

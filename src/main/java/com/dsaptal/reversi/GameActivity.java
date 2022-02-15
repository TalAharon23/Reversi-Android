package com.dsaptal.reversi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import java.util.Timer;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Timer timer = new Timer();
        GameUpdateTimer ut = new GameUpdateTimer();
        ut.boardView = (GameView) this.findViewById(R.id.view);
        timer.schedule(ut, 200, 200);
        View.OnTouchListener TouchListener = new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                float x = event.getX();
                float y = event.getY();
                return true;
            }
        };
    }
}

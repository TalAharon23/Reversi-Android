package com.dsaptal.reversi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        new Thread() { public void run() {
            try {
                synchronized (this) {
                    wait(3700);
                    Intent intent = new Intent(FirstActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                    finish();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }.start();
    }
}
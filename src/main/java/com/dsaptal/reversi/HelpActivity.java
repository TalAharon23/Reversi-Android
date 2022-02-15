package com.dsaptal.reversi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ScrollView;

public class HelpActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        ScrollView scrollView = new ScrollView(this);

    }
}

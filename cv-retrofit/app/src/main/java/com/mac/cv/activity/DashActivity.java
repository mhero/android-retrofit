package com.mac.cv.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mac.cv.R;

public class DashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);

    }

    public void onClickBtn(View v) {
        Intent myIntent = new Intent(DashActivity.this, MainActivity.class);
        DashActivity.this.startActivity(myIntent);
    }
}

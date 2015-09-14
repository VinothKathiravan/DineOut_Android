package com.vinoth.dineout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class Register extends AppCompatActivity {

    Toolbar _toolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        _toolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(_toolBar);

    }


}

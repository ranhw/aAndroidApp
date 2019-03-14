package com.example.ranhaowen.hellowworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(), "onCreat()", Toast.LENGTH_SHORT).show();
    }

    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(), "onCreat()", Toast.LENGTH_SHORT).show();
    }
}
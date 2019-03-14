package com.example.ranhaowen.hellowworld;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;

public class LoopActivity extends AppCompatActivity {

    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loops);
        Toast.makeText(getApplicationContext(), "onCreat()", Toast.LENGTH_SHORT).show();
        button2 = (Button)findViewById(R.id.button1);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(LoopActivity.this,MainActivity.class);
                startActivityForResult(it,0x123);
                setContentView(R.layout.activity_main);
            }
        });
        Toast.makeText(getApplicationContext(), "onStart()", Toast.LENGTH_SHORT).show();
    }
}
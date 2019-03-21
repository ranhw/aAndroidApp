package com.example.ranhaowen.hellowworld;

import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;

import static java.lang.System.exit;

public class LoopActivity extends AppCompatActivity {

    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loops);
        Toast.makeText(getApplicationContext(), "onCreat()", Toast.LENGTH_SHORT).show();
        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(LoopActivity.this,MainActivity.class);
                startActivityForResult(it,0x111);
                finish();
                setContentView(R.layout.activity_main);
                Toast.makeText(getApplicationContext(), "onResume()", Toast.LENGTH_SHORT).show();
            }
        });
        Toast.makeText(getApplicationContext(), "onStart()", Toast.LENGTH_SHORT).show();
    }

    // 定义一个变量，来标识是否退出
    private static boolean isExit = false;
    Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (!isExit) {
                isExit = true;
                mHandler.sendEmptyMessageDelayed(0, 2000);
            } else {
                exit(R.layout.activity_loops);
                Toast.makeText(getApplicationContext(), "onDestory()", Toast.LENGTH_SHORT).show();
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);}
}
package com.example.ranhaowen.hellowworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.os.Handler;
import android.os.Message;
import android.os.Handler;

import static java.lang.System.exit;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "[hello]MainActivity: ";

    private Button btnchoose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d (TAG, " onCreate in");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(), "onCreat()", Toast.LENGTH_SHORT).show();
        Log.d (TAG, " onCreate out");
        btnchoose = (Button)findViewById(R.id.btnchoose);
        Log.d (TAG, " Click in");
        btnchoose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this,LoopActivity.class);
                startActivityForResult(it,0x123);
                setContentView(R.layout.activity_loops);
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
                Toast.makeText(getApplicationContext(), "再按一次退出程序",
                        Toast.LENGTH_SHORT).show();
                mHandler.sendEmptyMessageDelayed(0, 2000);
            } else {
                exit(R.layout.activity_main);
                Toast.makeText(getApplicationContext(), "onDestory()", Toast.LENGTH_SHORT).show();
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);}
}
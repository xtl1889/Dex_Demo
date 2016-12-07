package com.example.lee.dex_demo;

import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    private Button mBt;
    private TextView mTv;
    private CountDownTimer mCountDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mBt= (Button) findViewById(R.id.bt);
        mTv= (TextView) findViewById(R.id.tv);

        startTime();
        mBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TimeActivity.class));
            }
        });


    }

    private void startTime(){
        mCountDownTimer=new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTv.setText(String.valueOf(millisUntilFinished/1000));
                Log.e("Time", "onTick: -----"+(millisUntilFinished/1000) );
            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this,"finish",Toast.LENGTH_SHORT).show();
            }
        };
    }
}

package com.example.lee.dex_demo;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.UUID;

/*
* 定时器
* */
public class TimeActivity extends AppCompatActivity {

    private TextView tv_time;
    private Button bt_time,toOtherPage;

    private CountDownTimer mCountDownTimer;

    private int i,n;

    private long mStartTime=3000;
    private long mRandTime=1000;
    private long mSurplusTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        initView();
    }

    private void initView() {
        tv_time= (TextView) findViewById(R.id.tv_time);
        bt_time= (Button) findViewById(R.id.bt_time);
        toOtherPage= (Button) findViewById(R.id.toOtherPage);
        toOtherPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TimeActivity.this, Main2Activity.class));
            }
        });

    }

    private void startTime(){
        mCountDownTimer=new CountDownTimer(mStartTime,mRandTime) {
            @Override
            public void onTick(long millisUntilFinished) {
//                Log.e("time", "onTick: -----"+millisUntilFinished);
//                mSurplusTime=millisUntilFinished;
//                tv_time.setText("---"+(i++)+"---");
            }

            @Override
            public void onFinish() {
                Toast.makeText(TimeActivity.this,"--"+(n++)+"--",Toast.LENGTH_SHORT).show();
                Log.e("time", "onFinish: ----" + n);
                mStartTime=3000;
                mCountDownTimer.start();
            }
        }.start();

//        UUID uuid= TelephonyManager.
    }

    @Override
    protected void onResume() {
        super.onResume();
        startTime();

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mCountDownTimer!=null){
            mCountDownTimer.cancel();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}

package com.mars.android20180110_1;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Handler handler;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler();
        tv = findViewById(R.id.textView);
        //實作thread
        MyThread t = new MyThread();
        //啟動thread
        t.start();

    }
    //自己建立一個thread
    class MyThread extends Thread
    {
        @Override
        public void run() {
            super.run();
            //無窮迴圈
            while(true)
            {
                //暫停一秒
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //呼叫handler.post 做裡面的事情
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText(String.valueOf(Integer.valueOf(tv.getText().toString())+1));
                    }
                });

            }
        }
    }

}

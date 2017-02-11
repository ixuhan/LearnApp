package com.ixuhan.learnapp.welcome;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.ixuhan.learnapp.R;

/**
 * Created by hank on 2017/2/10 0010.
 */

public class Second_Welcome_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //隐藏状态栏
        //定义全屏参数
        int flag= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //获得当前窗体对象
        Window window=Second_Welcome_Activity.this.getWindow();
        //设置当前窗体为全屏显示
        window.setFlags(flag, flag);
        setContentView(R.layout.second_welcome_layout);

        new Thread(new SleepMethod()).start();
    }

    // handler类接收数据
    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 3:
                    Intent intent = new Intent();
                    intent.setClass(Second_Welcome_Activity.this, Third_Welcome_Activity.class);
                    startActivity(intent);
                    Second_Welcome_Activity.this.finish();//结束当前的activity
                    break;
                default:
                    TextView textView = (TextView) findViewById(R.id.time);
                    textView.setText((3-Integer.valueOf(msg.what))+"s");
                    break;
            }
        }
    };

    class SleepMethod implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 0; i <= 3; i++) {
                    Thread.sleep(1000);
                    Message msg = new Message();
                    msg.what = i;
                    handler.sendMessage(msg);
                }
                System.out.println("send...");
            } catch (Exception e) {
                System.out.println("暂停出错!");
            }
        }
    }

    //第三种方式(Android1.6版本及以后的版本中提供了)
    public void BtnJumpOnClick(View view){
        Intent intent = new Intent();
        intent.setClass(Second_Welcome_Activity.this, Third_Welcome_Activity.class);
        startActivity(intent);
        Second_Welcome_Activity.this.finish();//结束当前的activity
    }

}

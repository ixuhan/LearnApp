package com.ixuhan.learnapp.welcome;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.ixuhan.learnapp.R;
import com.ixuhan.learnapp.body.Main_Body_Activity;

import java.io.IOException;

/**
 * Created by hank on 2017/2/10 0010.
 */

public class Third_Welcome_Activity extends AppCompatActivity {
    private long exitTime = 0;
    private SurfaceView surfaceview;
    private Button btnGo;
    private MediaPlayer mediaPlayer;
    private int postion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //隐藏状态栏
        //定义全屏参数
        int flag= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //获得当前窗体对象
        Window window=Third_Welcome_Activity.this.getWindow();
        //设置当前窗体为全屏显示
        window.setFlags(flag, flag);
        setContentView(R.layout.third_welcome_layout);

        findViewById();
        initView();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-exitTime) > 2000){
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void findViewById() {
        // TODO Auto-generated method stub
        surfaceview = (SurfaceView) findViewById(R.id.surfaceView);
    }

    protected void initView() {
        // TODO Auto-generated method stub
        mediaPlayer = new MediaPlayer();
        surfaceview.getHolder().setKeepScreenOn(true);
        surfaceview.getHolder().addCallback(new SurfaceViewLis());
    }

    private class SurfaceViewLis implements SurfaceHolder.Callback {

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width,
                                   int height) {

        }

        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            if (postion == 0) {
                try {
                    play();
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (SecurityException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalStateException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {

        }

    }

    public void play() throws IllegalArgumentException, SecurityException,
            IllegalStateException, IOException {
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        AssetFileDescriptor fd = this.getAssets().openFd("start.mp4");
        mediaPlayer.setDataSource(fd.getFileDescriptor(), fd.getStartOffset(),
                fd.getLength());
        mediaPlayer.setLooping(true);
        mediaPlayer.setDisplay(surfaceview.getHolder());
        // 通过异步的方式装载媒体资源
        mediaPlayer.prepareAsync();
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                // 装载完毕回调
                mediaPlayer.start();
            }
        });
    }

    //第三种方式(Android1.6版本及以后的版本中提供了)
    public void IntoMain(View view){
        Intent intent = new Intent();
        intent.setClass(Third_Welcome_Activity.this, Main_Body_Activity.class);
        startActivity(intent);
        Third_Welcome_Activity.this.finish();//结束当前的activity
    }

}

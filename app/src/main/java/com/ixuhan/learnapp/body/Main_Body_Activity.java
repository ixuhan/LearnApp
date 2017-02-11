package com.ixuhan.learnapp.body;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.ixuhan.learnapp.R;

/**
 * Created by hank on 2017/2/10 0010.
 */

public class Main_Body_Activity extends AppCompatActivity {
    //private PullToRefreshView mPullToRefreshView;
    private VideoView videoView ;
    private VideoView videoView2 ;
    private VideoView videoView3 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_body_layout);

        /*mPullToRefreshView = (PullToRefreshView) findViewById(R.id.pull_to_refresh);
        mPullToRefreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPullToRefreshView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPullToRefreshView.setRefreshing(false);
                        Toast.makeText(Main_Body_Activity.this, "已全部更新", Toast.LENGTH_SHORT).show();
                    }
                }, 2000);
            }
        });*/

        //网络视频
        String videoUrl2 = "http://xiaoer.ixuhan.cn/1483975372425.mp4";
        Uri uri = Uri.parse( videoUrl2 );
        videoView = (VideoView)this.findViewById(R.id.videoView );
        //设置视频控制器
        videoView.setMediaController(new MediaController(this));
        //播放完成回调
        videoView.setOnCompletionListener( new MyPlayerOnCompletionListener());
        //设置视频路径
        videoView.setVideoURI(uri);
        //开始播放视频
        //videoView.start();
        videoView.requestFocus();

        //网络视频
        String videoUrl3 = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";
        uri = Uri.parse( videoUrl3 );
        videoView = (VideoView)this.findViewById(R.id.videoView2 );
        //设置视频控制器
        videoView.setMediaController(new MediaController(this));
        //播放完成回调
        videoView.setOnCompletionListener( new MyPlayerOnCompletionListener());
        //设置视频路径
        videoView.setVideoURI(uri);
        //开始播放视频
        //videoView.start();
        videoView.requestFocus();
    }

    class MyPlayerOnCompletionListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mp) {
            Toast.makeText( Main_Body_Activity.this, "播放完成了", Toast.LENGTH_SHORT).show();
        }
    }


}

package com.ixuhan.learnapp.body;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ixuhan.learnapp.R;

/**
 * Created by hank on 2017/2/10 0010.
 */

public class Main_Body_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_body_layout);

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            Toast.makeText(this, "延时系统内部错误", Toast.LENGTH_SHORT).show();
        }
    }


}

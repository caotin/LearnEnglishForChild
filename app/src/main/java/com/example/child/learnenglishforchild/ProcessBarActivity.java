package com.example.child.learnenglishforchild;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;

public class ProcessBarActivity extends AppCompatActivity {
    ProgressBar progressBar;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process_bar);
        progressBar=(ProgressBar) findViewById(R.id.pb_count);


    }

    public void startAnimation(View view) {
        ObjectAnimator progressAnimator = ObjectAnimator.ofInt(progressBar, "progress", 100, 0);
        progressAnimator.setDuration(30000);
        progressAnimator.setInterpolator(new LinearInterpolator());
        progressAnimator.start();
    }
}

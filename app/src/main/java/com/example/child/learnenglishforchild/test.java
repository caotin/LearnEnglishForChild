package com.example.child.learnenglishforchild;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class test extends AppCompatActivity {
    ImageAdapter imageAdapter;
    ArrayAdapter<ImageAdapter> arrayAdapter;
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        gridView=findViewById(R.id.gv_play);


        gridView.setAdapter(new ImageAdapter(this));

//        imageView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//
//                final int actionPeformed = motionEvent.getAction();
//                switch(actionPeformed){
//                    case MotionEvent.ACTION_DOWN:{
//                        imageView.setImageResource(R.drawable.background);
//                        break;
//                    }
//
//                    case MotionEvent.ACTION_UP:{
//                        imageView.setImageResource(R.drawable.back);
//                        break;
//                    }
//                }
//                return false;
//            }
//        });
    }




}

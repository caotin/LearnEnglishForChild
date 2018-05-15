package com.example.child.learnenglishforchild;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class SelectTopicActivity extends AppCompatActivity {
    ArrayList<Topic> topics=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_topic);
    }
    private void init(){

    }
}

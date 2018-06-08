package com.example.child.learnenglishforchild;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class SelectTopicActivity extends AppCompatActivity {
    ArrayList<Topic> topics=new ArrayList<>();

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_topic);

        init();
        listView=findViewById(R.id.lv_topic);
        listView.setAdapter(new TopicAdapter(SelectTopicActivity.this,topics));

    }
    private void init(){
        topics.add(new Topic(R.drawable.cow,"Animal",1));
        topics.add(new Topic(R.drawable.cow,"Job",2));
        topics.add(new Topic(R.drawable.cow,"Fruit",3));
        topics.add(new Topic(R.drawable.cow,"Items",4));

    }
}

package com.example.child.learnenglishforchild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class TopicActivity extends AppCompatActivity {
    ArrayList<Topic> topics=new ArrayList<>();

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        init();
        listView=findViewById(R.id.lv_topic);
        listView.setAdapter(new TopicAdapter(TopicActivity.this,topics));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(TopicActivity.this,PlayActivity.class);
                intent.putExtra("idTopic",position);
                startActivity(intent);
            }
        });
    }
    private void init(){
        topics.add(new Topic(R.drawable.cow,"Animal",1));
        topics.add(new Topic(R.drawable.cow,"Job",2));
        topics.add(new Topic(R.drawable.cow,"Fruit",3));
        topics.add(new Topic(R.drawable.cow,"Items",4));

    }
}

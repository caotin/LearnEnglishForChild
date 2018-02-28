package com.example.child.learnenglishforchild;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    FloatingActionButton fab_setting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab_setting=(FloatingActionButton) findViewById(R.id.btnSetting);
        fab_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Ban da chon",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

package com.example.child.learnenglishforchild;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import android.app.AlertDialog;

public class MainActivity extends AppCompatActivity {


    FloatingActionButton fab_setting;
    FloatingActionButton fab_sound;
    FloatingActionButton fab_music;
    FloatingActionButton fab_start;
    Button btnGuide;
    Button btnScore;
    Button btnExit;
    boolean showhide=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        btnGuide= (Button) findViewById(R.id.btnGuide);
        btnScore= (Button) findViewById(R.id.btnScore);
        btnExit= (Button) findViewById(R.id.btnExit);

        fab_setting=(FloatingActionButton) findViewById(R.id.btnSetting);
        fab_sound=(FloatingActionButton) findViewById(R.id.btnSound);
        fab_music=(FloatingActionButton) findViewById(R.id.btnMusic);
        fab_start=(FloatingActionButton) findViewById(R.id.btnStart);
        hideButton();

        btnGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }

        });
        fab_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,activity_play.class);
                startActivity(intent);
            }
        });

        fab_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (showhide==false){
                    hideButton();

                }else{
                    showButton();

                }

            }
        });
    }
    private void hideButton(){
        fab_sound.hide();
        fab_music.hide();
        showhide=true;
    }
    private void showButton(){
        fab_sound.show();
        fab_music.show();
        showhide=false;
    }
    public void openDialog() {
        AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(
                MainActivity.this);

        alertDialog2.setTitle("Confirm Delete...");

        alertDialog2.setMessage("Are you sure you want delete this file?");

        alertDialog2.setPositiveButton("YES",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),
                                "You clicked on YES", Toast.LENGTH_SHORT)
                                .show();
                    }
                });

        alertDialog2.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),
                                "You clicked on NO", Toast.LENGTH_SHORT)
                                .show();
                        dialog.cancel();
                    }
                });

        alertDialog2.show();
    }
}

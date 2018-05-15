package com.example.child.learnenglishforchild;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import android.app.AlertDialog;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {





    FloatingActionButton fab_setting;
    FloatingActionButton fab_sound;
    FloatingActionButton fab_music;
    FloatingActionButton fab_start;
    Button btnGuide;
    Button btnScore;
    Button btnExit;
    boolean showhide=false;
    MediaPlayer mediaPlayer;
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
        fab_sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
                builder
                        .setContentTitle("Title")
                        .setContentText("content")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setVisibility(NotificationCompat.VISIBILITY_PUBLIC);
            }
        });
        btnGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }

        });
        fab_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,PlayActivity.class);
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
        fab_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                    Toast.makeText(MainActivity.this, "Music: disabled", Toast.LENGTH_SHORT).show();
                }

                else
                    playAudio();
            }
        });

        playAudio();
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
//        AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(
//                MainActivity.this);
//
//        alertDialog2.setTitle("Confirm Delete...");
//
//        alertDialog2.setMessage("Are you sure you want delete this file?");
//
//        alertDialog2.setPositiveButton("YES",new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(getApplicationContext(),
//                                "You clicked on YES", Toast.LENGTH_SHORT)
//                                .show();
//                    }
//                });
//
//        alertDialog2.setNegativeButton("NO", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(getApplicationContext(),
//                                "You clicked on NO", Toast.LENGTH_SHORT)
//                                .show();
//                        dialog.cancel();
//                    }
//                });
//
//        alertDialog2.show();
    }

    public void playAudio(){
        mediaPlayer=new MediaPlayer();

        mediaPlayer=MediaPlayer.create(this,R.raw.soundtrack);
        mediaPlayer.setVolume(0.2f,0.2f);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        Toast.makeText(this, "Music: enabled", Toast.LENGTH_SHORT).show();
    }
}

package com.example.child.learnenglishforchild;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class activity_play extends AppCompatActivity {
    ArrayList<Image> arrayList=new ArrayList<>();
    ImageAdapter imageAdapter;
    ArrayList<Image> showImage=new ArrayList<>();
    GridView gridView;
    int listNum[];
    List<Boolean> close=new ArrayList<>();
    List<Integer> tick=new ArrayList<>();
    List<Boolean> listTick=new ArrayList<>();
Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);


        init();
        gridView=findViewById(R.id.gv_play);

        listNum=random(4);
        setDefault(4);



        imageAdapter=new ImageAdapter(this,showImage);
        gridView.setAdapter(imageAdapter);


    }
    public void init(){
        arrayList.add(new Image(R.drawable.a2_of_clubs,AudioManager.SCO_AUDIO_STATE_CONNECTED));
        arrayList.add(new Image(R.drawable.a3_of_clubs,AudioManager.SCO_AUDIO_STATE_CONNECTED));
        arrayList.add(new Image(R.drawable.a2_of_spades,AudioManager.SCO_AUDIO_STATE_CONNECTED));
        arrayList.add(new Image(R.drawable.a3_of_spades,AudioManager.SCO_AUDIO_STATE_CONNECTED));

    }
    public void setDefault(int num){
        for (int i=0;i<num*2;i++)
            showImage.add(arrayList.get(listNum[i]));
    }
    public int[] random(int num){
        Random random=new Random();
        int count=0;
        int n[]=new int[num];
        while(count<num){
            n[count]=random.nextInt(arrayList.size());//random lay du lieu
            if (!check(n,count)){
                count++;
            }
        }

        int x[]=new int[num*2];
        for (int i=0;i<num*2;i++){
            if (i>=num)
                x[i]=n[i-num];
            else
            x[i]=n[i];

        }
        for (int i=0;i<num*2;i++){
            for (int j=0;j<num*2;j++){
                if (random.nextBoolean()){
                    int temp=x[i];
                    x[i]=x[j];
                    x[j]=temp;
                }
            }
        }


        return x;
    }
    public boolean check(int n[],int count){

        for (int i=0;i<count;i++){
            if (n[count]==n[i]){
                return true;
            }
        }
        return false;
    }


    public void startAnimation(View view) {

    }
}

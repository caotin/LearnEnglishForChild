package com.example.child.learnenglishforchild;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class PlayActivity extends AppCompatActivity implements ImageAdapter.DataInterface {
    ArrayList<Image> arrayList=new ArrayList<>();
    ImageAdapter imageAdapter;
    ArrayList<Image> showImage=new ArrayList<>();
    TextView txtPoint;
    GridView gridView;

    int listNum[];
    int point=0;
    int level=1;
    int highScore=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        txtPoint=findViewById(R.id.txt_point);
        gridView=findViewById(R.id.gv_play);
        txtPoint.setText(String.valueOf(point));
        Intent intent=getIntent();

        init(intent.getIntExtra("idTopic",0));
        setGridView();

        txtPoint.setText(String.valueOf(imageAdapter.countPoint()));

    }
    public void setGridView(){
        listNum=new int[level*2];
        listNum=random(level);
        setDefault(level);


        imageAdapter=new ImageAdapter(this,showImage);
        gridView.setAdapter(imageAdapter);
    }
    public void init(int id){
        switch (id){
            case 0:
                arrayList.add(new Image(R.drawable.penguins,R.raw.penguin));
                arrayList.add(new Image(R.drawable.shrimp,R.raw.shrimp));
                arrayList.add(new Image(R.drawable.bear,R.raw.bear));
                arrayList.add(new Image(R.drawable.bee,R.raw.bee));
                arrayList.add(new Image(R.drawable.cat,R.raw.cat));
                arrayList.add(new Image(R.drawable.chicken,R.raw.chicken));
                arrayList.add(new Image(R.drawable.cow,R.raw.cow));
                arrayList.add(new Image(R.drawable.crocodile,R.raw.crocodile));
                arrayList.add(new Image(R.drawable.dog,R.raw.dog));
                arrayList.add(new Image(R.drawable.duck,R.raw.duck));
                arrayList.add(new Image(R.drawable.elephant,R.raw.elephant));
                arrayList.add(new Image(R.drawable.fox,R.raw.fox));
                arrayList.add(new Image(R.drawable.frog,R.raw.frog));
                arrayList.add(new Image(R.drawable.horse,R.raw.horse));
                arrayList.add(new Image(R.drawable.lion,R.raw.lion));
                arrayList.add(new Image(R.drawable.monkey,R.raw.monkey));
                arrayList.add(new Image(R.drawable.panda,R.raw.panda));
                arrayList.add(new Image(R.drawable.rabbits,R.raw.rabbit));
                arrayList.add(new Image(R.drawable.tiger,R.raw.tiger));
                break;
            case 1:
                arrayList.add(new Image(R.drawable.builder,R.raw.builder));
                arrayList.add(new Image(R.drawable.businessman,R.raw.businessman));
                arrayList.add(new Image(R.drawable.butcher,R.raw.butcher1));
                arrayList.add(new Image(R.drawable.chef,R.raw.chef));
                arrayList.add(new Image(R.drawable.dancer,R.raw.dancer));
                arrayList.add(new Image(R.drawable.dentist,R.raw.dentist));
                arrayList.add(new Image(R.drawable.doctor,R.raw.doctor1));
                arrayList.add(new Image(R.drawable.farmer,R.raw.farmer));
                arrayList.add(new Image(R.drawable.fireman,R.raw.fireman));
                arrayList.add(new Image(R.drawable.hairdresser,R.raw.hairdresser));
                arrayList.add(new Image(R.drawable.pilot,R.raw.pilot1));
                arrayList.add(new Image(R.drawable.policeman,R.raw.policeman));
                arrayList.add(new Image(R.drawable.singer,R.raw.singer));
                arrayList.add(new Image(R.drawable.teacher,R.raw.teacher));
                break;
            case 2:
                arrayList.add(new Image(R.drawable.apple,R.raw.apple1));
                arrayList.add(new Image(R.drawable.bana,R.raw.banana));
                arrayList.add(new Image(R.drawable.coconut,R.raw.coconut));
                arrayList.add(new Image(R.drawable.dragonfruits,R.raw.dragonfruits));
                arrayList.add(new Image(R.drawable.grape,R.raw.grape));
                arrayList.add(new Image(R.drawable.guava,R.raw.guava));
                arrayList.add(new Image(R.drawable.jackfruit,R.raw.jackfruit));
//                arrayList.add(new Image(R.drawable.,R.raw.laadstarfruit));
                arrayList.add(new Image(R.drawable.lemon,R.raw.lemon));
                arrayList.add(new Image(R.drawable.lion,R.raw.mango));
                arrayList.add(new Image(R.drawable.orange,R.raw.orange));
//                arrayList.add(new Image(R.drawable.,R.raw.pair1));
                arrayList.add(new Image(R.drawable.papaya,R.raw.papaya));
//                arrayList.add(new Image(R.drawable.str,R.raw.strawberry));
                arrayList.add(new Image(R.drawable.watermelon,R.raw.watermelon));
                break;
            case 3:
                arrayList.add(new Image(R.drawable.bed,R.raw.bag1));
                arrayList.add(new Image(R.drawable.telephone,R.raw.bed));
                arrayList.add(new Image(R.drawable.book,R.raw.book));
                arrayList.add(new Image(R.drawable.clock,R.raw.clock1));
                arrayList.add(new Image(R.drawable.dao,R.raw.knife1));
                arrayList.add(new Image(R.drawable.den,R.raw.light1));
                arrayList.add(new Image(R.drawable.du,R.raw.umbrella));
                arrayList.add(new Image(R.drawable.ghe,R.raw.chair1));
                arrayList.add(new Image(R.drawable.hat500x500,R.raw.hat));
                arrayList.add(new Image(R.drawable.quanao,R.raw.clothes));
                arrayList.add(new Image(R.drawable.quat,R.raw.fan1));
                arrayList.add(new Image(R.drawable.shoes,R.raw.shoe1));
                arrayList.add(new Image(R.drawable.table,R.raw.table1));
//                arrayList.add(new Image(R.drawable.tivi,R.raw.));
                break;
            default:break;
        }
    }

//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//
//
//    }

    public void setDefault(int num){
        for (int i=0;i<num*2;i++)
            showImage.add(arrayList.get(listNum[i]));
    }
    public int[] random(int num){
        Random random=new Random();
        int count=0;
        int n[]=new int[num];
        while(count<num){
            n[count]=random.nextInt(arrayList.size());
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

    @Override
    public void OnClickData() {
        imageAdapter.notifyDataSetChanged();
        txtPoint.setText(String.valueOf((imageAdapter.countPoint()*level)));
        if (imageAdapter.finish()){
            level++;
            showImage.clear();
            imageAdapter.notifyDataSetChanged();
            setGridView();
        }
        if (imageAdapter.countPoint()>highScore)
            highScore=imageAdapter.countPoint();
    }

    @Override
    protected void onStart() {
        super.onStart();
        point=0;
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        int defaultValue = 0;
        highScore = sharedPref.getInt("highScore", defaultValue);
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences settings = getApplicationContext().getSharedPreferences("data", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("level", level);

// Apply the edits!
        editor.apply();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        point=0;
    }
}

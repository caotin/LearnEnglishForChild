package com.example.child.learnenglishforchild;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class PlayActivity extends AppCompatActivity {
    ArrayList<Image> arrayList=new ArrayList<>();
    ImageAdapter imageAdapter;
    ArrayList<Image> showImage=new ArrayList<>();
    TextView txtPoint;
    GridView gridView;
    int listNum[];
    int point=0;
    int level=10;
    boolean mark[];
    int prePosition=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        txtPoint=findViewById(R.id.txt_point);
        gridView=findViewById(R.id.gv_play);
        txtPoint.setText(String.valueOf(point));
        Intent intent=getIntent();

        init(intent.getIntExtra("idTopic",0));
        listNum=random(level);
        setDefault(level);
        mark=new boolean[showImage.size()];
        for (int i=0;i<showImage.size();i++){
            mark[i]=true;
        }





        imageAdapter=new ImageAdapter(this,showImage);

        gridView.setAdapter(imageAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if (!mark[position]){
//                    return;
//                }
                System.out.println(prePosition);
                if (prePosition==-1){
                    prePosition=position;
                    return;
                }
                else{
                    System.out.println(prePosition);
                    if (showImage.get(position).getPicture()==showImage.get(prePosition).getPicture()){
                        point+=level;
                        txtPoint.setText(String.valueOf(point));

                        mark[prePosition]=false;
                        mark[position]=false;
                    }
                    prePosition=position;
                }
            }
        });

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
                break;
            case 3:
                break;

            default:break;

        }


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

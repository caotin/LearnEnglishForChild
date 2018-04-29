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
    ArrayList<Image> arrayList2=new ArrayList<>();
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

        listNum=random(3);
        setDefault(3);
        context=this;


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                View v=view;
                if (view == null) {
                    LayoutInflater inflater = (LayoutInflater) context
                            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                    //here is where you inflate your layout containing your viewflipper
                    view = inflater.inflate(R.layout.item_image, null);

                }
                View rootLayout = v.findViewById(R.id.main_flip_layout);
                View cardFace = v.findViewById(R.id.img_item);
                View cardBack = v.findViewById(R.id.img_item_back);

                FlipAnimation flipAnimation = new FlipAnimation(cardFace, cardBack);

                if (cardFace.getVisibility() == View.GONE)
                {
                    flipAnimation.reverse();
                }
                rootLayout.startAnimation(flipAnimation);

//                if (close.get(i)){
//                    return;
//                }
//
//                if (listTick.get(i))
//                    return;
//                listTick.set(i,true);
//
//                tick.add(i);
//                if (tick.size()==1){
//                    arrayList2.set(i,arrayList.get(listNum[i]));
//
//
//
//                    imageAdapter.notifyDataSetChanged();
//                    return;
//                }
//                if (tick.size()==2){
//                    arrayList2.set(i,arrayList.get(listNum[i])); // hiển thị hình ảnh
//                    imageAdapter.notifyDataSetChanged();
//
//                    if (listNum[tick.get(0)]==listNum[tick.get(1)]){ //thực hiện kiểm tra
//                        arrayList2.set(tick.get(0),new Image(R.drawable.background,AudioManager.SCO_AUDIO_STATE_CONNECTED));
//                        arrayList2.set(tick.get(1),new Image(R.drawable.background,AudioManager.SCO_AUDIO_STATE_CONNECTED));
//                        imageAdapter.notifyDataSetChanged();
//
//                        close.set(tick.get(0),true);
//                        close.set(tick.get(0),true);
//
//                        tick.clear();
//                        return;
//                    }else {
//                        arrayList2.set(tick.get(0),new Image(R.drawable.back,AudioManager.SCO_AUDIO_STATE_CONNECTED));
//                        imageAdapter.notifyDataSetChanged();
//                        listTick.set(tick.get(0),false);
//                        listTick.set(tick.get(1),false);
//
//                        tick.remove(0);
//                    }
//                }


            }
        });
        imageAdapter=new ImageAdapter(this,arrayList2);
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
            arrayList2.add(new Image(R.drawable.back,AudioManager.SCO_AUDIO_STATE_CONNECTED));
        for (int i=0;i<num*2;i++)
            listTick.add(false);
        for (int i=0;i<num*2;i++)
            close.add(false);
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

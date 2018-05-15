package com.example.child.learnenglishforchild;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by CaoTin on 21/3/2018.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Image> arrayList = new ArrayList<>();
    private ArrayList<Image> listback = new ArrayList<>();
    final Handler handler = new Handler();
    private int listNum[];
    private int savePosition;
    public ImageAdapter(Context c) {
        mContext = c;
    }
    public static int point=0;
    public ImageAdapter(Context mContext, ArrayList<Image> arrayList) {
        this.mContext = mContext;
        this.arrayList = arrayList;
        listNum=new int[arrayList.size()];
        for (int i=0;i<this.arrayList.size();i++){
            listback.add(new Image(R.drawable.back2,0));
        }
        savePosition=-1;

    }

    public int getCount() {
        return arrayList.size();
    }

    public Object getItem(int position) {
        return arrayList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }
    public int countPoint(int level){
        return level*point;
    }

    public View getView(final int position, final View convertView, ViewGroup parent) {
        final View view;
        if (convertView==null){
            LayoutInflater layoutInflater = ((Activity) mContext).getLayoutInflater();
            view = layoutInflater.inflate(R.layout.item_image, parent, false);
        }
        else {
            view=convertView;
        }

        final ImageView back = view.findViewById(R.id.img_item);
        final ImageView front = view.findViewById(R.id.img_item_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (arrayList.get(position).getPicture()==android.R.color.transparent)
                    return;
                MediaPlayer mp=MediaPlayer.create(mContext,arrayList.get(position).getAudio());
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                if (savePosition!=-1&&savePosition!=position) {
                    if (arrayList.get(savePosition).getPicture() == arrayList.get(position).getPicture()) {
                        final Dialog dialog=new Dialog(mContext);
                        dialog.setContentView(R.layout.item_dialog);
                        point++;
                        ImageView imageView=dialog.findViewById(R.id.img_dialog);
                        imageView.setImageResource(arrayList.get(position).getPicture());

                        dialog.show();


                        arrayList.set(savePosition, new Image(android.R.color.transparent, 0));
                        arrayList.set(position, new Image(android.R.color.transparent, 0));
                        listback.set(position, new Image(android.R.color.transparent, 0));
                        listback.set(savePosition, new Image(android.R.color.transparent, 0));




                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dialog.dismiss();
                                notifyDataSetChanged();
                            }
                        }, 2000);
                    }else {
                        savePosition=-1;
                    }
                }
                savePosition=position;
                flipCard(view);
            }

        });
        front.setImageResource(arrayList.get(position).getPicture());
        back.setImageResource(listback.get(position).getPicture());
        return view;
    }


    private void flipCard(View view)
    {
        final View rootLayout = view.findViewById(R.id.main_flip_layout);
        View cardFace = view.findViewById(R.id.img_item);
        View cardBack = view.findViewById(R.id.img_item_back);

        final FlipAnimation flipAnimation = new FlipAnimation(cardFace, cardBack);

//        if (cardFace.getVisibility() == View.GONE)
//        {
//            flipAnimation.reverse();
//        }

        rootLayout.startAnimation(flipAnimation);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                flipAnimation.reverse();
                rootLayout.startAnimation(flipAnimation);
            }
        }, 1500);

    }
}
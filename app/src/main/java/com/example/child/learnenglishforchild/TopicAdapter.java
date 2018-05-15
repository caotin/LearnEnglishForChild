package com.example.child.learnenglishforchild;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by CaoTin on 15/5/2018.
 */

public class TopicAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Topic> arrayList = new ArrayList<>();
    public TopicAdapter(Context mContext, ArrayList<Topic> arrayList) {
        this.mContext = mContext;
        this.arrayList = arrayList;
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
    public View getView(final int position, final View convertView, ViewGroup parent) {
        final View view;
        if (convertView==null){
            LayoutInflater layoutInflater = ((Activity) mContext).getLayoutInflater();
            view = layoutInflater.inflate(R.layout.item_topic, parent, false);
        }
        else {
            view=convertView;
        }
        ImageView imageView=view.findViewById(R.id.img_topic);
        TextView textView=view.findViewById(R.id.tv_name);
        imageView.setImageResource(arrayList.get(position).getImage());
        textView.setText(arrayList.get(position).getName());




        return view;
    }



}

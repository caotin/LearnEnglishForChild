package com.example.child.learnenglishforchild;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by CaoTin on 21/3/2018.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Image> arrayList = new ArrayList<>();

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public ImageAdapter(Context mContext, ArrayList<Image> arrayList) {
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

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = ((Activity) mContext).getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.item_image, parent, false);

        ImageView imageView = view.findViewById(R.id.img_item);
        ImageView images = view.findViewById(R.id.img_item_back);
        imageView.setImageResource(arrayList.get(position).getPicture());
        images.setImageResource(arrayList.get(position).getPicture());
        return view;
    }


}
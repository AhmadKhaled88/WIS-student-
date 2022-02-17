package com.example.my_uni_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GridAdapter extends BaseAdapter {
    Context context;
    int[] image;

    LayoutInflater inflater ;

    public GridAdapter(Context context, int[] imag) {
        this.context = context;
        this.image = imag;
    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.grid_item, null);
        }
        ImageView imageView = convertView.findViewById(R.id.gridimage);
        imageView.setImageResource(image[position]);
        return convertView;
    }
}
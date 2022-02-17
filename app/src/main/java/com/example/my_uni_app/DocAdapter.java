package com.example.my_uni_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DocAdapter extends ArrayAdapter<doc> {
    private Context mContext;
    private int mResource;

    public DocAdapter (@NonNull Context context, int resource, @NonNull ArrayList<doc> objects) {
        super(context, resource, objects);
        this.mContext = context ;
        this.mResource= resource;


    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource,parent,false);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imgcs);
        TextView txtName   = (TextView) convertView.findViewById(R.id.docName);
        TextView  txtDes    = (TextView) convertView.findViewById(R.id.docRank);

        imageView.setImageResource(getItem(position).getImage());

        txtName.setText(getItem(position).getName());
        txtDes.setText(getItem(position).getDes());

        return convertView;
}}

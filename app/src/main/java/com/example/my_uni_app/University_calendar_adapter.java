package com.example.my_uni_app;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class University_calendar_adapter extends RecyclerView.Adapter<University_calendar_adapter.calendarViewHolder> {

    private Context context;
    private List<University_calendar_data>list;


    public University_calendar_adapter(Context context, List<University_calendar_data> list) {

        this.context = context;
        this.list = list;
    }

    @NonNull
    @NotNull
    @Override
    public calendarViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.iteam_university_calendar,parent,false);
        return new calendarViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull calendarViewHolder holder, int position) {



       holder.calendarname.setText(list.get(position).getPdfTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(context,pdfviewer.class);
               intent.putExtra("pdfUrl",list.get(position).getPdfUrl());
               context.startActivity(intent);
           }
       });


       holder.calendardownlode.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View v) {
               Intent intent=new Intent(Intent.ACTION_VIEW);
               intent.setData(Uri.parse(list.get(position).getPdfUrl()));
               context.startActivity(intent);
           }
       });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class calendarViewHolder extends RecyclerView.ViewHolder {

        private TextView calendarname;
        private ImageView calendardownlode;

        public calendarViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            calendarname=itemView.findViewById(R.id.calendarname);

            calendardownlode=itemView.findViewById(R.id.calendardownlode);
        }
    }
}

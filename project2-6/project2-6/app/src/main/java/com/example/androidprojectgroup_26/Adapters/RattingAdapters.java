package com.example.androidprojectgroup_26.Adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androidprojectgroup_26.Objects.Ratting;
import com.example.androidprojectgroup_26.R;
import com.example.androidprojectgroup_26.Session.MyApplication;


import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;

public class RattingAdapters extends RecyclerView.Adapter<RattingAdapters.viewHolder> {


    List<Ratting> rattings;
    private LayoutInflater inflater;
    Activity context;
    MyApplication myApplication;

    public RattingAdapters(Activity context, List<Ratting> posts) {
        this.rattings = posts;
        this.context = context;
        try {
            myApplication = (MyApplication) context.getApplicationContext();

        } catch (Exception e) {

        }
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_ratting, null);

        RecyclerView.ViewHolder holder = new viewHolder(view);
        return (viewHolder) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final viewHolder holder, final int position) {

        holder.Name.setText(rattings.get(position).getUserName());

        holder.Message.setText(rattings.get(position).getMessage());
        holder.materialRatingBar.setProgress(rattings.get(position).getStars());
        holder.materialRatingBar.setEnabled(false);
        holder.materialRatingBar.setClickable(false);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(Long.valueOf(rattings.get(position).getDate()));
        holder.Date.setText(DateFormat.getDateTimeInstance().format(calendar.getTime()));
    }

    @Override
    public int getItemCount() {
        return rattings.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {


        TextView Name, Message, Date;
        MaterialRatingBar materialRatingBar;

        viewHolder(View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.Name);
            Message = itemView.findViewById(R.id.Message);
            Date = itemView.findViewById(R.id.Date);
            materialRatingBar = itemView.findViewById(R.id.Ratting);


        }
    }
}

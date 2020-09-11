package com.example.gadsleaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static androidx.recyclerview.widget.RecyclerView.*;

public class LearningLeadersRecyclerAdapter extends RecyclerView.Adapter<LearningLeadersRecyclerAdapter.ViewHolder> {

     private final Context mContext;
    private final List<Learningleaders> mLeaders;
     private final LayoutInflater mLayoutInflater;

    public LearningLeadersRecyclerAdapter(Context context,List<Learningleaders> leaders) {
      mContext=context;
        mLeaders = leaders;
        mLayoutInflater= LayoutInflater.from(mContext);

    }

    @NonNull
    @Override
    public LearningLeadersRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.leaderboard_item,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Learningleaders leader = mLeaders.get(position);
        holder.name.setText(leader.name);
        holder.hours.setText(leader.hours+" Learning Hours "+leader.country);

    }

    @Override
    public int getItemCount() {
        return 0;

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView name;
        public final TextView hours;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.leader_name);
            hours = (TextView) itemView.findViewById((R.id.leader_hours_and_country));

        }
    }
}

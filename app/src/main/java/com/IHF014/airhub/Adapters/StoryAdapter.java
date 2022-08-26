package com.IHF014.airhub.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.IHF014.airhub.Models.StoryModel;
import com.IHF014.airhub.R;
import com.devlomi.circularstatusview.CircularStatusView;

import java.util.ArrayList;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryViewHolder> {

    Context context;
    ArrayList<StoryModel> list;

    public StoryAdapter(Context context,ArrayList<StoryModel> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public StoryAdapter.StoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StoryAdapter.StoryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.story_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StoryAdapter.StoryViewHolder holder, int position) {

        holder.statusView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class StoryViewHolder extends RecyclerView.ViewHolder{

        CircularStatusView statusView;

        public StoryViewHolder(@NonNull View itemView) {
            super(itemView);

            statusView = itemView.findViewById(R.id.circular_status_view);

        }

    }

}

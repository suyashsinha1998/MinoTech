package com.example.suyesh.minotech;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.suyesh.minotech.Models.VideosModel;

import java.util.ArrayList;

/**
 * Created by SUYESH on 3/30/2018.
 */

public class VideosAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<VideosModel> videosModels;
    private Context context;

    public VideosAdapter(ArrayList<VideosModel> videosModels, Context context) {
        this.videosModels = videosModels;
        this.context = context;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);
        return null;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

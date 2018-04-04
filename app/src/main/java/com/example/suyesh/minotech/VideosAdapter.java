package com.example.suyesh.minotech;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.suyesh.minotech.Models.VideosModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by SUYESH on 3/30/2018.
 */

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.ViewHolder> {

    private ArrayList<VideosModel> list;
    private Context context;

    public VideosAdapter(ArrayList<VideosModel> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.customlayout2, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        VideosModel videosModel = list.get(position);
        final Intent intent = new Intent(context,VideosPage.class);

        holder.text.setText(videosModel.getInfo());
        Picasso.with(context)
                .load(videosModel.getImage())
                .into(holder.img);
        final VideosListPageRecyclerView videosListPageRecyclerView = new VideosListPageRecyclerView();

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    intent.putExtra("id",list.get(position).getVideo_id().toString());
                    context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView img;
        public TextView text;
        public RelativeLayout relativeLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            img = (ImageView) itemView.findViewById(R.id.ivThumb);
            text = (TextView) itemView.findViewById(R.id.tvInfoThumb);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativeLayout);
        }


    }
}

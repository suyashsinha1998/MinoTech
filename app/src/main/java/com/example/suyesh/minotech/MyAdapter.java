package com.example.suyesh.minotech;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.suyesh.minotech.Models.UserModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SUYESH on 3/21/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<UserModel> userModels;
    private Context context;

    public MyAdapter(ArrayList<UserModel> mylist, Context applicationContext) {
      this.userModels = mylist;
        this.context = applicationContext;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        UserModel userModel= userModels.get(position);

        holder.t1.setText(userModel.getName());
        holder.t2.setText(userModel.getGender());
        holder.t3.setText(userModel.getJob());

    }

    @Override
    public int getItemCount() {
        return userModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView t1,t2,t3;

        public ViewHolder(View itemView) {
            super(itemView);

            t1=(TextView)itemView.findViewById(R.id.first);
            t2=(TextView)itemView.findViewById(R.id.second);
            t3=(TextView)itemView.findViewById(R.id.third);
        }
    }
}

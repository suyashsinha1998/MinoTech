package com.example.suyesh.minotech;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.suyesh.minotech.Models.VideosModel;

import java.util.ArrayList;

public class VideosListPageRecyclerView extends AppCompatActivity {

    protected RecyclerView recyclerView;
    protected RecyclerView.Adapter adapter;
    private ArrayList<VideosModel> videosModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos_list_page_recycler_view);

        recyclerView = (RecyclerView) findViewById(R.id.videosrecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        videosModels = new ArrayList<>();

        loadRecyclerViewData();
    }

    protected void loadRecyclerViewData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Videos");
        progressDialog.show();
    }

}
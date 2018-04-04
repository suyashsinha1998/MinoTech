package com.example.suyesh.minotech;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.suyesh.minotech.Models.VideosModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class VideosListPageRecyclerView extends AppCompatActivity {

    protected RecyclerView recyclerView;
    protected RecyclerView.Adapter adapter;
    private ArrayList<VideosModel> videosModels;
    private static final String videojson = "https://api.myjson.com/bins/qugyz";
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos_list_page_recycler_view);

        editText = (EditText)findViewById(R.id.searchbar);
        button = (Button)findViewById(R.id.searchbtn);
        recyclerView = (RecyclerView) findViewById(R.id.videosrecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        videosModels = new ArrayList<>();

        loadRecyclerViewData();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                if (str.length()==0)
                {
                    Toast.makeText(VideosListPageRecyclerView.this, "Please Enter Some Text", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent i = new Intent(Intent.ACTION_WEB_SEARCH);
                    i.putExtra(SearchManager.QUERY,str+" videos");
                    startActivity(i);
                }
            }
        });
    }

    protected void loadRecyclerViewData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Videos");
        progressDialog.show();

        StringRequest stringRequest=new StringRequest(Request.Method.GET,
                videojson,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        JSONArray jsonArray = null;
                        try {
                            jsonArray = new JSONArray(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        for (int i = 0; i < jsonArray.length(); ++i) {
                            JSONObject JO = null;
                            try {
                                JO = (JSONObject) jsonArray.get(i);
                                VideosModel vm = new VideosModel(JO.getString("title"), JO.getString("image"),JO.getString("video_id"));
                                videosModels.add(vm);
                                adapter = new VideosAdapter(videosModels, getApplicationContext());
                                recyclerView.setAdapter(adapter);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

}
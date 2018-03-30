package com.example.suyesh.minotech;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.suyesh.minotech.Models.UserModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DownloadsPage extends AppCompatActivity {

    protected RecyclerView recyclerView;
    protected RecyclerView.Adapter adapter;
    private ArrayList<UserModel> userModels;
    final static String urljson="https://api.myjson.com/bins/ois5v";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloads_page);

        recyclerView=(RecyclerView)findViewById(R.id.reclylerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        userModels = new ArrayList<>();

        loadRecyclerViewData();

        }

        /*protected void loadRecyclerViewData(){

            ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Loading Data...");
            progressDialog.show();

            parseData process = new parseData();

            process.execute();

            Log.v(process.mylist.size()+" ","downloads");
            adapter = new MyAdapter(process.mylist,getApplicationContext());
            recyclerView.setAdapter(adapter);
        }*/
        protected void loadRecyclerViewData()
        {
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Loading Data...");
            progressDialog.show();

            StringRequest stringRequest=new StringRequest(Request.Method.GET,
                    urljson,
                    new Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            progressDialog.dismiss();
                            JSONArray jsonArray = null;
                            try {
                                jsonArray = new JSONArray(response);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            for (int i=0 ; i<jsonArray.length(); ++i)
                            {
                                JSONObject JO = null;
                                try {
                                    JO = (JSONObject) jsonArray.get(i);
                                    UserModel um= new UserModel(JO.getString("name"),JO.getString("gender"),JO.getString("job"));
                                    userModels.add(um);
                                    adapter = new MyAdapter(userModels,getApplicationContext());
                                    recyclerView.setAdapter(adapter);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }


                        }
                    },
                    new ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    });

            RequestQueue requestQueue= Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);


        }

}



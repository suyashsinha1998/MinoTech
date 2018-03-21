package com.example.suyesh.minotech;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.suyesh.minotech.Models.UserModel;
import com.example.suyesh.minotech.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by SUYESH on 1/23/2018.
 */

public class parseData extends AsyncTask<Void,Void,Void> {

    static ArrayList<UserModel> mylist = new ArrayList<UserModel>();
    String data="";

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        for (int i=0 ; i<jsonArray.length(); ++i)
        {
            JSONObject JO = null;
            try {
                JO = (JSONObject) jsonArray.get(i);
                UserModel um= new UserModel(JO.getString("name"),JO.getString("gender"),JO.getString("job"));
                mylist.add(um);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }


    @Override
    protected Void doInBackground(Void... params) {

        try {
            data="";
            URL urlJason = new URL("https://api.myjson.com/bins/rc3op");
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlJason.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line="";
            while(line!=null)
            {
                line = bufferedReader.readLine();
                data=data+line;
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}

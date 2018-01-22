package com.example.suyesh.minotech;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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

public class DownloadsPage extends AppCompatActivity {

    ArrayList<ArrayList<String>> mylist = new ArrayList<ArrayList<String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloads_page);
        ListView listView = (ListView)findViewById(R.id.downloadsLv);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        String data="";

        try {
            URL urlJason = new URL("https://api.myjson.com/bins/ochgh");
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlJason.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line="";
            while(line!=null)
            {
                line = bufferedReader.readLine();
                data=data+line;
            }
            JSONArray jsonArray = new JSONArray(data);
            ArrayList<String> temp = new ArrayList<String>();
            for (int i=0 ; i<jsonArray.length(); ++i)
            {

                JSONObject JO = (JSONObject) jsonArray.get(i);
                temp.add(JO.get("name").toString());
                temp.add(JO.get("gender").toString());
                temp.add(JO.get("job").toString());
                mylist.add(temp);
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


    class CustomAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return mylist.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.downloadlayout,null);
            TextView t1=(TextView)convertView.findViewById(R.id.down1);
            TextView t2=(TextView)convertView.findViewById(R.id.down2);
            TextView t3=(TextView)convertView.findViewById(R.id.down3);

            for(int j =0;i<mylist.size();++i)
            {
                t1.setText(mylist.get(j).get(0));
                t2.setText(mylist.get(j).get(1));
                t3.setText(mylist.get(j).get(2));
            }

            return convertView;
        }
    }
}



package com.example.suyesh.minotech;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class NewsPage extends AppCompatActivity {

    private EditText et;
    private Button btn;

    String[] text ={"INDIA","WORLD","MINING WEEKLY","MINES","DGMS","MINE SAFETY"};
    int[] img ={R.drawable.mining_india,R.drawable.mining_world,R.drawable.mining_weekly,R.drawable.mines,R.drawable.dgms,R.drawable.mine_safety};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_page);

        et=(EditText)findViewById(R.id.etSearch);
        btn=(Button)findViewById(R.id.btnSearch);

        ListView listViewNews = (ListView)findViewById(R.id.lv2);
        NewCustomAdapter customAdapter = new NewCustomAdapter();
        listViewNews.setAdapter(customAdapter);
        final Intent i = new Intent(NewsPage.this,NewsWeb.class);

        listViewNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position)
                {
                    case 0: i.putExtra("url","http://www.mining.com/tag/india/");
                            startActivity(i);
                            break;
                    case 1: i.putExtra("url","http://www.mining.com/");
                            startActivity(i);
                            break;
                    case 2: i.putExtra("url","http://www.miningweekly.com/");
                            startActivity(i);
                            break;
                    case 3: i.putExtra("url","https://www.ndtv.com/topic/india-coal-mines");
                            startActivity(i);
                            break;
                    case 4: i.putExtra("url","https://timesofindia.indiatimes.com/topic/DGMS/news");
                            startActivity(i);
                            break;
                    case 5: i.putExtra("url","http://www.dgms.net/legislation.html");
                            startActivity(i);
                            break;
                }

            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = et.getText().toString();
                if (str.length()==0)
                {
                    Toast.makeText(NewsPage.this, "Please Enter Some Text", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent i = new Intent(Intent.ACTION_WEB_SEARCH);
                    i.putExtra(SearchManager.QUERY,str+" news");
                    startActivity(i);
                }
            }
        });


    }

    class NewCustomAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return img.length;
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
            convertView = getLayoutInflater().inflate(R.layout.customolayout3,null);
            ImageView imageView=(ImageView)convertView.findViewById(R.id.ivimg);
            TextView textView=(TextView)convertView.findViewById(R.id.tvText);

            imageView.setImageResource(img[i]);
            textView.setText(text[i]);
            return convertView;
        }
    }
}

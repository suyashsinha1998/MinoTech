package com.example.suyesh.minotech;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class VideosListPage extends AppCompatActivity {

    private EditText search;
    private Button searchbtn;

    String[] info={"Explosives Underground:Mining & Training Safety Training Video" , "Fully Mechanized Long Wall Production",
                    "How is coal mined? What is surface mining" , "Open Pit Coal Mine" ,"How Do They It - Coal Mining",
                   "MVM1100-Narrow Vien Mining" , "Longwall Mining", "Safety Video- Dropped Objects Demonstration" ,"Sub Level Caving",
                    "Mining Operation-Cut and Fill Stoping"};
    int[] images={R.drawable.explosives_underground,R.drawable.fully_mechanised_longwall,R.drawable.how_is_coal_mined,
                   R.drawable.open_pit_coal_mine, R.drawable.video_8,R.drawable.mining_machinery,R.drawable.longwall_mining,R.drawable.video_1,
                   R.drawable.sub_level_caving,R.drawable.cut_fill_stoping};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos_list_page);

        ListView listView = (ListView)findViewById(R.id.lv1);
        search=(EditText)findViewById(R.id.etSearch);
        searchbtn=(Button)findViewById(R.id.btnSearch);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        final Intent i = new Intent(VideosListPage.this,VideosPage.class);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position)
                {
                    case 0: i.putExtra("id","AYE0llgdaac");
                            startActivity(i);
                            break;
                    case 1: i.putExtra("id","WmwEB4DY_jc");
                            startActivity(i);
                            break;
                    case 2: i.putExtra("id","nr7JImmQIjg");
                            startActivity(i);
                            break;
                    case 3: i.putExtra("id","cWs3FzDIgUA");
                            startActivity(i);
                        break;
                    case 4: i.putExtra("id","ylkdUuNOJzw");
                            startActivity(i);
                            break;
                    case 5: i.putExtra("id","6qao6WAM7lo");
                            startActivity(i);
                        break;
                    case 6: i.putExtra("id","NsiGV7lmNXE");
                            startActivity(i);
                            break;
                    case 7: i.putExtra("id","jPQm3UlE9hs");
                            startActivity(i);
                            break;
                    case 8: i.putExtra("id","mozTwnQ1cWU");
                            startActivity(i);
                            break;
                    case 9: i.putExtra("id","BvhIvi96q0Q");
                            startActivity(i);
                            break;
                 }

            }
        });

        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = search.getText().toString();
                if (str.length()==0)
                {
                    Toast.makeText(VideosListPage.this, "Please Enter Some Text", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent i = new Intent(Intent.ACTION_WEB_SEARCH);
                    i.putExtra(SearchManager.QUERY,str+" videos");
                    startActivity(i);
                }
            }
        });

    }


    class CustomAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return images.length;
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
            convertView = getLayoutInflater().inflate(R.layout.customlayout2,null);
            ImageView thumb=(ImageView)convertView.findViewById(R.id.ivThumb);
            TextView infothumb=(TextView)convertView.findViewById(R.id.tvInfoThumb);

            thumb.setImageResource(images[i]);
            infothumb.setText(info[i]);
            return convertView;
        }
    }
}

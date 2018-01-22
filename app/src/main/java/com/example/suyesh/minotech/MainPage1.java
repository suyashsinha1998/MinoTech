package com.example.suyesh.minotech;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainPage1 extends AppCompatActivity {
    ListView list;
    String []name ={"TEST","PRACTICE","NEWS","VIDEOS","DOWNLOADS","ABOUT US"};
    String []description={"Enter to test your grip over tbe subject","Practice to enhance your knowledge","Update yourself to the latest happenings",
                          "Grasp the graphical knowlegde on the subject","Consists of various resources","Know about us"};
    int []images={R.drawable.test,R.drawable.practice,R.drawable.news,R.drawable.videos,R.drawable.downloads,R.drawable.aboutus};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page1);


        list=(ListView)findViewById(R.id.lv);
        CustomAdapter customAdapter = new CustomAdapter();
        list.setAdapter(customAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position)
                {
                    case 2: Intent i = new Intent(MainPage1.this,NewsPage.class);
                            startActivity(i);
                            break;

                    case 3:
                            i = new Intent(MainPage1.this , VideosListPage.class);
                            startActivity(i);
                            break;

                    case 5: i=new Intent(MainPage1.this,AboutusPage.class);
                            startActivity(i);
                            break;

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
            convertView = getLayoutInflater().inflate(R.layout.customlayout,null);
            ImageView ivImages=(ImageView)convertView.findViewById(R.id.ivImages);
            TextView tvName=(TextView)convertView.findViewById(R.id.tvName);
            TextView tvDescription = (TextView)convertView.findViewById(R.id.tvDescription);

            ivImages.setImageResource(images[i]);
            tvName.setText(name[i]);
            tvDescription.setText(description[i]);

            return convertView;
        }
    }
}

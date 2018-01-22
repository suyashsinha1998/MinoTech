package com.example.suyesh.minotech;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    private ImageView ivLogo;
    private TextView tvText,tvSlogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ivLogo = (ImageView)findViewById(R.id.ivLogo);
        tvText = (TextView)findViewById(R.id.tvText);
        tvSlogan = (TextView)findViewById(R.id.tvSlogan);
        Animation myAnim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        tvText.startAnimation(myAnim);
        ivLogo.startAnimation(myAnim);
        tvSlogan.startAnimation(myAnim);
        final Intent i = new Intent(this,MainPage1.class);
        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(6000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
        }

}

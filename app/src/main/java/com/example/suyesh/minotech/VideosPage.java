package com.example.suyesh.minotech;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class VideosPage extends YouTubeBaseActivity {

    YouTubePlayerView v1;

    static final String KEY ="AIzaSyACkwyMItMvasv8eNYqkFPB1v8YJP-1cDo";

    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos_page);

        final String id = getIntent().getExtras().getString("id");

        v1=(YouTubePlayerView)findViewById(R.id.video1);

        onInitializedListener=new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                if(!b)
                youTubePlayer.cueVideo(id);

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        v1.initialize(KEY,onInitializedListener);

    }
}

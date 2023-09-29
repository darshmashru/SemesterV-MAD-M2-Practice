package com.darshmashru.madm2practice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.VideoView;

public class clickVideo extends AppCompatActivity {
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_video);
        videoView = findViewById(R.id.videoViewpg3);
    }
    public void clickVideo(View view) {
        Intent i = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        startActivityForResult(i, 100);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100 && resultCode == RESULT_OK) {
            Uri videoUri = data.getData();
            videoView.setVideoURI(videoUri);
            videoView.start();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
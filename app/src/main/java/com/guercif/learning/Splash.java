package com.guercif.learning;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Splash extends AppCompatActivity {
VideoView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.splash);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        try {
            view = (VideoView) findViewById(R.id.videoView);
            view.setVideoPath("android.resource://" + getPackageName() +"/"+R.raw.learn_tifnagh);
            view.start();
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, "video not found", Toast.LENGTH_SHORT).show();
        }
  new Handler().postDelayed(new Runnable() {
      @Override
      public void run() {
          startActivity(new Intent(Splash.this,MainActivity.class));
      }
  },4000);
    }
}
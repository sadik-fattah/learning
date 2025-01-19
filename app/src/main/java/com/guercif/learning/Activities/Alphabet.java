package com.guercif.learning.Activities;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.guercif.learning.R;


public class Alphabet extends AppCompatActivity implements View.OnClickListener{
    ImageButton previous, refresh, next;
   // TextView text;
    private ImageView letterImage;
    private int count = 0;
    private MediaPlayer mediaPlayer;

    private int[] audioId = {R.raw.ya,R.raw.yab,R.raw.yag,R.raw.yad,
            R.raw.yadd,R.raw.yey, R.raw.yaf,R.raw.yak,
            R.raw.yah, R.raw.yahh,R.raw.yaa, R.raw.yakh,
            R.raw.yaq, R.raw.yi,R.raw.yazh,R.raw.yal,
            R.raw.yam, R.raw.yan,R.raw.yu,R.raw.yar,
            R.raw.yarr, R.raw.yagh,R.raw.yas,R.raw.yass,
            R.raw.yach, R.raw.yat, R.raw.yatt,R.raw.yaw,
            R.raw.yay, R.raw.yaz,R.raw.yazz,R.raw.ow};
private int [] imageId = {
        R.drawable.tifinagh_0,R.drawable.tifinagh_1,R.drawable.tifinagh_2,R.drawable.tifinagh_3,
        R.drawable.tifinagh_4,R.drawable.tifinagh_5,R.drawable.tifinagh_6,R.drawable.tifinagh_7,
        R.drawable.tifinagh_8,R.drawable.tifinagh_9,R.drawable.tifinagh_10,R.drawable.tifinagh_11,
        R.drawable.tifinagh_12,R.drawable.tifinagh_13,R.drawable.tifinagh_14,R.drawable.tifinagh_15,
        R.drawable.tifinagh_16,R.drawable.tifinagh_17,R.drawable.tifinagh_18,R.drawable.tifinagh_19,
        R.drawable.tifinagh_20,R.drawable.tifinagh_21,R.drawable.tifinagh_22,R.drawable.tifinagh_23,
        R.drawable.tifinagh_24,R.drawable.tifinagh_25,R.drawable.tifinagh_26,R.drawable.tifinagh_27,
        R.drawable.tifinagh_28,R.drawable.tifinagh_29,R.drawable.tifinagh_30,R.drawable.tifinagh_31,

};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.alphabet);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        previous = findViewById(R.id.previous);
        refresh = findViewById(R.id.refresh);
        next = findViewById(R.id.next);
         letterImage = findViewById(R.id.letter_image);



        previous.setOnClickListener(this);
        refresh.setOnClickListener(this);
        next.setOnClickListener(this);
        updateContent();
    }

    private void updateContent() {
        letterImage.setImageResource(imageId[count]);
        if (mediaPlayer !=null){
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(this, audioId[count]);
        mediaPlayer.start();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.next) {
            if (count < audioId.length -1 ) {
                count++;
            updateContent();
            } else {
                Toast.makeText(this, "End of Alphabet", Toast.LENGTH_SHORT).show();
            }
        } else if (view.getId() == R.id.previous) {
            if (count > 0) {
                count--;
              updateContent();
            } else {
                Toast.makeText(this, "Start of Alphabet", Toast.LENGTH_SHORT).show();
            }
        } else if (view.getId() == R.id.refresh) {
         mediaPlayer.start();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
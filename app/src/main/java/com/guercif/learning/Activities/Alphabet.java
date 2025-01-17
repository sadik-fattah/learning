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
    ImageView letterImage;
    int count;
    MediaPlayer audio;
    int[] id = {R.raw.ya,R.raw.yab,R.raw.yag,R.raw.yad,
            R.raw.yadd,R.raw.yey, R.raw.yaf,R.raw.yak,
            R.raw.yah, R.raw.yahh,R.raw.yaa, R.raw.yakh,
            R.raw.yaq, R.raw.yi,R.raw.yazh,R.raw.yal,
            R.raw.yam, R.raw.yan,R.raw.yu,R.raw.yar,
            R.raw.yarr, R.raw.yagh,R.raw.yas,R.raw.yass,
            R.raw.yach, R.raw.yat, R.raw.yatt,R.raw.yaw,
            R.raw.yay, R.raw.yaz,R.raw.yazz,R.raw.ow};

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
     //   text = findViewById(R.id.letter);
        audio = MediaPlayer.create(this, id[count]);
        audio.start();

        previous.setOnClickListener(this);
        refresh.setOnClickListener(this);
        next.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.next) {
            if (count < 32) {
                count++;
                letterImage.setImageResource(alphabet(count)); // Set image resource
                audio = MediaPlayer.create(this, id[count]);
                audio.start();
            } else {
                Toast.makeText(this, "End of Alphabet", Toast.LENGTH_SHORT).show();
            }
        } else if (view.getId() == R.id.previous) {
            if (count > 0) {
                count--;
                letterImage.setImageResource(alphabet(count)); // Set image resource
            } else {
                Toast.makeText(this, "Start of Alphabet", Toast.LENGTH_SHORT).show();
            }
        } else if (view.getId() == R.id.refresh) {
            audio.start();
        }
    }
/*
    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.next){
            if(count != 32){
                audio.stop();
                count++;
                text.setText(alphabet(count));
                audio = MediaPlayer.create(this, id[count]);
                audio.start();
            }
            else {
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            }

        }
        else if (view.getId() == R.id.previous) {
            if (count !=0){
                count --;
                text.setText(alphabet(count));
            }else {
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            }
        } else if (view.getId() == R.id.refresh) {
            audio.start();
        }
    }
    private String alphabet(int n){
        char part1 = (char) ('a'+ n);
        //char part2 = (char) ('a'+n);
        String a1 = Character.toString(part1);
        // String a2 = Character.toString(part2);
        String ans = a1;
        return ans;
    }*/
private int alphabet(int n) {
    // Assuming your images are named tifinagh_0, tifinagh_1, ..., tifinagh_32
    // This assumes you have 33 images, adjust as necessary
    return getResources().getIdentifier("tifinagh_" + n, "drawable", getPackageName());
}

}
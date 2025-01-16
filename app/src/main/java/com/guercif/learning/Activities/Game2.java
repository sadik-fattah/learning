package com.guercif.learning.Activities;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.guercif.learning.R;


public class Game2 extends AppCompatActivity implements View.OnClickListener{
    Button opt1, opt2, opt3, opt4;
    ImageButton imageRefresh;
    MediaPlayer audio;
    int count = 0;
    String comb1 = "ⵎⴱⵓⴷⵕⴻⵙⴽⵛⵃⵟⵅⵢⵉⵥⵍⵯⵊⵣⵇⵡⵄⵜⵀⵚⴼⵖⴹⵔⴳⵏⴰ";
    String comb2 = "ⵎⴰⵍⵯⵏⴱⵊⵥⵓⴳⵉⵣⵔⴷⵇⵢⵕⴹⵅⵡⵖⴻⵄⵟⵙⴼⵃⵜⵚⴽⵀⵛ";
    String comb3 = "ⴰⵎⵯⵍⴱⵏⵥⵊⴳⵓⵣⵉⴷⵔⵢⵇⴷⵔⵡⵅⴻⵖⵟⵄⴼⵙⵜⵃⴽⵚⵛⵀ";
    String comb4 = "ⴽⵚⵎⴰⴽⵚⵏⴱⴼⵙⵔⴷⴼⵙⵕⴹⴻⵖⵀⵛⵯⵍⵃⵜⵥⵊⵄⵟⵣⵉⵅⵡⵢⵇ";
    String ans = "ⴰⴱⴳⴷⴹⴻⴼⴽⵀⵃⵄⵅⵇⵉⵊⵍⵎⵏⵓⵔⵕⵖⵙⵚⵛⵜⵟⵡⵢⵣⵥⵯ";
    int[] id = {R.raw.ya, R.raw.yab,R.raw.yag,R.raw.yad,
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
        setContentView(R.layout.game2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        opt1 = findViewById(R.id.opt1);
        opt2 = findViewById(R.id.opt2);
        opt3 = findViewById(R.id.opt3);
        opt4 = findViewById(R.id.opt4);

        imageRefresh = findViewById(R.id.imageRefresh);

        audio = MediaPlayer.create(this, id[count]);

        opt1.setText(Character.toString(comb1.charAt(count)));
        opt2.setText(Character.toString(comb2.charAt(count)));
        opt3.setText(Character.toString(comb3.charAt(count)));
        opt4.setText(Character.toString(comb4.charAt(count)));

        opt1.setOnClickListener(this);
        opt2.setOnClickListener(this);
        opt3.setOnClickListener(this);
        opt4.setOnClickListener(this);
        imageRefresh.setOnClickListener(v -> audio.start());
    }

    @Override
    public void onClick(View view) {
        Button b = (Button) view;
        String s = b.getText().toString();
        String st = Character.toString(ans.charAt(count));

        if (s.compareTo(st) == 0) {
            count++;
            if (count == 26) {
                count = 0;
            }
            opt1.setText(Character.toString(comb1.charAt(count)));
            opt2.setText(Character.toString(comb2.charAt(count)));
            opt3.setText(Character.toString(comb3.charAt(count)));
            opt4.setText(Character.toString(comb4.charAt(count)));

            audio = MediaPlayer.create(this, id[count]);
            audio.start();
        } else {
            Toast.makeText(this, "Wrong Answer...Replay the audio", Toast.LENGTH_SHORT).show();
        }

    }
}
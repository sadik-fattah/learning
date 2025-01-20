package com.guercif.learning.Activities;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.guercif.learning.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Game2 extends AppCompatActivity implements View.OnClickListener{
    Button opt1, opt2, opt3, opt4;
    ImageButton imageRefresh;
    TextView scoreText;
    MediaPlayer audio;
    int count = 0;
    int score = 0;

    String ans    = "ⴰⴱⴳⴷⴹⴻⴼⴽⵀⵃⵄⵅⵇⵉⵊⵍⵎⵏⵓⵔⵕⵖⵙⵚⵛⵜⵟⵡⵢⵣⵥⵯ";
    String comb1  = "ⵔⵇⵕⵥⵅⴰⵜⴳⵢⵟⵖⴷⵓⴱⴹⵙⵎⴻⵛⵏⴽⵚⵉⵣⴼⵍⵄⵃⵡⵀⵊⵯ";
    String  comb2 = "ⵟⵚⵖⵎⵣⵅⴷⵢⴳⴰⵙⵥⵃⵡⴼⵓⵯⵔⵄⴽⴹⴱⵛⴻⵉⵇⵍⵜⵀⵏⵊⵕ";
    String  comb3 = "ⵍⵚⵕⵛⵊⵙⵅⴻⴼⵎⵏⵉⴷⵢⵔⵃⵣⵀⵄⵜⴳⵇⵥⴱⵟⵡⵖⵓⴰⴽⵯⴹ";
    String  comb4 = "ⴽⵃⵜⵛⴰⵡⵀⵄⵎⵙⴼⵯⴷⴳⵊⴱⵉⵟⵓⵔⵢⵕⵣⵏⵖⴻⵥⴹⵅⵇⵚⵍ";

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
        scoreText = findViewById(R.id.scoreText);

        setupNewQuestion();

        opt1.setOnClickListener(this);
        opt2.setOnClickListener(this);
        opt3.setOnClickListener(this);
        opt4.setOnClickListener(this);
        imageRefresh.setOnClickListener(v -> audio.start());
    }

    private void setupNewQuestion() {
        audio = MediaPlayer.create(this, id[count]);
        audio.start();

        List<String> options = new ArrayList<>();
        options.add(Character.toString(comb1.charAt(count)));
        options.add(Character.toString(comb2.charAt(count)));
        options.add(Character.toString(comb3.charAt(count)));
        options.add(Character.toString(comb4.charAt(count)));


        String correctAnswer = Character.toString(ans.charAt(count));
        Random random = new Random();
        options.set(random.nextInt(4), correctAnswer);




        opt1.setText(options.get(0));
        opt2.setText(options.get(1));
        opt3.setText(options.get(2));
        opt4.setText(options.get(3));
    }

    @Override
    public void onClick(View view) {
        Button b = (Button) view;
        String selectedAnswer = b.getText().toString();
        String correctAnswer = Character.toString(ans.charAt(count));

        if (selectedAnswer.equals(correctAnswer)) {
            score++;
            scoreText.setText("Score: " + score);
           // b.setBackgroundColor(Color.GREEN);

            new Handler().postDelayed(() -> {
              //  b.setBackgroundColor(Color.LTGRAY);
                count++;
                if (count == ans.length()) {
                    count = 0;
                    Toast.makeText(this, "You've completed the game!", Toast.LENGTH_SHORT).show();
                }
                setupNewQuestion();
            }, 1000);
        } else {
           // b.setBackgroundColor(Color.RED);
            Toast.makeText(this, "Wrong Answer! Try again.", Toast.LENGTH_SHORT).show();

           // new Handler().postDelayed(() -> b.setBackgroundColor(Color.LTGRAY), 1000);
        }
    }
}
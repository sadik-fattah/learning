package com.guercif.learning.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.guercif.learning.MainActivity;
import com.guercif.learning.R;


public class Rhytem extends AppCompatActivity {
    ArrayAdapter<String> arrayAdapter ;
    ListView list;
    TextView text;
    String[] music = {"ⴽⵔ ⴷ ⵏⴽⵔ ⴷ ⴰ ⵉⵍⵍⵉ","ⴰⵍⵎⵎⵓⴷ, ⴰⵍⵎⵎⵓⴷ, ⴰⵍⵎⵎⵓⴷ ⴰ","ⵔⵉⵖ ⵔⵉⵖ ⴰⵙⵍⵎⴰⴷ",
            "ⵉⵎⵉⴽⴽ ⵙ ⵉⵎⵉⴽⴽ","ⵙ ⵉⴷⴰⵎⵎⵏ ⵏⵏⵎ ⴰ ⵙ ⵍⵍⵉⵖ"};
    int count = 0;
    MediaPlayer audio;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rhytem);
        list = findViewById(R.id.listView);
        text = findViewById(R.id.rhytem_text);

        arrayAdapter= new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, music);
        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener((adapterView, view, i, l) -> {
            String select = (String) list.getItemAtPosition(i);
            if(count>0){
                audio.stop();
            }
            else{
                count++;
            }
            if (select.compareTo("ⴽⵔ ⴷ ⵏⴽⵔ ⴷ ⴰ ⵉⵍⵍⵉ") == 0) {
                audio = MediaPlayer.create(Rhytem.this, R.raw.trick1);
                audio.start();
                text.setText(R.string.song1);
            }
            else if(select.compareTo("ⴰⵍⵎⵎⵓⴷ, ⴰⵍⵎⵎⵓⴷ, ⴰⵍⵎⵎⵓⴷ ⴰ")==0){
                audio = MediaPlayer.create(Rhytem.this,R.raw.trick2);
                audio.start();
                text.setText(R.string.song2);
            }
            else if(select.compareTo("ⴰⵍⵎⵎⵓⴷ, ⴰⵍⵎⵎⵓⴷ, ⴰⵍⵎⵎⵓⴷ ⴰ")==0){
                audio = MediaPlayer.create(Rhytem.this,R.raw.trick3);
                audio.start();
                text.setText(R.string.song3);
            }
            else if(select.compareTo("ⵔⵉⵖ ⵔⵉⵖ ⴰⵙⵍⵎⴰⴷ")==0){
                audio = MediaPlayer.create(Rhytem.this,R.raw.trick4);
                audio.start();
                text.setText(R.string.song4);
            }
            else if(select.compareTo("ⵙ ⵉⴷⴰⵎⵎⵏ ⵏⵏⵎ ⴰ ⵙ ⵍⵍⵉⵖ")==0){
                audio = MediaPlayer.create(Rhytem.this,R.raw.trick5);
                audio.start();
                text.setText(R.string.song5);
            }

        });
    }

    public void onBackPressed() {
        super.onBackPressed();
        if (count > 0) {
            audio.stop();
        }
        Intent intent = new Intent(Rhytem.this, MainActivity.class);
        startActivity(intent);
    }
    public void onPause() {
        if (count > 0) {
            audio.stop();
        }
        super.onPause();
    }
}
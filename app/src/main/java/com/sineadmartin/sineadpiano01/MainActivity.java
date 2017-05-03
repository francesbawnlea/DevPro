package com.sineadmartin.sineadpiano01;

//READ NEW BOOK sineadmartinx@yahoo.com FOR HELP WITH CONSTRAINTS
//SOUNDS MUST START AT SAME TIME
//WHEN I CLICK C2 AND G2 AT SAME TIME WE HAVE A CHORD
//OTHERS NOT WORKING THE SAME, DUE TO HOW THEY WERE RECORDED

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button c2, d2, e2, f2, g2, bb;
    private SoundPool soundPool;

    private int sound_c2, sound_d2, sound_e2, sound_f2, sound_g2, sound_black1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c2 = (Button)findViewById(R.id.c2);
        d2 = (Button)findViewById(R.id.d2);
        e2 = (Button)findViewById(R.id.e2);
        f2 = (Button)findViewById(R.id.f2);
        g2 = (Button)findViewById(R.id.g2);

        bb = (Button)findViewById(R.id.black);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            soundPool = new SoundPool.Builder().setMaxStreams(5).build();
        }
        else{
            soundPool=new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        }

        sound_c2  = soundPool.load(this, R.raw.longdryc1, 1);
        sound_d2  = soundPool.load(this, R.raw.d2, 1);
        sound_e2  = soundPool.load(this, R.raw.e2, 1);
        sound_f2  = soundPool.load(this, R.raw.f2, 1);
        sound_g2  = soundPool.load(this, R.raw.g2, 1);

        sound_black1 = soundPool.load(this, R.raw.longdryc1, 1);//for testin


        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_c2,1,1,0,0,1);
                Toast.makeText(MainActivity.this,"This isssssssss the c2", Toast.LENGTH_SHORT).show();

            }
        });

        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_black1,1,1,0,0,1);
                Toast.makeText(MainActivity.this,"This isssss black", Toast.LENGTH_SHORT).show();

            }
        });

        d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_d2,1,1,0,0,1);
                Toast.makeText(MainActivity.this,"This is d2", Toast.LENGTH_SHORT).show();

            }
        });

        e2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_e2,1,1,0,0,1);
                Toast.makeText(MainActivity.this,"This is e2", Toast.LENGTH_SHORT).show();

            }
        });

        f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_f2,1,1,0,0,1);
                Toast.makeText(MainActivity.this,"This is f2", Toast.LENGTH_SHORT).show();

            }
        });
        g2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_g2,1,1,0,0,1);
                Toast.makeText(MainActivity.this,"This is g2", Toast.LENGTH_SHORT).show();

            }
        });

    }
}

package com.sineadmartin.sineadpiano01;

//READ NEW BOOK sineadmartinx@yahoo.com FOR HELP WITH CONSTRAINTS
//SOUNDS MUST START AT SAME TIME
//WHEN I CLICK C2 AND G2 AT SAME TIME WE HAVE A CHORD
//OTHERS NOT WORKING THE SAME, DUE TO HOW THEY WERE RECORDED

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static protected StaveCustomView cv;

    Button c, cSharp, d, dSharp, e, f, g;



    private SoundPool soundPool;

    private int sound_c, sound_cSharp, sound_d, sound_dSharp, sound_e2, sound_f2, sound_g2 ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cv = (StaveCustomView)findViewById(R.id.stave);
        //set up soundpools

        c = (Button)findViewById(R.id.c);
        cSharp = (Button)findViewById(R.id.cSharp);
        d = (Button)findViewById(R.id.d);
        dSharp = (Button)findViewById(R.id.dSharp);
        e = (Button)findViewById(R.id.e);
        f = (Button)findViewById(R.id.f);
        g = (Button)findViewById(R.id.g);



        //Button btnDraw = (Button) findViewById(R.id.c2);
        //final ImageView imgViewC2 = (ImageView) findViewById(R.id.imgViewC2);
        //final ImageView imgViewCsharp = (ImageView) findViewById(R.id.imgViewCsharp);
        //final ImageView imgViewD2 = (ImageView) findViewById(R.id.imgViewD2);



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            soundPool = new SoundPool.Builder().setMaxStreams(5).build();
        }
        else{
            soundPool=new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        }

        sound_c  = soundPool.load(this, R.raw.c, 1);
        sound_d  = soundPool.load(this, R.raw.d, 1);
        sound_dSharp  = soundPool.load(this, R.raw.d_sharp, 1);
        sound_e2  = soundPool.load(this, R.raw.e2, 1);
        sound_f2  = soundPool.load(this, R.raw.f2, 1);
        sound_g2  = soundPool.load(this, R.raw.g2, 1);


        sound_cSharp = soundPool.load(this, R.raw.c_sharp, 1);//for testing



        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                soundPool.play(sound_c,1,1,0,0,1);
                Toast.makeText(MainActivity.this,"This is the c2", Toast.LENGTH_SHORT).show();//remove these eventually
                cv.drawCircle();//call the method in customview class to create circle and place randomly on customview
                //Here we Place a note on appropriate xy pos on StaveCustomView
                //How da fk?
                //maybe this?
                //for (int i = 0; i < viewSize; i=i+1) {
                   // canvas.drawLine(0, i * (getHeight() / viewSize), getWidth(), i * (getHeight() / viewSize), linePaint);


                //imgViewD2.setImageDrawable(null);
                //make circle and place on ImageView cnote

                //drawAndPlaceNote(imgViewC2);

                //set paint
                //Paint paint = new Paint();
                //paint.setColor(Color.BLUE);
                //paint.setStyle(Paint.Style.FILL_AND_STROKE);
                //paint.setStrokeWidth(4);

                //create bitmap
               // Bitmap bmp = Bitmap.createBitmap(50,50,Bitmap.Config.ARGB_8888);//this config is best quality for the graphics

                //create canvas obj, this draws onto the butmap
                //Canvas canvas = new Canvas(bmp);//canvas objcontains built in method that creates a circle
                //canvas.drawCircle(bmp.getWidth()/2, bmp.getHeight()/2, 10,paint);//x coord, y coord, radius, color

                //output circle, by calling img view
                //imgCircle.setImageBitmap(bmp);


            }
        });

        cSharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_cSharp,1,1,0,0,1);
                //Toast.makeText(MainActivity.this,"This is theee black", Toast.LENGTH_SHORT).show();
                cv.drawCircle();//call the method in customview class to create circle and place randomly on customview

                //now create a method somewhere in here to destroy all imageviews yippee!!!!!
                //drawAndPlaceNote(imgViewCsharp);


            }

        });

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_d,1,1,0,0,1);
                //Toast.makeText(MainActivity.this,"This is d2", Toast.LENGTH_SHORT).show();
                cv.drawCircle();//call the method in customview class to create circle and place randomly on customview

                //drawAndPlaceNote(imgViewC2);

            }
        });

        dSharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_dSharp,1,1,0,0,1);
                //Toast.makeText(MainActivity.this,"This is d2", Toast.LENGTH_SHORT).show();
                cv.drawCircle();//call the method in customview class to create circle and place randomly on customview

                //drawAndPlaceNote(imgViewC2);

            }
        });

        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_e2,1,1,0,0,1);
                //Toast.makeText(MainActivity.this,"This is e2", Toast.LENGTH_SHORT).show();

            }
        });

        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_f2,1,1,0,0,1);
                //Toast.makeText(MainActivity.this,"This is f2", Toast.LENGTH_SHORT).show();

            }
        });
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_g2,1,1,0,0,1);
                //Toast.makeText(MainActivity.this,"This is g2", Toast.LENGTH_SHORT).show();

            }
        });

        //Method to destroy all ImageViews, this method will delete them before next note event occurs



    }



    //Method to create a circle, i WONT USE THIS
    public void drawAndPlaceNote(ImageView imgView){

        //set paint
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(4);

        //create bitmap
        Bitmap bmp = Bitmap.createBitmap(50,50,Bitmap.Config.ARGB_8888);//this config is best quality for the graphics

        //create canvas obj, this draws onto the butmap
        Canvas canvas = new Canvas(bmp);//canvas objcontains built in method that creates a circle
        canvas.drawCircle(bmp.getWidth()/2, bmp.getHeight()/2, 10,paint);//x coord, y coord, radius, color

        //Can I destroy all images here first before creation? try it!
        //imgView.setImageDrawable(null); Doesn't work
        //Must find a wat to create a method to destroy all images before another created
        //instead of individually doing it in each button onclick event

        //output circle, by calling img view
        imgView.setImageBitmap(bmp);


    }






}

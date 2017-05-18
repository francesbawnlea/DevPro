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

    Button c, cSharp, d, dSharp, e, f, fSharp, g, gSharp, a, aSharp, b, c1, cSharp1, d1, dSharp1, e1, f1;



    private SoundPool soundPool;

    private int sound_c, sound_cSharp, sound_d, sound_dSharp, sound_e, sound_f, sound_fSharp, sound_g, sound_gSharp, sound_a, sound_aSharp, sound_b, sound_c1,sound_cSharp1, sound_d1, sound_dSharp1,sound_e1, sound_f1   ;



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
        fSharp = (Button)findViewById(R.id.fSharp);
        g = (Button)findViewById(R.id.g);
        gSharp = (Button)findViewById(R.id.gSharp);
        a = (Button)findViewById(R.id.a);
        aSharp = (Button)findViewById(R.id.aSharp);
        b = (Button)findViewById(R.id.b);
        c1 = (Button)findViewById(R.id.c1);
        cSharp1 = (Button)findViewById(R.id.c1Sharp);
        d1 = (Button)findViewById(R.id.d1);
        dSharp1 = (Button)findViewById(R.id.d1Sharp);
        e1 = (Button)findViewById(R.id.e1);
        f1 = (Button)findViewById(R.id.f1);



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
        sound_cSharp = soundPool.load(this, R.raw.c_sharp, 1);//for testing
        sound_d  = soundPool.load(this, R.raw.d, 1);
        sound_dSharp  = soundPool.load(this, R.raw.d_sharp, 1);
        sound_e  = soundPool.load(this, R.raw.e, 1);
        sound_f  = soundPool.load(this, R.raw.f, 1);
        sound_fSharp  = soundPool.load(this, R.raw.f_sharp, 1);
        sound_g  = soundPool.load(this, R.raw.g, 1);
        sound_gSharp  = soundPool.load(this, R.raw.g_sharp, 1);
        sound_a  = soundPool.load(this, R.raw.a, 1);
        sound_aSharp  = soundPool.load(this, R.raw.a_sharp, 1);
        sound_b  = soundPool.load(this, R.raw.b, 1);
        sound_c1  = soundPool.load(this, R.raw.c1, 1);
        sound_cSharp1  = soundPool.load(this, R.raw.c_sharp1, 1);
        sound_d1  = soundPool.load(this, R.raw.d1, 1);
        sound_dSharp1  = soundPool.load(this, R.raw.d_sharp1, 1);
        sound_e1  = soundPool.load(this, R.raw.e1, 1);
        sound_f1  = soundPool.load(this, R.raw.f1, 1);

        //cv.setYcoord();//set the array full of y positions






        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                soundPool.play(sound_c,1,1,0,0,1);
                Toast.makeText(MainActivity.this,"This is the c2", Toast.LENGTH_SHORT).show();//remove these eventually
                //cv.drawCircle();//call the method in customview class to create circle and place randomly on customview

                cv.setYcoord();//NEED THIS: 13/05/17, Calling this method here fills the array with note positions
                cv.drawCircleXY(12);
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
                cv.setYcoord();
                cv.drawCircleXY(12);//call the method in customview class to create circle and place randomly on customview

                //now create a method somewhere in here to destroy all imageviews yippee!!!!!
                //drawAndPlaceNote(imgViewCsharp);


            }

        });

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_d,1,1,0,0,1);
                //Toast.makeText(MainActivity.this,"This is d2", Toast.LENGTH_SHORT).show();
                cv.setYcoord();
                cv.drawCircleXY(11);//call the method in customview class to create circle and place randomly on customview

                //drawAndPlaceNote(imgViewC2);

            }
        });

        dSharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_dSharp,1,1,0,0,1);
                //Toast.makeText(MainActivity.this,"This is d2", Toast.LENGTH_SHORT).show();
                cv.setYcoord();
                cv.drawCircleXY(11);//call the method in customview class to create circle and place randomly on customview

                //drawAndPlaceNote(imgViewC2);

            }
        });

        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_e,1,1,0,0,1);

                cv.setYcoord();
                cv.drawCircleXY(10);

            }
        });

        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_f,1,1,0,0,1);
                cv.setYcoord();
                cv.drawCircleXY(9);

            }
        });

        fSharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_fSharp,1,1,0,0,1);
                cv.setYcoord();
                cv.drawCircleXY(9);

            }
        });
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_g,1,1,0,0,1);
                cv.setYcoord();
                cv.drawCircleXY(8);

            }
        });
        gSharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_gSharp,1,1,0,0,1);
                cv.setYcoord();
                cv.drawCircleXY(8);

            }
        });
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_a,1,1,0,0,1);
                cv.setYcoord();
                cv.drawCircleXY(7);

            }
        });
        aSharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_aSharp,1,1,0,0,1);
                cv.setYcoord();
                cv.drawCircleXY(7);

            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_b,1,1,0,0,1);
                cv.setYcoord();
                cv.drawCircleXY(6);

            }
        });
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_c1,1,1,0,0,1);
                cv.setYcoord();
                cv.drawCircleXY(5);

            }
        });

        cSharp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_cSharp1,1,1,0,0,1);
                cv.setYcoord();
                cv.drawCircleXY(5);

            }
        });
        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_d1,1,1,0,0,1);
                cv.setYcoord();
                cv.drawCircleXY(4);

            }
        });
        dSharp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_dSharp1,1,1,0,0,1);
                cv.setYcoord();
                cv.drawCircleXY(4);

            }
        });
        e1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_e1,1,1,0,0,1);
                cv.setYcoord();
                cv.drawCircleXY(3);

            }
        });
        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(sound_f1,1,1,0,0,1);
                cv.setYcoord();
                cv.drawCircleXY(2);

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

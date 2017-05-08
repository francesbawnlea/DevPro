package com.sineadmartin.sineadpiano01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

import static android.R.attr.x;

/**
 * Created by Sinead on 5/6/2017.
 */

public class StaveCustomView extends View {
    private int viewSize = 6;

    //the random circle
    public Paint mPaint;
    public static Canvas mCanvas;
    private int mPivotX = 0;
    private int mPivotY = 0;
    private int radius = 20;


    private Paint linePaint = new Paint();//To draw the white lines on black canvas
    protected static ArrayList<Float> ArrayListOfNotePositions = new ArrayList<Float>();//stores the note positions on the y axis
    float[] yAxis = new float[12];//stores the y axis start point for drawing the note, need 12 places for division for twelve notes,stave divided downward into twelve
    //float average;

    // default constructor for the class that takes in a context
    public StaveCustomView(Context c) {
        super(c);
        mPaint = new Paint();
        init();
    }
    // constructor that takes in a context and also a list of attributes
// that were set through XML
    public StaveCustomView(Context c, AttributeSet as) {
        super(c, as);
        mPaint = new Paint();
        init();
    }
    // constructor that take in a context, attribute set and also a default
// style in case the view is to be styled in a certain way
    public StaveCustomView(Context c, AttributeSet as, int default_style) {
        super(c, as, default_style);
        mPaint = new Paint();
        init();
    }

    // refactored init method as most of this code is shared by all the
// constructors
    protected void init() {

        linePaint.setColor(Color.WHITE);//sets the colour for drawing the lines on the stave
        //graphPaint.setColor(Color.GREEN);
        //avgPaint.setColor(Color.RED);
        float y = (float)((getHeight()/12)+0);//div by 10 for 100 samples
        for(int i = 0; i<yAxis.length;i++){
            yAxis[i]=(float)((x*i));//fill the array with the y coords for whrer to pos the notes
        }
    }



    public void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        linePaint.setStrokeWidth(2);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setAntiAlias(true);

        //random circle
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        linePaint.setStrokeWidth(4);
        mPaint.setAntiAlias(true);


        //Draw white lines to canvas, 6 in total, for 10km to 60km/h
        for (int i = 0; i < viewSize; i=i+1) {
            canvas.drawLine(0, i * (getHeight() / viewSize), getWidth(), i * (getHeight() / viewSize), linePaint);

        }
        canvas.drawCircle(mPivotX, mPivotY, radius, mPaint);

        //Here maybe to start placing the nots corresponding to their positions? dunno??
        //Or create method outside of ondraw to be called from main to place notes on button press, sounds more like it lol
    }

    public void drawCircle() {

        int minX = radius * 2;
        int maxX = getWidth() - (radius * 2);

        int minY = radius * 2;
        int maxY = getHeight() - (radius * 2);

        //Generate random numbers for x and y locations of the circle on screen
        Random random = new Random();
        mPivotX = random.nextInt(maxX - minX + 1) + minX;
        mPivotY = random.nextInt(maxY - minY + 1) + minY;

        //important. Refreshes the view by calling onDraw function
        invalidate();
    }

    public void drawCircleToCorrectPos(){
        //How do I get the correct position?
        //Is this passed in from somewhere above, the array list?
        //Map notes to positions in the array
        //Then can place notes depending on whcih button pressed
    }

    public void placeNoteOnStave(){//DO I NEED THIS METHOD?? MAYBE NOT!

        if(!ArrayListOfNotePositions.isEmpty()){

            for(int i = 0;i<ArrayListOfNotePositions.size();i++){
                if(i==0){
                    //cv.drawLine(xAxis[i],(float)(getHeight()*((60-ArrayListOfSpeeds.get(i))*1.666)/100),
                          //  xAxis[i],(float)(getHeight()*((60-ArrayListOfSpeeds.get(i))*1.666)/100),graphPaint);

                    //float count = 0;//needs to be in here for red line to work..??
//            for (int i = 0; i < ArrayListOfSpeeds.size(); i++) {
//                count += ArrayListOfSpeeds.get(i);
//            }//make this a seperate method
//            average = count / ArrayListOfSpeeds.size();//takes addition of all elems of array and divs by array size
//            canvas.drawLine(0, (float) (getHeight() * ((60 - average) * 1.666) / 100), getWidth(), (float) (getHeight() * ((60 - average) * 1.666) / 100), avgPaint);
//            MainActivity.UpdateAverageSpeed(average);
                }
                else{
                    //canvas.drawLine(xAxis[i-1],(float)(getHeight()*((60-ArrayListOfSpeeds.get(i-1))*1.666)/100),
                           // xAxis[i],(float)(getHeight()*((60-ArrayListOfSpeeds.get(i))*1.666)/100),graphPaint);
                }
                //drawRedLine(canvas);//pass in the canvas to this method
            }
//
        }
        else{
            //if it is empty, do nothing?
            //if array list is full, 100 elements? go to tracker mng class to alter?
            //what to do?
            //lose the least recent val and shift every element down, then add new element to end of array


        }
    }


}

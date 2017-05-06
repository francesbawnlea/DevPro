package com.sineadmartin.sineadpiano01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Sinead on 5/6/2017.
 */

public class StaveCustomView extends View {
    private int viewSize = 6;
    private Paint linePaint = new Paint();//To draw the white lines on black canvas
    float[] xAxis = new float[100];//stores the x axis start point for drawing
    float average;

    // default constructor for the class that takes in a context
    public StaveCustomView(Context c) {
        super(c);
        init();
    }
    // constructor that takes in a context and also a list of attributes
// that were set through XML
    public StaveCustomView(Context c, AttributeSet as) {
        super(c, as);
        init();
    }
    // constructor that take in a context, attribute set and also a default
// style in case the view is to be styled in a certain way
    public StaveCustomView(Context c, AttributeSet as, int default_style) {
        super(c, as, default_style);
        init();
    }

    // refactored init method as most of this code is shared by all the
// constructors
    protected void init() {

        linePaint.setColor(Color.WHITE);
        //graphPaint.setColor(Color.GREEN);
        //avgPaint.setColor(Color.RED);
        float x = (float)((getWidth()/100)+9.5);//div by 10 for 100 samples
        for(int i = 0; i<xAxis.length;i++){
            xAxis[i]=(float)((x*i));
        }
    }

    public void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        linePaint.setStrokeWidth(2);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setAntiAlias(true);

        //Draw white lines to canvas, 6 in total, for 10km to 60km/h
        for (int i = 0; i < viewSize; i=i+1) {
            canvas.drawLine(0, i * (getHeight() / viewSize), getWidth(), i * (getHeight() / viewSize), linePaint);
        }
    }
}

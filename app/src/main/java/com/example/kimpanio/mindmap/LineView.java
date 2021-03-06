package com.example.kimpanio.mindmap;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by Kimpanio on 2016-06-03.
 */
public class LineView extends View {
    Paint paint = new Paint();

    // Variables for coords for drawing line.
    private float startX;
    private float startY;
    private float stopX;
    private float stopY;

    public LineView(Context context) {
        super(context);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);
    }

    @Override
    public void dispatchDraw(Canvas canvas) {
        canvas.drawLine(startX, startY, stopX, stopY, paint);
        super.dispatchDraw(canvas);
    }

    public void setStart(Bubble bubble) {
        startX = bubble.getPositionX() + bubble.getWidth()/2;
        startY = bubble.getPositionY() + bubble.getHeight()/2;
    }

    public void setStop(Bubble bubble) {
        stopX = bubble.getPositionX() + bubble.getWidth()/2;
        stopY = bubble.getPositionY() + bubble.getHeight()/2;
    }
}
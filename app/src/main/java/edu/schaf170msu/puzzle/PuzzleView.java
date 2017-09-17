package edu.schaf170msu.puzzle;


import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


/**
 * Custom view class for our Puzzle.
 */
public class PuzzleView extends View {

    /**
     * The actual puzzle
     */
    private Puzzle puzzle;


    public PuzzleView(Context context) {
        super(context);
        init(null, 0);
    }

    public PuzzleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public PuzzleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return puzzle.onTouchEvent(this, event);
    }

    private void init(AttributeSet attrs, int defStyle) {
        puzzle = new Puzzle(getContext());

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        puzzle.draw(canvas);

    }


}
package edu.schaf170msu.puzzle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

/**
 * Created by Andrew on 9/11/17.
 */

public class PuzzlePiece {
    /**
     * The image for the actual piece.
     */
    private Bitmap piece;

    /**
     * x location.
     * We use relative x locations in the range 0-1 for the center
     * of the puzzle piece.
     */
    private float x = .26f;

    /**
     * y location
     */
    private float y = .24f;

    /**
     * x location when the puzzle is solved
     */
    private float finalX;

    /**
     * y location when the puzzle is solved
     */
    private float finalY;

    public PuzzlePiece(Context context, int id, float finalX, float finalY) {
        this.finalX = finalX;
        this.finalY = finalY;

        piece = BitmapFactory.decodeResource(context.getResources(), id);
    }

    /**
     * Draw the puzzle piece
     * @param canvas Canvas we are drawing on
     * @param marginX Margin x value in pixels
     * @param marginY Margin y value in pixels
     * @param puzzleSize Size we draw the puzzle in pixels
     * @param scaleFactor Amount we scale the puzzle pieces when we draw them
     */
    public void draw(Canvas canvas, int marginX, int marginY,
                     int puzzleSize, float scaleFactor) {
        canvas.save();

        // Convert x,y to pixels and add the margin, then draw
        canvas.translate(marginX + x * puzzleSize, marginY + y * puzzleSize);

        // Scale it to the right size
        canvas.scale(scaleFactor, scaleFactor);

        // This magic code makes the center of the piece at 0, 0
        canvas.translate(-piece.getWidth() / 2, -piece.getHeight() / 2);

        // Draw the bitmap
        canvas.drawBitmap(piece, 0, 0, null);
        canvas.restore();
    }
}

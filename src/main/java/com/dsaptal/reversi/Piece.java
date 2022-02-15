package com.dsaptal.reversi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;


public class Piece {

    SideTypes side;
    public Bitmap blackPiece, whitePiece;
    int row,col;
    //int cellLocation;
    //int BOARD_DIMS = 8;
    Rect rect;


    public Piece(SideTypes side,int row,int col) {
        this.side = side;
        this.LoadPiece();
        this.row=row;
        this.col=col;
    }

    private void LoadPiece() {
        this.blackPiece = BitmapFactory.decodeResource(GameView.context.getResources(), R.drawable.blackpiece);
        this.blackPiece = Bitmap.createScaledBitmap(this.blackPiece, 74, 73, true);
        whitePiece = BitmapFactory.decodeResource(GameView.context.getResources(), R.drawable.whitepiece);
        whitePiece = Bitmap.createScaledBitmap(this.whitePiece, 74, 73, true);
    }

    public void onDraw(Canvas canvas, Paint paint) {
        int x = col * 90 + 8;
        int y = row * 100 + 226;
        rect = new Rect(x, y, x+blackPiece.getWidth(), y+blackPiece.getHeight());
        if (side == SideTypes.BLACK)
            canvas.drawBitmap(blackPiece, x, y, paint);
        else if (side == SideTypes.WHITE)
            canvas.drawBitmap(whitePiece, x, y, paint);
        /*int x = GetCellLocation(this.cellLocation) % BOARD_DIMS;
        int y = GetCellLocation(this.cellLocation) / BOARD_DIMS +3;
        x = (x * 93)-4;
        y = (y * 100) - 67;
        if (side == SideTypes.BLACK)
            canvas.drawBitmap(blackPiece, x, y, paint);
        else if (side == SideTypes.WHITE)
            canvas.drawBitmap(whitePiece, x, y, paint);
*/
    }

    /*public int GetRow(int cellLocation)
    {
        return cellLocation/10;
    }

    public int GetCol(int cellLocation)
    {
        return cellLocation%10;
    }

    public int GetCellLocation(int cellLocation)
    {
        return ((GetRow(this.cellLocation)-1)*8 + (GetCol(this.cellLocation)-2));
    }*/
}
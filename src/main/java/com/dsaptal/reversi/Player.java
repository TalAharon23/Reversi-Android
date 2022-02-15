package com.dsaptal.reversi;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

/**
 * Created by LIRAN AHARON on 30/03/2016.
 */
public class Player {
    ArrayList<Piece> pieces = new ArrayList<Piece>();
    GameService gameService;
    public Player(GameService gameService) {
        this.gameService = gameService;
    }

    public void Draw(Canvas canvas, Paint paint) {

        for(Piece piece: pieces)
            piece.onDraw(canvas,paint);
    }
}

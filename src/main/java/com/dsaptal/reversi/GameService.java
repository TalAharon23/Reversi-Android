package com.dsaptal.reversi;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

/**
 * Created by LIRAN AHARON on 27/01/2016.
 */
public class GameService {
    public static int N = 8;
    private static GameService _instance = new GameService();
    public int turn = 0;
    public boolean overGame = false;
    Piece Board[][];
    Ai ai;
    Player player;

    public GameService() {
        Board = new Piece[N][N];
        player = new Player(this);
        ai = new Ai(this);
        for (int i = 0; i < N; i++)    // set up the board
            for (int j = 0; j < N; j++) {
                if (i == 4 && j == 3 || j == 4 && i == 3)
                    Board[i][j] = new Piece(SideTypes.BLACK,i,j);
                else if (i == 3 && j == 3 || i == 4 && j == 4)
                    Board[i][j] = new Piece(SideTypes.WHITE,i,j);
                else
                    Board[i][j] = new Piece(SideTypes.EMPTY,i,j);
            }
        ai.pieces.add(Board[3][3]);
        ai.pieces.add(Board[4][4]);
        player.pieces.add(Board[4][3]);
        player.pieces.add(Board[3][4]);
    }

    void PutPiece(Player player, Piece p, SideTypes side) {
        Board[p.row][p.col].side=side;
        player.pieces.add(Board[p.row][p.col]);
        turn=(turn==1?0:1);
    }

    private boolean isOnBoard(int dest_row, int dest_col) {
        if ((dest_row >= 0) && (dest_row <= 8))
            if ((dest_col >= 0) && (dest_col <= 8))
                return true;
        return false;
    }

    public Piece RectContain(int x,int y) {
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                Piece piece=Board[i][j];
                if(piece.rect.contains(x,y))
                    return piece;

            }
        }
        return null;
    }

    public static GameService get_instance() {
        return _instance;
    }

    public void onDraw(Canvas canvas, Paint paint) { //drawing board by player's pieces
        player.Draw(canvas,paint);
        ai.Draw(canvas,paint);
        /*int x = 8;
        int y = 226;
        for (Piece[] pieceRow : Board) {
            for (Piece piece : pieceRow) {
                piece.onDraw(canvas, paint, x, y);
                x += 90;
            }
            x = 8;
            y += 100;
        }*/
    }


}

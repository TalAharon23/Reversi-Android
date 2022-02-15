package com.dsaptal.reversi;

import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Liran on 06/03/2016.
 */
public class Ai extends Player{

    ArrayList<Piece> availablePoss;
    public Ai(GameService gameService){super(gameService);}


    public void MakeaMove() {  //Ai move on board
        boolean flag = false;
        availablePoss = Rules.get_instance().IsPossible(this);
        if (!availablePoss.isEmpty()) {
             for(Piece piece: availablePoss) {
                    GameService.get_instance().PutPiece(this, piece, SideTypes.WHITE);
                    flag = true;
                    break;
                }
             }
        Toast toast = Toast.makeText(GameView.context, "YourTurn", Toast.LENGTH_LONG);
        toast.show();
        }
    }

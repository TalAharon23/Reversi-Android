package com.dsaptal.reversi;

/**
 * Created by LIRAN AHARON on 07/02/2016.
 */
import java.util.TimerTask;

public class GameUpdateTimer extends TimerTask {

    public GameView boardView;

    @Override
    public void run() {
        boardView.post(new Runnable(){ public void run(){ boardView.invalidate(); } });
    }

    public GameView getBoardView(){
        return boardView;
    }
}


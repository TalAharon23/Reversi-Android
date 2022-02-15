package com.dsaptal.reversi;

import java.util.ArrayList;

/**
 * Created by Liran on 06/03/2016.
 */
public class Rules {
    private static Rules _instance = new Rules();
    ArrayList<Piece> possPositions = new ArrayList<Piece>();


    public Rules (){
    }


    public static Rules get_instance() {
        return _instance;
    }

    public boolean LegalMove(Piece p){
        return GameService.get_instance().Board[p.row][p.col].side==SideTypes.EMPTY;
    }

    public ArrayList IsPossible(Player player)
    {
        int [][] DirMatrix =  { {0,1},{0,-1},{1,0},{-1,0},{-1,-1},{1,1},{-1,1},{1,-1}};
        for(Piece piece: player.pieces) {
                for (int i = 0; i < 8; i++) {
                    if (runOnDirection( piece, piece.row, piece.col, piece.side, DirMatrix[i][0], DirMatrix[i][1])) {
                        possPositions.add(piece);
                    }
                }
            }
        return possPositions;
    }

    public boolean runOnDirection(Piece piece, int row, int col, SideTypes side, int DirR,int DirC)
    {
        if(row == 7 || col == 0 || col == 7 || row == 0) // checks if in the frame
            return false;
        if(GameService.get_instance().Board[row][col].side == side)
            return true;
        if(GameService.get_instance().Board[row][col].side == SideTypes.EMPTY)
            return false;
        return runOnDirection(piece, row+DirR,col+DirC,side, DirR,DirC);
    }
}

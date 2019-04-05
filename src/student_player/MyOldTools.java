package student_player;

import boardgame.Board;
import pentago_swap.PentagoBoardState;
import pentago_swap.PentagoCoord;
import pentago_swap.PentagoMove;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class MyOldTools {
    public static ArrayList<Integer> quadrants;
    public static PentagoBoardState pentagoBoardState ;


    public HashMap<String, Integer> map;
    public static int player_id;


    public static void setPlayer(int id){player_id = id; }
    public static PentagoMove initialMove(PentagoBoardState boardState){
        PentagoMove myMove = (PentagoMove) boardState.getRandomMove();
        if(boardState.getPieceAt(1,1) == PentagoBoardState.Piece.EMPTY){
            myMove= new PentagoMove(1,1, PentagoBoardState.Quadrant.TL,PentagoBoardState.Quadrant.TR,boardState.getTurnPlayer());
        }
        else if(boardState.getPieceAt(1,4) == PentagoBoardState.Piece.EMPTY){
            myMove= new PentagoMove(1,4, PentagoBoardState.Quadrant.TL,PentagoBoardState.Quadrant.TR,boardState.getTurnPlayer());
        }
        else if(boardState.getPieceAt(4,1) == PentagoBoardState.Piece.EMPTY){
            myMove= new PentagoMove(4,1, PentagoBoardState.Quadrant.TL,PentagoBoardState.Quadrant.TR,boardState.getTurnPlayer());
        }
        else if(boardState.getPieceAt(4,4) == PentagoBoardState.Piece.EMPTY){
            myMove= new PentagoMove(4,4, PentagoBoardState.Quadrant.TL,PentagoBoardState.Quadrant.TR,boardState.getTurnPlayer());
        }
        return myMove ;

    }
    public static PentagoBoardState.Quadrant getQuadrant(int row, int col){
        if(row<=2 && col<=2){
            return PentagoBoardState.Quadrant.TL;
        }else if(row > 2 && col<=2){
            return PentagoBoardState.Quadrant.BL;
        }else if(row > 2 && col>2){
            return PentagoBoardState.Quadrant.BL;
        }else{
            return PentagoBoardState.Quadrant.TR;
        }
    }
    public static PentagoBoardState.Quadrant getDiagonalQuadrant(PentagoBoardState.Quadrant quad){
        if(quad== PentagoBoardState.Quadrant.TL){
            return PentagoBoardState.Quadrant.BR;
        }else if(quad== PentagoBoardState.Quadrant.BR){
            return PentagoBoardState.Quadrant.TL;
        }else if(quad== PentagoBoardState.Quadrant.BL){
            return PentagoBoardState.Quadrant.TR;
        }else{
            return PentagoBoardState.Quadrant.BL;
        }

    }
    public static PentagoBoardState.Quadrant getXNeighborQuadrant(PentagoBoardState.Quadrant quad){
        if(quad == PentagoBoardState.Quadrant.TL){
            return PentagoBoardState.Quadrant.TR;
        }else if(quad== PentagoBoardState.Quadrant.BR){
            return PentagoBoardState.Quadrant.BL;
        }else if(quad== PentagoBoardState.Quadrant.BL){
            return PentagoBoardState.Quadrant.BR;
        }else{
            return PentagoBoardState.Quadrant.TL;
        }

    }
    public static PentagoBoardState.Quadrant getYNeighborQuadrant(PentagoBoardState.Quadrant quad){
        if(quad == PentagoBoardState.Quadrant.TL){
            return PentagoBoardState.Quadrant.BL;
        }else if(quad== PentagoBoardState.Quadrant.BR){
            return PentagoBoardState.Quadrant.TR;
        }else if(quad== PentagoBoardState.Quadrant.BL){
            return PentagoBoardState.Quadrant.TL;
        }else{
            return PentagoBoardState.Quadrant.BR;
        }

    }
    public static PentagoCoord getDefenseMovesInRow(PentagoBoardState boardState, int row){
        ArrayList<PentagoMove> sameRow = new ArrayList<PentagoMove>();
        for(PentagoMove move : boardState.getAllLegalMoves()){
            if(move.getMoveCoord().getX() == row) sameRow.add(move);
        }

        if(boardState.getPieceAt(row, 0)== PentagoBoardState.Piece.EMPTY){
            System.out.println("Right Aligned Danger");
            return new PentagoCoord(row, getMaxY(sameRow).getMoveCoord().getY());
        }
        else{
            System.out.println("Left Aligned Danger");
            return new PentagoCoord(row, getMinY(sameRow).getMoveCoord().getY());
        }
    }
    public static PentagoCoord getDefenseMovesInCol(PentagoBoardState boardState, int col){
        ArrayList<PentagoMove> sameCol = new ArrayList<PentagoMove>();
        for(PentagoMove move : boardState.getAllLegalMoves()){
            if(move.getMoveCoord().getY() == col) sameCol.add(move);
        }
        if((boardState.getPieceAt(0,col) == (PentagoBoardState.Piece.EMPTY))){
            return new PentagoCoord(getMaxX(sameCol).getMoveCoord().getX(), col);
        }
        else{
            return new PentagoCoord(getMinX(sameCol).getMoveCoord().getX(), col);
        }
    }
    public static PentagoMove getMinY(ArrayList<PentagoMove> moves) {
        PentagoMove minY = moves.get(0);
        for (PentagoMove m : moves) {
            if (m.getMoveCoord().getY() < minY.getMoveCoord().getY()) {
                minY = m;
            }
        }
        return minY;
    }
    public static PentagoMove getMinX(ArrayList<PentagoMove> moves) {
        PentagoMove minX = moves.get(0);
        for (PentagoMove m : moves) {
            if (m.getMoveCoord().getX() < minX.getMoveCoord().getX()) {
                minX = m;
            }
        }
        return minX;
    }
    public static PentagoMove getMaxX (ArrayList<PentagoMove> moves){
        PentagoMove maxX = moves.get(0);
        for (PentagoMove m : moves) {
            if (m.getMoveCoord().getX() > maxX.getMoveCoord().getX()) {
                maxX = m;
            }
        }
        return maxX;
    }
    public static PentagoMove getMaxY(ArrayList<PentagoMove> moves) {
        PentagoMove maxY = moves.get(0);
        for (PentagoMove m : moves) {
            if (m.getMoveCoord().getY() > maxY.getMoveCoord().getY()) {
                maxY = m;
            }
        }
        return maxY;
    }


    public static PentagoMove checkDanger(PentagoBoardState boardState, PentagoMove move ){
        int opponent = boardState.getOpponent();
        PentagoBoardState.Piece oppPiece;
        if(opponent == 1){
            oppPiece = PentagoBoardState.Piece.WHITE;
        }else{
            oppPiece = PentagoBoardState.Piece.BLACK;
        }
        int count = 0;

        for (int row = 0; row <= 5; row++) {
            for (int col = 0; col <= 5; col++) {
                if (boardState.getPieceAt(row, col) == oppPiece) count++;
                        if (count == 3){
                            return new PentagoMove(getDefenseMovesInRow(boardState, row), getQuadrant(row,col),getDiagonalQuadrant(getQuadrant(row,col)),boardState.getTurnPlayer());
                        }
                    }
                    count =0;
            }



        return move;
    }

    public static PentagoMove myTurn (PentagoBoardState boardState){
        HashMap<PentagoMove, Integer> moves = heuristicFunctionMap(boardState);
        ArrayList<PentagoMove> topMoves = getTopMoves(moves);
        int sims = 10;
        int plusMinus;
        PentagoMove myMove = topMoves.get(0);
//        for(PentagoMove m : topMoves){
//            plusMinus = 0;
//            for(int i = 0 ; i < sims; i++){
//                HashMap<PentagoMove, Integer> simmoves = heuristicFunctionMap(boardState);
//                ArrayList<PentagoMove> topSimMoves = getTopMoves(moves);
//                plusMinus += simulateGame(boardState,myMove);
//            }
//            if()
//        }
//        int numberOfGames = sims*(topMoves.size()-1);
//        double winrate = plusMinus / numberOfGames;
//        System.out.println("The win rate is: " + winrate);
        return myMove;
    }

    public static PentagoMove heuristicFunction(PentagoBoardState boardState){
        ArrayList<PentagoMove > allmoves = boardState.getAllLegalMoves();
        TreeMap<Integer, Integer > map = new TreeMap<Integer, Integer>();
        for(int i = 0 ; i < allmoves.size()-1; i++){
            PentagoMove m = allmoves.get(i);
            map.put(getHeuristic(m, boardState), i);
        }
        int bestMoveindex =  map.get(map.floorKey(map.size()-1));
        PentagoMove bestMove = allmoves.get(bestMoveindex);
        System.out.println("Playing:" + bestMove.getMoveCoord().getX() + "," + bestMove.getMoveCoord().getY() + " with heuristic "+ getHeuristic(bestMove, boardState));
        return bestMove;
    }

    public static HashMap<PentagoMove, Integer> heuristicFunctionMap(PentagoBoardState boardState){
        ArrayList<PentagoMove > allmoves = boardState.getAllLegalMoves();
        HashMap<PentagoMove, Integer > map = new HashMap<>();
        for(int i = 0 ; i < allmoves.size()-1; i++){
            PentagoMove m = allmoves.get(i);
            map.put(m, getHeuristic(m, boardState));
        }
        return map;
    }

    public static ArrayList<PentagoMove> getTopMoves (HashMap<PentagoMove, Integer>map){
        ArrayList<PentagoMove> topMoves = new ArrayList();
        int max  = 0;
        for(int i = 0  ;  i < map.size() -1; i ++){
            if(map.get(i) > max ){
                max = map.get(i);
                topMoves.clear();
            } else{
                topMoves.add((PentagoMove) (map.keySet()).toArray()[i]);
            }

        }
        return topMoves;
    }

    public static PentagoMove getRandomTopMove(ArrayList<PentagoMove> topMoves) {
        int rand =(int) Math.random()*(topMoves.size()-1);
        return topMoves.get(rand);
    }


    public static int simulateGame(PentagoBoardState boardState , PentagoMove move){
        System.out.println("Simulation");
        PentagoBoardState boardStateClone = (PentagoBoardState)boardState.clone();
        boardStateClone.processMove(move);
        while(boardStateClone.getWinner() == Board.NOBODY){
            move = heuristicFunction(boardStateClone);
            System.out.println("Player" + boardStateClone.getTurnPlayer() + " plays: " + move.toPrettyString());
            boardStateClone.processMove(move);
        }
        System.out.println("This game evaluated to  "+  evaluateGame(boardStateClone));
        return evaluateGame(boardStateClone);
    }

    public static void playMove(PentagoBoardState boardState){
        PentagoMove move = heuristicFunction(boardState);
        boardState.processMove(move);
    }
    public static int evaluateGame (PentagoBoardState boardState){
        if(boardState.getWinner() == player_id){
            // winner ret 1
            return 1;
        }
        else if(boardState.getWinner() != player_id && boardState.getWinner()!= Board.NOBODY){
            //loss
            return -1;
        }else if(boardState.getWinner()== Board.NOBODY){
            //tie game
            return 0;
        }else{
            //unknown
            return 0;
        }

    }
    public static int getHeuristic(PentagoMove move, PentagoBoardState boardState ){
        int rowheuristic = getMyPiecesInRow(boardState, move.getMoveCoord().getX());
        int colheuristic = getMyPiecesInCol(boardState, move.getMoveCoord().getY());
        return rowheuristic+colheuristic;
    }
    public static int getMyPiecesInRow(PentagoBoardState boardState, int row){
        int me = boardState.getOpponent(); //BLACK == 0 ; WHITE ==1
        int numberOfPieces = 0;
        for(int i = 0 ; i <= 5; i ++){
            if(boardState.getPieceAt(row, i) == PentagoBoardState.Piece.WHITE && me==1) numberOfPieces++;
            else if(boardState.getPieceAt(row, i) == PentagoBoardState.Piece.BLACK && me==0) numberOfPieces++;
        }
        return numberOfPieces;
    }
    public static int getMyPiecesInCol(PentagoBoardState boardState, int col){
        int me = boardState.getOpponent();
        int numberOfPieces = 0;
        for(int i = 0 ; i <= 5; i ++){
            if(boardState.getPieceAt(i, col) == PentagoBoardState.Piece.WHITE && me==1) numberOfPieces++;
            else if(boardState.getPieceAt(i, col) == PentagoBoardState.Piece.BLACK && me==0) numberOfPieces++;
        }

        return numberOfPieces;

    }
    public static PentagoMove gameWinnable(PentagoBoardState boardState){
        ArrayList<PentagoMove> moves = boardState.getAllLegalMoves();

        for(PentagoMove m : moves){
            PentagoBoardState boardStateClone = (PentagoBoardState)boardState.clone();
            boardStateClone.processMove(m);
            if(boardStateClone.getWinner() == boardStateClone.getOpponent()){
                return m;
            }
        }
        return null;
    }


    public static double monteCarloSimulation(PentagoBoardState boardState, PentagoMove move){
        int numberOfGames = 10;
        int plusMinus = 0;
        for(int i = 0 ; i < numberOfGames ; i++){
            plusMinus = simulateGame(boardState, move);
        }
        return plusMinus / numberOfGames;
    }



}

package student_player;

import boardgame.Board;
import boardgame.BoardState;
import pentago_swap.PentagoBoard;
import pentago_swap.*;
import sun.applet.Main;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.UnaryOperator;


public class MyTools {
    private PentagoBoardState.Piece[][] board;

    public static ArrayList <PentagoCoord>diagA = new ArrayList<>();
    public static ArrayList<PentagoCoord> diagB = new ArrayList<>();
    public static ArrayList <PentagoCoord>diagC = new ArrayList<>();
    public static ArrayList <PentagoCoord>diagD = new ArrayList<>();
    public static ArrayList <PentagoCoord>diagE = new ArrayList<>();
    public static ArrayList <PentagoCoord>diagF = new ArrayList<>();
    public static final int BOARD_SIZE = 6;



    private static final UnaryOperator<PentagoCoord> getNextDiagRight = c -> new PentagoCoord(c.getX()+1, c.getY()+1);
    private static final UnaryOperator<PentagoCoord> getNextDiagLeft = c -> new PentagoCoord(c.getX()+1, c.getY()-1);
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
<<<<<<< HEAD
    public static void setCoords(PentagoBoardState boardState){
        List<PentagoCoord> coordsA = Arrays.asList(new PentagoCoord(0,4), new PentagoCoord(1,3), new PentagoCoord(2,2), new PentagoCoord(3,1), new PentagoCoord(4,0));
        List<PentagoCoord> coordsB = Arrays.asList(new PentagoCoord(0,5), new PentagoCoord(1,4), new PentagoCoord(2,3), new PentagoCoord(3,2), new PentagoCoord(4,1), new PentagoCoord(5,0));
        List<PentagoCoord> coordsC = Arrays.asList(new PentagoCoord(1,5), new PentagoCoord(2,4), new PentagoCoord(3,3), new PentagoCoord(4,2), new PentagoCoord(5,1));
        List<PentagoCoord> coordsD = Arrays.asList(new PentagoCoord(0,1), new PentagoCoord(1,2), new PentagoCoord(2,3), new PentagoCoord(3,4), new PentagoCoord(4,5));
        List<PentagoCoord> coordsE = Arrays.asList(new PentagoCoord(0,0), new PentagoCoord(1,1), new PentagoCoord(2,2), new PentagoCoord(3,3), new PentagoCoord(4,4), new PentagoCoord(5,5));
        List<PentagoCoord> coordsF = Arrays.asList(new PentagoCoord(1,0), new PentagoCoord(2,1), new PentagoCoord(3,2), new PentagoCoord(4,3), new PentagoCoord(5,4));
        diagA.addAll(coordsA);
        diagB.addAll(coordsB);
        diagC.addAll(coordsC);
        diagD.addAll(coordsD);
        diagE.addAll(coordsE);
        diagF.addAll(coordsF);


=======
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

        if(boardState.getPieceAt(row, 0) == PentagoBoardState.Piece.EMPTY){
            System.out.println("Right Aligned Danger");
            return getMaxX(sameRow).getMoveCoord();
        }
        else{
            System.out.println("Left Aligned Danger");
            return getMinX(sameRow).getMoveCoord();
        }
    }
    public static PentagoCoord getDefenseMovesInCol(PentagoBoardState boardState, int col){
        ArrayList<PentagoMove> sameCol = new ArrayList<PentagoMove>();
        ArrayList<PentagoMove> moves = boardState.getAllLegalMoves();
        for(PentagoMove move : moves){
            if(move.getMoveCoord().getY() == col) sameCol.add(move);
        }
        if((boardState.getPieceAt(0,col) == (PentagoBoardState.Piece.EMPTY))){
            return getMaxY(sameCol).getMoveCoord();
        }
        else{
            return getMinY(sameCol).getMoveCoord();
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
>>>>>>> parent of b47362f... BETA DONE
    }


    public static PentagoMove myTurn (PentagoBoardState boardState){
        HashMap<PentagoMove, Integer> moves = heuristicFunctionMap(boardState);
        ArrayList<PentagoMove> topMoves = getTopMoves(moves);
        ArrayList<PentagoMove> midMoves = getMidMoves(moves);
        ArrayList<PentagoMove> lowerMoves = getLowerMoves(moves);


        int simsTop = 10;
        int simsMid = 5;
        int simslower = 5;
        double plusMinus = 0;
        double winRateTops=0;
        double winRateMids=0;
        double winRateLower=0;
        double previous ;
        PentagoMove myMove = null;
        PentagoMove myMoveMid = null;
        PentagoMove myMoveLower = null;

        for(PentagoMove m : topMoves){
            previous = plusMinus;
            plusMinus = 0;
            for(int i = 0 ; i < simsTop; i++){
                plusMinus += simulateGame(boardState,m);
            }
            winRateTops = plusMinus /simsTop;
            if(plusMinus > previous){
                myMove = m;
            }
        }
<<<<<<< HEAD
        plusMinus = 0;
        for(PentagoMove m : midMoves){
            previous = plusMinus;
            plusMinus = 0;
            for(int i = 0 ; i < simsMid; i++){
                plusMinus += simulateGame(boardState,m);
            }
            winRateMids = plusMinus /simsMid;
            if(plusMinus > previous){
                myMoveMid = m;
            }
        }
     return myMove ;




=======
        return myMove;
//        plusMinus = 0;
//        for(PentagoMove m : midMoves){
//            previous = plusMinus;
//            plusMinus = 0;
//            for(int i = 0 ; i < simsMid; i++){
//                plusMinus += simulateGame(boardState,m);
//            }
//            winRateMids = plusMinus /simsMid;
//            if(plusMinus > previous){
//                myMoveMid = m;
//            }
//        }
>>>>>>> parent of b47362f... BETA DONE
//        plusMinus = 0;
//        for(PentagoMove m : lowerMoves){
//            previous = plusMinus;
//            plusMinus = 0;
//            for(int i = 0 ; i < simslower; i++){
//                plusMinus += simulateGame(boardState,m);
//            }
//            winRateLower = plusMinus /simslower;
//            if(plusMinus > previous){
//                myMoveLower = m;
//            }
//        }
//        double max = Math.max(winRateLower, Math.max(winRateMids, winRateTops));
//
//        if(max == winRateLower){
//            System.out.println("Chose a lower wit win rate: " + winRateLower);
//            return myMoveLower;
//        } else
//            if(max == winRateMids){
//            System.out.println("Chose a mid wit win rate: " + winRateMids);
//            return myMoveMid;
//        }else{
//            return myMove;
//        }
//        System.out.println("The win rate of this move is: " + winrate + "based on " + total + " total  games" );
    }

    public static HashMap<PentagoMove, Integer> heuristicFunctionMap(PentagoBoardState boardState){
        ArrayList<PentagoMove > allmoves = boardState.getAllLegalMoves();
        HashMap<PentagoMove, Integer > map = new HashMap<>();
        for(int i = 0 ; i <= allmoves.size()-1; i++){
            PentagoMove m = allmoves.get(i);
            map.put(m, getHeuristic(m, boardState));
        }
        return map;
    }

    public static ArrayList<PentagoMove> getTopMoves (HashMap<PentagoMove, Integer>map){
        ArrayList<PentagoMove> topMoves = new ArrayList();
        int maxValueInMap=(Collections.max(map.values()));  // This will return max value in the Hashmap
            for(Map.Entry<PentagoMove, Integer> entry : map.entrySet()){
                if(entry.getValue()==maxValueInMap){
                    topMoves.add(entry.getKey());
                }

            }
        return topMoves;
    }

    public static ArrayList<PentagoMove> getMidMoves (HashMap<PentagoMove, Integer>map){
        ArrayList<PentagoMove> midMoves = new ArrayList();
        int maxValueInMap=(Collections.max(map.values()));  // This will return max value in the Hashmap
        int minValueInMap=(Collections.min(map.values()));  // This will return max value in the Hashmap

        for(Map.Entry<PentagoMove, Integer> entry : map.entrySet()){
            if(entry.getValue()!= maxValueInMap && entry.getValue()!=minValueInMap){
                midMoves.add(entry.getKey());
            }

        }
        return midMoves;
    }
    public static ArrayList<PentagoMove> getLowerMoves (HashMap<PentagoMove, Integer>map){
        ArrayList<PentagoMove> lowerMoves = new ArrayList();
        int maxValueInMap=(Collections.max(map.values()));  // This will return max value in the Hashmap
        int minValueInMap=(Collections.min(map.values()));  // This will return max value in the Hashmap

        for(Map.Entry<PentagoMove, Integer> entry : map.entrySet()){
            if(entry.getValue()== minValueInMap){
                lowerMoves.add(entry.getKey());
            }

        }
        return lowerMoves;
    }



    public static PentagoMove getRandomTopMove(ArrayList<PentagoMove> topMoves) {
        int rand =(int) Math.random()*(topMoves.size()-1);
        return topMoves.get(rand);
    }


    public static double simulateGame(PentagoBoardState boardState , PentagoMove move){
        PentagoBoardState boardStateClone = (PentagoBoardState)boardState.clone();
        boardStateClone.processMove(move);
        while(boardStateClone.getWinner() == Board.NOBODY ){
            HashMap<PentagoMove, Integer> map = heuristicFunctionMap(boardStateClone);
                ArrayList<PentagoMove> moves = getTopMoves(map);
                move = getRandomTopMove(moves);
                (boardStateClone).processMove(move);
        }

        return evaluateGame(boardStateClone);
    }


    public static double evaluateGame (PentagoBoardState boardState){
        if(boardState.getWinner() == player_id){
            // winner ret 1
            return 1;
        }
        else if(boardState.getWinner() != player_id && boardState.getWinner()!= Board.NOBODY){
            //loss
            return -5;
        }else if(boardState.getWinner()== Board.NOBODY){
            //tie game
            return 0.5;
        }else{
            //unknown
            return 0.0;
        }

    }
<<<<<<< HEAD
    public static int getHeuristic(PentagoMove move, PentagoBoardState boardState){
        PentagoBoardState boardStateClone = (PentagoBoardState)boardState.clone();
        int rowheuristic = getPiecesInRow(boardStateClone, move.getMoveCoord().getX());
        int colheuristic = getPiecesInCol(boardStateClone, move.getMoveCoord().getY());
        int diagheuristic = 0;
        int max = Math.max(diagheuristic, Math.max(rowheuristic,colheuristic));

        return Math.max(diagheuristic, Math.max(rowheuristic,colheuristic));
=======
    public static int getHeuristic(PentagoMove move, PentagoBoardState boardState ){
        int rowheuristic = getMyPiecesInRow(boardState, move.getMoveCoord().getX());
        int colheuristic = getMyPiecesInCol(boardState, move.getMoveCoord().getY());
//        int rowOppheuristic = getOppPiecesInRow(boardStateClone,move.getMoveCoord().getX());
//        int colOppheuristic = getOppPiecesInCol(boardStateClone,move.getMoveCoord().getY());
        int a = Math.max(rowheuristic, colheuristic);
//        int b = Math.max(rowOppheuristic, colOppheuristic);
        return a;
>>>>>>> parent of b47362f... BETA DONE
    }


    public static int getPiecesInRow(PentagoBoardState boardState, int row){
        int bot;
        if(boardState.firstPlayer() == player_id){
            bot =0;
        }else{
            bot =1;
        }
        int opp = boardState.getOpponent(); //BLACK == 0 ; WHITE ==1
        int numberOfMyPieces = 0;
        int numberOfOppPieces = 0;
        for(int i = 0 ; i <= 5; i ++){
            if(boardState.getPieceAt(row, i) == PentagoBoardState.Piece.WHITE && opp==1) numberOfMyPieces++;
            else if(boardState.getPieceAt(row, i) == PentagoBoardState.Piece.BLACK && opp==0) numberOfMyPieces++;
            else if(boardState.getPieceAt(row, i) == PentagoBoardState.Piece.WHITE && bot==1) numberOfOppPieces++;
            else if(boardState.getPieceAt(row, i) == PentagoBoardState.Piece.BLACK && bot==0) numberOfOppPieces++;
        }
        return Math.max(numberOfMyPieces, numberOfOppPieces);
    }
    public static int getPiecesInCol(PentagoBoardState boardState, int col){
        int bot;
        if(boardState.firstPlayer() == player_id){
            bot =0;
        }else{
            bot =1;
        }

        int opp = boardState.getOpponent();
        int numberOfMyPieces = 0;
        int numberOfOppPieces = 0 ;
        for(int i = 0 ; i <= 5; i ++){
            if(boardState.getPieceAt(i, col) == PentagoBoardState.Piece.WHITE && opp==1) numberOfMyPieces++;
            else if(boardState.getPieceAt(i, col) == PentagoBoardState.Piece.BLACK && opp==0) numberOfMyPieces++;
            else if(boardState.getPieceAt(i, col) == PentagoBoardState.Piece.WHITE && bot==1) numberOfOppPieces++;
            else if(boardState.getPieceAt(i, col) == PentagoBoardState.Piece.BLACK && bot==0) numberOfOppPieces++;
        }

        return Math.max(numberOfMyPieces, numberOfOppPieces);

    }

    public static int getPiecesInDiag(PentagoBoardState boardState, PentagoCoord coord){
        int bot;
        if(boardState.firstPlayer() == player_id){
            bot =0;
        }else{
            bot =1;
        }
        int opp = boardState.getOpponent(); //BLACK == 0 ; WHITE ==1
        int myA = 0;
        int OppA = 0;
        ArrayList<Integer> maxs = new ArrayList<>();
        int x = coord.getX();
        int y = coord.getY();

        for(PentagoCoord c : diagA){
            if(diagA.contains(coord)){
                if(boardState.getPieceAt(c.getX(), c.getY()) == PentagoBoardState.Piece.WHITE && opp==1) myA++;
                else if(boardState.getPieceAt(c.getX(), c.getY()) == PentagoBoardState.Piece.BLACK && opp==0) myA++;
                else if(boardState.getPieceAt(c.getX(), c.getY()) == PentagoBoardState.Piece.WHITE && bot==1) OppA++;
                else if(boardState.getPieceAt(c.getX(), c.getY()) == PentagoBoardState.Piece.BLACK && bot==0) OppA++;
            }

        }
        maxs.add(Math.max(myA, OppA));

        int myB = 0;
        int OppB = 0;
        for(PentagoCoord c : diagB){
            if(diagB.contains(coord)){
                if(boardState.getPieceAt(c.getX(), c.getY()) == PentagoBoardState.Piece.WHITE && opp==1) myB++;
                else if(boardState.getPieceAt(c.getX(), c.getY()) == PentagoBoardState.Piece.BLACK && opp==0) myB++;
                else if(boardState.getPieceAt(c.getX(), c.getY()) == PentagoBoardState.Piece.WHITE && bot==1) OppB++;
                else if(boardState.getPieceAt(c.getX(), c.getY()) == PentagoBoardState.Piece.BLACK && bot==0) OppB++;
            }

        }
        maxs.add(Math.max(myB, OppB));

        int myC = 0;
        int OppC = 0;
        for(PentagoCoord c : diagC){
            if(diagC.contains(coord)){
                if(boardState.getPieceAt(c.getX(), c.getY()) == PentagoBoardState.Piece.WHITE && opp==1) myC++;
                else if(boardState.getPieceAt(c.getX(), c.getY()) == PentagoBoardState.Piece.BLACK && opp==0) myC++;
                else if(boardState.getPieceAt(c.getX(), c.getY()) == PentagoBoardState.Piece.WHITE && bot==1) OppC++;
                else if(boardState.getPieceAt(c.getX(), c.getY()) == PentagoBoardState.Piece.BLACK && bot==0) OppC++;
            }

        }
        maxs.add(Math.max(myC, OppC));

        int myD = 0;
        int OppD = 0;
        for(PentagoCoord c : diagD){
            if(diagD.contains(coord)){
                if(boardState.getPieceAt(c.getX(), c.getY()) == PentagoBoardState.Piece.WHITE && opp==1) myD++;
                else if(boardState.getPieceAt(c.getX(), c.getY()) == PentagoBoardState.Piece.BLACK && opp==0) myD++;
                else if(boardState.getPieceAt(c.getX(), c.getY()) == PentagoBoardState.Piece.WHITE && bot==1) OppD++;
                else if(boardState.getPieceAt(c.getX(), c.getY()) == PentagoBoardState.Piece.BLACK && bot==0) OppD++;
            }

        }
        maxs.add(Math.max(myD, OppD));

        int myE = 0;
        int OppE = 0;
        for(PentagoCoord c : diagE){
            if(diagE.contains(coord)){
                if(boardState.getPieceAt(c.getX(), c.getY()) == PentagoBoardState.Piece.WHITE && opp==1) myE++;
                else if(boardState.getPieceAt(c.getX(), c.getY()) == PentagoBoardState.Piece.BLACK && opp==0) myE++;
                else if(boardState.getPieceAt(c.getX(), c.getY()) == PentagoBoardState.Piece.WHITE && bot==1) OppE++;
                else if(boardState.getPieceAt(c.getX(), c.getY()) == PentagoBoardState.Piece.BLACK && bot==0) OppE++;
            }

        }
        maxs.add(Math.max(myE, OppE));

        int myF = 0;
        int OppF = 0;
        for(PentagoCoord c : diagF){
            if(diagF.contains(coord)){
                if(boardState.getPieceAt(c.getX(), c.getY()) == PentagoBoardState.Piece.WHITE && opp==1) myF++;
                else if(boardState.getPieceAt(c.getX(), c.getY()) == PentagoBoardState.Piece.BLACK && opp==0) myF++;
                else if(boardState.getPieceAt(c.getX(), c.getY()) == PentagoBoardState.Piece.WHITE && bot==1) OppF++;
                else if(boardState.getPieceAt(c.getX(), c.getY()) == PentagoBoardState.Piece.BLACK && bot==0) OppF++;
            }

        }
        maxs.add(Math.max(myF, OppF));

        return Collections.max(maxs);

    }

    public static int getOppPiecesInRow(PentagoBoardState boardState, int row){
        int bot;
        if(boardState.firstPlayer() == player_id){
            bot =0;
        }else{
            bot =1;
        }
        int numberOfPieces = 0;
        for(int i = 0 ; i <= 5; i ++){
            if(boardState.getPieceAt(row, i) == PentagoBoardState.Piece.WHITE && bot==1) numberOfPieces++;
            else if(boardState.getPieceAt(row, i) == PentagoBoardState.Piece.BLACK && bot==0) numberOfPieces++;
        }
        return numberOfPieces;
    }

    public static int getOppPiecesInCol(PentagoBoardState boardState, int col){
        int bot;
        if(boardState.firstPlayer() == player_id){
            bot =0;
        }else{
            bot =1;
        }
        int numberOfPieces = 0;
        for(int i = 0 ; i <= 5; i ++){
            if(boardState.getPieceAt(i, col) == PentagoBoardState.Piece.WHITE && bot==1) numberOfPieces++;
            else if(boardState.getPieceAt(i, col) == PentagoBoardState.Piece.BLACK && bot==0) numberOfPieces++;
        }

        return numberOfPieces;

    }
    public static PentagoMove gameWinnable(PentagoBoardState boardState){
        ArrayList<PentagoMove> moves = boardState.getAllLegalMoves();

        for(PentagoMove m : moves){
            PentagoBoardState boardStateClone = (PentagoBoardState)boardState.clone();
            boardStateClone.processMove(m);
            if(boardStateClone.getWinner() == player_id){
                return m;
            }
        }
        return null;
    }

    public static PentagoMove checkDanger(PentagoBoardState boardState, PentagoMove move){
        int opponent = boardState.getOpponent();
        int count = 0;
        PentagoBoardState.Piece piece ;
        if(opponent == 1) {
            piece = PentagoBoardState.Piece.WHITE;
        }     else{
            piece = PentagoBoardState.Piece.BLACK;
        }       //Check Columns
        for (int col = 0; col <= 5; col++) {
                    for (int row = 0; row <= 5; row++) {
                        if (boardState.getPieceAt(row, col) == piece) count++;
                        if (count == 3) {
                            System.out.println("DANGER");
                            return new PentagoMove(getDefenseMovesInCol(boardState, col), getQuadrant(row, col), getDiagonalQuadrant(getQuadrant(row, col)), boardState.getTurnPlayer());
                        }
                    }

                    count =0;

            }

        for (int row = 0; row <= 5; row++){
            for (int col = 0; col <= 5; col++) {
                if (boardState.getPieceAt(row, col) == piece)count++;
                if (count == 3) {
                    System.out.println("DANGER");
                    return new PentagoMove(getDefenseMovesInRow(boardState, col), getQuadrant(row, col), getDiagonalQuadrant(getQuadrant(row, col)), boardState.getTurnPlayer());
                }
            }
            count = 0;
        }



        return move;
    }

}
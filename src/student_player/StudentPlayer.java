package student_player;

import boardgame.Move;
import pentago_swap.PentagoMove;

import pentago_swap.PentagoPlayer;
import pentago_swap.PentagoBoardState;

/** A player file submitted by a student. */
public class StudentPlayer extends PentagoPlayer {

    /**
     * You must modify this constructor to return your student number. This is
     * important, because this is what the code that runs the competition uses to
     * associate you with your agent. The constructor should do nothing else.
     */
    public StudentPlayer() {
        super("260740998");
    }

    /**
     * This is the primary method that you need to implement. The ``boardState``
     * object contains the current state of the game, which your agent must use to
     * make decisions.
     */


    public PentagoMove chooseMove(PentagoBoardState boardState) {

        // You probably will make separate functions in MyTools.
        // For example, maybe you'll need to load some pre-processed best opening
        // strategies...
        Move myMove = boardState.getRandomMove();
        MyTools.simulateGame(boardState, (PentagoMove) myMove);
        MyTools.setPlayer(player_id);
        System.out.println("2607 Pieces in row 0:" + MyTools.getMyPiecesInRow(boardState, 0));
        System.out.println("2607 Pieces in row 1:" + MyTools.getMyPiecesInRow(boardState, 1));
        System.out.println("2607 Pieces in row 2:" + MyTools.getMyPiecesInRow(boardState, 2));
        System.out.println("2607 Pieces in row 3:" + MyTools.getMyPiecesInRow(boardState, 3));
        System.out.println("2607 Pieces in row 4:" + MyTools.getMyPiecesInRow(boardState, 4));
        System.out.println("2607 Pieces in row 5:" + MyTools.getMyPiecesInRow(boardState, 5));

        System.out.println("");

        System.out.println("2607 Pieces in col 0:" + MyTools.getMyPiecesInCol(boardState, 0));
        System.out.println("2607 Pieces in col 1:" + MyTools.getMyPiecesInCol(boardState, 1));
        System.out.println("2607 Pieces in col 2:" + MyTools.getMyPiecesInCol(boardState, 2));
        System.out.println("2607 Pieces in col 3:" + MyTools.getMyPiecesInCol(boardState, 3));
        System.out.println("2607 Pieces in col 4:" + MyTools.getMyPiecesInCol(boardState, 4));
        System.out.println("2607 Pieces in col 5:" + MyTools.getMyPiecesInCol(boardState, 5));



        System.out.println("OPPONENT: Rows");

        System.out.println("Opponent Pieces in row 0:" + MyTools.getOppPiecesInRow(boardState, 0));
        System.out.println("Opponent Pieces in row 1:" + MyTools.getOppPiecesInRow(boardState, 1));
        System.out.println("Opponent Pieces in row 2:" + MyTools.getOppPiecesInRow(boardState, 2));
        System.out.println("Opponent Pieces in row 3:" + MyTools.getOppPiecesInRow(boardState, 3));
        System.out.println("Opponent Pieces in row 4:" + MyTools.getOppPiecesInRow(boardState, 4));
        System.out.println("Opponent Pieces in row 5:" + MyTools.getOppPiecesInRow(boardState, 5));
        System.out.println("OPPONENT: Cols");

        System.out.println("Opponent Pieces in col 0:" + MyTools.getOppPiecesInCol(boardState, 0));
        System.out.println("Opponent Pieces in col 1:" + MyTools.getOppPiecesInCol(boardState, 1));
        System.out.println("Opponent Pieces in col 2:" + MyTools.getOppPiecesInCol(boardState, 2));
        System.out.println("Opponent Pieces in col 3:" + MyTools.getOppPiecesInCol(boardState, 3));
        System.out.println("Opponent Pieces in col 4:" + MyTools.getOppPiecesInCol(boardState, 4));
        System.out.println("Opponent Pieces in col 5:" + MyTools.getOppPiecesInCol(boardState, 5));

        if(boardState.getTurnNumber()<3){
            myMove = MyTools.initialMove(boardState);
        }else{
              myMove  = MyTools.myTurn(boardState);
        }
        PentagoMove winningMove = MyTools.gameWinnable(boardState);
        if(winningMove != null){
            System.out.println("Game Over!");
            return winningMove;
        }
        int heuristic = MyTools.getHeuristic((PentagoMove)myMove, boardState);
        System.out.println("The heuristic is:" + heuristic);
        PentagoMove m = (PentagoMove) myMove;
        // Return your move to be processed by the server.

        return ((PentagoMove) myMove);
    }
}
package student_player;

import boardgame.Move;
import pentago_swap.PentagoBoardState;
import pentago_swap.PentagoMove;
import pentago_swap.PentagoPlayer;

public class MyOldPlayer extends PentagoPlayer {
    /**
     * You must modify this constructor to return your student number. This is
     * important, because this is what the code that runs the competition uses to
     * associate you with your agent. The constructor should do nothing else.
     */
    public MyOldPlayer() {
        super("OLD260740998");
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
//        MyTools.simulateGame(boardState, (PentagoMove) myMove);
        MyTools.setPlayer(player_id);

        if(boardState.getTurnNumber()<3){
            myMove = MyTools.initialMove(boardState);
        }else{
            myMove  =  MyOldTools.heuristicFunction(boardState);
        }
        PentagoMove winningMove = MyTools.gameWinnable(boardState);
        if(winningMove != null){
            System.out.println("Game Over!");
            return winningMove;
        }
        System.out.println("old one");

        // Return your move to be processed by the server.
        return ((PentagoMove) myMove);
    }

}

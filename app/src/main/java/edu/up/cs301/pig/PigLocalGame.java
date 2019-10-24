package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    PigGameState currentState;

    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        //TODO  You will implement this constructor
        currentState = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        //TODO  You will implement this method
        if(currentState.getPlayerId() == playerIdx) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        //TODO  You will implement this method
        if(action instanceof PigHoldAction){
            if (currentState.getPlayerId() == 0) {
                currentState.setPlayerOneScore(currentState.getRunningTotal() + currentState.getPlayerOneScore());
            } else {
                currentState.setPlayerTwoScore(currentState.getRunningTotal() + currentState.getPlayerTwoScore());
            }
            currentState.setRunningTotal(0);

            if(playerNames.length == 2) {
                if (currentState.getPlayerId() == 0) {
                    currentState.setPlayerId(1);
                } else {
                    currentState.setPlayerId(0);
                }
                currentState.setRunningTotal(0);
            }
            return true;
        }
        else if(action instanceof PigRollAction) {
            currentState.setDieValue((int) (Math.random()*6 + 1));
            currentState.setRunningTotal(currentState.getRunningTotal() + currentState.getDieValue());

            if (currentState.getDieValue() == 1) {
                if(playerNames.length == 2){
                    if (currentState.getPlayerId() == 0) {
                        currentState.setPlayerId(1);
                    } else {
                        currentState.setPlayerId(0);
                    }
                }
                currentState.setRunningTotal(0);
            }
            return true;
        }
        else{
            return false;
        }
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method

        PigGameState copiedState = new PigGameState(currentState);
        p.sendInfo(copiedState);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //TODO  You will implement this method
        if(currentState.getPlayerOneScore() >=50)
            return "Player 1 has won";
        else if(currentState.getPlayerTwoScore() >=50)
            return "Player 2 has won";
        return null;

    }

}// class PigLocalGame

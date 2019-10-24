package edu.up.cs301.pig;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigSmartComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigSmartComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        // TODO  You will implement this method

        if(info instanceof PigGameState) {
            PigGameState test = new PigGameState((PigGameState) info);
            if (test.getPlayerId() == playerNum) {
                if(test.getPlayerId() == 0){
                    if(test.getPlayerOneScore() >= test.getPlayerTwoScore()){
                        if(test.getRunningTotal() < 20 && 50 - test.getRunningTotal() - test.getPlayerOneScore() > 0){
                            PigRollAction rollAction = new PigRollAction(this);
                            game.sendAction(rollAction);
                        }
                        else{
                            PigHoldAction holdAction = new PigHoldAction(this);
                            game.sendAction(holdAction);
                        }
                    }
                    else{
                        if(test.getRunningTotal() < 25 && 50 - test.getRunningTotal() - test.getPlayerOneScore() > 0){
                            PigRollAction rollAction = new PigRollAction(this);
                            game.sendAction(rollAction);
                        }
                        else{
                            PigHoldAction holdAction = new PigHoldAction(this);
                            game.sendAction(holdAction);
                        }
                    }
                }
                else{
                    if(test.getPlayerTwoScore() >= test.getPlayerOneScore()){
                        if(test.getRunningTotal() < 20 && 50 - test.getRunningTotal() - test.getPlayerTwoScore() > 0){
                            PigRollAction rollAction = new PigRollAction(this);
                            game.sendAction(rollAction);
                        }
                        else{
                            PigHoldAction holdAction = new PigHoldAction(this);
                            game.sendAction(holdAction);
                        }
                    }
                    else{
                        if(test.getRunningTotal() < 25 && 50 - test.getRunningTotal() - test.getPlayerTwoScore() > 0){
                            PigRollAction rollAction = new PigRollAction(this);
                            game.sendAction(rollAction);
                        }
                        else{
                            PigHoldAction holdAction = new PigHoldAction(this);
                            game.sendAction(holdAction);
                        }
                    }
                }
            }
            else {
                return;
            }
        }
        else {
            return;
        }
    }//receiveInfo

}

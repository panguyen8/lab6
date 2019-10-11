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
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
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
                int percent = (int) (Math.random() * 2);
                if (percent == 1) {
                    PigHoldAction holdAction = new PigHoldAction(this);
                    game.sendAction(holdAction);
                } else {
                    PigRollAction rollAction = new PigRollAction(this);
                    game.sendAction(rollAction);
                }
            } else {
                return;
            }
        } else {
            return;
        }
    }//receiveInfo

}

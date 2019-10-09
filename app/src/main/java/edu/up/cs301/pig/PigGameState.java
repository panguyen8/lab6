package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

public class PigGameState extends GameState {
    private int playerId;
    private int playerOneScore;
    private int playerTwoScore;
    private int runningTotal;
    private int dieValue;

    public PigGameState() {

        playerId = 0;
        playerOneScore = 0;
        playerTwoScore = 0;
        runningTotal = 0;
    }

    public PigGameState(PigGameState oldPigGameState) {
        playerId = oldPigGameState.playerId;
        playerOneScore = oldPigGameState.playerOneScore;
        playerTwoScore = oldPigGameState.playerTwoScore;
        runningTotal = oldPigGameState.runningTotal;
        dieValue = oldPigGameState.dieValue;

    }

    public int getPlayerId(){
        return playerId;
    }

    public void setPlayerId(int newPlayerId){
        playerId = newPlayerId;
    }

    public int getPlayerOneScore() {
        return playerOneScore;
    }

    public void setPlayerOneScore(int newPlayerOneScore) {
        playerOneScore = newPlayerOneScore;
    }

    public int getPlayerTwoScore() {
        return playerTwoScore;
    }

    public void setPlayerTwoScore(int newPlayerTwoScore) {
        playerTwoScore = newPlayerTwoScore;
    }

    public int getRunningTotal() {
        return runningTotal;
    }

    public void setRunningTotal(int newRunningTotal) {
        runningTotal = newRunningTotal;
    }

    public int getDieValue() {
        return dieValue;
    }

    public void setDieValue(int newDieValue) {
        dieValue = newDieValue;
    }
}

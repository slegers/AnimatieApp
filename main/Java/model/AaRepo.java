package model;

import Controller.AaController;
import model.Game.GameState.GameState;
import model.Game.GameState.StopStatus;
import model.Game.GameType.GameType;

/**
 * Created by yanice on 27/12/16.
 */
public class AaRepo {

    private GameState state = new StopStatus();
    private GameType type;
    private AaController controller;

    public AaRepo(AaController controller){
        this.controller = controller;
    }

    public void setGameState(GameState state){
        this.state = state;
    }

    public boolean gameIsStarted(){
        return state.isStarted();
    }

    public void setGameType(GameType type){
        this.type = type;
    }
    public String getGameName(){
        return type.getNameType();
    }

}

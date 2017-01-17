package model.TimesUp.State;

import model.TimesUp.TimesUpGame;

/**
 * Created by yanice on 17/01/17.
 */
public class InitialState implements  TimesUpState {

    private TimesUpGame game;

    public InitialState(TimesUpGame game){
        this.game = game;
    }

    @Override
    public void nextButtonPushed() {

    }

    @Override
    public void startButtonPushed() {
        game.setTime("Start?");
        game.setNextName(game.getRandomName());
        game.setState(game.getNormalState());
        game.resertTimer();
    }

    @Override
    public void passButtonPushed() {

    }
}

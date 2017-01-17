package model.TimesUp.State;

import model.TimesUp.TimesUpGame;

/**
 * Created by yanice on 17/01/17.
 */
public class OutOfTimeState implements TimesUpState {
    TimesUpGame game;
    public OutOfTimeState(TimesUpGame game){
        this.game = game;
    }

    @Override
    public void nextButtonPushed() {
        game.setNextTeam();
        game.setNextName(game.getRandomName());
        game.setTime("Start?");
        game.setState(game.getInitialState());
    }

    @Override
    public void startButtonPushed() {

    }

    @Override
    public void passButtonPushed() {

    }
}

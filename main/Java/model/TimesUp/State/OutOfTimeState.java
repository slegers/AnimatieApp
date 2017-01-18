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

    }

    @Override
    public void startButtonPushed() {
        game.setState(game.getInitialState());
    }

    @Override
    public void passButtonPushed() {

    }

    @Override
    public void initiate() {
        game.setTime("Start?");
        game.stopTimer();
        game.resertTimer();
        game.setNextName(game.getRandomName());
        game.disableNextPassButton();
        game.enalbeStartButton();
        game.setState(game.getInitialState());
    }
}

package model.TimesUp.State;

import model.TimesUp.TimesUpGame;

/**
 * Created by yanice on 17/01/17.
 */
public class OutOfTimeState implements TimesUpState {

    private TimesUpGame timesUpGame;

    public OutOfTimeState(TimesUpGame timesUpGame){
        this.timesUpGame = timesUpGame;
    }

    @Override
    public void pass() {

    }

    @Override
    public void next() {

    }

    @Override
    public void start() {
        timesUpGame.setNextName(timesUpGame.getRandomName());
        timesUpGame.resertTimer();
        timesUpGame.startTimer();
        timesUpGame.setState(timesUpGame.getNormalState());
    }
}

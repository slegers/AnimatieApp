package model.TimesUp.State;

import model.TimesUp.TimesUpGame;

/**
 * Created by yanice on 17/01/17.
 */
public class NextRoundState implements TimesUpState {
    private TimesUpGame timesUpGame;

    public NextRoundState(TimesUpGame timesUpGame){
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

    }
}

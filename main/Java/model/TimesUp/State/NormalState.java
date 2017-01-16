package model.TimesUp.State;

import model.TimesUp.TimesUpGame;

/**
 * Created by yanice on 17/01/17.
 */
public class NormalState implements TimesUpState {

    private TimesUpGame timesUpGame;

    public NormalState(TimesUpGame timesUpGame){
        this.timesUpGame = timesUpGame;
    }

    @Override
    public void pass() {
        timesUpGame.setNextName(timesUpGame.getRandomName());
    }

    @Override
    public void next() {
        timesUpGame.addGuessedNames(timesUpGame.getNextName());
        timesUpGame.removeName(timesUpGame.getNextName());
        timesUpGame.setNextName(timesUpGame.getRandomName());
    }

    @Override
    public void start() {

    }
}

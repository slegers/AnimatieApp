package model.TimesUp.State;

import model.TimesUp.TimesUpGame;

/**
 * Created by yanice on 17/01/17.
 */
public class OutOfNamesState implements TimesUpState{

    TimesUpGame game;
    public OutOfNamesState(TimesUpGame game){
        this.game = game;
    }

    @Override
    public void nextButtonPushed() {
        String name = game.getNextName();
        game.removeName(name);
        game.addGuessedNames(name);
        game.setNextName(game.getRandomName());
        game.increasePoint();
    }

    @Override
    public void startButtonPushed() {

    }

    @Override
    public void passButtonPushed() {

    }

    @Override
    public void initiate() {
        game.setTime("Start?");
        game.resetNames();
        game.stopTimer();
        game.resertTimer();
        game.setNextName(game.getRandomName());
        game.disableNextPassButton();
        game.enalbeStartButton();
        game.setState(game.getInitialState());
    }

}

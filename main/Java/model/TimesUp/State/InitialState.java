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
        game.startTimer();
        game.enableNextPassButton();
        game.disalbeStartButton();
        game.setNextName(game.getRandomName());
        game.setState(game.getNormalState());
    }

    @Override
    public void passButtonPushed() {

    }

    @Override
    public void initiate() {
        game.setNextTeam();
        game.setTime("Start?");
        game.stopTimer();
        game.setNextName(game.getRandomName());
        game.disableNextPassButton();
        game.enalbeStartButton();
    }

}

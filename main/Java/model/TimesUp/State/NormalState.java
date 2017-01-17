package model.TimesUp.State;

import model.TimesUp.TimesUpGame;

/**
 * Created by yanice on 17/01/17.
 */
public class NormalState implements TimesUpState {
    TimesUpGame game;
    public NormalState(TimesUpGame game){
        this.game = game;
    }

    @Override
    public void nextButtonPushed() {
        if(game.isRunning()){
            game.increasePoint();
            game.removeName(game.getNextName());
            game.addGuessedNames(game.getNextName());
            String name = game.getRandomName();
            game.setNextName(name);
        }
    }

    @Override
    public void startButtonPushed() {
        game.startTimer();
    }

    @Override
    public void passButtonPushed() {
        if(game.isRunning()){
            String name = game.getRandomName();
            game.setNextName(name);
        }
    }
}

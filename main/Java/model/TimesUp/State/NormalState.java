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
        String name = game.getNextName();
        game.removeName(name);
        game.addGuessedNames(name);
        game.setNextName(game.getRandomName());
        game.increasePoint();
    }

    @Override
    public void startButtonPushed(){
    }

    @Override
    public void passButtonPushed() {
        game.setNextName(game.getRandomName());
    }

    @Override
    public void initiate() {

    }

}

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
        System.out.println("out of nams");

    }

    @Override
    public void startButtonPushed() {

    }

    @Override
    public void passButtonPushed() {

    }
}

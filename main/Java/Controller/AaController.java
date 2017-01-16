package Controller;

import Controller.TimesUp.TimesUpController;
import View.MainMenu;
import View.TimesUp.TimesUpSettingsView;
import View.TimesUp.TimesUpView;
import model.AaRepo;
import model.Game.GameState.StartStatus;

/**
 * Created by yanice on 25/12/16.
 */
public class AaController {
    private TimesUpController timesUpController = new TimesUpController();
    private AaRepo aaRepo = new AaRepo(this);
    public TimesUpController getTimesUpController() {
        return timesUpController;
    }

    public AaController(){ new MainMenu(this);
    }
    
    public void startTimesUpSettings(){
        if(!aaRepo.gameIsStarted()){
            aaRepo.setGameState(new StartStatus());
            timesUpController.createTimesUpSettingsView();
        }
    }
}

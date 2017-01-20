package Controller;

import Controller.Stopwatch.StopwatchController;
import Controller.TimesUp.TimesUpController;
import View.MainMenu;
import View.TimesUp.TimesUpSettingsView;
import View.TimesUp.TimesUpView;

/**
 * Created by yanice on 25/12/16.
 */
public class AaController {
    private TimesUpController timesUpController;
    private StopwatchController stopwatchController;
    public TimesUpController getTimesUpController() {
        return timesUpController;
    }

    public AaController(){ new MainMenu(this);
    }
    
    public void startTimesUpSettings(){
        timesUpController = new TimesUpController();
        timesUpController.createTimesUpSettingsView();
    }
    public void startStopwatch(){
        stopwatchController = new StopwatchController();
        stopwatchController.createStopwatchView();
    }
}

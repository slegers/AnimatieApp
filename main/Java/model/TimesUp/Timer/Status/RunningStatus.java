package model.TimesUp.Timer.Status;

/**
 * Created by yanice on 16/01/17.
 */
public class RunningStatus implements TimerStatus {


    @Override
    public boolean isRunning() {
        return true;
    }
}

package model.TimesUp.Obeserver;

/**
 * Created by yanice on 15/01/17.
 */
public interface Observer extends model.Timer.GameTimerObserver.Observer {
     void update(String name, String teamName, String time,String teamScore);

    @Override
    void update();
}

package Controller.TimesUp;

import View.Team.CreateTeamView;
import View.Timer.TimerView;
import model.TimesUp.Obeserver.Observer;
import model.TimesUp.Obeserver.Subject;
import model.TimesUp.Settings.TimesUpSettingsFacade;
import View.TimesUp.*;
import model.TimesUp.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanice on 27/12/16.
 */
public class TimesUpController implements Subject {
    private TimesUpSettingsFacade timesUpSettingsFacade = new TimesUpSettingsFacade();
    private TimesUpRepo repo = new TimesUpRepo(this);
    private ArrayList<Observer> observers = new ArrayList<>();

    public void saveTimesUpSettings(int numbTeam, int numbNames, int time, String list, boolean extraView) {
        timesUpSettingsFacade.setNumbTeams(numbTeam);
        timesUpSettingsFacade.setNmbNames(numbNames);
        timesUpSettingsFacade.setMaxTime(time);
        timesUpSettingsFacade.setFile(list);
        timesUpSettingsFacade.setAdminField(extraView);
    }
    public void addTeam(String teamName){
        repo.addTeam(teamName);

    }

    private void createTeamView(){
        new CreateTeamView(this);
    }

    public TimesUpSettingsFacade getTimesUpSettingsFacade(){
        return timesUpSettingsFacade;
    }
    public void readNames(){
        repo.readNames();
    }

    public void createTimesUpSettingsView() {
        new TimesUpSettingsView(this);
    }
    private void createTimesUpView() {
        readNames();
        if(getTimesUpSettingsFacade().getAdminField()){

           registerObserver( new TimerView(this));
        }
        new TimesUpView(this);
    }
    private boolean createAnotherTeam(){
        if(getTimesUpSettingsFacade().getNumbTeams() > repo.getTeams().size()){
            return true;
        }
        return false;
    }

    public void createTeams() {
        if(createAnotherTeam()){
            createTeamView();
        }else{
            repo.setTimer();
            repo.setNextTeam();
            createTimesUpView();
        }
    }

    public String getNextTime() {
        return repo.getTime();
    }

    @Override
    public List<Observer> getObservers() {
        return observers;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : getObservers()){
            o.update();
        }
    }
    public String getNextName(){
            return repo.getNextName();
    }

    public String getNextTeamName() {
        return repo.getCurrentTeamName();
    }

    public String getScore() {
        return repo.getCurrentTeamScore();
    }
}





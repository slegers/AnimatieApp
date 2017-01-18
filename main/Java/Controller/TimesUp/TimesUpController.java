package Controller.TimesUp;

import View.Team.CreateTeamView;
import View.Timer.TimerView;
import model.Team.Team;
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
    private TimesUpGame game = new TimesUpGame(this);
    private ArrayList<Observer> observers = new ArrayList<>();
    private  TimesUpView view;


    public void saveTimesUpSettings(int numbTeam, int numbNames, int time, String list, boolean extraView) {
        timesUpSettingsFacade.setNumbTeams(numbTeam);
        timesUpSettingsFacade.setNmbNames(numbNames);
        timesUpSettingsFacade.setMaxTime(time);
        timesUpSettingsFacade.setFile(list);
        timesUpSettingsFacade.setAdminField(extraView);
    }
    public void addTeam(String teamName){
        if(!teamNameExists(teamName)){
            game.addTeam(teamName);
        }
    }
    private boolean teamNameExists(String name){
        for(Team team : game.getTeams()){
            if(team.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public void createTeamView(){
        new CreateTeamView(this);
    }

    public TimesUpSettingsFacade getTimesUpSettingsFacade(){
        return timesUpSettingsFacade;
    }
    public void readNames(){
        game.readNames();
    }

    public void createTimesUpSettingsView() {
        new TimesUpSettingsView(this);
    }
    private void createTimesUpView() {
        readNames();
        if(getTimesUpSettingsFacade().getAdminField()){
           registerObserver( new TimerView(this));
        }
        view = new TimesUpView(this);
        registerObserver( view);
    }
    private boolean createAnotherTeam(){
        if(!(getTimesUpSettingsFacade().getNumbTeams() > game.getTeams().size())){
            return false;
        }
        return true;
    }

    public void createTeams() {
        if(createAnotherTeam()){
            createTeamView();
        }else{
            game.setTimer();
            game.setNextTeam();
            createTimesUpView();
        }
    }

    public String getNextTime() {
        return game.getTime();
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
            //o.update();
            o.update(game.getNextName(), game.getCurrentTeamName(), game.getTime(), game.getCurrentTeamScore());
        }
    }
    public String getNextName(){
            return game.getNextName();
    }

    public String getNextTeamName() {
        return game.getCurrentTeamName();
    }

    public String getScore() {
        return game.getCurrentTeamScore();
    }

    public void startButtonPushed() {
         game.startButtonPushed();
            notifyObservers();
    }
    public void nextButtonPushed() {
        game.nextButtonPushed();
        notifyObservers();
    }
    public void passButtonPushed() {
        game.passButtonPushed();
        notifyObservers();
    }

    public void enalbeStartButton(){
        view.enalbeStartButton();
    }
    public void disalbeStartButton(){
        view.disalbeStartButton();
    }
    public void enableNextPassButton(){
        view.enableNextPassButton();

    }
    public void disableNextPassButton(){
        view.disableNextPassButton();
    }

    public void createTimerView() {
        registerObserver( new TimerView(this));
    }

    public void dispose() {
        view.dispose();
        game = null;
        observers = null;
        timesUpSettingsFacade = null;
        view = null;
    }
}





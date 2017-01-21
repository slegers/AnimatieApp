package model.TimesUp;

import Controller.TimesUp.TimesUpController;
import model.Timer.CTimer;
import model.Timer.GameTimer;
import model.TimesUp.State.*;
import model.Team.Team;
import model.Timer.CountDownTimer;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by yanice on 29/12/16.
 */
public class TimesUpGame {
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> guessedNames = new ArrayList<>();
    private TimesUpController controller;
    private CountDownTimer timer;
    //private GameTimer timer;
    private ArrayList<Team> teams = new ArrayList<>();
    private Team currentTeam;
    private String name;
    private String time;
    private TimesUpState state;
    private OutOfNamesState outOfNamesState;
    private OutOfTimeState outOfTimeState;
    private NormalState normalState;
    private InitialState initialState;
    public TimesUpGame(TimesUpController controller){
        this.controller = controller;
        outOfNamesState = new OutOfNamesState(this);
        outOfTimeState = new OutOfTimeState(this);
        normalState = new NormalState(this);
        initialState = new InitialState(this);
        state = getInitialState();
    }

    public ArrayList<String> getNames(){
        return names;
    }

    public String getNextName(){
        return name;

    }

    public void setNextName(String name){
        this.name = name;
    }

    /**
     * Get A random name out of the name List.
     *
     * @return A random name out of the not guessed name list.
     */
    public String getRandomName(){
        Random r = new Random();
        if(names.size() == 0){
            return "";
        }
        return names.get(r.nextInt(names.size()));
    }

    /**
     * Remove a name out of the not guessed name list.
     * @param name
     */
    public void removeName(String name){
        names.remove(name);
    }

    public void readNames(){
        Scanner x = new Scanner((getClass().getClassLoader().getResourceAsStream(controller.getTimesUpSettingsFacade().getFile() + ".txt")));
        while(x.hasNextLine() && controller.getTimesUpSettingsFacade().getNmbNames() > getNames().size()){
            addName(x.nextLine());
        }
    }
    public  void addName(String name){
        names.add(name);
    }

    public String getTime() {
        return time;
    }
    public void setTime(String time){
        this.time = time;
    }

    public void setTimer() {
        this.timer = new CountDownTimer(controller,this);
        //this.timer = new CTimer(controller.getTimesUpSettingsFacade().getMaxTime());
    }
    public void notifyView(){
        controller.notifyObservers();
    }
    public void resertTimer(){
        timer.resertTimer();
        //timer.reset();
    }
    public ArrayList<Team> getTeams() {
        return teams;
    }

    public String getCurrentTeamName() {
        return currentTeam.getName();
    }

    public void setNextTeam(){
        if(currentTeam == null || currentTeam.getNumber() == getTeams().size()-1){
            currentTeam = getTeams().get(0);
        }else{
            currentTeam = getTeams().get(getCurrentTeam().getNumber()+1);
        }
    }
    public String getCurrentTeamScore() {
        return getCurrentTeam().getSeconds() +"";
    }

    public void addTeam(String teamName) {
        if(hasValidName(teamName)){
            Team team = new Team(teamName, teams.size());
            teams.add(team);
        }
    }

    public Team getCurrentTeam() {
        return currentTeam;
    }


    public ArrayList<String> getGuessedNames() {
        return guessedNames;
    }
    public void addGuessedNames(String name) {
         guessedNames.add(name);
    }

    public void startTimer() {
        timer.start();
    }

    public void startButtonPushed() {
        determineState();
        state.startButtonPushed();
    }

    private void determineState() {
        if(isOutOfNames()){
            setState(getOutOfNamesState());
        }else if(isOutOfTime()){
            setState(getOutOfTimeState());
        }
    }

    public void nextButtonPushed() {
        determineState();
        state.nextButtonPushed();
    }
    public void passButtonPushed() {
        determineState();
        state.passButtonPushed();

    }
    public boolean isOutOfNames(){
        if(getNames().size() <=0){
            return true;
        }
        return false;
    }

    public OutOfNamesState getOutOfNamesState() {
        return outOfNamesState;
    }

    public OutOfTimeState getOutOfTimeState() {
        return outOfTimeState;
    }
    public NormalState getNormalState() {
        return normalState;
    }

    public void setState(TimesUpState state) {
        this.state = state;
        this.state.initiate();

    }

    public boolean isOutOfTime() {
        if(timer.getTimeInt() == 0){
            return true;
        }
        return false;
    }

    public void increasePoint() {
        currentTeam.increasePointsBy(1);
    }

    public InitialState getInitialState() {
        return initialState;
    }

    public boolean hasValidName(String name){
        if(name.trim().matches("")){
            return false;
        }
        return true;
    }

    public void resetNames() {
        names =  guessedNames;
        guessedNames = new ArrayList<>();
    }

    public void stopTimer() {
        timer.stop();
    }

    public void enalbeStartButton(){
        controller.enalbeStartButton();
    }
    public void disalbeStartButton(){
        controller.disalbeStartButton();
    }
    public void enableNextPassButton(){
       controller.enableNextPassButton();
    }
    public void disableNextPassButton(){
        controller.disableNextPassButton();
    }
}

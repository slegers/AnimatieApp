package model.TimesUp;

import Controller.TimesUp.TimesUpController;
import model.Team.Team;
import model.Timer.CountDownTimer;
import model.TimesUp.State.NextRoundState;
import model.TimesUp.State.NormalState;
import model.TimesUp.State.OutOfTimeState;
import model.TimesUp.State.TimesUpState;

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
    private ArrayList<Team> teams = new ArrayList<>();
    private Team currentTeam;
    private String name;
    private TimesUpState state;
    private NormalState normalState = new NormalState(this);
    private NextRoundState nextRoundState = new NextRoundState(this);
    private OutOfTimeState outOfTimeState = new OutOfTimeState(this);
    public TimesUpGame(TimesUpController controller){
        this.controller = controller;
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
    public String getRandomName(){
        Random r = new Random();
        return names.get(r.nextInt(names.size()));
    }
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
        return timer.getTime();
    }

    public void setTimer() {
        this.timer = new CountDownTimer(this);
    }
    public void notifyView(){
        controller.notifyObservers();
    }
    public void resertTimer(){
        timer.resertTimer();
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
        Team team = new Team(teamName, teams.size());
        teams.add(team);
    }

    public Team getCurrentTeam() {
        return currentTeam;
    }

    public boolean isRunning() {
        return timer.isRunning();
    }

    public NormalState getNormalState() {
        return normalState;
    }

    public OutOfTimeState getOutOfTimeState() {
        return outOfTimeState;
    }

    public NextRoundState getNextRoundState() {
        return nextRoundState;
    }

    public void setState(TimesUpState state) {
        this.state = state;
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
}

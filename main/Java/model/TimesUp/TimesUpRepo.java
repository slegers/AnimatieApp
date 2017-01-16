package model.TimesUp;

import Controller.TimesUp.TimesUpController;
import model.Team.Team;
import model.Timer.CountDownTimer;
import model.TimesUp.State.NextRoundState;
import model.TimesUp.State.OutOfNamesState;
import model.TimesUp.State.OutOfTimeStatus;
import model.TimesUp.State.TimesUpState;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by yanice on 29/12/16.
 */
public class TimesUpRepo {
    private ArrayList<String> names = new ArrayList<>();
    private TimesUpController controller;
    private CountDownTimer timer;
    private ArrayList<Team> teams = new ArrayList<>();
    private Team currentTeam;
    private TimesUpState state;
    private NextRoundState nextRoundState = new NextRoundState();
    private OutOfNamesState outOfNamesState = new OutOfNamesState();
    private OutOfTimeStatus outOfTimeStatus = new OutOfTimeStatus();
    public TimesUpRepo(TimesUpController controller){
        this.controller = controller;
    }

    public ArrayList<String> getNames(){
        return names;
    }

    public String getNextName(){

        Random r = new Random();
        String name = names.get(r.nextInt(names.size()));
        removeName(name);
        return name;
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
        this.timer = new CountDownTimer(controller);
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

    public NextRoundState getNextRoundState() {
        return nextRoundState;
    }

    public OutOfNamesState getOutOfNamesState() {
        return outOfNamesState;
    }

    public void setOutOfNamesState(OutOfNamesState outOfNamesState) {
        this.outOfNamesState = outOfNamesState;
    }

    public OutOfTimeStatus getOutOfTimeStatus() {
        return outOfTimeStatus;
    }

    public void setOutOfTimeStatus(OutOfTimeStatus outOfTimeStatus) {
        this.outOfTimeStatus = outOfTimeStatus;
    }

    public TimesUpState getState() {
        return state;
    }
}

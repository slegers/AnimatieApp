package model.Team;

/**
 * Created by yanice on 27/12/16.
 */
public class Team {

    private String name;
    private int points;
    private int number;
    public Team(String teamTeam, int number){
        this.name = teamTeam;
        this.number = number;
    }

    public void setSecond(int seconds) {
        this.points = seconds;
    }

    public int getSeconds() {
        return points;
    }

    public void increasePointsBy(int points){
        if(this.points + points < 0){
            this.points = 0;
        }else{
            this.points += points;
        }
    }
    public String getName(){
        return name;
    }

    public void setName(String name){

        if(hasValidName(name)){
            this.name = name;
        }
    }

    public boolean hasValidName(String name){
        if(name.trim().matches("")){
            return false;
        }
        return true;
    }

    public int getNumber() {
        return number;
    }
}

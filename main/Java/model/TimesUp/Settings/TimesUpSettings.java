package model.TimesUp.Settings;

/**
 * Created by yanice on 27/12/16.
 */
public class TimesUpSettings implements TimesUpSettingsInterface {

    private boolean adminView;
    private static volatile  TimesUpSettings timesUpSettings;
    private int numbTeams,nmbNames,maxTime;
    private String file;
    private TimesUpSettings(){

    }
    static  synchronized TimesUpSettings getTimesUpSettings(){
        if(timesUpSettings == null){
            timesUpSettings = new TimesUpSettings();
        }
        return timesUpSettings;
    }
    @Override
    public String getFile() {
        return file;
    }
    @Override
    public void setFile(String file) {
        this.file = file;
    }
    @Override
    public int getNumbTeams() {
        return numbTeams;
    }
    @Override
    public void setNumbTeams(int numbTeams) {
        this.numbTeams = numbTeams;
    }
    @Override
    public int getNmbNames() {
        return nmbNames;
    }
    @Override
    public void setNmbNames(int nmbNames) {
        this.nmbNames = nmbNames;
    }
    @Override
    public int getMaxTime() {
        return maxTime;
    }
    @Override
    public void setMaxTime(int maxTime) {
        this.maxTime = maxTime;
    }
    @Override
    public void setAdminField(boolean adminView) {
        this.adminView = adminView;
    }

    @Override
    public boolean getAdminField() {
        return adminView;
    }
}

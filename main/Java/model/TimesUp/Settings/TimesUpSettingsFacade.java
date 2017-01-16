package model.TimesUp.Settings;

/**
 * Created by yanice on 27/12/16.
 */
public class TimesUpSettingsFacade implements TimesUpSettingsInterface {

    private TimesUpSettings settings;

    public  TimesUpSettingsFacade(){
        settings = TimesUpSettings.getTimesUpSettings();
    }

    @Override
    public String getFile() {
        return settings.getFile();
    }

    @Override
    public void setFile(String file) {
         settings.setFile(file);
    }

    @Override
    public int getNumbTeams() {
        return settings.getNumbTeams();
    }

    @Override
    public void setNumbTeams(int numbTeams) {
        settings.setNumbTeams(numbTeams);
    }

    @Override
    public int getNmbNames() {
        return settings.getNmbNames();
    }

    @Override
    public void setNmbNames(int nmbNames) {
        settings.setNmbNames(nmbNames);
    }

    @Override
    public int getMaxTime() {
        return settings.getMaxTime();
    }

    @Override
    public void setMaxTime(int maxTime) {
        settings.setMaxTime(maxTime);
    }
    @Override
    public void setAdminField(boolean adminView) {
        settings.setAdminField(adminView);
    }

    @Override
    public boolean getAdminField() {
        return settings.getAdminField();
    }
}

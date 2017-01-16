package model.TimesUp.Settings;

/**
 * Created by yanice on 27/12/16.
 */
public interface TimesUpSettingsInterface {
     String getFile();

     void setFile(String file);

     int getNumbTeams();

     void setNumbTeams(int numbTeams);

     int getNmbNames();

    void setNmbNames(int nmbNames);

    int getMaxTime();

    void setMaxTime(int maxTime);

    void setAdminField(boolean adminField);

    boolean getAdminField();
}

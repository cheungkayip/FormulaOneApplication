package f1.app.drivers;

import f1.app.statistics.Statistics;
import f1.app.teams.Team;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Date;

/**
 * Created by kayipcheung on 28-11-15.
 */
public class Driver {
    private String firstName;
    private String middleName;
    private String lastName;
    private String country;
    private Team teamInfo;
    private Date dateOfBirth;
    private String placeOfBirth;
    private Statistics statisticsInfo;
    private ImageView driverImage;
    private ImageView driverFlag;
    private StringBuffer buffer;

    public ImageView getDriverFlag() {
        return driverFlag;
    }

    public void setDriverFlag(ImageView driverFlag) {
        this.driverFlag = driverFlag;
    }

    public ImageView getDriverImage() {
        return driverImage;
    }

    public void setDriverImage(ImageView driverImage) {
        this.driverImage = driverImage;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Team getTeamInfo() {
        return teamInfo;
    }

    public void setTeamInfo(Team teamInfo) {
        this.teamInfo = teamInfo;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public Statistics getStatisticsInfo() {
        return statisticsInfo;
    }

    public void setStatisticsInfo(Statistics statisticsInfo) {
        this.statisticsInfo = statisticsInfo;
    }


    public StringBuffer toString(Driver driver){
        getBuffer().append("First Name: " + driver.getFirstName() + "\n" +
                "Last Name: " + driver.getLastName() + "\n" +
                "Place of Birth: " + driver.getPlaceOfBirth() + "\n" +
                "Country" + driver.getCountry() + "\n" +
                "Number of Podiums: " + driver.getStatisticsInfo().getNumberOfPodiums() + "\n" +
                "Points: " + driver.getStatisticsInfo().getPoints() + "\n" +
                "Grand Prix Entered: " + driver.getStatisticsInfo().getGrandPrixEntered() + "\n" +
                "World Championships: " + driver.getStatisticsInfo().getWorldChampionships() + "\n" +
                "Highest Race Finish: " + driver.getStatisticsInfo().getHighestRaceFinish() + "\n" +
                "Highest Grid Position: " + driver.getStatisticsInfo().getHighestGridPosition() + "\n" +
                "Team Name: " + driver.getTeamInfo().getTeamName() + "\n" + "\n");
        return getBuffer();
    }

    public StringBuffer getBuffer() {
        return buffer;
    }

    public void setBuffer(StringBuffer buffer) {
        this.buffer = buffer;
    }
}

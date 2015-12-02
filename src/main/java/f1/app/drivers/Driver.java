package f1.app.drivers;

import f1.app.statistics.Statistics;
import f1.app.constructor.Constructor;
import javafx.scene.image.ImageView;

import java.util.Date;

/**
 * Created by kayipcheung on 28-11-15.
 */
public class Driver {
    //http://ergast.com/api/f1/2015/drivers.json
    private String code;
    private String driverId;
    private String permanentNumber;
    private String url;
    private String givenName;
    private String middleName;
    private String familyName;
    private String nationality;
    private Constructor constructorInfo;
    private Date dateOfBirth;
    private String placeOfBirth;
    private Statistics statisticsInfo;
    private ImageView driverImage;
    private ImageView driverFlag;
    private StringBuffer buffer;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getPermanentNumber() {
        return permanentNumber;
    }

    public void setPermanentNumber(String permanentNumber) {
        this.permanentNumber = permanentNumber;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

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

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Constructor getConstructorInfo() {
        return constructorInfo;
    }

    public void setConstructorInfo(Constructor constructorInfo) {
        this.constructorInfo = constructorInfo;
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
        getBuffer().append(
                "Driver ID: " + driver.getDriverId() + "\n" +
                "Given Name: " + driver.getGivenName() + "\n" +
                "Family Name: " + driver.getFamilyName() + "\n" +
                "Place of Birth: " + driver.getPlaceOfBirth() + "\n" +
                "Permanent Number: " + driver.getPermanentNumber() + "\n" +
                "Nationality" + driver.getNationality() + "\n" +
                "Weblink URL" + driver.getUrl() + "\n"
//                "Number of Podiums: " + driver.getStatisticsInfo().getNumberOfPodiums() + "\n" +
//                "Points: " + driver.getStatisticsInfo().getPoints() + "\n" +
//                "Grand Prix Entered: " + driver.getStatisticsInfo().getGrandPrixEntered() + "\n" +
//                "World Championships: " + driver.getStatisticsInfo().getWorldChampionships() + "\n" +
//                "Highest Race Finish: " + driver.getStatisticsInfo().getHighestRaceFinish() + "\n" +
//                "Highest Grid Position: " + driver.getStatisticsInfo().getHighestGridPosition() + "\n" +
//                "Constructor Name: " + driver.getConstructorInfo().getConstructorId() + "\n" + "\n"
        );
        return getBuffer();
    }

    public StringBuffer getBuffer() {
        return buffer;
    }

    public void setBuffer(StringBuffer buffer) {
        this.buffer = buffer;
    }
}

package f1.app.drivers;

import f1.app.constructor.Constructor;
import javafx.scene.image.ImageView;

/**
 * Created by kayipcheung on 28-11-15.
 */
public class Driver {
    private String code;
    private String driverId;
    private String permanentNumber;
    private String url;
    private String givenName;
    private String familyName;
    private String nationality;
    private Constructor constructorInfo;
    private String dateOfBirth;
    private ImageView driverImage;
    private ImageView driverFlag;
    private ImageView driverHelmet;
    private StringBuffer buffer;

    public ImageView getDriverHelmet() {
        return driverHelmet;
    }

    public ImageView setDriverHelmet(ImageView driverHelmet) {
        this.driverHelmet = driverHelmet;
        return driverHelmet;
    }

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

    public ImageView setDriverFlag(ImageView driverFlag) {
        this.driverFlag = driverFlag;
        return driverFlag;
    }

    public ImageView getDriverImage() {
        return driverImage;
    }

    public ImageView setDriverImage(ImageView driverImage) {
        this.driverImage = driverImage;
        return driverImage;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public StringBuffer toString(Driver driver) {
        getBuffer().append(
                "Driver ID: " + driver.getDriverId() + "\n" +
                        "Given Name: " + driver.getGivenName() + "\n" +
                        "Family Name: " + driver.getFamilyName() + "\n" +
                        "Date of Birth: " + driver.getDateOfBirth() + "\n" +
                        "Permanent Number: " + driver.getPermanentNumber() + "\n" +
                        "Nationality: " + driver.getNationality() + "\n" +
                        "Weblink URL: " + driver.getUrl() + "\n" + "\n"
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

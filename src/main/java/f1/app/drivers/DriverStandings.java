package f1.app.drivers;

import f1.app.constructor.Constructor;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kayipcheung on 07-12-15.
 */
public class DriverStandings {
    private String position;
    private String positionText;
    private String points;
    private String wins;
    private Driver driver;
    private Constructor constructor;
    private StringBuffer buffer;
    private Map<String, JSONObject> driverStandingsList = new HashMap<String, JSONObject>();

    public Map<String, JSONObject> getDriverStandingsList() {
        return driverStandingsList;
    }

    public void setDriverStandingsList(Map<String, JSONObject> driverStandingsList) {
        this.driverStandingsList = driverStandingsList;
    }

    public Constructor getConstructor() {
        return constructor;
    }

    public void setConstructor(Constructor constructor) {
        this.constructor = constructor;
    }

    public String getPositionText() {
        return positionText;
    }

    public void setPositionText(String positionText) {
        this.positionText = positionText;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public StringBuffer toString(DriverStandings standings) {
        getBuffer().append(
                        "Position: " + standings.getPosition() + "\n" +
                        "Driver: " + standings.getDriver().getGivenName() + " " + standings.getDriver().getFamilyName() + "\n" +
                        "Constructor: " + standings.getConstructor().getConstructorName() + "\n" +
                        "Points: " + standings.getPoints() + "\n" +
                        "Wins: " + standings.getWins() + "\n"
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

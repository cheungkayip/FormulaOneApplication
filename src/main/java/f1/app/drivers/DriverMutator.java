package f1.app.drivers;

import f1.app.constructor.Constructor;
import f1.app.ergast.url.Ergast;
import f1.app.global.GlobalF1;
import f1.app.statistics.Statistics;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * Created by kayipcheung on 28-11-15.
 * A mutator for Drivers
 */
public class DriverMutator {
    private Driver driver;
    private Statistics statistics;
    private Constructor constructor;
    private Ergast ergast;
    private ArrayList<Driver> driverList = new ArrayList<Driver>();

    public Ergast getErgast() {
        return ergast;
    }

    public void setErgast(Ergast ergast) {
        this.ergast = ergast;
    }

    public Driver modifyTheDriver() {
        //TODO: IMPLEMENT
        return getDriver();
    }

    public Driver showTheDriver() {

        return getDriver();
    }

    public Driver clearTheDriver() {
        driver = null;
        return driver;
    }

    public ArrayList<Driver> createDriversFromURL() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        setErgast(new Ergast());
        int driverCount = 0;
        try {
            String output = getErgast().callUrlToGetJSONData("http://ergast.com/api/f1/2015/drivers.json");


            JSONObject json = (JSONObject) new JSONParser().parse(output);
            JSONObject mrData = (JSONObject) json.get("MRData");
            JSONObject driverTable = (JSONObject) mrData.get("DriverTable");
            JSONArray drivers = (JSONArray) driverTable.get("Drivers");
            Iterator<String> iterator = drivers.iterator();
            while (iterator.hasNext()) {
                if (iterator.next() == ("" + driverCount)) {
                    break;
                }
                setDriver(new Driver());
                setConstructor(new Constructor());
                JSONObject object = (JSONObject) drivers.get(driverCount);

                // Set the Driver specific details
                getDriver().setDriverId((String) object.get("driverId"));
                getDriver().setCode((String) object.get("code"));
                getDriver().setPermanentNumber((String) object.get("permanentNumber"));
                getDriver().setNationality((String) object.get("nationality"));
                getDriver().setGivenName((String) object.get("givenName"));
                getDriver().setFamilyName((String) object.get("familyName"));
                getDriver().setPlaceOfBirth((String) object.get("dateOfBirth"));
                getDriver().setUrl((String) object.get("url"));



                // Image related + Constructor Team information
                Object jsonFile = parser.parse(new FileReader("src/main/resources/Drivers.json"));
                JSONObject jsonObject = (JSONObject) jsonFile;
                JSONArray jsonFileArray = (JSONArray) jsonObject.get("Driver");
                GlobalF1 global = new GlobalF1();
                global.selectImagesForDriversOrConstructor(jsonFileArray, object, getDriver(), getConstructor()); // Access Global class to set the Images

                // Increment the next Driver
                driverCount++;
                // Add the driver to our own ArrayList (so you can call it later)
                driverList.add(getDriver());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return driverList;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public Constructor getConstructor() {
        return constructor;
    }

    public void setConstructor(Constructor constructor) {
        this.constructor = constructor;
    }

    public ArrayList<Driver> getDriverList() {
        return driverList;
    }
}

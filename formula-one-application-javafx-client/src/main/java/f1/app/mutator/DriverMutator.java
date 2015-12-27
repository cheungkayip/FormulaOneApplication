package f1.app.mutator;

import f1.app.pojo.Constructor;
import f1.app.ergast.url.Ergast;
import f1.app.global.GlobalF1;
import f1.app.pojo.Driver;
import f1.app.pojo.DriverStandings;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by kayipcheung on 28-11-15.
 * A mutator for Drivers
 */
public class DriverMutator {
    private Driver driver;
    private Constructor constructor;
    private DriverStandings driverStandings;
    private Ergast ergast;
    private ArrayList<Driver> driverList = new ArrayList<>();
    private ArrayList<DriverStandings> driverStandingsList = new ArrayList<>();

    public Ergast getErgast() {
        return ergast;
    }

    public void setErgast(Ergast ergast) {
        this.ergast = ergast;
    }

    public Driver clearTheDriver() {
        return driver = null;
    }

    public DriverStandings getDriverStandings() {
        return driverStandings;
    }

    public void setDriverStandings(DriverStandings driverStandings) {
        this.driverStandings = driverStandings;
    }

    public ArrayList<Driver> createDriversFromURL(String resource) {
        JSONParser parser = new JSONParser();
        setErgast(new Ergast());
        int driverCount = 0;
        try {
            String output = getErgast().decideTheRightJSON(resource, GlobalF1.DRIVERS_JSON);

            JSONObject json = (JSONObject) new JSONParser().parse(output);
            JSONObject mrData = (JSONObject) json.get("MRData");
            JSONObject driverTable = (JSONObject) mrData.get("DriverTable");
            JSONArray drivers = (JSONArray) driverTable.get("Drivers");
            for (Object driver1 : drivers) {
                if (driver1 == ("" + driverCount)) {
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
                getDriver().setDateOfBirth((String) object.get("dateOfBirth"));
                getDriver().setUrl((String) object.get("url"));

                // Image related + Constructor Team information
                Object jsonFile;
                String resourceNew;
                if (resource.equals(GlobalF1.FORMULA_ONE_RESOURCES_TESTDIR) || resource.equals(GlobalF1.SAVED_JSON_DIR_TEST)) {
                    resourceNew = GlobalF1.FORMULA_ONE_RESOURCES_TESTDIR;
                    jsonFile = parser.parse(new FileReader(GlobalF1.FORMULA_ONE_RESOURCES_TESTDIR + "Drivers.json"));
                } else {
                    resourceNew = GlobalF1.FORMULA_ONE_RESOURCES_DIR;
                    jsonFile = parser.parse(new FileReader(GlobalF1.FORMULA_ONE_RESOURCES_DIR + "Drivers.json"));
                }
                JSONObject jsonObject = (JSONObject) jsonFile;
                JSONArray jsonFileArray = (JSONArray) jsonObject.get("Driver");
                GlobalF1 global = new GlobalF1();
                global.selectImagesForDrivers(jsonFileArray, object, getDriver(), getConstructor(), resourceNew); // Access Global class to set the Images

                // Increment the next Driver
                driverCount++;
                // Add the driver to our own ArrayList (so you can call it later)
                driverList.add(getDriver());
            }
            setDriverList(driverList);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return getDriverList();
    }

    public ArrayList<DriverStandings> generateDriverStandings() throws IOException, ParseException {
        setErgast(new Ergast());

        String output = getErgast().callUrlToGetJSONData(GlobalF1.DRIVER_STANDINGS_JSON);
        JSONObject json = (JSONObject) new JSONParser().parse(output);
        JSONObject mrData = (JSONObject) json.get("MRData");
        JSONObject standingsTable = (JSONObject) mrData.get("StandingsTable");
        JSONArray standingLists = (JSONArray) standingsTable.get("StandingsLists");
        JSONObject driverStandings = (JSONObject) standingLists.get(0);
        JSONArray resultsOfADriver = (JSONArray) driverStandings.get("DriverStandings");

        resultsOfADriver.stream().forEach(aResultsOfADriver -> {
            setDriverStandings(new DriverStandings());
            JSONObject temp = (JSONObject) aResultsOfADriver;

            getDriverStandings().setPosition(temp.get("position").toString());
            getDriverStandings().setPoints(temp.get("points").toString());
            getDriverStandings().setWins(temp.get("wins").toString());
            JSONObject driver = (JSONObject) temp.get("Driver");
            // Only get the Drivers Name (thats all you need)
            getDriverStandings().setDriver(driver.get("givenName").toString() + " " + driver.get("familyName").toString());
            // Only need the Constructor Name (no need for the whole Constructor Object)
            JSONArray constructor = (JSONArray) temp.get("Constructors");
            constructor.stream().forEach(aConstructor -> {
                JSONObject cons = (JSONObject) aConstructor;
                getDriverStandings().setConstructor(cons.get("name").toString());
            });
            driverStandingsList.add(getDriverStandings());
        });

        setDriverStandingsList(getDriverStandingsList());
        return getDriverStandingsList();
    }

    public ArrayList<DriverStandings> getDriverStandingsList() {
        return driverStandingsList;
    }

    public void setDriverStandingsList(ArrayList<DriverStandings> driverStandingsList) {
        this.driverStandingsList = driverStandingsList;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
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

    public void setDriverList(ArrayList<Driver> driverList) {
        this.driverList = driverList;
    }
}

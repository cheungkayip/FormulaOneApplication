package f1.app.drivers;

import f1.app.constructor.Constructor;
import f1.app.constructor.ConstructorMutator;
import f1.app.ergast.url.Ergast;
import f1.app.global.GlobalF1;
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
        driver = null;
        return driver;
    }

    public DriverStandings getDriverStandings() {
        return driverStandings;
    }

    public void setDriverStandings(DriverStandings driverStandings) {
        this.driverStandings = driverStandings;
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
                getDriver().setDateOfBirth((String) object.get("dateOfBirth"));
                getDriver().setUrl((String) object.get("url"));

                // Image related + Constructor Team information
                Object jsonFile = parser.parse(new FileReader("src/main/resources/Drivers.json"));
                JSONObject jsonObject = (JSONObject) jsonFile;
                JSONArray jsonFileArray = (JSONArray) jsonObject.get("Driver");
                GlobalF1 global = new GlobalF1();
                global.selectImagesForDrivers(jsonFileArray, object, getDriver(), getConstructor()); // Access Global class to set the Images

                // Increment the next Driver
                driverCount++;
                // Add the driver to our own ArrayList (so you can call it later)
                driverList.add(getDriver());
            }
            setDriverList(driverList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return getDriverList();
    }

    public ArrayList<DriverStandings> generateDriverStandings() throws IOException, ParseException {
        setErgast(new Ergast());


        String output = getErgast().callUrlToGetJSONData("http://ergast.com/api/f1/2015/driverStandings.json");
        JSONObject json = (JSONObject) new JSONParser().parse(output);
        JSONObject mrData = (JSONObject) json.get("MRData");
        JSONObject standingsTable = (JSONObject) mrData.get("StandingsTable");
        JSONArray standingLists = (JSONArray) standingsTable.get("StandingsLists");
        JSONObject driverStandings = (JSONObject) standingLists.get(0);
        JSONArray resultsOfADriver = (JSONArray) driverStandings.get("DriverStandings");

        for (Object aResultsOfADriver : resultsOfADriver) {
            setDriver(new Driver());
            setConstructor(new Constructor());
            setDriverStandings(new DriverStandings());
            JSONObject temp = (JSONObject) aResultsOfADriver;
            getDriverStandings().setWins(temp.get("wins").toString());
            getDriverStandings().setPositionText(temp.get("positionText").toString());

            JSONObject driver = (JSONObject) temp.get("Driver");
            getDriver().setCode(driver.get("code").toString());
            getDriver().setDriverId(driver.get("driverId").toString());
            if (!driver.get("code").toString().equals("RSS")) {
                getDriver().setPermanentNumber(driver.get("permanentNumber").toString());
            } else if (driver.get("code").toString().equals("RSS")) {
                getDriver().setPermanentNumber("");
            }
            getDriver().setNationality(driver.get("nationality").toString());
            getDriver().setGivenName(driver.get("givenName").toString());
            getDriver().setFamilyName(driver.get("familyName").toString());
            getDriver().setDateOfBirth(driver.get("dateOfBirth").toString());
            getDriver().setUrl(driver.get("url").toString());
            getDriverStandings().setDriver(getDriver());

            JSONArray constructor = (JSONArray) temp.get("Constructors");
            for (Object aConstructor : constructor) {
                JSONObject cons = (JSONObject) aConstructor;
                getConstructor().setNationality(cons.get("nationality").toString());
                getConstructor().setConstructorName(cons.get("name").toString());

                ConstructorMutator mutator = new ConstructorMutator();
                getConstructor().setConstructorId(mutator.decideWhichConstructorEnumToSelect(cons, getDriver(), getConstructor()));
                getConstructor().setConstructorUrl(cons.get("url").toString());
                getDriverStandings().setConstructor(getConstructor());
            }

            getDriverStandings().setPosition(temp.get("position").toString());
            getDriverStandings().setPoints(temp.get("points").toString());
            driverStandingsList.add(getDriverStandings());
        }
        setDriverStandingsList(getDriverStandingsList());

//        System.out.println(driverStandings);
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

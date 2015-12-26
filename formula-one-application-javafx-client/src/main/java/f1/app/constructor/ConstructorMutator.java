package f1.app.constructor;

import f1.app.drivers.Driver;
import f1.app.ergast.url.Ergast;
import f1.app.global.GlobalF1;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A ConstructorMutator for all Constructor Team mutations. This Class will be used
 * in the Controllers to do specific Business Logic to get Constructor Data.
 * Created by kayipcheung on 04-12-15.
 */
public class ConstructorMutator {

    private Ergast ergast;
    private Driver driver;
    private Constructor constructor;
    private ConstructorStandings standingsObject;
    private ArrayList<Constructor> constructorsList = new ArrayList<>();
    private ArrayList<ConstructorStandings> standingsList = new ArrayList<>();

    public ConstructorStandings getStandingsObject() {
        return standingsObject;
    }

    public void setStandingsObject(ConstructorStandings standingsObject) {
        this.standingsObject = standingsObject;
    }

    public ArrayList<ConstructorStandings> getStandingsList() {
        return standingsList;
    }

    public void setStandingsList(ArrayList<ConstructorStandings> standingsList) {
        this.standingsList = standingsList;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public ArrayList<Constructor> getConstructorsList() {
        return constructorsList;
    }

    public void setConstructorsList(ArrayList<Constructor> constructorsList) {
        this.constructorsList = constructorsList;
    }

    public Constructor getConstructor() {
        return constructor;
    }

    public void setConstructor(Constructor constructor) {
        this.constructor = constructor;
    }

    public Ergast getErgast() {
        return ergast;
    }

    public void setErgast(Ergast ergast) {
        this.ergast = ergast;
    }


    public Constructor clearTheConstructor() {
        return constructor = null;
    }
    public ArrayList<Constructor> getAllTheConstructorInformation(String resource, String testResource) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        setErgast(new Ergast());

            String output = getErgast().decideTheRightJSON(testResource,GlobalF1.CONSTRUCTORS_JSON);

            JSONObject json = (JSONObject) new JSONParser().parse(output);
            JSONObject mrData = (JSONObject) json.get("MRData");
            JSONObject constructorTable = (JSONObject) mrData.get("ConstructorTable");
            JSONArray constructors = (JSONArray) constructorTable.get("Constructors");
            // Java 8 Streaming
            constructors.stream().forEach(constructor -> {
                setConstructor(new Constructor());
                setDriver(new Driver());

                JSONObject object = (JSONObject) constructor;
                Object jsonFile = null;
                try {
                    jsonFile = parser.parse(new FileReader(resource+"Drivers.json"));
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }

                JSONObject jsonObject = (JSONObject) jsonFile;
                JSONArray constructorJSON = (JSONArray) (jsonObject != null ? jsonObject.get("Driver") : null);

                GlobalF1 global = new GlobalF1();
                // Set the Enum correctly
                Constructor.ConstructorId id = null;
                id = decideWhichConstructorEnumToSelect((JSONObject) constructor, getDriver(), getConstructor());
                getConstructor().setConstructorId(id);
                getConstructor().setConstructorUrl((String) object.get("url"));
                String idToUppercase = object.get("name").toString().toUpperCase();
                getConstructor().setConstructorName(idToUppercase);
                getConstructor().setNationality((String) object.get("nationality"));
                try {
                    global.selectImagesForConstructor(constructorJSON, getConstructor(), resource);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // Add the driver to our own ArrayList (so you can call it later)
                constructorsList.add(getConstructor());
                setConstructorsList(constructorsList);
            });

        return getConstructorsList();
    }

    public ArrayList<ConstructorStandings> displayConstructorStandings(String resource) throws IOException, ParseException {

        setErgast(new Ergast());
        String output = getErgast().decideTheRightJSON(resource, GlobalF1.CONSTRUCTORS_STANDINGS_JSON);

        JSONObject json = (JSONObject) new JSONParser().parse(output);
        JSONObject mrData = (JSONObject) json.get("MRData");
        JSONObject standingsTable = (JSONObject) mrData.get("StandingsTable");
        JSONArray standingsLists = (JSONArray) standingsTable.get("StandingsLists");
        JSONArray constructorStandings = null;
        for(Object temp: standingsLists){
            JSONObject temp2 = (JSONObject) temp;
            constructorStandings = (JSONArray) temp2.get("ConstructorStandings");
            break;
        }
if(constructorStandings != null) {
    constructorStandings.stream().forEach(constructorPosition -> {
        setStandingsObject(new ConstructorStandings());
        JSONObject temp = (JSONObject) constructorPosition;
        getStandingsObject().setPosition(temp.get("position").toString());
        getStandingsObject().setPoints(temp.get("points").toString());
        getStandingsObject().setWins(temp.get("wins").toString());
        JSONObject constructor = (JSONObject) temp.get("Constructor");
        getStandingsObject().setConstructorName(constructor.get("name").toString());
        standingsList.add(getStandingsObject());
    });
}
        setStandingsList(standingsList);
        return getStandingsList();
    }

    public Constructor.ConstructorId decideWhichConstructorEnumToSelect(JSONObject theIdfromArray, Driver driver, Constructor constructor) {

        for (Constructor.ConstructorId temp : Constructor.ConstructorId.values()) {
                String idToUppercase = theIdfromArray.get("constructorId").toString().toUpperCase();
                if (temp.name().equals(idToUppercase)) {
                    constructor.setConstructorId(temp);
                    driver.setConstructorInfo(constructor);
                    break;
                }
        }
        return constructor.getConstructorId();
    }
}

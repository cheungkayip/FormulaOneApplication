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

/**
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
        constructor = null;
        return constructor;
    }
    public ArrayList<Constructor> getAllTheConstructorInformation(String resource){
        JSONParser parser = new JSONParser();
        setErgast(new Ergast());
        try {
            String output = getErgast().callUrlToGetJSONData(GlobalF1.CONSTRUCTORS_JSON);

            JSONObject json = (JSONObject) new JSONParser().parse(output);
            JSONObject mrData = (JSONObject) json.get("MRData");
            JSONObject constructorTable = (JSONObject) mrData.get("ConstructorTable");
            JSONArray constructors = (JSONArray) constructorTable.get("Constructors");
            for (int i = 0;i < constructors.size();i++) {
                if (constructors.size() == (i)) {
                    break;
                }
                setConstructor(new Constructor());
                setDriver(new Driver());

                JSONObject object = (JSONObject) constructors.get(i);
                Object jsonFile = parser.parse(new FileReader(resource+"Drivers.json"));
                JSONObject jsonObject = (JSONObject) jsonFile;
                JSONArray constructorJSON = (JSONArray) jsonObject.get("Driver");

                GlobalF1 global = new GlobalF1();
                // Set the Enum correctly
                Constructor.ConstructorId id = decideWhichConstructorEnumToSelect((JSONObject) constructors.get(i), getDriver(), getConstructor());
                getConstructor().setConstructorId(id);
                getConstructor().setConstructorUrl((String) object.get("url"));
                String idToUppercase = object.get("name").toString().toUpperCase();
                getConstructor().setConstructorName(idToUppercase);
                getConstructor().setNationality((String) object.get("nationality"));
                global.selectImagesForConstructor(constructorJSON, getConstructor(), resource);

                // Add the driver to our own ArrayList (so you can call it later)
                constructorsList.add(getConstructor());
                setConstructorsList(constructorsList);
            }
        }catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return getConstructorsList();
    }

    public ArrayList<ConstructorStandings> displayConstructorStandings() throws IOException, ParseException {

        setErgast(new Ergast());
        String output = getErgast().callUrlToGetJSONData(GlobalF1.CONSTRUCTORS_STANDINGS_JSON);

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
    for (Object constructorPosition : constructorStandings) {
        setStandingsObject(new ConstructorStandings());

        JSONObject temp = (JSONObject) constructorPosition;

        getStandingsObject().setPosition(temp.get("position").toString());
        getStandingsObject().setPoints(temp.get("points").toString());
        getStandingsObject().setWins(temp.get("wins").toString());
        JSONObject constructor = (JSONObject) temp.get("Constructor");
        getStandingsObject().setConstructorName(constructor.get("name").toString());

        standingsList.add(getStandingsObject());
    }
}
        setStandingsList(standingsList);
        return getStandingsList();
    }

    public Constructor.ConstructorId decideWhichConstructorEnumToSelect(JSONObject theIdfromArray, Driver driver, Constructor constructor) throws IOException {
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

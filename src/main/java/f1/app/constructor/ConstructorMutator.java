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
    private ArrayList<Constructor> constructorsList = new ArrayList<>();

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
    public ArrayList<Constructor> getAllTheConstructorInformation(){
        JSONParser parser = new JSONParser();
        setErgast(new Ergast());
        try {
            String output = getErgast().callUrlToGetJSONData("http://ergast.com/api/f1/2015/Constructors.json");


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
                Object jsonFile = parser.parse(new FileReader("src/main/resources/Drivers.json"));
                JSONObject jsonObject = (JSONObject) jsonFile;
                JSONArray constructorJSON = (JSONArray) jsonObject.get("Driver");

                GlobalF1 global = new GlobalF1();
                // Set the Enum correctly
                Constructor.ConstructorId id = decideWhichConstructorEnumToSelect((JSONObject) constructors.get(i), getDriver());
                getConstructor().setConstructorId(id);
                getConstructor().setConstructorUrl((String) object.get("url"));
                String idToUppercase = object.get("name").toString().toUpperCase();
                getConstructor().setConstructorName(idToUppercase);
                getConstructor().setNationality((String) object.get("nationality"));
                global.selectImagesForConstructor(constructorJSON, getConstructor());

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

    public Constructor.ConstructorId decideWhichConstructorEnumToSelect(JSONObject theIdfromArray, Driver driver) throws IOException {
            for (Constructor.ConstructorId temp : Constructor.ConstructorId.values()) {
                String idToUppercase = theIdfromArray.get("constructorId").toString().toUpperCase();
                if (temp.name().equals(idToUppercase)) {
                    getConstructor().setConstructorId(temp);
                    driver.setConstructorInfo(getConstructor());
                    break;
                }
        }
        return getConstructor().getConstructorId();
    }
}

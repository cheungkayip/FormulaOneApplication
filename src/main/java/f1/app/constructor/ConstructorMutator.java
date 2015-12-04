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
import java.util.Iterator;

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

    public ArrayList<Constructor> getAllTheConstructorInformation(){
        JSONParser parser = new JSONParser();
        setErgast(new Ergast());
        int count = 0;
        try {
            String output = getErgast().callUrlToGetJSONData("http://ergast.com/api/f1/2015/Constructors.json");


            JSONObject json = (JSONObject) new JSONParser().parse(output);
            JSONObject mrData = (JSONObject) json.get("MRData");
            JSONObject constructorTable = (JSONObject) mrData.get("ConstructorTable");
            JSONArray constructors = (JSONArray) constructorTable.get("Constructors");
            Iterator<String> iterator = constructors.iterator();
            while (iterator.hasNext()) {
                if (iterator.next() == ("" + count)) {
                    break;
                }
                setConstructor(new Constructor());
                setDriver(new Driver());

                JSONObject object = (JSONObject) constructors.get(count);
                Object jsonFile = parser.parse(new FileReader("src/main/resources/Drivers.json"));
                JSONObject jsonObject = (JSONObject) jsonFile;
                JSONArray constructorJSON = (JSONArray) jsonObject.get("Driver");

                // Set the Driver specific details
                getConstructor().setConstructorUrl((String) object.get("url"));
                getConstructor().setNationality((String) object.get("nationality"));
                // Set the Enum correctly
                String idToUppercase = object.get("constructorId").toString().toUpperCase();
                getConstructor().setConstructorName(idToUppercase);
                GlobalF1 global = new GlobalF1();

                Constructor.ConstructorId id = decideWhichConstructorEnumToSelect(constructorJSON,global,getConstructor(), getDriver()); // Decide enum in the new method
                getConstructor().setConstructorId(id);

                // Image related + Constructor Team information

                global.selectImagesForDriversOrConstructor(constructorJSON, object, driver, getConstructor());

                // Increment the next Driver
                count++;
                // Add the driver to our own ArrayList (so you can call it later)
                constructorsList.add(getConstructor());
            }
        }catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return constructorsList;
    }

    public Constructor.ConstructorId decideWhichConstructorEnumToSelect(JSONArray constructorJSON, GlobalF1 global, Constructor constructor, Driver driver) throws IOException {

        JSONObject object = null;
        for(int i = 0;i < constructorJSON.size();i++){
            object = (JSONObject) constructorJSON.get(i);
            if (object.containsKey("teamLogo")){
                break;
            }
        }
        if(object != null) {
            String teamLogoString = (String) object.get("teamLogo"); // Constructor Logo Image
            constructor.setTeamLogo(global.setTheImage("src/main/resources/Constructors/" + teamLogoString));

            for (Constructor.ConstructorId temp : Constructor.ConstructorId.values()) {
                if (temp.name().equals(object.get("teamName"))) {
                    constructor.setConstructorId(temp);
                    driver.setConstructorInfo(constructor);
                    break;
                }
            }
        }else{
            System.out.println("Something went wrong. Did not find a match for Constructor name");
        }
        return constructor.getConstructorId();
    }
}

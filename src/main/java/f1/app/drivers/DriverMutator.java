package f1.app.drivers;

import f1.app.constructor.Constructor;
import f1.app.ergast.url.Ergast;
import f1.app.statistics.Statistics;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
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
        driverList.clear();
        return driver;
    }

    public Driver createDriversFromURL() throws IOException, ParseException {
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
                JSONArray driverJSON = (JSONArray) jsonObject.get("Driver");
                selectImageAndConstructorInfo(driverJSON, object);


                // Increment the next Driver
                driverCount++;
                // Add the driver to our own ArrayList (so you can call it later)
                driverList.add(getDriver());
            }
        }catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return getDriver();
    }

    public Driver selectImageAndConstructorInfo(JSONArray driverJSON, JSONObject jsonURLObject) throws IOException, ParseException {
        int i = 0;
        for (Object temp : driverJSON) {
            JSONObject obj = (JSONObject) driverJSON.get(i);
            if (obj.get("driverId").toString().equals((String) jsonURLObject.get("code")) && obj.get("driverImage") != "") {

                // Create the Display image
                String driverImage = (String) obj.get("driverImage"); // Driver Display Image
                getDriver().setDriverImage(setTheImage("src/main/resources/Drivers/" + driverImage));
                // Create the Flag image
                String imageStringFlag = (String) obj.get("driverFlag"); // Driver Flag Image
                getDriver().setDriverFlag(setTheImage("src/main/resources/Flags/" + imageStringFlag));
                // Create the Flag image
                String helmet = (String) obj.get("helmet"); // Driver Flag Image
                getDriver().setDriverHelmet(setTheImage("src/main/resources/Helmets/" + helmet));

                // Create the Constructor logo image
                setConstructor(new Constructor());
                String teamLogoString = (String) obj.get("teamLogo"); // Constructor Logo Image
                getConstructor().setTeamLogo(setTheImage("src/main/resources/Constructors/" + teamLogoString));

                for (Constructor.ConstructorId cid : Constructor.ConstructorId.values()) {
                    if (cid.name().equals(obj.get("teamName"))) {
                        getConstructor().setConstructorId(cid);

                        getDriver().setConstructorInfo(getConstructor());
                        break;
                    }
                }
            }
            i++;
        }
        return getDriver();
    }

    public ImageView setTheImage(String imageString) throws IOException {
        BufferedImage bufferedImage;
        bufferedImage = ImageIO.read(new File(imageString));
        Image image = SwingFXUtils.toFXImage(bufferedImage, null);
        ImageView view = new ImageView();
        view.setImage(image);
        return view;
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

    public Driver createDriversFromJSONFile() {
        JSONParser parser = new JSONParser();
        int driverCount = 0;
        try {
            Object obj = parser.parse(new FileReader("src/main/resources/Drivers.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray driverJSON = (JSONArray) jsonObject.get("Driver");

            Iterator<String> iterator = driverJSON.iterator();
            // Loop through all the JSON Array Objects to create a Driver object for each Driver
            while (iterator.hasNext()) {
                if (iterator.next() == ("" + driverCount)) {
                    break;
                }
                // Create Driver Object
                setDriver(new Driver());
                JSONObject object = (JSONObject) driverJSON.get(driverCount);
                // Create the Display image
                String driverImage = (String) object.get("driverImage"); // Driver Display Image
                getDriver().setDriverImage(setTheImage("src/main/resources/Drivers/" + driverImage));
                // Create the Flag image
                String imageStringFlag = (String) object.get("driverFlag"); // Driver Flag Image
                getDriver().setDriverFlag(setTheImage("src/main/resources/Flags/" + imageStringFlag));

                setConstructor(new Constructor());
                // Create the Constructor logo image
                String teamLogoString = (String) object.get("teamLogo"); // Constructor Logo Image
                getConstructor().setTeamLogo(setTheImage("src/main/resources/Constructors/" + teamLogoString));

                for (Constructor.ConstructorId temp : Constructor.ConstructorId.values()) {
                    if (temp.name().equals(object.get("teamName"))) {
                        getConstructor().setConstructorId(temp);
                        getDriver().setConstructorInfo(getConstructor());
                        break;
                    }
                }
                driverCount++;
                getDriver().toString();
                driverList.add(getDriver());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return getDriver();
    }
}

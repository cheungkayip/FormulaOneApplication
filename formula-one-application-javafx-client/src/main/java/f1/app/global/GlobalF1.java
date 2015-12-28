package f1.app.global;

import f1.app.pojo.Circuit;
import f1.app.pojo.Constructor;
import f1.app.pojo.Driver;
import f1.app.pojo.RaceResults;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by kayipcheung on 04-12-15.
 */
public class GlobalF1 {
    public static final String FORMULA_ONE_RESOURCES_TESTDIR = "src/main/resources/";
    public static final String SAVED_JSON_DIR_TEST = "src/main/resources/SavedJSON/";
    public static final String SAVED_JSON_DIR = "formula-one-application-javafx-client/src/main/resources/SavedJSON/";
    public static final String FORMULA_ONE_RESOURCES_DIR = "formula-one-application-javafx-client/src/main/resources/";
    public static final String RACE_RESULTS_DIR = "http://ergast.com/api/f1/2015/";

    public static final String DRIVERS_JSON = "http://localhost:8080/formula-one-application-rest-api-0.0.1-SNAPSHOT/rest/drivers";
    public static final String DRIVER_STANDINGS_JSON = "http://localhost:8080/formula-one-application-rest-api-0.0.1-SNAPSHOT/rest/drivers/standings";
    public static final String CONSTRUCTORS_JSON = "http://localhost:8080/formula-one-application-rest-api-0.0.1-SNAPSHOT/rest/constructors";
    public static final String CONSTRUCTORS_STANDINGS_JSON = "http://localhost:8080/formula-one-application-rest-api-0.0.1-SNAPSHOT/rest/constructors/standings";
    public static final String CIRCUITS_JSON = "http://localhost:8080/formula-one-application-rest-api-0.0.1-SNAPSHOT/rest/circuits";

    public Driver selectImagesForDrivers(JSONArray jsonFileArray, JSONObject jsonURLObject, Driver driver, Constructor constructor, String resource) throws IOException {
        int i = 0;
        for (Object temp : jsonFileArray) {

            JSONObject obj = (JSONObject) temp;
                if (obj.get("driverId").toString().equals(jsonURLObject.get("code")) && obj.get("driverImage") != "") {
                    // Driver Related
                    // Create the Display image
                    String driverImage = (String) obj.get("driverImage"); // Driver Display Image
                    String dir;
                    if(resource.equals(GlobalF1.FORMULA_ONE_RESOURCES_TESTDIR)){
                        dir = GlobalF1.FORMULA_ONE_RESOURCES_TESTDIR;
                    } else{
                        dir = GlobalF1.FORMULA_ONE_RESOURCES_DIR;
                    }
                    driver.setDriverImage(setTheImage(dir +"Drivers/" + driverImage));
                    // Create the Flag image
                    String imageStringFlag = (String) obj.get("driverFlag"); // Driver Flag Image
                    driver.setDriverFlag(setTheImage(dir +"Flags/" + imageStringFlag));
                    // Create the Flag image
                    String helmet = (String) obj.get("helmet"); // Driver Flag Image
                    driver.setDriverHelmet(setTheImage(dir +"Helmets/" + helmet));

                    // Because the Driver Information page only needs the Teamlogo we add it over here
                    String teamLogoString = (String) obj.get("teamLogo"); // Constructor Logo Image
                    constructor.setTeamLogo(setTheImage(dir +"Constructors/" + teamLogoString));
                    driver.setConstructorInfo(constructor);
                    driver.getConstructorInfo().setTeamLogo(constructor.getTeamLogo());
            }
            i = i++;
        }
        return driver;
    }

    public Constructor selectImagesForConstructor(JSONArray jsonFileArray, Constructor constructor, String source) throws IOException {

        JSONObject obj;
        for (Object aJsonFileArray : jsonFileArray) {
            // Constructor Related
            obj = (JSONObject) aJsonFileArray;
            if (obj.get("teamName").toString().equals(constructor.getConstructorId().toString())) {
                String teamLogoString = (String) obj.get("teamLogo"); // Constructor Logo Image
                constructor.setTeamLogo(setTheImage(source+"Constructors/" + teamLogoString));
                break;
            }
        }
        return constructor;
    }

    public ImageView setTheImage(String imageString) throws IOException {
        BufferedImage bufferedImage;
        bufferedImage = ImageIO.read(new File(imageString));
        Image image = SwingFXUtils.toFXImage(bufferedImage, null);
        ImageView view = new ImageView();
        view.setImage(image);
        return view;
    }
}

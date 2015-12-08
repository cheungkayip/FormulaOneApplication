package f1.app.global;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import f1.app.constructor.Constructor;
import f1.app.drivers.Driver;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by kayipcheung on 04-12-15.
 */
public class GlobalF1 {

    public Driver selectImagesForDrivers(JSONArray jsonFileArray, JSONObject jsonURLObject, Driver driver, Constructor constructor) throws IOException, ParseException {
        int i = 0;
        for (Object temp : jsonFileArray) {

            JSONObject obj = (JSONObject) temp;
                if (obj.get("driverId").toString().equals(jsonURLObject.get("code")) && obj.get("driverImage") != "") {
                    // Driver Related
                    // Create the Display image
                    String driverImage = (String) obj.get("driverImage"); // Driver Display Image
                    driver.setDriverImage(setTheImage("src/main/resources/Drivers/" + driverImage));
                    // Create the Flag image
                    String imageStringFlag = (String) obj.get("driverFlag"); // Driver Flag Image
                    driver.setDriverFlag(setTheImage("src/main/resources/Flags/" + imageStringFlag));
                    // Create the Flag image
                    String helmet = (String) obj.get("helmet"); // Driver Flag Image
                    driver.setDriverHelmet(setTheImage("src/main/resources/Helmets/" + helmet));

                    // Because the Driver Information page only needs the Teamlogo we add it over here
                    String teamLogoString = (String) obj.get("teamLogo"); // Constructor Logo Image
                    constructor.setTeamLogo(setTheImage("src/main/resources/Constructors/" + teamLogoString));
                    driver.setConstructorInfo(constructor);
                    driver.getConstructorInfo().setTeamLogo(constructor.getTeamLogo());
            }
            i = i++;
        }
        return driver;
    }

    public Constructor selectImagesForConstructor(JSONArray jsonFileArray, Constructor constructor) throws IOException {

        JSONObject obj;
        for (Object aJsonFileArray : jsonFileArray) {
            // Constructor Related
            obj = (JSONObject) aJsonFileArray;
            if (obj.get("teamName").toString().equals(constructor.getConstructorId().toString())) {
                String teamLogoString = (String) obj.get("teamLogo"); // Constructor Logo Image
                constructor.setTeamLogo(setTheImage("src/main/resources/Constructors/" + teamLogoString));
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

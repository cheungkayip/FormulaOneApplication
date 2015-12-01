package f1.app.drivers;

import f1.app.ergast.url.Ergast;
import f1.app.statistics.Statistics;
import f1.app.teams.Team;
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
    private Team team;
    private ArrayList<Driver> driverList = new ArrayList<Driver>();

    public Driver modifyTheDriver() {
        //TODO: IMPLEMENT
        return getDriver();
    }

    public Driver clearTheDriver() {
        driver = null;
        driverList.clear();
        return driver;
    }

    public Driver createTheDrivers2() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Ergast ergast = null;
        ergast.setErgast(new Ergast());
        int driverCount = 0;
        String output = ergast.getErgast().callUrlToGetJSONData("http://ergast.com/api/f1/2015/drivers.json?callback=myParser");
        Object obj = parser.parse(output);
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray driverJSON = (JSONArray) jsonObject.get("Drivers");

        Iterator<String> iterator = driverJSON.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == ("" + driverCount)) {
                break;
            }
            setDriver(new Driver());
            JSONObject object = (JSONObject) driverJSON.get(driverCount);

            // Set the Driver specific details
            getDriver().setFirstName((String) object.get("firstName"));
            getDriver().setLastName((String) object.get("lastName"));
            getDriver().setPlaceOfBirth((String) object.get("placeOfBirth"));
            getDriver().setCountry((String) object.get("country"));
        }
        return getDriver();
    }

    public Driver createTheDrivers() {
        JSONParser parser = new JSONParser();
        int driverCount = 0;
        try {
            String currentDirectory = System.getProperty("user.dir");
            System.out.println(currentDirectory);
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

                // Set the Driver specific details
                getDriver().setFirstName((String) object.get("firstName"));
                getDriver().setLastName((String) object.get("lastName"));
                getDriver().setPlaceOfBirth((String) object.get("placeOfBirth"));
                getDriver().setCountry((String) object.get("country"));
                // Create the driverDisplay picture
                String imageString = (String) object.get("driverImage"); // JSON String name
                BufferedImage bufferedImage;
                bufferedImage = ImageIO.read(new File("src/main/resources/" + imageString));
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                ImageView view = new ImageView();
                view.setImage(image);
                getDriver().setDriverImage(view);

                // Create Statistics Object
                setStatistics(new Statistics());
                // Set the Driver Statistics from the JSON file
                getStatistics().setNumberOfPodiums((long) object.get("numberOfPodiums"));
                getStatistics().setPoints((long) object.get("points"));
                getStatistics().setGrandPrixEntered((long) object.get("grandPrixEntered"));
                getStatistics().setWorldChampionships((long) object.get("worldChampionships"));
                getStatistics().setHighestRaceFinish((long) object.get("highestRaceFinish"));
                getStatistics().setHighestGridPosition((long) object.get("highestGridPosition"));
                getDriver().setStatisticsInfo(getStatistics());

                // Create the Display image
                String driverImage = (String) object.get("driverImage"); // Driver Display Image
                getDriver().setDriverImage(setTheImage(driverImage));
                // Create the Flag image
                String imageStringFlag = (String) object.get("driverFlag"); // Driver Flag Image
                getDriver().setDriverFlag(setTheImage(imageStringFlag));


                setTeam(new Team());
                // Create the Team logo image
                String teamLogoString = (String) object.get("teamLogo"); // Team Logo Image
                getTeam().setTeamLogo(setTheImage(teamLogoString));

                for (Team.TeamName temp : Team.TeamName.values()) {
                    if (temp.name().equals(object.get("teamName"))) {
                        getTeam().setTeamName(temp);
                        getDriver().setTeamInfo(getTeam());
//                            System.out.println(temp.name() + " and " + object.get("teamName") + " are the same so add them now!");
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

    public ImageView setTheImage(String imageString) throws IOException {
        BufferedImage bufferedImage;
        bufferedImage = ImageIO.read(new File("src/main/resources/" + imageString));
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public ArrayList<Driver> getDriverList() {
        return driverList;
    }

}

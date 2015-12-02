package javafx;

import f1.app.drivers.Driver;
import f1.app.drivers.DriverMutator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Formula1Controller implements Initializable {
    @FXML
    private TextField code;
    @FXML
    private TextField driverId;
    @FXML
    private TextField permanentNumber;
    @FXML
    private TextField givenName;
    @FXML
    private ImageView driverFlag;
    @FXML
    private TextField familyName;
    @FXML
    private TextField placeOfBirth;
    @FXML
    private TextField nationality;
    @FXML
    private TextField points;
    @FXML
    private TextField numberOfPodiums;
    @FXML
    private TextField grandPrixEntered;
    @FXML
    private TextField worldChampionships;
    @FXML
    private TextField highestRaceFinish;
    @FXML
    private TextField highestGridPosition;
    @FXML
    private TextField constructor;
    @FXML
    private TextArea addedDrivers;
    @FXML
    private ImageView driverImage;
    @FXML
    private ImageView teamLogo;
    @FXML
    private Button fillDriversButton; // fx:id="myButton" value injected by FXMLLoader
    @FXML
    private Button clearButton;
    @FXML
    private Button changeButton;
    @FXML
    private Button showSelectedDriverButton;
    DriverMutator mutator = new DriverMutator();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clearAllTheFields();
        AddTheDrivers();
    }

    public void clearAllTheFields() {
        clearButton.setOnAction(event -> {
        // Clear the Object
        mutator.clearTheDriver();
        // Clear Driver details Fields
        code.setText("");
        driverId.setText("");
        permanentNumber.setText("");
        givenName.setText("");
        familyName.setText("");
        placeOfBirth.setText("");
        nationality.setText("");
        // Clear Statistics Fields
        points.setText("");
        numberOfPodiums.setText("");
        grandPrixEntered.setText("");
        worldChampionships.setText("");
        highestRaceFinish.setText("");
        highestGridPosition.setText("");
        // Clear TeamInfo Fields
        constructor.setText("");
        addedDrivers.setText("");
        // Clear the Image
        driverImage.setImage(null);
        driverFlag.setImage(null);
        teamLogo.setImage(null);
        addedDrivers.setText(null);
    });
    }

    public void AddTheDrivers() {
        assert fillDriversButton != null : "fx:id=\"myButton\" was not injected: check your FXML file 'Formula1.fxml'.";
        fillDriversButton.setOnAction(event -> {
        // Create the Drivers from the JSON URL
            try {
                mutator.createDriversFromURL();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            // Get driver specific info
        code.setText(mutator.getDriver().getCode());
        driverId.setText(mutator.getDriver().getDriverId());
        permanentNumber.setText(mutator.getDriver().getPermanentNumber());
        givenName.setText(mutator.getDriver().getGivenName());
        familyName.setText(mutator.getDriver().getFamilyName());
        placeOfBirth.setText(mutator.getDriver().getPlaceOfBirth());
        nationality.setText(mutator.getDriver().getNationality());

        // Get driver statistics
//        points.setText(""+mutator.getDriver().getStatisticsInfo().getPoints());
//        numberOfPodiums.setText(""+mutator.getDriver().getStatisticsInfo().getNumberOfPodiums());
//        grandPrixEntered.setText(""+mutator.getDriver().getStatisticsInfo().getGrandPrixEntered());
//        worldChampionships.setText(""+mutator.getDriver().getStatisticsInfo().getWorldChampionships());
//        highestRaceFinish.setText(""+mutator.getDriver().getStatisticsInfo().getHighestRaceFinish());
//        highestGridPosition.setText(""+mutator.getDriver().getStatisticsInfo().getHighestGridPosition());

        // Get Constructor Info
        constructor.setText(""+mutator.getDriver().getConstructorInfo().getConstructorId());

        // Set Drivers Display Picture + Flag
        driverImage.setImage(mutator.getDriver().getDriverImage().getImage());
        driverFlag.setImage(mutator.getDriver().getDriverFlag().getImage());
        teamLogo.setImage(mutator.getConstructor().getTeamLogo().getImage());
        // Display Drivers that were from the JSON File
            String theResult;
        mutator.getDriver().setBuffer(new StringBuffer());
        for(Driver temp: mutator.getDriverList()){
             mutator.getDriver().toString(temp);
        }
            StringBuffer buffer = mutator.getDriver().getBuffer();
            addedDrivers.setText(""+buffer);
    });
    }


}

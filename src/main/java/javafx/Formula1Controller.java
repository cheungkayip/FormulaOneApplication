package javafx;

import f1.app.drivers.Driver;
import f1.app.drivers.DriverMutator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class Formula1Controller implements Initializable {
    @FXML
    private Button showButton; // fx:id="myButton" value injected by FXMLLoader
    @FXML
    private Button clearButton;
    @FXML
    private Button changeButton;
    @FXML
    private TextField firstName;
    @FXML
    private ImageView driverFlag;
    @FXML
    private TextField lastName;
    @FXML
    private TextField placeOfBirth;
    @FXML
    private TextField country;
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
    private TextField team;
    @FXML
    private TextArea addedDrivers;
    @FXML
    private ImageView driverImage;
    @FXML
    private ImageView teamLogo;
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
        firstName.setText("");
        lastName.setText("");
        placeOfBirth.setText("");
        country.setText("");
        // Clear Statistics Fields
        points.setText("");
        numberOfPodiums.setText("");
        grandPrixEntered.setText("");
        worldChampionships.setText("");
        highestRaceFinish.setText("");
        highestGridPosition.setText("");
        // Clear TeamInfo Fields
        team.setText("");
        addedDrivers.setText("");
        // Clear the Image
        driverImage.setImage(null);
        driverFlag.setImage(null);
        teamLogo.setImage(null);
        addedDrivers.setText(null);
    });
    }

    public void AddTheDrivers() {
        assert showButton != null : "fx:id=\"myButton\" was not injected: check your FXML file 'Formula1.fxml'.";
        showButton.setOnAction(event -> {
        // Create the Drivers from the JSON File
        mutator.createTheDrivers();
        // Get driver specific info
        firstName.setText(mutator.getDriver().getFirstName());
        lastName.setText(mutator.getDriver().getLastName());
        placeOfBirth.setText(mutator.getDriver().getPlaceOfBirth());
        country.setText(mutator.getDriver().getCountry());

        // Get driver statistics
        points.setText(""+mutator.getDriver().getStatisticsInfo().getPoints());
        numberOfPodiums.setText(""+mutator.getDriver().getStatisticsInfo().getNumberOfPodiums());
        grandPrixEntered.setText(""+mutator.getDriver().getStatisticsInfo().getGrandPrixEntered());
        worldChampionships.setText(""+mutator.getDriver().getStatisticsInfo().getWorldChampionships());
        highestRaceFinish.setText(""+mutator.getDriver().getStatisticsInfo().getHighestRaceFinish());
        highestGridPosition.setText(""+mutator.getDriver().getStatisticsInfo().getHighestGridPosition());

        // Get Team Info
        team.setText(""+mutator.getDriver().getTeamInfo().getTeamName());

        // Set Drivers Display Picture + Flag
        driverImage.setImage(mutator.getDriver().getDriverImage().getImage());
        driverFlag.setImage(mutator.getDriver().getDriverFlag().getImage());
        teamLogo.setImage(mutator.getTeam().getTeamLogo().getImage());
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

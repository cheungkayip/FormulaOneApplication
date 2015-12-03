package javafx;

import f1.app.drivers.Driver;
import f1.app.drivers.DriverMutator;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DriverController implements Initializable {
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
    private TextField dateOfBirth;
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
    private ImageView driverHelmet;
    @FXML
    private Button fillDriversButton; // fx:id="myButton" value injected by FXMLLoader
    @FXML
    private Button clearButton;
    @FXML
    private Button changeButton;
    @FXML
    private Button showSelectedDriverButton;

    @FXML
    public ComboBox driversCombobox;

    DriverMutator mutator = new DriverMutator();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getAllDriversButton();
        clearButton();
        modifyDriverButton();
        showDriverButton();
    }

    public void showDriverButton() {
        showSelectedDriverButton.setOnAction(event -> {
                    // Get Selected value first
                    String selectedValue = (String) driversCombobox.getValue();
                    for (Driver driver : mutator.getDriverList()) {
                        if (selectedValue.contentEquals(driver.getGivenName() + " " + driver.getFamilyName())) {
                            mutator.setDriver(driver);
                            mutator.setConstructor(driver.getConstructorInfo());
                            fillTheDriverFields();
                            break;
                        }
                    }
                }
        );
    }

    public void clearButton() {
        clearButton.setOnAction(event -> {
            // Clear the Object
            mutator.clearTheDriver();
            driversCombobox.setItems(FXCollections.observableArrayList());
            clearTheDriverFields();
        });
    }

    public void getAllDriversButton() {
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

            fillTheDriverFields();

            // Fetch the ArrayList + Fill the Choicebox with data
            ArrayList<Driver> listOfAllDrivers = mutator.getDriverList();
            ArrayList<String> driverNames = new ArrayList<>();
            for (int i = 0; i < listOfAllDrivers.size(); i++) {
                String givenName = listOfAllDrivers.get(i).getGivenName();
                String familyName = listOfAllDrivers.get(i).getFamilyName();
                driverNames.add(givenName + " " + familyName);
            }
            driversCombobox.setItems(FXCollections.observableArrayList(driverNames));
            System.out.println(driversCombobox.getItems());

        });
    }

    public void modifyDriverButton(){
        //TODO: IMPLEMENT
    }

    public void fillTheDriverFields() {
        // Get driver specific info
        code.setText(mutator.getDriver().getCode());
        driverId.setText(mutator.getDriver().getDriverId());
        permanentNumber.setText(mutator.getDriver().getPermanentNumber());
        givenName.setText(mutator.getDriver().getGivenName());
        familyName.setText(mutator.getDriver().getFamilyName());
        dateOfBirth.setText(mutator.getDriver().getPlaceOfBirth());
        nationality.setText(mutator.getDriver().getNationality());

        // Get Constructor Info
        constructor.setText("" + mutator.getDriver().getConstructorInfo().getConstructorId());

        // Set Drivers Display Picture + Flag
        driverImage.setImage(mutator.getDriver().getDriverImage().getImage());
        driverFlag.setImage(mutator.getDriver().getDriverFlag().getImage());
        teamLogo.setImage(mutator.getConstructor().getTeamLogo().getImage());
        driverHelmet.setImage(mutator.getDriver().getDriverHelmet().getImage());
        // Display Drivers that were from the JSON File
        mutator.getDriver().setBuffer(new StringBuffer());
        for (Driver temp : mutator.getDriverList()) {
            mutator.getDriver().toString(temp);
        }
        StringBuffer buffer = mutator.getDriver().getBuffer();
        addedDrivers.setText("" + buffer);
    }

    public void clearTheDriverFields(){
        //In case you keep pressing "Get all Drivers" button clear the Combobox first to prevent double values
        driversCombobox.setItems(FXCollections.observableArrayList());
        // Clear Driver details Fields
        code.setText("");
        driverId.setText("");
        permanentNumber.setText("");
        givenName.setText("");
        familyName.setText("");
        dateOfBirth.setText("");
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
        driverHelmet.setImage(null);
        driverHelmet.setImage(null);
        addedDrivers.setText(null);
    }
}
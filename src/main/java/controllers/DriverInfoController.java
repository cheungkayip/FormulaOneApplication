package controllers;

import f1.app.constructor.Constructor;
import f1.app.constructor.ConstructorMutator;
import f1.app.drivers.Driver;
import f1.app.drivers.DriverMutator;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DriverInfoController implements Initializable {
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
    private Button clearButton;
    @FXML
    private Button showSelectedDriverButton;
    @FXML
    public ChoiceBox<String> driversCombobox;

    private DriverMutator driverMutator = new DriverMutator();
    private ConstructorMutator constructorMutator = new ConstructorMutator();
    private ArrayList<Constructor> constructorList = new ArrayList<>();

    public ArrayList<Constructor> getConstructorList() {
        return constructorList;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        preLoadTheApplicationWithData();
        clearButton();
        modifyDriverButton();
        showDriverButton();
    }

    public void showDriverButton() {
        showSelectedDriverButton.setOnAction(event -> {
                    // Get Selected value first
                    String selectedValue = driversCombobox.getValue();
                    for (Driver driver : driverMutator.getDriverList()) {
                        if (selectedValue.contentEquals(driver.getGivenName() + " " + driver.getFamilyName())) {
                            driverMutator.setDriver(driver);
                            driverMutator.setConstructor(driver.getConstructorInfo());
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
            driverMutator.clearTheDriver();
            clearTheDriverFields();
        });
    }

    public void modifyDriverButton() {
        //TODO: IMPLEMENT
    }

    public void preLoadTheApplicationWithData() {
        // Create the Drivers from the JSON URL
        try {
            driverMutator.createDriversFromURL();
            constructorList = constructorMutator.getAllTheConstructorInformation();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        fillTheDriverFields();

        // Fetch the ArrayList + Fill the Choicebox with data
        ArrayList<Driver> listOfAllDrivers = driverMutator.getDriverList();
        ArrayList<String> driverNames = new ArrayList<>();
        for (Driver listOfAllDriver : listOfAllDrivers) {
            String givenName = listOfAllDriver.getGivenName();
            String familyName = listOfAllDriver.getFamilyName();
            driverNames.add(givenName + " " + familyName);
        }
        driversCombobox.setItems(FXCollections.observableArrayList(driverNames));
        System.out.println(driversCombobox.getItems());
    }

    public void fillTheDriverFields() {
        // Get driver specific info
        code.setText(driverMutator.getDriver().getCode());
        driverId.setText(driverMutator.getDriver().getDriverId());
        permanentNumber.setText(driverMutator.getDriver().getPermanentNumber());
        givenName.setText(driverMutator.getDriver().getGivenName());
        familyName.setText(driverMutator.getDriver().getFamilyName());
        dateOfBirth.setText(driverMutator.getDriver().getDateOfBirth());
        nationality.setText(driverMutator.getDriver().getNationality());

        // Get Constructor Info
        constructor.setText("" + driverMutator.getDriver().getConstructorInfo().getConstructorId());

        // Set Drivers Display Picture + Flag
        driverImage.setImage(driverMutator.getDriver().getDriverImage().getImage());
        driverFlag.setImage(driverMutator.getDriver().getDriverFlag().getImage());
        driverHelmet.setImage(driverMutator.getDriver().getDriverHelmet().getImage());
        teamLogo.setImage(driverMutator.getConstructor().getTeamLogo().getImage());
        // Display Drivers that were from the JSON File
        driverMutator.getDriver().setBuffer(new StringBuffer());
        for (Driver temp : driverMutator.getDriverList()) {
            driverMutator.getDriver().toString(temp);
        }
        StringBuffer buffer = driverMutator.getDriver().getBuffer();
        addedDrivers.setText("" + buffer);
    }

    public void clearTheDriverFields() {
        // Clear Driver details Fields
        code.setText("");
        driverId.setText("");
        permanentNumber.setText("");
        givenName.setText("");
        familyName.setText("");
        dateOfBirth.setText("");
        nationality.setText("");
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
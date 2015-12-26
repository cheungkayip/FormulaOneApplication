package controllers;

import f1.app.drivers.Driver;
import f1.app.drivers.DriverMutator;
import f1.app.global.GlobalF1;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
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
    public ChoiceBox<String> driversChoicebox;

    private final DriverMutator driverMutator = new DriverMutator();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert code != null : "fx:id=\"code\" was not injected: check your FXML file 'Driver.fxml'.";
        assert driverId != null : "fx:id=\"driverId\" was not injected: check your FXML file 'Driver.fxml'.";
        assert permanentNumber != null : "fx:id=\"permanentNumber\" was not injected: check your FXML file 'Driver.fxml'.";
        assert givenName != null : "fx:id=\"givenName\" was not injected: check your FXML file 'Driver.fxml'.";
        assert driverFlag != null : "fx:id=\"driverFlag\" was not injected: check your FXML file 'Driver.fxml'.";
        assert familyName != null : "fx:id=\"familyName\" was not injected: check your FXML file 'Driver.fxml'.";
        assert dateOfBirth != null : "fx:id=\"dateOfBirth\" was not injected: check your FXML file 'Driver.fxml'.";
        assert nationality != null : "fx:id=\"nationality\" was not injected: check your FXML file 'Driver.fxml'.";
        assert driverImage != null : "fx:id=\"driverImage\" was not injected: check your FXML file 'Driver.fxml'.";
        assert teamLogo != null : "fx:id=\"teamLogo\" was not injected: check your FXML file 'Driver.fxml'.";
        assert driverHelmet != null : "fx:id=\"driverHelmet\" was not injected: check your FXML file 'Driver.fxml'.";
        preLoadTheApplicationWithData();
        clearButton();
        showDriverButton();
    }

    private void showDriverButton() {
        showSelectedDriverButton.setOnAction(event -> {
            // Get Selected value first
            String selectedValue = driversChoicebox.getValue();
            // Java 8 to match the Object
            Optional<Driver> driver = driverMutator.getDriverList().stream().filter(obj -> selectedValue.contentEquals(obj.getGivenName() + " " + obj.getFamilyName())).findFirst();
            driverMutator.setDriver(driver.get());
            driverMutator.setConstructor(driver.get().getConstructorInfo());
            fillTheDriverFields();
        });
    }

    private void clearButton() {
        clearButton.setOnAction(event -> {
            // Clear the Object
            driverMutator.clearTheDriver();
            clearTheDriverFields();
        });
    }

    private void preLoadTheApplicationWithData() {
        // Create the Drivers from the JSON URL
        driverMutator.createDriversFromURL(GlobalF1.FORMULA_ONE_RESOURCES_DIR);
        fillTheDriverFields();
        loadChoicebox();
    }

    private void loadChoicebox(){
        // Fetch the ArrayList + Fill the Choicebox with data
        ArrayList<Driver> listOfAllDrivers = driverMutator.getDriverList();
        ArrayList<String> driverNames = new ArrayList<>();
        // Java 8 Streaming
        listOfAllDrivers.stream().forEach(driverList -> {
            String givenName = driverList.getGivenName();
            String familyName = driverList.getFamilyName();
            driverNames.add(givenName + " " + familyName);
        });
        driversChoicebox.setItems(FXCollections.observableArrayList(driverNames));
        driversChoicebox.getSelectionModel().selectFirst();

        // Get Selected value first
        String selectedValue = driversChoicebox.getValue();
        // Java 8 to match the Object
        Optional<Driver> driver = driverMutator.getDriverList().stream().filter(obj -> selectedValue.contentEquals(obj.getGivenName() + " " + obj.getFamilyName())).findFirst();
        driverMutator.setDriver(driver.get());
        driverMutator.setConstructor(driver.get().getConstructorInfo());
        fillTheDriverFields();
    }

    private void fillTheDriverFields() {
        // Get driver specific info
        code.setText(driverMutator.getDriver().getCode());
        driverId.setText(driverMutator.getDriver().getDriverId());
        permanentNumber.setText(driverMutator.getDriver().getPermanentNumber());
        givenName.setText(driverMutator.getDriver().getGivenName());
        familyName.setText(driverMutator.getDriver().getFamilyName());
        dateOfBirth.setText(driverMutator.getDriver().getDateOfBirth());
        nationality.setText(driverMutator.getDriver().getNationality());

        // Set Drivers Display Picture + Flag
        driverImage.setImage(driverMutator.getDriver().getDriverImage().getImage());
        driverFlag.setImage(driverMutator.getDriver().getDriverFlag().getImage());
        driverHelmet.setImage(driverMutator.getDriver().getDriverHelmet().getImage());
        teamLogo.setImage(driverMutator.getConstructor().getTeamLogo().getImage());
        // Display Drivers that were from the JSON File
        driverMutator.getDriver().setBuffer(new StringBuffer());
        // Java 8 Streaming
        driverMutator.getDriverList().stream().forEach(driverList -> driverMutator.getDriver().toString(driverList));
        StringBuffer buffer = driverMutator.getDriver().getBuffer();
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
        // Clear the Image
        driverImage.setImage(null);
        driverFlag.setImage(null);
        teamLogo.setImage(null);
        driverHelmet.setImage(null);
        driverHelmet.setImage(null);
    }


}
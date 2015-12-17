package controllers;

import f1.app.drivers.Driver;
import f1.app.drivers.DriverStandings;
import f1.app.global.GlobalF1;
import f1.app.races.RaceMutator;
import f1.app.races.RaceResults;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * Created by kayipcheung on 13-12-15.
 */
public class RaceResultsController implements Initializable {
    @FXML
    private int season;
    @FXML
    private int round;
    @FXML
    private String circuitName;
    @FXML
    private String locality;
    @FXML
    private String country;
    @FXML
    private String raceStartDate;
    @FXML
    private String raceStartTime;
    @FXML
    private String finishingPosition;
    @FXML
    private int driverNumber;
    @FXML
    private int driverPoints;
    @FXML
    private String givenName;
    @FXML
    private String familyName;
    @FXML
    private String constructor;
    @FXML
    private int startingGrid;
    @FXML
    private int drivenLaps;
    @FXML
    private String status;
    @FXML
    private String totalRidingTime;
    @FXML
    private int fastestLapRank;
    @FXML
    private int fastestLap;
    @FXML
    private String fastestLapTime;
    @FXML
    private ChoiceBox<String> raceChoiceBox;
    @FXML
    private TableView<RaceResults> tableView;
    RaceMutator mutator = new RaceMutator();
    ArrayList<RaceResults> arrayList = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        generateTheRaceChoiceBox();
    }

    public void generateTheRaceChoiceBox(){
        // Create the Drivers from the JSON URL
        try {
            assert season != 0 : "fx:id=\"season\" was not injected: check your FXML file 'RaceResults.fxml'.";
            assert round != 0 : "fx:id=\"round\" was not injected: check your FXML file 'RaceResults.fxml'.";
            assert circuitName != null : "fx:id=\"circuitName\" was not injected: check your FXML file 'RaceResults.fxml'.";
            assert season != 0 : "fx:id=\"season\" was not injected: check your FXML file 'RaceResults.fxml'.";
            assert locality != null : "fx:id=\"locality\" was not injected: check your FXML file 'RaceResults.fxml'.";
            assert country != null : "fx:id=\"country\" was not injected: check your FXML file 'RaceResults.fxml'.";
            assert raceStartDate != null : "fx:id=\"raceStartDate\" was not injected: check your FXML file 'RaceResults.fxml'.";
            assert raceStartTime != null : "fx:id=\"raceStartTime\" was not injected: check your FXML file 'RaceResults.fxml'.";
            assert driverNumber != 0 : "fx:id=\"driverNumber\" was not injected: check your FXML file 'RaceResults.fxml'.";
            assert driverPoints != 0 : "fx:id=\"driverPoints\" was not injected: check your FXML file 'RaceResults.fxml'.";
            assert givenName != null : "fx:id=\"givenName\" was not injected: check your FXML file 'RaceResults.fxml'.";
            assert familyName != null : "fx:id=\"familyName\" was not injected: check your FXML file 'RaceResults.fxml'.";
            assert constructor != null : "fx:id=\"constructor\" was not injected: check your FXML file 'RaceResults.fxml'.";
            assert startingGrid != 0 : "fx:id=\"startingGrid\" was not injected: check your FXML file 'RaceResults.fxml'.";
            assert drivenLaps != 0 : "fx:id=\"drivenLaps\" was not injected: check your FXML file 'RaceResults.fxml'.";
            assert status != null : "fx:id=\"status\" was not injected: check your FXML file 'RaceResults.fxml'.";
            assert totalRidingTime != null : "fx:id=\"totalRidingTime\" was not injected: check your FXML file 'RaceResults.fxml'.";
            assert fastestLapRank != 0 : "fx:id=\"fastestLapRank\" was not injected: check your FXML file 'RaceResults.fxml'.";
            assert fastestLap != 0 : "fx:id=\"fastestLap\" was not injected: check your FXML file 'RaceResults.fxml'.";
            assert fastestLapTime != null : "fx:id=\"fastestLapTime\" was not injected: check your FXML file 'RaceResults.fxml'.";
            arrayList = mutator.generateRaceResults(GlobalF1.SAVED_JSON_DIR);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        // Fetch the ArrayList + Fill the Choicebox with data
        ArrayList<String> circuitInformation = mutator.getCircuitInformation();

        raceChoiceBox.setItems(FXCollections.observableArrayList(circuitInformation));
        raceChoiceBox.getSelectionModel().selectFirst();
        raceChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                // Java 8 Steam Example + Filter + Foreach
                ArrayList<RaceResults> theList = mutator.decideWhichRaceIsDisplayed(arrayList,newValue);
                ObservableList<RaceResults> data = tableView.getItems();
                data.clear();
                data.addAll(theList.stream().collect(Collectors.toList()));
            }
        });





    }
}

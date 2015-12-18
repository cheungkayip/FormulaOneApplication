package controllers;

import f1.app.global.GlobalF1;
import f1.app.races.RaceMutator;
import f1.app.races.RaceResults;
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
 * RaceResults Controller to control the UI Components with the F1 App
 * Created by kayipcheung on 13-12-15.
 */
public class RaceResultsController implements Initializable {
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

    public void generateTheRaceChoiceBox() {
        // Create the Drivers from the JSON URL
        try {
            arrayList = mutator.generateRaceResults(GlobalF1.SAVED_JSON_DIR);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        // Fetch the ArrayList + Fill the Choicebox with data
        ArrayList<String> circuitInformation = mutator.getCircuitInformation();

        raceChoiceBox.setItems(FXCollections.observableArrayList(circuitInformation));
        raceChoiceBox.getSelectionModel().selectFirst();
        // To default display the first Albert Park Australia Race we set this one time.
        // The Listener afterwards will decide on your choicebox choice.
        ArrayList<RaceResults> defaultFirstRace = mutator.decideWhichRaceIsDisplayed(arrayList,0);
        ObservableList<RaceResults> defaultTable = tableView.getItems();
        defaultTable.addAll(defaultFirstRace.stream().collect(Collectors.toList()));

        // This is the Listener which will change if you select a different race.
        raceChoiceBox.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            // Java 8 Steam Example + Filter + Foreach
            ArrayList<RaceResults> theList = mutator.decideWhichRaceIsDisplayed(arrayList, newValue);
            ObservableList<RaceResults> data = tableView.getItems();
            data.clear();
            data.addAll(theList.stream().collect(Collectors.toList()));
        });


    }
}

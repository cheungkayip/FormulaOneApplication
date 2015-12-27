package controllers;

import f1.app.mutator.DriverMutator;
import f1.app.pojo.DriverStandings;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * Created by kayipcheung on 04-12-15.
 */
public class DriverStandingsController implements Initializable {
    @FXML
    private TableView<DriverStandings> tableView;

    private final DriverMutator driverMutator = new DriverMutator();
    private ArrayList<DriverStandings> driverStandingsArrayList = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'DriverStandings.fxml'.";
            generateTheDriversTable();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private void generateTheDriversTable() throws IOException, ParseException {
        driverStandingsArrayList = driverMutator.generateDriverStandings();
        ObservableList<DriverStandings> data = tableView.getItems();
        // Java 8 Streaming
        data.addAll(driverStandingsArrayList.stream().collect(Collectors.toList()));
    }
}

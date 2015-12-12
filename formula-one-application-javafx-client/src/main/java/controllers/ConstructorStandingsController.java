package controllers;

import f1.app.constructor.ConstructorMutator;
import f1.app.constructor.ConstructorStandings;
import f1.app.drivers.DriverMutator;
import f1.app.drivers.DriverStandings;
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
 * Created by kayipcheung on 03-12-15.
 */
public class ConstructorStandingsController implements Initializable {
    @FXML
    private TableView<ConstructorStandings> tableView;

    ConstructorMutator constructorMutator = new ConstructorMutator();
    ArrayList<ConstructorStandings> standingsList = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'ConstructorStandings.fxml'.";
            generateConstructorStandings();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void generateConstructorStandings() throws IOException, ParseException {
        standingsList = constructorMutator.displayConstructorStandings();
        ObservableList<ConstructorStandings> data = tableView.getItems();
        // Java 8 Streaming
        data.addAll(standingsList.stream().collect(Collectors.toList()));
    }
}

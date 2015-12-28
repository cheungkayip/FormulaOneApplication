package f1.app.controllers;

import f1.app.mutator.ConstructorMutator;
import f1.app.pojo.ConstructorStandings;
import f1.app.global.GlobalF1;
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

    private final ConstructorMutator constructorMutator = new ConstructorMutator();
    private ArrayList<ConstructorStandings> standingsList = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'ConstructorStandings.fxml'.";
            generateConstructorStandings();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private void generateConstructorStandings() throws IOException, ParseException {
        standingsList = constructorMutator.displayConstructorStandings(GlobalF1.SAVED_JSON_DIR);
        ObservableList<ConstructorStandings> data = tableView.getItems();
        // Java 8 Streaming
        data.addAll(standingsList.stream().collect(Collectors.toList()));
    }
}

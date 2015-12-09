package controllers;

import f1.app.drivers.DriverMutator;
import f1.app.drivers.DriverStandings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by kayipcheung on 04-12-15.
 */
public class DriverStandingsController implements Initializable {
    @FXML
    private TableView<DriverStandings> tableView;

    DriverMutator driverMutator = new DriverMutator();
    ArrayList<DriverStandings> driverStandingsArrayList = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            generateTheDriversTable();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void generateTheDriversTable() throws IOException, ParseException {
        driverStandingsArrayList = driverMutator.generateDriverStandings();
        ObservableList<DriverStandings> data = tableView.getItems();
        for(DriverStandings temp: driverStandingsArrayList){
            data.add(new DriverStandings(temp.getPosition(),temp.getPoints(), temp.getWins(), temp.getDriver(), temp.getConstructor()));
            System.out.println(temp.getDriver().getGivenName() + " " + temp.getDriver().getFamilyName());
        }


    }
}

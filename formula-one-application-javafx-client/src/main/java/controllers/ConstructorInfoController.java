package controllers;

import f1.app.constructor.Constructor;
import f1.app.constructor.ConstructorMutator;
import f1.app.global.GlobalF1;
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
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created by kayipcheung on 06-12-15.
 */
public class ConstructorInfoController  implements Initializable {

    @FXML
    private TextField constructorId;
    @FXML
    private TextField constructorUrl;
    @FXML
    private TextField constructorName;
    @FXML
    private TextField constructorNationality;
    @FXML
    private ImageView teamLogo;
    @FXML
    public ChoiceBox<String> constructorsChoicebox;
    @FXML
    private Button showConstructorButton;
    @FXML
    private Button clearButton;
    @FXML
    private TextArea addedConstructors;

    ConstructorMutator constructorMutator = new ConstructorMutator();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert constructorId != null : "fx:id=\"constructorId\" was not injected: check your FXML file 'ConstructorInfo.fxml'.";
        assert constructorUrl != null : "fx:id=\"constructorUrl\" was not injected: check your FXML file 'ConstructorInfo.fxml'.";
        assert constructorName != null : "fx:id=\"constructorName\" was not injected: check your FXML file 'ConstructorInfo.fxml'.";
        assert constructorNationality != null : "fx:id=\"constructorNationality\" was not injected: check your FXML file 'ConstructorInfo.fxml'.";
        assert teamLogo != null : "fx:id=\"teamLogo\" was not injected: check your FXML file 'ConstructorInfo.fxml'.";
        try {
            preLoadTheApplicationWithData();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        clearButton();
        ShowConstructorButton();
    }

    public void clearButton() {
        clearButton.setOnAction(event -> {
            // Clear the Object
            constructorMutator.clearTheConstructor();
            clearTheConstructorFields();
        });
    }

    public void ShowConstructorButton() {
        showConstructorButton.setOnAction(event -> {
        String selectedValue = constructorsChoicebox.getValue(); // Get Selected value first
        // Java 8 Streaming
        Optional<Constructor> constructor = constructorMutator.getConstructorsList().stream().filter(obj -> selectedValue.contentEquals(obj.getConstructorName())).findFirst();
        constructorMutator.setConstructor(constructor.get());
        fillConstructorFields();
        }
    );
}
    public void preLoadTheApplicationWithData() throws IOException, ParseException {
        // Create the Drivers from the JSON URL
        constructorMutator.getAllTheConstructorInformation(GlobalF1.FORMULA_ONE_RESOURCES_DIR, GlobalF1.SAVED_JSON_DIR);

        fillConstructorFields();

        // Fetch the ArrayList + Fill the Choicebox with data
        ArrayList<Constructor> listOfAllConstructors = constructorMutator.getConstructorsList();
        ArrayList<String> cNames = new ArrayList<>();
        // Java 8 Streaming
        listOfAllConstructors.stream().forEach(list -> {
            String name = list.getConstructorName();
            cNames.add(name);
        });
        constructorsChoicebox.setItems(FXCollections.observableArrayList(cNames));
        constructorsChoicebox.getSelectionModel().selectFirst();
    }

    public void fillConstructorFields() {
        // Get driver specific info
        constructorId.setText(""+ constructorMutator.getConstructor().getConstructorId());
        constructorUrl.setText(""+ constructorMutator.getConstructor().getConstructorUrl());
        constructorName.setText(""+ constructorMutator.getConstructor().getConstructorName());
        constructorNationality.setText(""+ constructorMutator.getConstructor().getNationality());
        teamLogo.setImage(constructorMutator.getConstructor().getTeamLogo().getImage());
        // Display Drivers that were from the JSON File
        constructorMutator.getConstructor().setBuffer(new StringBuffer());
        // Java 8 Streaming
        constructorMutator.getConstructorsList().stream().forEach(constructorList -> constructorMutator.getConstructor().toString(constructorList));
        StringBuffer buffer = constructorMutator.getConstructor().getBuffer();
        addedConstructors.setText("" + buffer);
    }

    public void clearTheConstructorFields() {
        // Clear Driver details Fields
        constructorId.setText("");
        constructorUrl.setText("");
        constructorName.setText("");
        constructorNationality.setText("");
        teamLogo.setImage(null);
    }

}

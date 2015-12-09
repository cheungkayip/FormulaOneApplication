package controllers;

import f1.app.constructor.Constructor;
import f1.app.constructor.ConstructorMutator;
import f1.app.drivers.Driver;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
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
        preLoadTheApplicationWithData();
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
                    // Get Selected value first
                    String selectedValue = constructorsChoicebox.getValue();
                    for (Constructor constructor : constructorMutator.getConstructorsList()) {
                        if (selectedValue.contentEquals(constructor.getConstructorName())) {
                            constructorMutator.setConstructor(constructor);
                            fillConstructorFields();
                            break;
                        }
                    }
                }
        );
    }
    public void preLoadTheApplicationWithData() {
        // Create the Drivers from the JSON URL
        constructorMutator.getAllTheConstructorInformation();

        fillConstructorFields();

        // Fetch the ArrayList + Fill the Choicebox with data
        ArrayList<Constructor> listOfAllConstructors = constructorMutator.getConstructorsList();
        ArrayList<String> cNames = new ArrayList<>();
        for (Constructor c : listOfAllConstructors) {
            String name = c.getConstructorName();
            cNames.add(name);
        }
        constructorsChoicebox.setItems(FXCollections.observableArrayList(cNames));
        constructorsChoicebox.getSelectionModel().selectFirst();
        System.out.println(constructorsChoicebox.getItems());
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
        for (Constructor temp : constructorMutator.getConstructorsList()) {
            constructorMutator.getConstructor().toString(temp);
        }
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

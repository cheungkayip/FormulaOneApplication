package f1.app.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.logging.Level;
import java.util.logging.Logger;

public class F1MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            primaryStage.setTitle("Formula One Application - Drivers, Constructors, RaceResults, Statistics etc");
            TabPane tabPane = FXMLLoader.load(F1MainApplication.class.getResource("/Main.fxml"));

            Scene scene = new Scene(tabPane);
            scene.getStylesheets().add("DarkTheme.css");
            tabPane.setPrefSize(1300, 1000);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception ex) {
            Logger.getLogger(F1MainApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {

        Application.launch(F1MainApplication.class, (java.lang.String[])null);
    }
}

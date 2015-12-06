package f1.app.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

import java.util.logging.Level;
import java.util.logging.Logger;

public class F1MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            primaryStage.setTitle("Formula One Application - Drivers, Constructors, Races, Statistics etc");

            TabPane gridpane = FXMLLoader.load(F1MainApplication.class.getResource("/Formula1.fxml"));

            Scene scene = new Scene(gridpane);
            gridpane.setPrefSize(1300, 1000);
            gridpane.setPadding(new Insets(30,0,0,0));
            ColumnConstraints column1 = new ColumnConstraints(100);
            ColumnConstraints column2 = new ColumnConstraints(50, 150, 300);
            column2.setHgrow(Priority.ALWAYS);
//            gridpane.getColumnConstraints().addAll(column1, column2);
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

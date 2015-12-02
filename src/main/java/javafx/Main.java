package javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            BorderPane root = new BorderPane();

            GridPane gridpane = FXMLLoader.load(Main.class.getResource("/Formula1.fxml"));
            Scene scene = new Scene(gridpane);
            gridpane.setPrefSize(1024, 768);
            gridpane.setPadding(new Insets(5));
            gridpane.setHgap(5);
            gridpane.setVgap(5);
            ColumnConstraints column1 = new ColumnConstraints(100);
            ColumnConstraints column2 = new ColumnConstraints(50, 150, 300);
            column2.setHgrow(Priority.ALWAYS);
            gridpane.getColumnConstraints().addAll(column1, column2);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Formula One Application");
            primaryStage.show();

        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {

        Application.launch(Main.class, (java.lang.String[])null);
    }
}

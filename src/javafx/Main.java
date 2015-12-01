package javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            GridPane page = FXMLLoader.load(Main.class.getResource("Formula1.fxml"));
            page.setPrefSize(1024, 768);
            Scene scene = new Scene(page);
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

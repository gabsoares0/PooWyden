package sample.controladores;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    private static Stage stage;

    public static void setStage(Stage primaryStage) {
        stage = primaryStage;
    }

    public static void changeScene(String fxmlPath) throws IOException {
        Parent root = FXMLLoader.load(SceneController.class.getResource(fxmlPath));
        stage.setScene(new Scene(root));
    }
}
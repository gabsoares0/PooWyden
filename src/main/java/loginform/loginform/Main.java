package loginform.loginform;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;
import sample.controladores.SceneController;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        SceneController.setStage(stage);
        SceneController.changeScene("/Login/login.fxml"); // Carregar a tela de login
        stage.setTitle("EN-Fitness");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
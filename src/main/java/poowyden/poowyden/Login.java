package poowyden.poowyden;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Login extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Login");
        stage.setScene(scene);

        // Configura a tela de login para abrir maximizada
        stage.setMaximized(true); // Abre em modo maximizado (ocupando a tela toda)
        // stage.setFullScreen(true); // Abre em modo tela cheia (ocultando a barra de título)

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

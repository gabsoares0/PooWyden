/*Quando escrevi esse código só eu e deus sabia o que ele fazia, agora só deus sabe.*/

package poowyden.poowyden;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

import javafx.fxml.FXMLLoader;

public class LoginController {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label wrongLogin;

    @FXML
    private void handleLogin() {
        if ("admin".equals(username.getText()) && "admin".equals(password.getText())) {
            try {
                // Carrega a nova tela do dashboard
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dashboard.fxml")));

                Scene scene = new Scene(root);

                // Adiciona o CSS
                //scene.getStylesheets().add(getClass().getResource("/Dashboard/values/style.css").toExternalForm());

                // Muda a cena
                Stage stage = (Stage) username.getScene().getWindow();
                stage.setTitle("Dashboard");
                stage.setScene(scene);
                System.out.println("LOGIN!!");
            } catch (IOException e) {
                wrongLogin.setText("Erro ao carregar a tela.");
            }
        } else {
            wrongLogin.setText("Usuário ou senha incorretos.");
        }
    }
}

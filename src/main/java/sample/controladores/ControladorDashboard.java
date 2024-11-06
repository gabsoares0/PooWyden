package sample.controladores;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class ControladorDashboard {
    @FXML
    private Button btnAlunos; // Associe o botão do navbar

    @FXML
    private void initialize() {
        btnAlunos.setOnAction(e -> mostrarAlunos());
    }

    private void mostrarAlunos() {
        try {
            // Carrega a nova tela de alunos
            Parent root = FXMLLoader.load(getClass().getResource("/Dashboard/alunos/alunos.fxml"));
            Scene scene = new Scene(root);

            // Muda a cena
            Stage stage = (Stage) btnAlunos.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
            // Trate o erro conforme necessário
        }
    }
}


package poowyden.poowyden;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class RegisterStudentController {

    @FXML
    private Button Cancelar;

    @FXML
    private void cancelarCadastro() {
        try {
            // Carrega a tela de alunos novamente
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
            Scene novaCena = new Scene(loader.load());

            // Obter a janela atual (Stage) e trocar de tela
            Stage stage = (Stage) Cancelar.getScene().getWindow();  // Botão de cancelar
            stage.setScene(novaCena);
        } catch (IOException e) {
            e.printStackTrace();  // Exibe a exceção no console para depuração
        }
    }
}
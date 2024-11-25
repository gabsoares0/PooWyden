package poowyden.poowyden;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class ProfessorsController {

    @FXML
    private Button Cancel;

    @FXML
    private Button Register;

    @FXML
    void cadastrarAluno() {
        // Implementação do método
    }

    @FXML
    void cancelarCadastro() {
        // Implementação do método
    }

    @FXML
    private void abrirTelaDeCadastro() {
        try {
            // Carregar o novo arquivo FXML (o arquivo de cadastro do aluno)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("registroProfessor.fxml"));
            Scene novaCena = new Scene(loader.load());

            // Obter a janela atual (Stage) e trocar de tela
            Stage stage = (Stage) Register.getScene().getWindow();
            stage.setScene(novaCena);
        } catch (IOException e) {
            e.printStackTrace();  // Exibe a exceção no console para depuração
        }
    }
}

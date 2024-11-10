package poowyden.poowyden;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import java.io.IOException;

public class RegisterStudentController {

    @FXML
    private Button Cancelar;

    @FXML
    private Button Cadastrar;

    @FXML
    private TextField nomeField;

    @FXML
    private TextField telefoneField;

    @FXML
    private DatePicker dataField;

    // Método para cancelar o cadastro e voltar para a tela anterior
    @FXML
    private void cancelarCadastro() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml")); // Troque "dashboard.fxml" pelo nome correto da sua tela de alunos
            Scene novaCena = new Scene(loader.load());
            Stage stage = (Stage) Cancelar.getScene().getWindow();
            stage.setScene(novaCena);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cadastrar o aluno
    @FXML
    private void cadastrarAluno() {
        // Após o cadastro, carregar a tela de alunos (
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
            Scene novaCena = new Scene(loader.load());
            Stage stage = (Stage) Cadastrar.getScene().getWindow(); // Pega o stage da tela atual
            stage.setScene(novaCena);  // Altera para a tela de alunos
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package poowyden.poowyden;

import DAO.StudentDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import DAO.StudentDAOImpl;
import Entities.Student;

public class RegisterStudentController {

    @FXML
    private Button Cancel;

    @FXML
    private Button Register;

    @FXML
    private TextField dateOfBirthField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField photoField;

    private final StudentDAO studentDAO = new StudentDAOImpl();

    //Método para cancelar o cadastro e voltar para a tela anterior
    @FXML
    private void cancelarCadastro() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml")); // Troque "dashboard.fxml" pelo nome correto da sua tela de alunos
            Scene novaCena = new Scene(loader.load());
            Stage stage = (Stage) Cancel.getScene().getWindow();
            stage.setScene(novaCena);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cadastrar o aluno
    @FXML
    private void cadastrarAluno() {
        //Cadastro de um novo aluno pelo metodo save()
        String name = nameField.getText();
        String phone = phoneField.getText();
        String dateOfBirth = dateOfBirthField.getText();
        String photo = photoField.getText();

        //Futura validação de dados de entrada

        Student student = new Student();
        student.setName(name);
        student.setPhone(phone);
        student.setDataNasc(dateOfBirth);
        student.setImgSrc(photo);

        //Salva no banco de dados
        studentDAO.save(student);
        System.out.println("Registro aluno cadastrado com sucesso");

        // Após o cadastro, carregar a tela de alunos (
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
            Scene novaCena = new Scene(loader.load());
            Stage stage = (Stage) Register.getScene().getWindow(); // Pega o stage da tela atual
            stage.setScene(novaCena);  // Altera para a tela de alunos
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
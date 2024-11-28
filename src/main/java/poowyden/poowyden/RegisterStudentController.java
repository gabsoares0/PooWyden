package poowyden.poowyden;

import Entities.Student;
import DAO.StudentDAO;
import DAO.StudentDAOImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import Services.PaymentService;

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

    private final PaymentService paymentService = new PaymentService();

    //Método para cancelar o cadastro e voltar para a tela anterior
    @FXML
    //Abre o dashboard já carregado com a aba de alunos
    private void cancelarCadastro() {
        try{
            // Obtém o Stage atual (onde o botão "Cancelar" está)
            Stage currentStage = (Stage) Cancel.getScene().getWindow();

            // Usa a classe BackToDashboard para abrir o dashboard no mesmo Stage, EVITANDO ASSIM ABRIR UMA OUTRA JANELA
            BackToDashboard backToDashboard = new BackToDashboard();
            backToDashboard.openDashboard(currentStage, "students.fxml");
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao cancelar cadastro de aluno");
        }
    }

    //Método para cadastrar o aluno
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

        //Salva no banco de dados e cria o registro de pagamento inicial
        paymentService.registerNewStudent(student);
        System.out.println("Registro aluno cadastrado com sucesso, com pagamento inicial criado");

        // Após o cadastro, carregar a tela de alunos (
        try {
            // Obtém o Stage atual (onde o botão "Cancelar" está)
            Stage currentStage = (Stage) Register.getScene().getWindow();

            // Usa a classe BackToDashboard para abrir o dashboard no mesmo Stage, EVITANDO ASSIM ABRIR UMA OUTRA JANELA
            BackToDashboard backToDashboard = new BackToDashboard();
            backToDashboard.openDashboard(currentStage, "students.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
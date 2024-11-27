package poowyden.poowyden;

import DAO.StudentDAOImpl;
import Entities.Student;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;


public class StudentsController {

    // Referência ao botão no FXML
    @FXML
    private Button Registrar;

    @FXML
    private ListView<String> studentsListView;

    //Lista especial do JavaFX que "observa" mduanças na lista, ou seja, quando os itens na lista mudam, os componentes
    //interface gráfica que usam essa listão serão automaticamente atualizados

    //Utilizada para armezenar dados que serão exibidos em componentes como ListView
    private ObservableList<String> studentsList;

    private StudentDAOImpl dao;

    public StudentsController() {
        this.dao = new StudentDAOImpl();
    }
    @FXML
    public void initialize(){
        studentsList = FXCollections.observableArrayList();
        studentsListView.setItems(studentsList);
        loadStudentsFromDatabase();
    }
    private void loadStudentsFromDatabase() {
        List<Student> students = dao.findAll();
        for(Student student : students){
            String studentInfo = student.getName() + " | " + student.getPhone() + " | " + student.getDataNasc();
            studentsList.add(studentInfo);
        }
    }

    @FXML
    private void abrirTelaDeCadastro() {
        try {
            // Carregar o novo arquivo FXML (o arquivo de cadastro do aluno)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("registroAluno.fxml"));
            Scene novaCena = new Scene(loader.load( ));

            // Obter a janela atual (Stage) e trocar de tela
            Stage stage = (Stage) Registrar.getScene().getWindow();
            stage.setScene(novaCena);
        } catch (IOException e) {
            e.printStackTrace();  // Exibe a exceção no console para depuração
        }
    }
}
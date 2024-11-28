package poowyden.poowyden;

import DAO.StudentDAOImpl;
import Entities.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.util.Callback;
import java.io.IOException;
import java.util.List;

public class StudentsController {

    @FXML
    private Button Registrar;

    @FXML
    private ListView<Student> studentsListView;

    private ObservableList<Student> studentsList;

    private final StudentDAOImpl dao;

    public StudentsController() {
        this.dao = new StudentDAOImpl();
    }
    //Metodo automaticamente chamado pelo JavaFX quando o controlador é carregado
    @FXML
    public void initialize() {
        //Cria uma observableList, uma lista especial do JavaFX que observa mudanças
        studentsList = FXCollections.observableArrayList();
        //Liga o studentsList ao ListView
        studentsListView.setItems(studentsList);
        //Define uma 'fábrica' de células, ou seja, nos diz COMO cada célula será criada
        studentsListView.setCellFactory(new Callback<ListView<Student>, ListCell<Student>>() {
            @Override
            public ListCell<Student> call(ListView<Student> param) {
                return new StudentListCell();
            }
        });
        loadStudentsFromDatabase();
    }

    private void loadStudentsFromDatabase() {
        List<Student> students = dao.findAll();
        studentsList.addAll(students);
    }

    @FXML
    private void abrirTelaDeCadastro() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("registroAluno.fxml"));
            Scene novaCena = new Scene(loader.load());

            Stage stage = (Stage) Registrar.getScene().getWindow();
            stage.setScene(novaCena);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

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

    @FXML
    public void initialize() {
        studentsList = FXCollections.observableArrayList();
        studentsListView.setItems(studentsList);
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

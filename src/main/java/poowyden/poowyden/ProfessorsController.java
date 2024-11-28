package poowyden.poowyden;

import DAO.ProfessorDAOImpl;
import Entities.Professor;
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

public class ProfessorsController {

    @FXML
    private ListView<Professor> professorsListView;

    private ObservableList<Professor> professorsList;

    @FXML
    private Button Cancel;

    @FXML
    private Button Register;

    private final ProfessorDAOImpl dao;

    public ProfessorsController() {
        this.dao = new ProfessorDAOImpl();
    }

    @FXML
    public void initialize() {
        professorsList = FXCollections.observableArrayList();
        professorsListView.setItems(professorsList);
        professorsListView.setCellFactory(new Callback<ListView<Professor>, ListCell<Professor>>() {
            @Override
            public ListCell<Professor> call(ListView<Professor> param) {
                return new ProfessorListCell();
            }
        });
        loadProfessorFromDatabase();
    }

    private void loadProfessorFromDatabase() {
        List<Professor> professors = dao.findAll();
        professorsList.addAll(professors);
    }

    @FXML
    private void abrirTelaDeCadastro() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("registroProfessor.fxml"));
            Scene novaCena = new Scene(loader.load());

            Stage stage = (Stage) Register.getScene().getWindow();
            stage.setScene(novaCena);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

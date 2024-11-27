package poowyden.poowyden;

import Entities.Professor;
import DAO.ProfessorDAO;
import DAO.ProfessorDAOImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegisterProfessorController {

    @FXML
    private Button Cancel;

    @FXML
    private Button Register;

    @FXML
    private TextField cityField;

    @FXML
    private TextField cpfField;

    @FXML
    private TextField dateOfBirthField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField photoField;

    @FXML
    private TextField stateField;

    @FXML
    private TextField streetField;

    @FXML
    private TextField streetNumberField;

    private final ProfessorDAO professorDAO = new ProfessorDAOImpl();

    @FXML
    void cadastrarProfessor(ActionEvent event) {
        String name = nameField.getText();
        String phone = phoneField.getText();
        String dateOfBirth = dateOfBirthField.getText();
        String cpf = cpfField.getText();
        String street = streetField.getText();
        String streetNumber = streetNumberField.getText();
        String city = cityField.getText();
        String state = stateField.getText();
        String photo = photoField.getText();

        Professor professor = new Professor();
        professor.setName(name);
        professor.setPhone(phone);
        professor.setDataNasc(dateOfBirth);
        professor.setCpf(cpf);
        professor.setStreet(street);
        professor.setStreet_number(streetNumber);
        professor.setCity(city);
        professor.setState(state);
        professor.setImgSrc(photo);

        //salva no banco de dados
        professorDAO.save(professor);
        System.out.println("Registro Professor cadastrado com sucesso");
    }

    @FXML
    void cancelarCadastro(ActionEvent event) {

    }

}

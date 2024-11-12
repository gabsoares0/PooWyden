package poowyden.poowyden;

import DAO.StudentDAOImpl;
import Entities.Student;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.List;

public class HomeController {
    @FXML
    private HBox studentsList;

    private final StudentDAOImpl studentDAO = new StudentDAOImpl();

    @FXML
    public void initialize(){
        loadStudents();
    }

    private void loadStudents(){

        //Obtem os estudantes
        List<Student> students = studentDAO.findAll();

        //Para cada estudante, crie um VBOX e adicione ao HBOX
        for(Student student: students){
            VBox studentCard = new VBox();
            studentCard.setPrefSize(190, 200);

            //Pane para imgSrc (Por enquanto só uma cor de fundo para servir de exemplo)
            Pane imgPane = new Pane();
            imgPane.setPrefSize(190, 130);
            imgPane.setStyle("-fx-background-color: #FDDB87; -fx-background-radius: 10;");

            //Label para o nome do estudante
            Label nameLabel = new Label(student.getName());
            nameLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
            nameLabel.setPrefWidth(150);

            //Label para ao telefone do estudante
            Label phoneLabel = new Label(student.getPhone());
            phoneLabel.setStyle("-fx-font-size: 13px; -fx-text-fill: #6f6f6f;");

            //Adiciona os componentes ao VBox
            studentCard.getChildren().addAll(imgPane, nameLabel, phoneLabel);

            //Adiciona o VBox ao HBox principal
            studentsList.getChildren().add(studentCard);

        }
    }
}

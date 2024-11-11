package poowyden.poowyden;

import Entities.Student;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ContactCrontroller implements Initializable {
    @FXML
    private VBox alunosLayout;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Obtém a lista de alunos
        List<Student> students = contacts();

        // Para cada aluno na lista de contatos, carregue a interface FXML correspondente
        for (int i = 0; i < students.size(); i++) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/poowyden/poowyden/aluno_item.fxml"));

            try {
                HBox hbox = fxmlLoader.load();
                ContactItem cic = fxmlLoader.getController();

                // Passa os dados do aluno para o controller do item
                cic.setData(students.get(i));

                // Adiciona o HBox à VBox que está na tela
                alunosLayout.getChildren().add(hbox);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private List<Student> contacts() {
        List<Student> ls = new ArrayList<>();
        Student student = new Student();

        student.setName("Igor Ariel");
        student.setPhone("(81)X XXXX-XXXX");
        ls.add(student);





        return ls;
    }
}

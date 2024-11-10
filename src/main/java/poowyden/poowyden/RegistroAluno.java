package poowyden.poowyden;

import Entidades.Aluno;
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

public class RegistroAluno implements Initializable {
    @FXML
    private VBox alunosLayout;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Aluno> contacts = new ArrayList<>();

        for(int i=0; i<contacts.size(); i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/poowyden/poowyden/aluno_item.fxml"));

            try {
                HBox hbox = fxmlLoader.load();
                ItemAluno itemAluno = fxmlLoader.getController();
                itemAluno.setData(contacts.get(i));
                alunosLayout.getChildren().add(hbox);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private List<Aluno> contacts() {
        List<Aluno> ls = new ArrayList<>();
        Aluno contact = new Aluno();

        contact.setName("Igor Matheus");
        contact.setImgSrc("/img/person.png");
        contact.setPhone("+55 xx-xxx-xxx");
        contact.setDataNasc("07/09/2005");
        contact.setName("Gabriel Soares");
        contact.setImgSrc("/img/person.png");
        contact.setPhone("+55 xx-xxx-xxx");
        contact.setDataNasc("03/04/2006");

        contact.setName("Henrique Silva");
        contact.setImgSrc("/img/person.png");
        contact.setPhone("+55 xx-xxx-xxx");
        contact.setDataNasc("09/06/2002");

        ls.add(contact);
        return ls;
    }
}
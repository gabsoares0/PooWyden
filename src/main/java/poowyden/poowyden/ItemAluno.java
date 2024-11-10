package poowyden.poowyden;

import Entidades.Aluno;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ItemAluno implements Initializable {
    @FXML
    private Label contato;

    @FXML
    private ImageView img;

    @FXML
    private Label nomeUser;

    @FXML
    private Label statusPagamento;

    public void setData(Aluno contact) {
        Image imgProfile = new Image(getClass().getResourceAsStream(contact.getImgSrc()));
        img.setImage(imgProfile);

        nomeUser.setText(contact.getName());
        contato.setText(contact.getPhone());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {}
}

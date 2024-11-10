package poowyden.poowyden;

import Entidades.Contact;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ContactItem implements Initializable {
    @FXML
    private Label phone;

    @FXML
    private ImageView img;

    @FXML
    private Label name;

    @FXML
    private Label statusPagamento;

    public void setData(Contact contact) {
        Image imgProfile = new Image(getClass().getResourceAsStream(contact.getImgSrc()));
        img.setImage(imgProfile);

        name.setText(contact.getName());
        phone.setText(contact.getPhone());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {}
}

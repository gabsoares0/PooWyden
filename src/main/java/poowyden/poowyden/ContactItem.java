package poowyden.poowyden;

import Entities.Student;
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

    public void setData(Student student) {
        Image imgProfile = new Image(getClass().getResourceAsStream(student.getImgSrc()));
        img.setImage(imgProfile);

        name.setText(student.getName());
        phone.setText(student.getPhone());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {}
}

package Model;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class AlunoItemController implements Initializable {

    @FXML
    private Label contato;

    @FXML
    private ImageView img;

    @FXML
    private Label nomeUser;

    @FXML
    private Label statusPagamento;

    public void setData(Aluno aluno) {
        Image imgProfile = new Image(getClass().getResourceAsStream(aluno.getImgSrc()));
        img.setImage(imgProfile);

        nomeUser.setText(aluno.getNome());
        contato.setText(aluno.getContato());
        statusPagamento.setText(aluno.getStatus());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

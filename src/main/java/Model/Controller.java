package Model;

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

public class Controller implements Initializable {
    @FXML
    private VBox alunosLayout;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Aluno> alunos = new ArrayList<>(alunos());
        for(int i=0; i<alunos.size(); i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("aluno_item.fxml"));

            try {
                HBox hBox = fxmlLoader.load();
                AlunoItemController cic = fxmlLoader.getController();
                cic.setData(alunos.get(i));
                alunosLayout.getChildren().add(hBox);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private List<Aluno> alunos(){
        List<Aluno> ls = new ArrayList<>();
        Aluno aluno = new Aluno();

        aluno.setNome("Gabriel Soares");
        aluno.setImgSrc("/img/person.png");
        aluno.setContato("(81)9 9234-6915");
        aluno.setStatus("Pendente");
        ls.add(aluno);

        aluno = new Aluno();
        aluno.setNome("Nicollas Mauricio");
        aluno.setImgSrc("/img/person.png");
        aluno.setContato("(81)9 9406-4597");
        aluno.setStatus("Pendente");
        ls.add(aluno);

        aluno = new Aluno();
        aluno.setNome("Igor Ariel");
        aluno.setImgSrc("/img/person.png");
        aluno.setContato("(81)9 9246-7693");
        aluno.setStatus("Pendente");
        ls.add(aluno);

        aluno = new Aluno();
        aluno.setNome("Henrique Gouveia");
        aluno.setImgSrc("/img/person.png");
        aluno.setContato("(81)9 9234-6782");
        aluno.setStatus("Pendente");
        ls.add(aluno);

        aluno = new Aluno();
        aluno.setNome("Wolney Freitas");
        aluno.setImgSrc("/img/person.png");
        aluno.setContato("(81)9 9234-4589");
        aluno.setStatus("Pendente");
        ls.add(aluno);

        aluno = new Aluno();
        aluno.setNome("Restaurante VIP");
        aluno.setImgSrc("/img/person.png");
        aluno.setContato("(81)9 9234-7789");
        aluno.setStatus("Pendente");
        ls.add(aluno);

        aluno = new Aluno();
        aluno.setNome("Restaurante VIP");
        aluno.setImgSrc("/img/person.png");
        aluno.setContato("(81)9 9234-7789");
        aluno.setStatus("Pendente");
        ls.add(aluno);

        aluno = new Aluno();
        aluno.setNome("Restaurante VIP");
        aluno.setImgSrc("/img/person.png");
        aluno.setContato("(81)9 9234-7789");
        aluno.setStatus("Pendente");
        ls.add(aluno);

        aluno = new Aluno();
        aluno.setNome("Restaurante VIP");
        aluno.setImgSrc("/img/person.png");
        aluno.setContato("(81)9 9234-7789");
        aluno.setStatus("Pendente");
        ls.add(aluno);

        aluno = new Aluno();
        aluno.setNome("Restaurante VIP");
        aluno.setImgSrc("/img/person.png");
        aluno.setContato("(81)9 9234-7789");
        aluno.setStatus("Pendente");
        ls.add(aluno);
        return ls;
    }
}

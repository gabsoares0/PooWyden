package poowyden.poowyden;

import Entities.Professor;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

//ListCell<T> é uma classe genérica do JavaFX que representa uma única célula em um ListView,
//T é o tipo de objeto que a célula exibirá
public class ProfessorListCell extends ListCell<Professor> {
    private GridPane gridPane = new GridPane();
    private Text name = new Text();
    private Text phone = new Text();
    private Text cpf = new Text();

    public ProfessorListCell() {
        gridPane.add(name, 0, 0);
        gridPane.add(phone, 1, 0);
        gridPane.add(cpf, 2, 0);
        gridPane.setHgap(50);
    }

    @Override
    protected void updateItem(Professor professor, boolean empty) {
        super.updateItem(professor, empty);
        if(empty || professor == null) {
            setGraphic(null);
        }else{
            name.setText(professor.getName());
            phone.setText(professor.getPhone());
            cpf.setText(professor.getCpf());
            setGraphic(gridPane);
        }
    }
}

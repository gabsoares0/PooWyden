package poowyden.poowyden;

import Entities.Student;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

//ListCell<T> é uma classe genérica do JavaFX que representa uma única célula em um ListView,
//T é o tipo de objeto que a célula exibirá
public class StudentListCell extends ListCell<Student> {
    private GridPane gridPane = new GridPane();
    private Text name = new Text();
    private Text phone = new Text();
    private Text dataNasc = new Text();

    public StudentListCell() {
        gridPane.add(name, 0, 0);
        gridPane.add(phone, 1, 0);
        gridPane.add(dataNasc, 2, 0);
        gridPane.setHgap(50); //Espaçamento horizontal entre colunas
    }

    @Override
    protected void updateItem(Student student, boolean empty) {
        super.updateItem(student, empty);
        if (empty || student == null) {
            setGraphic(null);
        }else{
            name.setText(student.getName());
            phone.setText(student.getPhone());
            dataNasc.setText(student.getDataNasc());
            setGraphic(gridPane);
        }
    }
}

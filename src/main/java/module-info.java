module poowyden.poowyden {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;


    opens poowyden.poowyden to javafx.fxml;
    exports poowyden.poowyden;
}
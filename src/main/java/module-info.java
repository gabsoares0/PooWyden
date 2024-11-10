module poowyden.poowyden {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens poowyden.poowyden to javafx.fxml;
    exports poowyden.poowyden;
}
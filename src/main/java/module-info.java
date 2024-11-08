module poowyden.poowyden {
    requires javafx.controls;
    requires javafx.fxml;


    opens poowyden.poowyden to javafx.fxml;
    exports poowyden.poowyden;
}
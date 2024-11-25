package poowyden.poowyden;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {

    public void openDashboard(Stage currentStage, String initialView) {
        try {
            // Carrega o FXML do dashboard
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
            Scene scene = new Scene(loader.load());

            // Obtém o controlador associado ao dashboard.fxml
            DashboardController controller = loader.getController();

            // Define a visão inicial antes de exibir a cena
            controller.setInitialView(initialView);

            // Configura a visão inicial explicitamente
            controller.setupInitialView();

            // Configura o Stage com a nova cena e exibe
            currentStage.setScene(scene);
            currentStage.setTitle("Dashboard");
            currentStage.show();

        } catch (IOException e) {
            System.err.println("Erro ao carregar o dashboard.fxml");
            e.printStackTrace();
        }
    }

}

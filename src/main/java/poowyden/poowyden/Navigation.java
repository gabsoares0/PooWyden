package poowyden.poowyden;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    public void openDashboard(String initialView){
        try{
            //Carrega o FXML do dashboard
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
            Scene scene = new Scene(loader.load());

            //Obtem o controlador e configura a visão inicial
            DashboardController controller = loader.getController();
            controller.setInitialView(initialView);

            //Configura o placo e exibe a cena
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Dashboard");
            stage.show();

        }catch(IOException e){
            System.err.println("Erro ao carregar o dashboard.fxml");
            e.printStackTrace();
        }
    }
}

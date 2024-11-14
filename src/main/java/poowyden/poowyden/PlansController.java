package poowyden.poowyden;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PlansController {
    private DashboardController dashboardController;

    @FXML
    private Button verMaisDetalhesJudo;
    @FXML
    private Button verMaisDetalhesMusculacao;
    @FXML
    private Button verMaisDetalhesZumba;

    public void setDashboardController(DashboardController dashboardController) {
        this.dashboardController = dashboardController;
    }

    @FXML
    public void initialize() {
        verMaisDetalhesJudo.setOnAction(event -> carregarDetalhes("judoDetalhes.fxml"));
        verMaisDetalhesMusculacao.setOnAction(event -> carregarDetalhes2("musculacaoDetalhes.fxml"));
        verMaisDetalhesZumba.setOnAction(event -> carregarDetalhes3("zumbaDetalhes.fxml"));
    }


    private void carregarDetalhes(String fxmlFile) {
        if (dashboardController != null) {
            dashboardController.loadView("judoDetalhes.fxml");
        }

    }
    private void carregarDetalhes2(String fxmlFile) {
        if (dashboardController != null) {
            dashboardController.loadView("musculacaoDetalhes.fxml");
        }
    }

        private void carregarDetalhes3 (String fxmlFile){
            if (dashboardController != null) {
                dashboardController.loadView("zumbaDetalhes.fxml");
            }

        }
    }

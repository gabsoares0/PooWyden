/*
package poowyden.poowyden;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;

public class DashboardController {

    @FXML
    private Button btnTrocarTela; // Botão que troca para outra tela

    @FXML
    private void trocarTela(ActionEvent event) {
        try {
            // Carrega a nova tela
            Parent novaTelaRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("NovaTela.fxml")));

            // Obtém a janela atual (Stage) e muda a cena para a nova tela
            Stage stage = (Stage) btnTrocarTela.getScene().getWindow();
            stage.setScene(new Scene(novaTelaRoot));
            stage.setTitle("Alunos");
            System.out.println("Trocando para a nova tela!");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar a nova tela.");
        }
    }
} */
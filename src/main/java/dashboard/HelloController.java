package dashboard;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public class HelloController {

    @FXML
    private AnchorPane mainPane; // Painel principal onde as novas telas serão carregadas

    @FXML
    private void abrirTelaAlunos() {
        carregarTela("C:\\Users\\gabri\\OneDrive\\Área de Trabalho\\backup limpo\\src\\main\\resources\\Dashboard\\alunos.fxml"); // caminho correto do seu arquivo Alunos.fxml
    }

    // Método para carregar uma nova tela no mainPane
    private void carregarTela(String nomeFxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(nomeFxml));
            Parent novaTela = loader.load();
            mainPane.getChildren().clear(); // Limpa o painel principal
            mainPane.getChildren().add(novaTela); // Adiciona a nova tela ao painel
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Métodos para abrir cada sessão
    @FXML
    private void abrirInicio() {
        carregarTela("Inicio.fxml");
    }

    @FXML
    private void abrirAlunos() {
        carregarTela("C:\\Users\\gabri\\OneDrive\\Área de Trabalho\\backup limpo\\src\\main\\resources\\Dashboard\\alunos.fxml");
    }

    @FXML
    private void abrirProfessores() {
        carregarTela("Professores.fxml");
    }

    @FXML
    private void abrirPlanos() {
        carregarTela("Planos.fxml");
    }

    @FXML
    private void abrirFinanceiro() {
        carregarTela("Financeiro.fxml");
    }

    @FXML
    private void abrirAvisos() {
        carregarTela("Avisos.fxml");
    }

    @FXML
    private void abrirRelatorios() {
        carregarTela("Relatorios.fxml");
    }


    // Configuração dos eventos de clique nos Labels
    @FXML
    private Label labelInicio;
    @FXML
    private Label labelAlunos;
    @FXML
    private Label labelProfessores;
    @FXML
    private Label labelPlanos;
    @FXML
    private Label labelFinanceiro;
    @FXML
    private Label labelAvisos;
    @FXML
    private Label labelRelatorios;

    @FXML
    public void initialize() {
        // Configura os eventos de clique para cada Label
        labelInicio.setOnMouseClicked(event -> abrirInicio());
        labelAlunos.setOnMouseClicked(event -> abrirAlunos());
        labelProfessores.setOnMouseClicked(event -> abrirProfessores());
        labelPlanos.setOnMouseClicked(event -> abrirPlanos());
        labelFinanceiro.setOnMouseClicked(event -> abrirFinanceiro());
        labelAvisos.setOnMouseClicked(event -> abrirAvisos());
        labelRelatorios.setOnMouseClicked(event -> abrirRelatorios());
        // Configure eventos de clique para os outros Labels, se necessário
    }
}

package poowyden.poowyden;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.util.Objects;

import javafx.fxml.FXMLLoader;

public class DashboardController{

    @FXML
    private VBox homeViewContainer; //Conteiner onde o FXML da tela selecionada no Dashboard será carregada

    //Metodo que limpa o conteudo atual do Vbox homeViewContainer e o susbstitui por outros arquivos FXML
    public void loadView(String fxmlFile){
        try{
            //Limpa o conteudo atual
            homeViewContainer.getChildren().clear();

            //Carrega o novo conteudo do FXML no fxmlFile passado como argumento
            Node node = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlFile)));

            // Adiciona o novo conteúdo ao VBox
            homeViewContainer.getChildren().add(node);
        } catch (IOException e){
            System.err.println("Erro ao carregar o arquivo FXML: " + fxmlFile);
            e.printStackTrace();
        }
    }
    public void loadHomeView(){
        loadView("home.fxml");
    }

    public void loadStudentsView(){
        loadView("students.fxml");
    }

    public void loadProfessorsView(){
        loadView("professors.fxml");
    }

    public void loadPlansView(){
        loadView("plans.fxml");
    }

    public void loadFinancesView(){
        loadView("finance.fxml");
    }

    public void loadWarningsView(){
        loadView("warnings.fxml");
    }

    public void loadRelatoryView(){
        loadView("relatory.fxml");
    }


}
package poowyden.poowyden;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.util.Objects;

import javafx.fxml.FXMLLoader;

public class DashboardController{

    public void setupInitialView(){
        if(initialView != null){
            System.out.println("Carregando visao inicial: " + initialView);
            loadView(initialView);
        }else{
            System.out.println("Carregando visao padrao: home.fxml");
            loadHomeView();
        }
    }

    @FXML
    private VBox homeViewContainer; //Conteiner onde o FXML da tela selecionada no Dashboard será carregada

    @FXML
    private String initialView; //Valor padrão para inicialização
    public void setInitialView(String view){
        this.initialView = view; //Define a visão inicial com base no parâmetro recebido
        System.out.println("Visao Inicial definida: " + view);
    }

    @FXML
    public void initialize(){
        System.out.println("Método initialize chamado.");
    }

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

    public void loadPlansView() {
        try {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("plans.fxml")));
            Node node = loader.load();

            // Obtém o controlador do plans.fxml e passa o DashboardController para ele
            PlansController planosController = loader.getController();
            planosController.setDashboardController(this);

            // Limpa o conteúdo atual e carrega o novo conteúdo no VBox
            homeViewContainer.getChildren().clear();
            homeViewContainer.getChildren().add(node);
        } catch (IOException e) {
            System.err.println("Erro ao carregar o arquivo plans.fxml");
            e.printStackTrace();
        }
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
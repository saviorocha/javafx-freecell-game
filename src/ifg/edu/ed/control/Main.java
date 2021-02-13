/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifg.edu.ed.control;

import javafx.scene.text.Font;
import java.io.File;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Classe principal. Cria a scene da tela de início, loading e do jogo e mostra
 * ela ao jogador
 *
 * @author Savio
 */
public class Main extends Application {

//    private Stage stage;
    private static Stage stageR;

    /**
     *
     * @return Stage - stage do javafx, usado para mostrar a tela
     */
    public static Stage getPrimaryStage() {
        return stageR;
    }

    /**
     *
     * @param stageR
     */
    private void setPrimaryStage(Stage stageR) {
        Main.stageR = stageR;
    }
    private Scene sceneInicial;
    private Scene sceneLoading;
    private Scene sceneJogo;
    private Box carta3D;
    private ObservableList listInicio;
    private ObservableList listLoading;

    /**
     * Método start da classe Application. Configura a tela inicial e a tela de
     * loading
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        setPrimaryStage(primaryStage);
//        stage = primaryStage;
        AnchorPane fxmlInicio = FXMLLoader.load(getClass().getResource("FXMLloading.fxml"));
        listInicio = fxmlInicio.getChildren();

        AnchorPane fxmlLoading = new AnchorPane();
        listLoading = fxmlLoading.getChildren();

        final Image bckgInicialImg = Misc.retornaImage("C:/Users/Savio/Documents/NetBeansProjects/FreeCellED/src/ifg/edu/ed/imgs/backgroundTelaInicial.png", 600, 450);

        BackgroundImage bckgTelaInicial = new BackgroundImage(bckgInicialImg,
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        fxmlInicio.setBackground(new Background(bckgTelaInicial));
        sceneInicial = new Scene(fxmlInicio, 600, 450);

        final Image bckgLoadingImg = Misc.retornaImage("C:/Users/Savio/Documents/NetBeansProjects/FreeCellED/src/ifg/edu/ed/imgs/background2.png", 600, 450);

        BackgroundImage bckgTelaLoading = new BackgroundImage(bckgLoadingImg,
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        fxmlLoading.setBackground(new Background(bckgTelaLoading));
        sceneLoading = new Scene(fxmlLoading, 600, 450);

//        FreeCellED freeCellED = new FreeCellED();
        carta3D = Misc.cartaShape(sceneLoading);
        Label lblLoading = new Label("Carregando...");
        lblLoading.setTranslateX(carta3D.getTranslateX() - 80);
        lblLoading.setTranslateY(carta3D.getTranslateY() + 50);
        lblLoading.setTextFill(Color.GREENYELLOW);
        lblLoading.setFont(new Font("Berlin Sans FB Demi", 30));
        listLoading.add(lblLoading);
        listLoading.add(carta3D);

        Button btn = new Button("Iniciar jogo");
        btn.setStyle("-fx-border-color: #00AB00; -fx-background-color: #4CFF00; ");
        btn.setTranslateX(265);
        btn.setTranslateY(340);
        listInicio.add(btn);

        btn.addEventHandler(MouseEvent.MOUSE_CLICKED, mudaTelaHandler);
        stageR.setTitle("FreeCell IFG");
        stageR.setScene(sceneInicial);
        stageR.show();
    }

    private final EventHandler<MouseEvent> mudaTelaHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            Timeline timeline2 = new Timeline(new KeyFrame(
                    Duration.millis(2500),
                    ae -> {
                        try {
                            telaJogo();
                        } catch (Exception ex) {
                            System.out.println("catch");
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
            ));
            timeline2.play();

            stageR.setResizable(false);
            carta3D.setOpacity(100);
            stageR.setTitle("FreeCell IFG");
            stageR.setScene(sceneLoading);
            stageR.show();
        }
    };

    /**
     * Atualiza o stage para mostrar a tela do jogo. Utiliza a Scene retornada
     * pelo método jogo() da classe FreeCellED
     *
     * @throws Exception
     */
    public void telaJogo() throws Exception {
        FreeCellED freeCellED = new FreeCellED();
        sceneJogo = freeCellED.jogo();
        System.out.println("telaJogo scene");
        stageR.setTitle("FreeCell IFG");
        stageR.setResizable(false);
        stageR.setScene(sceneJogo);
        stageR.show();
    }

    /**
     * Metódo main
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
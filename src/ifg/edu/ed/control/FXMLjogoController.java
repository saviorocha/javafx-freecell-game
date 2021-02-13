/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifg.edu.ed.control;

import ifg.edu.ed.model.Carta;
import ifg.edu.ed.model.PilhaCorrente;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author Savio
 */
public class FXMLjogoController implements Initializable {

    @FXML
    private Rectangle corr3;

    @FXML
    private Rectangle corr2;

    @FXML
    private Rectangle corr1;

    @FXML
    private Rectangle fin4;

    @FXML
    private Rectangle fin3;

    @FXML
    private Rectangle fin2;

    @FXML
    private Rectangle fin1;

    @FXML
    private Rectangle corr8;

    @FXML
    private Rectangle corr7;

    @FXML
    private Rectangle temp2;

    @FXML
    private Rectangle corr6;

    @FXML
    private Rectangle temp3;

    @FXML
    private Rectangle corr5;

    @FXML
    private Rectangle corr4;

    @FXML
    private Rectangle temp1;

    @FXML
    private Rectangle temp4;

    @FXML
    private Rectangle emptyRect1;

    @FXML
    private Rectangle emptyRect2;

    @FXML
    private Rectangle emptyRect3;

    @FXML
    private Rectangle emptyRect4;

    @FXML
    private Button reiniciarBtn;

    /**
     * Responsável por reiniciar o jogo quando clicado no botão "reiniciar". 
     * Para isso chama o método telaJogo de Main
     * @param event
     * @throws Exception
     */
    @FXML
    void reiniciarEvt(ActionEvent event) throws Exception {
        Main main1 = new Main();
        main1.telaJogo();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}

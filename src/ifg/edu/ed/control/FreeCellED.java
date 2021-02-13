/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifg.edu.ed.control;

import ifg.edu.ed.model.Carta;
import ifg.edu.ed.model.Pilha;
import ifg.edu.ed.model.PilhaCorrente;
import ifg.edu.ed.model.PilhaFinal;
import ifg.edu.ed.model.PilhaTemporaria;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Classe que controla a interface da tela durante o jogo
 *
 * @author Savio
 */
public class FreeCellED {

//    private Scene sceneLoading;
    private Scene sceneJogo;
    private AnchorPane fxmlJogo;

    private int count = 0;
    private int distY;
    private boolean isPressed;
    private Carta primeiraCarta;
    private Pilha primeiraPilha;
    private ImageView imgVSelecionada;
    private ObservableList listFreeCell;

    private List<Rectangle> listRect;
    private List<PilhaCorrente> pilhasC;
    private List<PilhaFinal> pilhasF;
    private List<PilhaTemporaria> pilhasT;
    private List<List> listaPilhas;
    private List<Carta> listaCartas;

    /**
     *
     * @return List - lista de retângulos da scene, que são usados para
     * representar de forma gráfica as pilhas
     */
    public List<Rectangle> getListRect() {
        return listRect;
    }

    /**
     *
     * @param listRect
     */
    public void setListRect(List<Rectangle> listRect) {
        this.listRect = listRect;
    }

    /**
     * Usa os métodos e atributos da classe IniciaJogo e elementos do arquivo
     * FXMLjogo.fxml para criar a tela do jogo
     *
     * @return Scene - scene da tela de jogo
     * @throws Exception
     */
    public Scene jogo() throws Exception {
        fxmlJogo = FXMLLoader.load(getClass().getResource("FXMLjogo.fxml"));

        listFreeCell = fxmlJogo.getChildren();
        System.out.println(fxmlJogo.toString());
        setListRect(new ArrayList<>(Arrays.asList((Rectangle) listFreeCell.get(3), (Rectangle) listFreeCell.get(2), (Rectangle) listFreeCell.get(1), (Rectangle) listFreeCell.get(0),
                (Rectangle) listFreeCell.get(7), (Rectangle) listFreeCell.get(6), (Rectangle) listFreeCell.get(5), (Rectangle) listFreeCell.get(4),
                (Rectangle) listFreeCell.get(8), (Rectangle) listFreeCell.get(9), (Rectangle) listFreeCell.get(10), (Rectangle) listFreeCell.get(11),
                (Rectangle) listFreeCell.get(12), (Rectangle) listFreeCell.get(13), (Rectangle) listFreeCell.get(14), (Rectangle) listFreeCell.get(15))));

        IniciaJogo ic = new IniciaJogo();
        List<ImageView> listaView = ic.begin(getListRect());

        listaCartas = ic.getListaCartas2();
        pilhasC = ic.getPilhasC();
        pilhasF = ic.getPilhasF();
        pilhasT = ic.getPilhasT();
        listaPilhas = ic.getPilhasLista();

        distY = ic.distY;

        for (int i = 0; i < listRect.size(); i++) {
            if (i < 8) {
                pilhasC.get(i).setPilhaRect(listRect.get(i));
            } else if (i >= 12 && i < 16) {
                pilhasT.get(i - 12).setPilhaRect(listRect.get(i));
            }
        }
        
        pilhasF.get(0).setPilhaRect((Rectangle) listFreeCell.get(20));
        pilhasF.get(1).setPilhaRect((Rectangle) listFreeCell.get(21));
        pilhasF.get(2).setPilhaRect((Rectangle) listFreeCell.get(22));
        pilhasF.get(3).setPilhaRect((Rectangle) listFreeCell.get(23));

        final Image bckgImg = Misc.retornaImage("C:/Users/Savio/Documents/NetBeansProjects/FreeCellED/src/ifg/edu/ed/imgs/backgroundJogo.png", 1920, 1080);
        BackgroundImage myBI = new BackgroundImage(bckgImg,
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        fxmlJogo.setBackground(new Background(myBI));

        isPressed = false;

        listaView.stream().map((v) -> {
            v.addEventHandler(MouseEvent.MOUSE_CLICKED, imgViewHandler);
            return v;
        }).forEachOrdered((v) -> {
            listFreeCell.add(v);
        });
        listRect.forEach((r) -> {
            r.addEventHandler(MouseEvent.MOUSE_CLICKED, rectHandler);
        });

        for (int i = 20; i < 24; i++) {
            Rectangle rectAux = (Rectangle) listFreeCell.get(i);
            rectAux.addEventHandler(MouseEvent.MOUSE_CLICKED, rectHandler);
        }

        sceneJogo = new Scene(fxmlJogo);

        return sceneJogo;
    }

    //eventHandler para o clique em um retangulo (pilha vazia)
    private final EventHandler<MouseEvent> rectHandler = (MouseEvent mouseEvt) -> {
        Rectangle rectH = (Rectangle) mouseEvt.getSource();
        Carta cartaAtual;
        int posLista = -1;
        for (int i = 0; i < 24; i++) {
            if (rectH.equals(listFreeCell.get(i))) {
                posLista = i;
            }
        }

        Pilha pilhaRect = Misc.retornaPilha(posLista, rectH, listaPilhas);

        if (isPressed) {
            cartaAtual = primeiraCarta;
            if (pilhaRect.add(cartaAtual)) {
                cartaAtual.setPilhaPosicao(pilhaRect.getPilhaPosicao());
                primeiraPilha.remove();
                cartaAtual.setPosicaoY((pilhaRect.getSize() - 1) * distY);

                fxmlJogo.getChildren().remove(imgVSelecionada);
                Misc.mudaCartaDePilha(cartaAtual, rectH, imgVSelecionada, false);
                fxmlJogo.getChildren().add(imgVSelecionada);

                isPressed = false;
                count--;
            } else {
                selectedImage(-5, -5, 0, 0);
                count--;
                isPressed = false;
            }
        }
    };

    //eventHandler para o clique em uma ImageView
    private final EventHandler<MouseEvent> imgViewHandler = (MouseEvent mouseEvt) -> {
//        FXMLjogoController Misc = new FXMLjogoController();
        if (mouseEvt.getButton().equals(MouseButton.PRIMARY)) {
            ImageView imgVPilha = (ImageView) mouseEvt.getSource();
            imgVPilha.setPreserveRatio(true);

            Carta cartaAtual = Misc.view_carta((ImageView) mouseEvt.getSource(), listaCartas);
            Pilha pilhaAtual = Misc.retornaPilha(cartaAtual.getTipoPilha(), cartaAtual, listaPilhas);

            if (!isPressed && count == 0) {//carta que foi selecionada
                primeiraCarta = cartaAtual;
                primeiraPilha = pilhaAtual;
                imgVSelecionada = imgVPilha;
//                    if(primeiraCarta.getTipoPilha().equals("PilhaTemporaria")){
//                        contador++;
//                    }
                if (primeiraCarta == pilhaAtual.getLast()) {
                    selectedImage(5, 5, 100, 100);
                    isPressed = true;
                    count++;
                }
            } else {//pilha na qual colocará a carta
                if (cartaAtual == pilhaAtual.getLast()) {//if para ver se a carta selecionada é a última da pilha
                    System.out.println("else");
                    switch (cartaAtual.getTipoPilha()) {
                        case "PilhaCorrente":

                            if (pilhaAtual.add(primeiraCarta)) {
//                                    contador--;
                                primeiraPilha.remove();
                                primeiraCarta.setPosicaoY((pilhaAtual.getSize() - 1) * distY);

                                fxmlJogo.getChildren().remove(imgVSelecionada);
                                Misc.mudaCartaDePilha(primeiraCarta, pilhaAtual.getPilhaRect(), imgVSelecionada, true);
                                fxmlJogo.getChildren().add(imgVSelecionada);
                            } else if (count == 1) {
                                selectedImage(-5, -5, 0, 0);
                                isPressed = false;
                            }
                            count--;
                            break;
                            
                        case "PilhaFinal":
                            if (pilhaAtual.add(primeiraCarta)) {
                                primeiraPilha.remove();
                                primeiraCarta.setPosicaoY((pilhaAtual.getSize() - 1) * distY);

                                fxmlJogo.getChildren().remove((imgVSelecionada));
                                Misc.mudaCartaDePilha(primeiraCarta, pilhaAtual.getPilhaRect(), imgVSelecionada, false);
                                fxmlJogo.getChildren().add((imgVSelecionada));
                            } else {
                                selectedImage(-5, -5, 0, 0);
                                isPressed = false;
                            }
                            count--;
                            break;
                            
                        case "PilhaTemporaria":
                            selectedImage(-5, -5, 0, 0);
                            count--;
                            isPressed = false;
                            break;
                        default:
                            System.err.println("deu um erro ae(2º switch case; eventHandler; FreeCellED))");
                    }
                    isPressed = false;
                }
            }
        }
    };

    /**
     * Redimensiona a ImageView quando um jogador seleciona a carta
     *
     * @param offY
     * @param offX
     * @param fitH
     * @param fitW
     */
    public void selectedImage(int offY, int offX, int fitH, int fitW) {
        imgVSelecionada.setLayoutY(imgVSelecionada.getLayoutY() + offY);
        imgVSelecionada.setLayoutX(imgVSelecionada.getLayoutX() + offX);
        imgVSelecionada.setFitHeight(fitH);
        imgVSelecionada.setFitWidth(fitW);
    }
}

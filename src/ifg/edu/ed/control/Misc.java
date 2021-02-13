/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifg.edu.ed.control;

import ifg.edu.ed.model.*;
import java.io.File;
import java.net.MalformedURLException;
import java.util.List;
import javafx.animation.RotateTransition;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 * Classe de métodos variados que são usados por diversas classes
 *
 * @author Savio
 */
public class Misc {

    /**
     * Método que recebe um objeto ImageView de uma carta e retorna o objeto
     * Carta correspondente
     *
     * @param imgView
     * @param listaCartas
     * @return carta
     */
    public static Carta view_carta(ImageView imgView, List<Carta> listaCartas) {
        Carta carta = null;
        Image imagem = imgView.getImage();
        String url = imagem instanceof LocatedImage
                ? ((LocatedImage) imagem).getURL()
                : null;

        for (int i = 0; i < listaCartas.size(); i++) {
            if (url.equals("file:/" + listaCartas.get(i).getImgPath())) {
                carta = listaCartas.get(i);
            }
        }
        return carta;
    }

    /**
     * Retorna a pilha correspondente ao rectangulo clicado no eventHandler. Para
     * isso usa-se o método rect_pilha
     *
     * @param posLista
     * @param rectH
     * @param listaPilhas lista com as listas de pilhas
     * @return Pilha
     */
    public static Pilha retornaPilha(int posLista, Rectangle rectH, List<List> listaPilhas) {

        if (posLista >= 0 && posLista < 8) {//pilha temporaria
            return rect_pilha(rectH, listaPilhas.get(0));
        } else if (posLista >= 20 && posLista < 24) {//pilha final
            return rect_pilha(rectH, listaPilhas.get(1));
        } else if (posLista >= 12 && posLista < 16) {//pilha corrente
            return rect_pilha(rectH, listaPilhas.get(2));
        } else {
            System.err.println("deu um erro ae; if-else; FreeCellED; rectHandler");
        }
        return null;
    }

    /**
     * Procura na lista uma pilha com o atributo pilhaRect igual ao rectangulo
     * passado
     *
     * @param <T> tipo genérico que estende de Pilha
     * @param rect retangulo clicado
     * @param listaPilhasG lista de um tipo genérico de pilha, podendo ser
     * temporaria, corrente ou final
     * @return Pilha - pilha correspondente ao retangulo clicado
     */
    public static <T extends Pilha> Pilha rect_pilha(Rectangle rect, List<T> listaPilhasG) {
        for (int i = 0; i < listaPilhasG.size(); i++) {
            if (listaPilhasG.get(i).getPilhaRect().equals(rect)) {
                return listaPilhasG.get(i);
            }
        }
        return null;
    }

    /**
     * Retorna a pilha correspondente à ImageView da carta clicada no
     * eventHandler Para isso usa-se o método carta_pilha
     *
     * @param tipoPilha tipo da pilha clicada (corrente, temporaria, final)
     * @param cartaAtual carta clicada
     * @param listaPilhas lista com as listas de pilhas
     * @return Pilha
     */
    public static Pilha retornaPilha(String tipoPilha, Carta cartaAtual, List<List> listaPilhas) {
        switch (tipoPilha) {
            case "PilhaCorrente":
                return carta_pilha(cartaAtual, listaPilhas.get(0));
            case "PilhaFinal":
                return carta_pilha(cartaAtual, listaPilhas.get(1));
            case "PilhaTemporaria":
                return carta_pilha(cartaAtual, listaPilhas.get(2));
            default:
                System.err.println("deu um erro ae; retornaPilha 2; ponte");
                return null;    
        }
    }

    /**
     * Procura na lista de pilhas a carta passada, para retornar a pilha dessa
     * carta Para isso, usa-se o atributo pilhaPosicao da classe Carta
     *
     * @param <T> tipo genérico que estende de pilha
     * @param carta carta clicada
     * @param listaPilhasG lista de um tipo genérico de pilha, podendo ser
     * temporaria, corrente ou final
     * @return Pilha
     */
    public static <T extends Pilha> Pilha carta_pilha(Carta carta, List<T> listaPilhasG) {
        return listaPilhasG.get(carta.getPilhaPosicao());
    }

    /**
     * Usa a classe Box para cirar e retornar uma carta tridimensional exibida
     * na tela de loading
     *
     * @param scene
     * @return Box - carta tridimensional
     * @throws Exception
     */
    public static Box cartaShape(Scene scene) throws Exception {
        Box box = new Box();

        box.setWidth(50.0);
        box.setHeight(80.0);
        box.setDepth(5.0);

        box.setTranslateX(265);
        box.setTranslateY(200);
        box.setTranslateZ(50);
        
        //--------Image-----------
        File fileCard = new File("C:/Users/Savio/Documents/NetBeansProjects/FreeCellED/src/ifg/edu/ed/imgs/EA.png");
        String localCardUrl = fileCard.toURI().toURL().toString();
        final Image cartaShapeImg = new Image(localCardUrl, 1920, 1080, true, true);

        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(cartaShapeImg);

        box.setMaterial(material);

        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.millis(1000));
        rotateTransition.setNode(box);
        rotateTransition.setAxis(Rotate.Y_AXIS);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(50);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();

        PerspectiveCamera camera = new PerspectiveCamera(false);
        camera.setTranslateX(0);
        camera.setTranslateY(0);
        camera.setTranslateZ(0);
        scene.setCamera(camera);

        return box;
    }

    /**
     * Retorna um objeto Image a partir da url
     *
     * @param url caminho da imagem
     * @param widht largura
     * @param height altura
     * @return Image - objeto Image com a imagem da carta na pasta imgs
     * @throws MalformedURLException
     */
    public static Image retornaImage(String url, int widht, int height) throws MalformedURLException {
        File file = new File(url);
        String fileUrl = file.toURI().toURL().toString();
        return new Image(fileUrl, widht, height, true, true);
    }

    /**
     * Cria a ImageView correspondente à carta e define sua posição a partir do
     * retangulo da sua pilha
     *
     * @param carta carta usada para criar o ImageView
     * @param pilhaC pilha no qual a carta se encontra
     * @param j inteiro usado para auxiliar a encontrar o retangulo em listRect
     * @param listRect lista com os retangulos da tela
     * @return ImageView - a ImageView da carta passada
     * @throws MalformedURLException
     */
    public static ImageView setaCartas(Carta carta, PilhaCorrente pilhaC, int j, List<Rectangle> listRect) throws MalformedURLException {
        File file = new File(carta.getImgPath());
        Rectangle rect = listRect.get(j);
        String localUrl = file.toURI().toURL().toString();
        Image img = new LocatedImage(localUrl, rect.getWidth(), rect.getHeight(), true, true, true);
        ImageView imagem = new ImageView(img);

        imagem.setX(rect.getLayoutX());
        imagem.setY(rect.getLayoutY() + (carta.getPosicaoY()));
        imagem.setImage(img);
        return imagem;
    }

    /**
     * Método usado para trocar a carta de pilha, baseado na posicao do
     * retangulo da pilha que se deseja adicionar
     *
     * @param carta
     * @param rect Retangulo correspondente da pilha, usado para calcular a
     * posicao do ImageView
     * @param imgV ImageView
     * @param offset se precisa ou não dar um "espaço" entre as cartas na pilha
     */
    public static void mudaCartaDePilha(Carta carta, Rectangle rect, ImageView imgV, boolean offset) {
        imgV.setX(rect.getLayoutX() - 5);
        if (!offset) {
            imgV.setY(rect.getLayoutY());
        } else {
            imgV.setY(rect.getLayoutY() + (carta.getPosicaoY()));
        }

        imgV.setLayoutX(imgV.getLayoutX() / 2);
        imgV.setLayoutY(imgV.getLayoutY() / 2);
        imgV.setSmooth(true);

        imgV.setFitHeight(0);
        imgV.setFitWidth(0);
    }
}
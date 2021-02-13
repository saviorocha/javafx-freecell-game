/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifg.edu.ed.control;

import ifg.edu.ed.model.Carta;

import ifg.edu.ed.model.CartaEnum;
import ifg.edu.ed.model.PilhaFinal;
import ifg.edu.ed.model.PilhaCorrente;
import ifg.edu.ed.model.PilhaTemporaria;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

/**
 * Classe que instancia os Objetos do tipo Carta, PilhaCorrente, PilhaFinal, PilhaTemporaria.
 * Além disso, ela adiciona as cartas nas pilhas e cria uma lista com as ImageViews de cada carta
 * @author Savio
 */
public class IniciaJogo {

    /**
     *
     * @return PilhaFinal - pilha w
     */
    public PilhaFinal getW() {
        return W;
    }

    /**
     *
     * @param W
     */
    public void setW(PilhaFinal W) {
        this.W = W;
    }

    /**
     *
     * @return PilhaFinal - pilha x
     */
    public PilhaFinal getX() {
        return X;
    }

    /**
     *
     * @param X
     */
    public void setX(PilhaFinal X) {
        this.X = X;
    }

    /**
     *
     * @return PilhaFinal - pilha y
     */
    public PilhaFinal getY() {
        return Y;
    }

    /**
     *
     * @param Y
     */
    public void setY(PilhaFinal Y) {
        this.Y = Y;
    }

    /**
     *
     * @return PilhaFinal - pilha z
     */
    public PilhaFinal getZ() {
        return Z;
    }

    /**
     *
     * @param Z
     */
    public void setZ(PilhaFinal Z) {
        this.Z = Z;
    }

    /**
     *
     * @return PilhaTemporaria - pilha 0
     */
    public PilhaTemporaria getA0() {
        return a0;
    }

    /**
     *
     * @param a0
     */
    public void setA0(PilhaTemporaria a0) {
        this.a0 = a0;
    }

    /**
     *
     * @return PilhaTemporaria - pilha 1
     */
    public PilhaTemporaria getA1() {
        return a1;
    }

    /**
     *
     * @param a1
     */
    public void setA1(PilhaTemporaria a1) {
        this.a1 = a1;
    }

    /**
     *
     * @return PilhaTemporaria - pilha 2
     */
    public PilhaTemporaria getA2() {
        return a2;
    }

    /**
     *
     * @param a2
     */
    public void setA2(PilhaTemporaria a2) {
        this.a2 = a2;
    }

    /**
     *
     * @return PilhaTemporaria - pilha 3
     */
    public PilhaTemporaria getA3() {
        return a3;
    }

    /**
     *
     * @param a3
     */
    public void setA3(PilhaTemporaria a3) {
        this.a3 = a3;
    }

    /**
     *
     * @return PilhaCorrente - pilha A
     */
    public PilhaCorrente getA() {
        return A;
    }

    /**
     *
     * @param A
     */
    public void setA(PilhaCorrente A) {
        this.A = A;
    }

    /**
     *
     * @return PilhaCorrente - pilha B
     */
    public PilhaCorrente getB() {
        return B;
    }

    /**
     *
     * @param B
     */
    public void setB(PilhaCorrente B) {
        this.B = B;
    }

    /**
     *
     * @return PilhaCorrente - pilhaC
     */
    public PilhaCorrente getC() {
        return C;
    }

    /**
     *
     * @param C
     */
    public void setC(PilhaCorrente C) {
        this.C = C;
    }

    /**
     *
     * @return PilhaCorrente - pilha D
     */
    public PilhaCorrente getD() {
        return D;
    }

    /**
     *
     * @param D
     */
    public void setD(PilhaCorrente D) {
        this.D = D;
    }

    /**
     *
     * @return PilhaCorrente - pilha E
     */
    public PilhaCorrente getE() {
        return E;
    }

    /**
     *
     * @param E
     */
    public void setE(PilhaCorrente E) {
        this.E = E;
    }

    /**
     *
     * @return PilhaCorrente - pilha F
     */
    public PilhaCorrente getF() {
        return F;
    }

    /**
     *
     * @param F
     */

    public void setF(PilhaCorrente F) {
        this.F = F;
    }

    /**
     *
     * @return PilhaCorrente - pilha G
     */
    public PilhaCorrente getG() {
        return G;
    }

    /**
     *
     * @param G
     */
    public void setG(PilhaCorrente G) {
        this.G = G;
    }

    /**
     *
     * @return PilhaCorrente - pilha H
     */
    public PilhaCorrente getH() {
        return H;
    }

    /**
     *
     * @param H
     */
    public void setH(PilhaCorrente H) {
        this.H = H;
    }

    /**
     *
     * @return List - lista com todas as pilhas correntes
     */
    public List<PilhaCorrente> getPilhasC() {
        return pilhasC;
    }

    /**
     *
     * @param pilhasC
     */
    public void setPilhasC(List<PilhaCorrente> pilhasC) {
        this.pilhasC = pilhasC;
    }

    /**
     *
     * @return List - lista com todas as pilhas finais 
     */
    public List<PilhaFinal> getPilhasF() {
        return pilhasF;
    }

    /**
     *
     * @param pilhasF
     */
    public void setPilhasF(List<PilhaFinal> pilhasF) {
        this.pilhasF = pilhasF;
    }

    /**
     *
     * @return List - lista com todas as pilhas temporarias
     */
    public List<PilhaTemporaria> getPilhasT() {
        return pilhasT;
    }

    /**
     *
     * @param pilhasT
     */
    public void setPilhasT(List<PilhaTemporaria> pilhasT) {
        this.pilhasT = pilhasT;
    }

    /**
     *
     * @return List - lista com todas as listas de pilhas
     */
    public List<List> getPilhasLista() {
        return pilhasLista;
    }

    /**
     *
     * @param pilhasLista
     */
    public void setPilhasLista(List<List> pilhasLista) {
        this.pilhasLista = pilhasLista;
    }

    /**
     *
     * @return List - lista de cartas, usada para adicionar de forma aleatória nas pilhas correntes
     */
    public List<Carta> getListaCartas() {
        return listaCartas;
    }

    /**
     *
     * @param listaCartas
     */
    public void setListaCartas(List<Carta> listaCartas) {
        this.listaCartas = listaCartas;
    }

    /**
     *
     * @return List - lista de cartas, usada na classe FreeCellED 
     */
    public List<Carta> getListaCartas2() {
        return listaCartas2;
    }

    /**
     *
     * @param listaCartas2
     */
    public void setListaCartas2(List<Carta> listaCartas2) {
        this.listaCartas2 = listaCartas2;
    }

    private PilhaFinal W = new PilhaFinal(0, "copas");
    private PilhaFinal X = new PilhaFinal(1, "paus");
    private PilhaFinal Y = new PilhaFinal(2, "ouro");
    private PilhaFinal Z = new PilhaFinal(3, "espada");

    private PilhaTemporaria a0 = new PilhaTemporaria(0);
    private PilhaTemporaria a1 = new PilhaTemporaria(1);
    private PilhaTemporaria a2 = new PilhaTemporaria(2);
    private PilhaTemporaria a3 = new PilhaTemporaria(3);

    private PilhaCorrente A = new PilhaCorrente(0);
    private PilhaCorrente B = new PilhaCorrente(1);
    private PilhaCorrente C = new PilhaCorrente(2);
    private PilhaCorrente D = new PilhaCorrente(3);
    private PilhaCorrente E = new PilhaCorrente(4);
    private PilhaCorrente F = new PilhaCorrente(5);
    private PilhaCorrente G = new PilhaCorrente(6);
    private PilhaCorrente H = new PilhaCorrente(7);

    private List<PilhaCorrente> pilhasC = new ArrayList<>(Arrays.asList(A, B, C, D, E, F, G, H));
    private List<PilhaFinal> pilhasF = new ArrayList<>(Arrays.asList(W, X, Y, Z));
    private List<PilhaTemporaria> pilhasT = new ArrayList<>(Arrays.asList(a0, a1, a2, a3));
    private List<List> pilhasLista = new ArrayList(Arrays.asList(pilhasC, pilhasF, pilhasT));

    private List<Carta> listaCartas = new ArrayList<>();
    private List<Carta> listaCartas2 = new ArrayList<>();

    final int distY = 31;

    /**
     * Cria listas com os naipes e valores de cartas e uma matriz com os nomes das cartas na pasta,
     * que serão usados para a criação das cartas pelo método criaCartas. 
     * Retorna uma lista de ImageViews criada pelo método retornaListaView
     *
     * @param listRect
     * @return List
     */
    public List<ImageView> begin(List<Rectangle> listRect) {

        String[] arr1 = {"EA", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9", "E10", "EJ", "EQ", "EK"};
        String[] arr2 = {"OA", "O2", "O3", "O4", "O5", "O6", "O7", "O8", "O9", "O10", "OJ", "OQ", "OK"};
        String[] arr3 = {"CA", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "CJ", "CQ", "CK"};
        String[] arr4 = {"PA", "P2", "P3", "P4", "P5", "P6", "P7", "P8", "P9", "P10", "PJ", "PQ", "PK"};

        String[][] cartasImg = {arr1, arr2, arr3, arr4};

        List<String> cartasNaipe = new ArrayList<>(Arrays.asList("espada", "ouro", "copas", "paus"));
        List<CartaEnum> cartasValores = new ArrayList<>(Arrays.asList(CartaEnum.A, CartaEnum.C2, CartaEnum.C3, CartaEnum.C4, CartaEnum.C5,
                CartaEnum.C6, CartaEnum.C7, CartaEnum.C8, CartaEnum.C9, CartaEnum.C10, CartaEnum.J, CartaEnum.Q, CartaEnum.K));

        criaCartas(cartasNaipe, cartasValores, cartasImg);
        return retornaListaView(listRect);
    }

    /**
     * Metódo responsável por instanciar as 52 cartas e adicioná-las a lista listaCartas
     *
     * @param cartasNaipe
     * @param cartasValores
     * @param cartasImg
     */
    public void criaCartas(List<String> cartasNaipe, List<CartaEnum> cartasValores, String[][] cartasImg) {
        //--------Image-----------
        for (int i = 0; i < cartasNaipe.size(); i++) {
            for (int j = 0; j < cartasValores.size(); j++) {
                String imgPath = "C:/Users/Savio/Documents/NetBeansProjects/FreeCellED/src/ifg/edu/ed/imgs/" + cartasImg[i][j] + ".png";
                listaCartas.add(new Carta(cartasNaipe.get(i), cartasValores.get(j), imgPath));
            }
        }
    }

    /**
     * Usa a lista listaCartas para adicionar as cartas de forma aleatória nas
     * pilhas A..H
     *
     * @param listRect
     * @return List
     */
    public List<ImageView> retornaListaView(List<Rectangle> listRect) {
        Random gerador = new Random();
        List<ImageView> listaView = new ArrayList<>();
        listaCartas.forEach((c) -> {
            listaCartas2.add(c);
        });
//        int count = 0;
        try {
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 8; j++) {
                    int randCarta = gerador.nextInt(listaCartas.size());
                    Carta auxCarta = listaCartas.get(randCarta);
//                    addPilha(pilhasC.get(j), auxCarta);
                    pilhasC.get(j).addInicio(auxCarta);
                    pilhasC.get(j).setLast();
                    auxCarta.setPosicaoY(i * distY);//precisa desse valor pra colocar uma carta em baixo da outra
                    auxCarta.setPilhaPosicao(pilhasC.get(j).getPilhaPosicao());
                    auxCarta.setTipoPilha(pilhasC.get(j).getClass().getSimpleName());
                    listaView.add(Misc.setaCartas(auxCarta, pilhasC.get(j), j, listRect)); //mandar essa lista pra classe FreeCellED, para adicionar as imagens
                    listaCartas.remove(randCarta);

                    if (i == 6 && j == 3) {
                        break;
                    }
                }
            }
        } catch (MalformedURLException e) {
            //exception
        }
        return listaView;
    }
}
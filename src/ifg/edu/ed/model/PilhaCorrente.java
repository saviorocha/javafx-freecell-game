/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifg.edu.ed.model;

import java.util.Comparator;
import java.util.Stack;
import javafx.scene.control.Label;
import ifg.edu.ed.model.CardComparator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Classe que implementa uma pilha corrente; Estende da classe Pilha
 *
 * @author Savio
 */
public class PilhaCorrente extends Pilha {

    private List<CartaEnum> cartaValores = new ArrayList<>(Arrays.asList(CartaEnum.A, CartaEnum.C2, CartaEnum.C3, CartaEnum.C4, CartaEnum.C5,
            CartaEnum.C6, CartaEnum.C7, CartaEnum.C8, CartaEnum.C9, CartaEnum.C10,
            CartaEnum.J, CartaEnum.Q, CartaEnum.K));
    private CardComparator comparador = new CardComparator();
    private Stack<Carta> pilhaC = super.getPilha();
    private Carta last;
    private int size;

    /**
     *
     * @param pilhaPosicao
     */
    public PilhaCorrente(int pilhaPosicao) {
        super(pilhaPosicao);
    }

    /**
     *
     * @return Stack - objeto do tipo Stack da pilha
     */
    public Stack<Carta> getPilhaC() {
        return pilhaC;
    }

    /**
     *
     * @param pilhaC
     */
    public void setPilhaC(Stack<Carta> pilhaC) {
        this.pilhaC = pilhaC;
    }

    /**
     *
     * @return Carta - última carta da pilha
     */
    @Override
    public Carta getLast() {
        return last;
    }

    /**
     * Atualiza a última carta da pilha
     */
    @Override
    public void setLast() {
//        this.last = pilhaC.get(pilhaC.size() - 1);
        if (!pilhaC.isEmpty()) {
            this.last = pilhaC.lastElement();
        } else {
            this.last = null;
        }
    }

    /**
     * Adiciona a carta à pilha. Usa um comparador para verificar se a adição é válida baseada nas regras do jogo
     * @param carta
     * @return boolean - caso tenha sido possível adicionar a carta na pilha retorna true, retorna false caso contrário
     */
    @Override
    public boolean add(Carta carta) {
        boolean cond = false;
        Carta lastValue = pilhaC.lastElement();
        int index = Collections.binarySearch(cartaValores, lastValue.getValor());
        if (pilhaC.lastElement().getNaipe().equals("paus") || pilhaC.lastElement().getNaipe().equals("espada")) {
            if (carta.getNaipe().equals("copas") || carta.getNaipe().equals("ouro")) {
                if (comparador.compare(carta.getValor(), lastValue.getValor()) < 0 && comparador.compare(carta.getValor(), cartaValores.get(index - 1)) == 0) {
                    pilhaC.push(carta);
                    carta.setPilhaPosicao(this.getPilhaPosicao());
                    carta.setTipoPilha(this.getClass().getSimpleName());
                    setLast();
                    setSize();
                    cond = true;
                }
            }
        } else {
            if (carta.getNaipe().equals("paus") || carta.getNaipe().equals("espada")) {
                if (comparador.compare(carta.getValor(), lastValue.getValor()) < 0 && comparador.compare(carta.getValor(), cartaValores.get(index - 1)) == 0) {
                    pilhaC.push(carta);
                    carta.setPilhaPosicao(this.getPilhaPosicao());
                    carta.setTipoPilha(this.getClass().getSimpleName());
                    setLast();
                    setSize();
                    cond = true;
                }
            }
        }
        return cond;
    }

    /**
     * Método usado no começo do jogo, para distribuir as cartas de forma aleatória
     * @param c
     */
    public void addInicio(Carta c) {
        this.size++;
        pilhaC.add(c);
    }

    /**
     * Atualiza o tamamho da pilha
     */
    @Override
    public void setSize() {
        this.size = pilhaC.size();
    }

    /**
     * @return int - tamanho da pilha
     */
    @Override
    public int getSize() {
        return this.size;
    }
}
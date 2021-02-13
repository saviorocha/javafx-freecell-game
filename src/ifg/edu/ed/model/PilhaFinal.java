/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifg.edu.ed.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Classe que implementa o método compare da classe Comparator<T>, usado para
 * comparar os valores das cartas
 *
 * @author Savio
 */
class CardComparator implements Comparator<CartaEnum> {

    @Override
    public int compare(CartaEnum v1, CartaEnum v2) {
        return v1.compareTo(v2);//v1 < v2 --> negativo
    }
}

/**
 * Classe que implementa uma pilha final; Estende da classe Pilha
 *
 * @author Savio
 */
public class PilhaFinal extends Pilha {

    private List<CartaEnum> cartaValores = new ArrayList<>(Arrays.asList(CartaEnum.A, CartaEnum.C2, CartaEnum.C3, CartaEnum.C4, CartaEnum.C5,
            CartaEnum.C6, CartaEnum.C7, CartaEnum.C8, CartaEnum.C9, CartaEnum.C10, CartaEnum.J, CartaEnum.Q, CartaEnum.K));
    private CardComparator comparador = new CardComparator();

    private Stack<Carta> pilhaF = super.getPilha();
    private String naipePilha;
    private Carta last;
    private int size;

    /**
     * Construtor
     *
     * @param pilhaPosicao
     * @param naipePilha
     */
    public PilhaFinal(int pilhaPosicao, String naipePilha) {
        super(pilhaPosicao);
        this.naipePilha = naipePilha;
    }

    /**
     *
     * @return int - tamanho da pilha
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Atualiza o tamanho da pilha
     */
    @Override
    public void setSize() {
        this.size = pilhaF.size();
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
     * Atualiza o último elemento da pilha
     */
    @Override
    public void setLast() {
        if (!pilhaF.isEmpty()) {
            this.last = pilhaF.lastElement();
        } else {
            this.last = null;
        }
    }

    /**
     * 
     * @return String - naipe da pilha
     */
    public String getNaipePilha() {
        return naipePilha;
    }

    /**
     *
     * @param naipePilha
     */
    public void setNaipePilha(String naipePilha) {
        this.naipePilha = naipePilha;
    }

    /**
     *
     * @return Stack - objeto Stack da pilha
     */
    public Stack<Carta> getPilhaF() {
        return pilhaF;
    }

    /**
     *
     * @param pilhaF
     */
    public void setPilhaF(Stack<Carta> pilhaF) {
        this.pilhaF = pilhaF;
    }

    /**
     * Adiciona a carta à pilha. Usa um comparador para verificar se a adição é válida baseada nas regras do jogo
     * @param carta
     * @return boolean - caso tenha sido possível adicionar a carta na pilha retorna true, retorna false caso contrário
     */
    @Override
    public boolean add(Carta carta) {
        boolean cond = false;
//        if (this.size == 0) {
        try {
            Carta lastValue = pilhaF.lastElement();
            int index = Collections.binarySearch(cartaValores, carta.getValor());
            if (carta.getNaipe().equals(this.getNaipePilha())) {
                if (carta.getNaipe().equals(lastValue.getNaipe())) {
                    if (comparador.compare(carta.getValor(), lastValue.getValor()) > 0 && comparador.compare(carta.getValor(), cartaValores.get(index + 1)) < 0) {
                        pilhaF.push(carta);
                        setLast();
                        setSize();
                        carta.setPilhaPosicao(this.getPilhaPosicao());
                        carta.setTipoPilha(this.getClass().getSimpleName());
                        cond = true;
                    }
                }

            }
        } catch (NoSuchElementException e) {
            if (carta.getNaipe().equals(this.naipePilha) && carta.getValor() == CartaEnum.A) {
                pilhaF.push(carta);
                setLast();
                setSize();
                carta.setPilhaPosicao(this.getPilhaPosicao());
                carta.setTipoPilha(this.getClass().getSimpleName());
                cond = true;
            }
        }
        return cond;
    }
}
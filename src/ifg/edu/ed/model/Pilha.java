/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifg.edu.ed.model;

import java.util.Stack;
import javafx.scene.shape.Rectangle;

/**
 * Classe que implementa um modelo de pilha. Usa a classe Stack
 *
 * @author Savio
 */
public class Pilha {

    private Stack<Carta> pilha = new Stack();
    private Carta last;
    private Rectangle pilhaRect;
    private int pilhaPosicao;
    private int size = 0;

    public Pilha(int pilhaPosicao) {
        this.pilhaPosicao = pilhaPosicao;
    }

    /**
     *
     * @return int - posição da pilha na lista de pilhas
     */
    public int getPilhaPosicao() {
        return pilhaPosicao;
    }

    /**
     *
     * @param pilhaPosicao
     */
    public void setPilhaPosicao(int pilhaPosicao) {
        this.pilhaPosicao = pilhaPosicao;
    }

    /**
     * Atualiza o tamanho da pilha
     */
    public void setSize() {
        this.size = pilha.size();
    }

    /**
     *
     * @return int - tamanho da pilha
     */
    public int getSize() {
        return this.size;
    }

    /**
     *
     * @return Rectangle - retangulo correspondente da pilha
     */
    public Rectangle getPilhaRect() {
        return pilhaRect;
    }

    /**
     *
     * @param pilhaRect
     */
    public void setPilhaRect(Rectangle pilhaRect) {
        this.pilhaRect = pilhaRect;
    }

    /**
     *
     * @return Carta - última carta da pilha
     */
    public Carta getLast() {
        return last;
    }

    /**
     * Atualiza a última carta da pilha
     */
    public void setLast() {
        if (!pilha.isEmpty()) {
            this.last = pilha.lastElement();
        } else {
            this.last = null;
        }
    }

    /**
     *
     * @return Stack - Objeto Stack da pilha
     */
    public Stack<Carta> getPilha() {
        return pilha;
    }

    /**
     *
     * @param pilha
     */
    public void setPilha(Stack<Carta> pilha) {
        this.pilha = pilha;
    }

    /**
     *
     * @param c
     * @return boolean - caso tenha sido possível adicionar a carta na pilha retorna true, retorna false caso contrário
     */
    public boolean add(Carta c) {
        pilha.push(c);
        setLast();
        setSize();
        return true;
    }

    /**
     * remove a carta da pilha
     */
    public void remove() {
        pilha.pop();
        setLast();
        setSize();
    }
}

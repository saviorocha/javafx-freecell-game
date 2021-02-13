/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifg.edu.ed.model;

import java.util.Stack;

/**
 * Classe que implementa uma pilha temporária; Estende da classe Pilha
 *
 * @author Savio
 */
public class PilhaTemporaria extends Pilha {

    private Stack<Carta> pilhaT = super.getPilha();
    private Carta last;

    /**
     * Construtor
     *
     * @param pilhaPosicao
     */
    public PilhaTemporaria(int pilhaPosicao) {
        super(pilhaPosicao);
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
     * Atualilza a útima carta da pilha
     */
    @Override
    public void setLast() {
        if (!pilhaT.isEmpty()) {
            this.last = pilhaT.lastElement();
        } else {
            this.last = null;
        }
    }

    /**
     *
     * @return Stack - objeto Stack da pilha
     */
    public Stack<Carta> getPilhaT() {
        return pilhaT;
    }

    /**
     *
     * @param pilhaT
     */
    public void setPilhaT(Stack<Carta> pilhaT) {
        this.pilhaT = pilhaT;
    }

    /**
     * Adiciona uma carta à pilha
     * @param carta
     * @return boolean - caso tenha sido possível adicionar a carta na pilha retorna true, retorna false caso contrário
     */
    @Override
    public boolean add(Carta carta) {
        if (pilhaT.isEmpty()) {
            pilhaT.push(carta);
            carta.setPilhaPosicao(this.getPilhaPosicao());
            carta.setTipoPilha(this.getClass().getSimpleName());
            setSize();
            setLast();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Remove a carta da pilha
     */
    @Override
    public void remove() {
        if (!pilhaT.isEmpty()) {
            pilhaT.pop();
            setSize();
        }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifg.edu.ed.model;

/**
 * Classe modelo para a implementação de uma carta
 *
 * @author Savio
 */
public class Carta {

    private String naipe, imgPath, tipoPilha;
    private CartaEnum valor;
    private int posicaoY;
    private int pilhaPosicao;

    /**
     * Construtor
     * @param naipe
     * @param valor
     * @param imgPath
     */
    public Carta(String naipe, CartaEnum valor, String imgPath) {
        this.naipe = naipe;
        this.valor = valor;
        this.imgPath = imgPath;
    }

    /**
     * 
     * @return int - posição da carta na lista de pilhas(em qual pilha ela esta)
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
     * 
     * @return int - posição Y da ImageView da carta
     */
    public int getPosicaoY() {
        return posicaoY;
    }

    /**
     *
     * @param posicaoY
     */
    public void setPosicaoY(int posicaoY) {
        this.posicaoY = posicaoY;
    }

    /**
     *
     * @return String - tipo de pilha no qual a carta está(Corrente, temporária, final)
     */
    public String getTipoPilha() {
        return tipoPilha;
    }

    /**
     *
     * @param tipoPilha
     */
    public void setTipoPilha(String tipoPilha) {
        this.tipoPilha = tipoPilha;
    }

    /**
     *
     * @return String - caminho da imagem da carta no pasta
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     *
     * @param imgPath
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    /**
     *
     * @return CartaEnum - valor da carta
     */
    public CartaEnum getValor() {
        return valor;
    }

    /**
     *
     * @param valor
     */
    public void setValor(CartaEnum valor) {
        this.valor = valor;
    }

    /**
     *
     * @return String - Naipe da carta
     */
    public String getNaipe() {
        return naipe;
    }

    /**
     *
     * @param naipe
     */
    public void setNaipe(String naipe) {
        this.naipe = naipe;
    }
}
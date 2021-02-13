/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifg.edu.ed.control;

import javafx.scene.image.Image;

/**
 * Classe usada para se obter o url de um objeto do tipo Image. Estende a classe
 * Image
 *
 * @author Savio
 */
public class LocatedImage extends Image {

    private final String url;

    /**
     * Construtor. Chama o construtor da super classe
     *
     * @param url
     * @param requestedWidth
     * @param requestedHeight
     * @param preserveRatio
     * @param smooth
     * @param backgroundLoading
     */
    public LocatedImage(String url, double requestedWidth, double requestedHeight, boolean preserveRatio, boolean smooth, boolean backgroundLoading) {
        super(url, requestedWidth, requestedHeight, preserveRatio, smooth);
        this.url = url;
    }

    /**
     *
     * @return String - caminho da imagem
     */
    public String getURL() {
        return url;
    }
}

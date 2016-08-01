/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.awt.image.BufferedImage;

/**
 *
 * @author David Pantaleón
 */
public class Imagen {
    private BufferedImage fotografia;
    private int alto;
    private int ancho;
    public Imagen(){}
    public Imagen(BufferedImage fot){
        fotografia=fot;
        alto=fot.getHeight();
        ancho=fot.getWidth();
    }
    public BufferedImage getFotografia(){return fotografia;}
    public int getAlto(){return alto;}
    public int getAncho(){return ancho;}
    public void setFotografia(BufferedImage fot){
        fotografia=fot;
    }
    public void setAlto(int alt){
        alto=alt;
    }
    public void setAncho(int anc){
        ancho=anc;
    }
}

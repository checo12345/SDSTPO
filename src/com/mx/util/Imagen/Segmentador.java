/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.util.Imagen;

/**
 *
 * @author David Pantaleón
 */
public class Segmentador {
    private Imagen img;
    public Segmentador(){}
    public Segmentador(Imagen image){
        img=image;
    }
    public Imagen getImagen(){return img;}
    public void setImagen(Imagen image){img=image;}
}

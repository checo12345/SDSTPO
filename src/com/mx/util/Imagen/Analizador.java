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
public class Analizador {
    private Imagen img;
    public Analizador(){}
    public Analizador(Imagen ima){
        img=ima;
    }
    public Imagen getImagen(){return img;}
    public void setImagen(Imagen ima){
        img=ima;
    }
}

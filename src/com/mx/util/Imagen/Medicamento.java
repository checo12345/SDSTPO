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
public class Medicamento {
    private String nombre;
    private String presentacion;
    private String dosis;
    public Medicamento(){
        nombre="default";
        presentacion="default";
        dosis="default";
    }
    public Medicamento(String nom,String pre,String dos){
        nombre=nom;
        presentacion=pre;
        dosis=dos;
    }
    public String getNombre(){
        return nombre;
    }
    public String getPresentacion(){
        return presentacion;
    }
    public String getDosis(){
        return dosis;
    }
    public void setNombre(String nom){
        nombre=nom;
    }
    public void setPresentacion(String pre){
        presentacion=pre;
    }
    public void setDosis(String dos){
        dosis=dos;
    }
}

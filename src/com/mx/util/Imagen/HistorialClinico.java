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
public class HistorialClinico {
    private String nombrePaciente;
    public HistorialClinico(){}
    public HistorialClinico(String nomPac){nombrePaciente=nomPac;}
    public String getNombrePaciente(){return nombrePaciente;}
    public void setNombrePaciente(String nomPac){nombrePaciente=nomPac;}
}

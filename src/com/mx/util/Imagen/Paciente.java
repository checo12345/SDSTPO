/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.util.Imagen;

import java.util.Date;

/**
 *
 * @author David Pantaleón
 */
public class Paciente {
    private Persona p;
    private String alergias;
    private String padecimientos;
    public Paciente(){}
    public Paciente(String nom,String apeP,String apeM,Date fecNac,int Tel,String dir,boolean sex,String aler,String padecimiento){
        p=new Persona(nom,apeP,apeM,fecNac,Tel,dir,sex){};
        alergias=aler;
        padecimientos=padecimiento;
    }
    public String getAlergias(){return alergias;}
    public String getPadecimientos(){return padecimientos;}
    public void setAlergias(String aler){alergias=aler;}
    public void setPadecimiento(String pade){padecimientos=pade;}
}

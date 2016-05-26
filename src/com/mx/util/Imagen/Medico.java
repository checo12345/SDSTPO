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
public class Medico extends Persona{
    private Persona p;
    private String especialidad;
    private int cedulaProfesional;
    public Medico(){}
    public Medico(String nom,String apeP,String apeM,Date fecNac,int Tel,String dir,boolean sex,String esp,int cedPro){
        p=new Persona(nom,apeP,apeM,fecNac,Tel,dir,sex){};
        especialidad=esp;
        cedulaProfesional=cedPro;
    }
    public String getEspecialidad(){return especialidad;}
    public int getCedulaProfesional(){return cedulaProfesional;}
    public void setEspecialidad(String esp){especialidad=esp;}
    public void setCedulaPrfesional(int cedPro){cedulaProfesional=cedPro;}
}

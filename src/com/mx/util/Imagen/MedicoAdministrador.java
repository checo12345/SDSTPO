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
public class MedicoAdministrador extends Medico{
    private Medico m;
    private String cargo;
    public MedicoAdministrador(){}
    public MedicoAdministrador(String nom,String apeP,String apeM,Date fecNac,int Tel,String dir,boolean sex,String esp,int cedPro,String car){
        m=new Medico(nom,apeP,apeM,fecNac,Tel,dir,sex,esp,cedPro){};
        cargo=car;
    }
    public String getCargo(){return cargo;}
    public void setCargo(String car){cargo=car;}
}

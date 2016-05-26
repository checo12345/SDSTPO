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
abstract class Persona {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private int telefono;
    private String direccion;
    private boolean sexo;
    /*  true = hombre
        false= mujer  */
    public Persona(){}
    public Persona(String nom,String apeP,String apeM,Date fecNac,int Tel,String dir,boolean sex){
        nombre=nom;
        apellidoPaterno=apeP;
        apellidoMaterno=apeM;
        fechaNacimiento=fecNac;
        telefono=Tel;
        direccion=dir;
        sexo=sex;
    }
    public String getNombre(){return nombre;}
    public String getApellidoPaterno(){return apellidoPaterno;}
    public String getApellidoMaterno(){return apellidoMaterno;}
    public Date getFechaNacimiento(){return fechaNacimiento;}
    public int getTelefono(){return telefono;}
    public String getDireccion(){return direccion;}
    public boolean getHombre(){return sexo;}
    public boolean getMujer(){return !sexo;}
    public void setNombre(String nom){
        nombre=nom;
    }
    public void setApellidoPaterno(String apePat){
        apellidoPaterno=apePat;
    }
    public void setApellidoMaterno(String apeMat){
        apellidoMaterno=apeMat;
    }
    public void setFechaNacimiento(Date fecNac){
        fechaNacimiento=fecNac;
    }
    public void setTelefono(int tel){
        telefono=tel;
    }
    public void setDireccion(String dir){
        direccion=dir;
    }
    public void setHombre(){
        sexo=true;
    }
    public void setMujer(){
        sexo=false;
    }
}

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
public class ConsultaMedica {
    private Date fechaConsulta;
    private String motivoConsulta;
    private Imagen ojoIzquierdo;
    private Imagen ojoDerecho;
    private String manifestaciones;
    public ConsultaMedica(){
        fechaConsulta=new Date();
        motivoConsulta="";
        ojoIzquierdo=new Imagen();
        ojoDerecho=new Imagen();
        manifestaciones="";
    }
    public ConsultaMedica(Date feCon,String motCon,Imagen oIzq,Imagen oDer,String man){
        fechaConsulta=feCon;
        motivoConsulta=motCon;
        ojoIzquierdo=oIzq;
        ojoDerecho=oDer;
        manifestaciones=man;
    }
    public Date getFechaConsulta(){return fechaConsulta;}
    public String getMotivoConsulta(){return motivoConsulta;}
    public Imagen getOjoIzquierdo(){return ojoIzquierdo;}
    public Imagen getOjoDerecho(){return ojoDerecho;}
    public String getManifestaciones(){return manifestaciones;}
    public void setFechaConsulta(Date fec){fechaConsulta=fec;}
    public void setMotivoConsulta(String mot){motivoConsulta=mot;}
    public void setOjoIzquierdo(Imagen oIzq){ojoIzquierdo=oIzq;}
    public void setOjoDerecho(Imagen oDer){ojoDerecho=oDer;}
    public void setManifestaciones(String man){manifestaciones=man;}
}

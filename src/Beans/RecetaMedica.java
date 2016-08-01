/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.Date;

/**
 *
 * @author David Pantaleón
 */
public class RecetaMedica {
    private String recomendaciones;
    private Date fecha;
    private double talla;
    private double peso;
    public RecetaMedica(){
        recomendaciones="default";
        fecha=new Date();
        talla=0.0;
        peso=0.0;
    }
    public RecetaMedica(String rec,Date fech,double tal,double pes){
        recomendaciones=rec;
        fecha=fech;
        talla=tal;
        peso=pes;
    }
    public String getRecomendaciones(){
        return recomendaciones;
    }
    public Date getFecha(){
        return fecha;
    }
    public double getTalla(){
        return talla;
    }
    public double getPeso(){
        return peso;
    }
    public void setRecomendaciones(String rec){
        recomendaciones=rec;
    }
    public void setFecha(Date fec){
        fecha=fec;
    }
    public void setTalla(double tal){
        talla=tal;
    }
    public void setPeso(double pes){
        peso=pes;
    }
}

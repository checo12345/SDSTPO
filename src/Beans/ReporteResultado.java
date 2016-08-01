/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author David Pantaleón
 */
public class ReporteResultado {
    private String nombreReporte;
    private String ruta;
    public ReporteResultado(){
        nombreReporte="default";
        ruta="/defaultReporte/";
    }
    public ReporteResultado(String nomRep,String rut){
        nombreReporte=nomRep;
        ruta=rut;
    }
    public String getNombreReporte(){
        return nombreReporte;
    }
    public String getRuta(){
        return ruta;
    }
    public void setNombreReporte(String nomRep){
        nombreReporte=nomRep;
    }
    public void setRuta(String rut){
        ruta=rut;
    }
}

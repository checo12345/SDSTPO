/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author laloe
 */
public class ResultadoPrediagnostico {
private int     idResultado;
private String  patologia;
private String  ojo;
private double  resultado; 
private String  rutaImagen;
private int     idPreDiag;

    public ResultadoPrediagnostico() {
    }

    public ResultadoPrediagnostico(String patologia, String ojo, double resultado, String rutaImagen, int idPreDiag) {
        this.patologia = patologia;
        this.ojo = ojo;
        this.resultado = resultado;
        this.rutaImagen = rutaImagen;
        this.idPreDiag = idPreDiag;
    }

    public int getIdResultado() {
        return idResultado;
    }

    public void setIdResultado(int idResultado) {
        this.idResultado = idResultado;
    }

    public String getPatologia() {
        return patologia;
    }

    public void setPatologia(String patologia) {
        this.patologia = patologia;
    }

    public String getOjo() {
        return ojo;
    }

    public void setOjo(String ojo) {
        this.ojo = ojo;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public int getIdPreDiag() {
        return idPreDiag;
    }

    public void setIdPreDiag(int idPreDiag) {
        this.idPreDiag = idPreDiag;
    }
    

}

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
public class Medicamento {
    private int    idMedicamento;
    private String nombre;
    private String presentacion;
    private String dosis;
    public Medicamento(){
        nombre="default";
        presentacion="default";
        dosis="default";
    }

    public Medicamento(int idMedicamento, String nombre, String presentacion, String dosis) {
        this.idMedicamento = idMedicamento;
        this.nombre = nombre;
        this.presentacion = presentacion;
        this.dosis = dosis;
    }
    

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
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

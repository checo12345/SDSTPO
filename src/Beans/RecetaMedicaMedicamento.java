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
public class RecetaMedicaMedicamento {
    private int idReceta;
    private int idMedicamento;
    private String dosis;

    public RecetaMedicaMedicamento() {
    }

    public RecetaMedicaMedicamento(int idReceta, int idMedicamento, String dosis) {
        this.idReceta = idReceta;
        this.idMedicamento = idMedicamento;
        this.dosis = dosis;
    }

    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.List;

/**
 *
 * @author David Pantaleón
 */
public class PrediagnosticoBean {
    private int     idPreDiag;
    private String  observaciones;
    private int     idConsulta;
    private List<ResultadoPrediagnostico> resultados;
    public PrediagnosticoBean(){}

    public List<ResultadoPrediagnostico> getResultados() {
        return resultados;
    }

    public void setResultados(List<ResultadoPrediagnostico> resultados) {
        this.resultados = resultados;
    }
    
    public PrediagnosticoBean( String observaciones, int idConsulta) {
        
        this.observaciones = observaciones;
        this.idConsulta = idConsulta;
    }

    public int getIdPreDiag() {
        return idPreDiag;
    }

    public void setIdPreDiag(int idPreDiag) {
        this.idPreDiag = idPreDiag;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }
    
}

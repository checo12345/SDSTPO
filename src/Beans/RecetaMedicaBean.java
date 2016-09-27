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
public class RecetaMedicaBean {
    private int idReceta;
    private String recomendaciones;
    private String fecha;
    private int idConsulta;

    public RecetaMedicaBean() {
    }

    public RecetaMedicaBean(int idReceta, String recomendaciones, String fecha, int idConsulta) {
        this.idReceta = idReceta;
        this.recomendaciones = recomendaciones;
        this.fecha = fecha;
        this.idConsulta = idConsulta;
    }

    public RecetaMedicaBean(String recomendaciones, String fecha, int idConsulta) {
        this.recomendaciones = recomendaciones;
        this.fecha = fecha;
        this.idConsulta = idConsulta;
    }

    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }
    
}

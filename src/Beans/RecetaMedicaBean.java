/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.Date;
import java.util.List;

/**
 *
 * @author David Pantaleón
 */
public class RecetaMedicaBean {
    private int    idReceta;
    private String recomendaciones,nombrePaciente,proximaCita,nombreResponsable,especialidadResp,cedulaResp;
    private String fecha;
    
    private String reporte;
    private int    idConsulta;
    private List<Medicamento> medicamentos;
    
    public RecetaMedicaBean() {
    }

    public RecetaMedicaBean(int idReceta, String recomendaciones, String fecha, int idConsulta) {
        this.idReceta = idReceta;
        this.recomendaciones = recomendaciones;
        this.fecha = fecha;
        this.idConsulta = idConsulta;
    }

    

    public String getReporte() {
        return reporte;
    }

    public void setReporte(String reporte) {
        this.reporte = reporte;
    }
    
    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }
    
    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
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
    
    public void setNombrePaciente(String NombrePaciente) {
        this.nombrePaciente = NombrePaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public String getProximaCita() {
        return proximaCita;
    }

    public void setProximaCita(String proximaCita) {
        this.proximaCita = proximaCita;
    }

    public String getNombreResponsable() {
        return nombreResponsable;
    }

    public void setNombreResponsable(String nombreResponsable) {
        this.nombreResponsable = nombreResponsable;
    }

    public String getEspecialidadResp() {
        return especialidadResp;
    }

    public void setEspecialidadResp(String especialidadResp) {
        this.especialidadResp = especialidadResp;
    }

    public String getCedulaResp() {
        return cedulaResp;
    }

    public void setCedulaResp(String cedulaResp) {
        this.cedulaResp = cedulaResp;
    }
    
    
}

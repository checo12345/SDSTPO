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
public class ConsultaMedicaBean {
    private int idConsulta;

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }
    private String fechaConsulta;
    private String motivoConsulta;
    private String ojoIzquierdo;
    private String ojoDerecho;
    private String rutaInforme;
    private List<String> manifestaciones;
    private int    cedulaMedico;
    private int    idPaciente;

    public String getRutaInforme() {
        return rutaInforme;
    }

    public void setRutaInforme(String rutaInforme) {
        this.rutaInforme = rutaInforme;
    }

    public int getCedulaMedico() {
        return cedulaMedico;
    }

    public void setCedulaMedico(int cedulaMedico) {
        this.cedulaMedico = cedulaMedico;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
    public ConsultaMedicaBean(){
        fechaConsulta="";
        motivoConsulta="";
        ojoIzquierdo="";
        ojoDerecho="";
        manifestaciones=null;
    }
    public ConsultaMedicaBean(String feCon,String motCon,String oIzq,String oDer,List<String> man){
        fechaConsulta=feCon;
        motivoConsulta=motCon;
        ojoIzquierdo=oIzq;
        ojoDerecho=oDer;
        manifestaciones=man;
    }

    public ConsultaMedicaBean(String fechaConsulta, String motivoConsulta, String ojoIzquierdo, String ojoDerecho, int cedulaMedico, int idPaciente,String rutaInforme) {
        this.fechaConsulta = fechaConsulta;
        this.motivoConsulta = motivoConsulta;
        this.ojoIzquierdo = ojoIzquierdo;
        this.ojoDerecho = ojoDerecho;
        this.cedulaMedico = cedulaMedico;
        this.idPaciente = idPaciente;
        this.rutaInforme=rutaInforme;
    }
    
    public String getFechaConsulta(){return fechaConsulta;}
    public String getMotivoConsulta(){return motivoConsulta;}
    public String getOjoIzquierdo(){return ojoIzquierdo;}
    public String getOjoDerecho(){return ojoDerecho;}
    public List<String> getManifestaciones(){return manifestaciones;}
    public void setFechaConsulta(String fec){fechaConsulta=fec;}
    public void setMotivoConsulta(String mot){motivoConsulta=mot;}
    public void setOjoIzquierdo(String oIzq){ojoIzquierdo=oIzq;}
    public void setOjoDerecho(String oDer){ojoDerecho=oDer;}
    public void setManifestaciones(List<String> man){manifestaciones=man;}
}
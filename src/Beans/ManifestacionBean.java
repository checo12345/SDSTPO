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
public class ManifestacionBean {
    private String manifestacion;
    private int idConsulta;

    public ManifestacionBean(String manifestacion, int idConsulta) {
        this.manifestacion = manifestacion;
        this.idConsulta = idConsulta;
    }

    public String getManifestacion() {
        return manifestacion;
    }

    public void setManifestacion(String manifestacion) {
        this.manifestacion = manifestacion;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }
    
}

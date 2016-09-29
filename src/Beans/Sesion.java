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
public class Sesion {
    private String usuario;
    private String password;
    private String rol;
    private int cedulaProfMedico;
    public Sesion(){
        usuario="default";
        password="default";
        rol="Usuario";
        cedulaProfMedico=0000000;
    }

    public Sesion(int cedulaProfMedico) {
        this.cedulaProfMedico = cedulaProfMedico;
    }

    public Sesion(String usuario, String password, String rol, int cedulaProfMedico) {
        this.usuario = usuario;
        this.password = password;
        this.rol = rol;
        this.cedulaProfMedico = cedulaProfMedico;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getCedulaProfMedico() {
        return cedulaProfMedico;
    }

    public void setCedulaProfMedico(int cedulaProfMedico) {
        this.cedulaProfMedico = cedulaProfMedico;
    }
    
}
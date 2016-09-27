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
    private boolean admin;
    private int ced_prof;
    public Sesion(){
        usuario="default";
        password="default";
        admin=false;
        ced_prof=0000000;
    }
    public Sesion(int ced_pro){
        ced_prof=ced_pro;
    }
    public Sesion(String usu,String pas,Boolean adm,int ced_p){
        usuario=usu;
        password=pas;
        admin=adm;
        ced_prof=ced_p;
    }
    public String getUsuario(){
        return usuario;
    }
    public String getPassword(){
        return password;
    }
    public boolean getAdmin(){
        return admin;
    }
    public int getCedProf(){
        return ced_prof;
    }
    public void setUsuario(String usu){
        usuario=usu;
    }
    public void setPassword(String pas){
        password=pas;
    }
    public void setAdmin(boolean adm){
        admin=adm;
    }
    public void setCedProf(int ced){
        ced_prof=ced;
    }
}

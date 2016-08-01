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
    public Sesion(){
        usuario="default";
        password="default";
    }
    public Sesion(String usu,String pas){
        usuario=usu;
        password=pas;
    }
    public String getUsuario(){
        return usuario;
    }
    public String getPassword(){
        return password;
    }
    public void setUsuario(String usu){
        usuario=usu;
    }
    public void setPassword(String pas){
        password=pas;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Beans.MedicoBean;
import Beans.Sesion;
import DAO.ServicioDAO;
import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author David Pantaleón
 */
public class MedicoAdministrador extends Medico {
    private MedicoBean m;
    private Sesion s;
    private static final Logger logger = Logger.getLogger("MedicoAdministrador");

    public MedicoAdministrador(int cedula) {
        super(cedula);
        
    }
    

    public  MedicoAdministrador(){
    super();
    }
    
    public void cargarInfoMedico(String nombre, String apeP, String apeM, Date f_nac, String tel, String dir, String sex, String espe, int cedula_prof,String usuario,String password,String Rol) {
        m=new MedicoBean();
        m.setNombre(nombre);
        m.setApellidoPaterno(apeP);
        m.setApellidoMaterno(apeM);
        m.setFechaNacimiento(f_nac);
        m.setTelefono(tel);
        m.setDireccion(dir);
        m.setSexo(sex);
        m.setEspecialidad(espe);
        m.setCedulaPrfesional(cedula_prof);
        s=new Sesion(usuario,password,Rol,cedula_prof);
    }

    public String insertNuevoMedico() {
        ServicioDAO serv=new ServicioDAO();
        return serv.insertarMedico(m,s);
    }

    public String updateNuevoMedico() {
        ServicioDAO serv=new ServicioDAO();
        return serv.actualizarMedico(m,s);
    }
}

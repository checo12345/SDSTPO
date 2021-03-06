/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Beans.ConsultaMedicaBean;
import Beans.MedicoBean;
import DAO.ServicioDAO;
import Excepciones.SDTPOException;
import Formularios.ConsultarHistorial;
import Formularios.RegistrarPaciente;
import Formularios.RegistroConsulta;
import Formularios.VerConsulta;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author laloe
 */
public class Medico {
    protected MedicoBean medico;
    private static final Logger logger = Logger.getLogger("Medico");
    public Medico(int cedula){
        medico=new MedicoBean(cedula);
    }
    
public boolean mostrarConsulta(JDialog frame,ConsultaMedicaBean consulta,String curp){
    VerConsulta vc=new VerConsulta(frame, false,consulta,curp);
    vc.setVisible(true);
    return true;
}
    public MedicoBean getMedico() {
        return medico;
    }
    public Medico(){}
    public boolean GenerarConsulta(JFrame frame){
        RegistroConsulta r=new RegistroConsulta(frame,true,medico);
        r.setVisible(true);
        return true;
    }
    
    public boolean registrarPaciente(JFrame frame) {
        RegistrarPaciente rp=new RegistrarPaciente(frame, true, 1);
        rp.setSize(1100, 700);
        rp.setLocationRelativeTo(null);
        rp.setVisible(true);
        
        return true;
    }
    public static void main(String[] args){
        Medico m=new Medico();
        m.obtenerHistorial("CURPp");
    }
    public boolean generarHistorial(JFrame frame){
        ConsultarHistorial ch=new ConsultarHistorial(frame,true,this);
        ch.setVisible(true);
        return true;
    }
    public ServicioRespuesta obtenerHistorial(String curp){
        ServicioRespuesta respuesta = new ServicioRespuesta();
        logger.info("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t============ METODO: obtenerHistorial() ============");
        try {
            ServicioDAO servicio = new ServicioDAO();
            
            

            respuesta = servicio.getConsultas(curp);
            if ((!respuesta.isSuccess()) || respuesta.getResult() == null) {
                throw new SDTPOException("Ocurrio un error al Buscar las consultas");
            }
            
           
        } catch (SDTPOException e) {
            logger.info("" + e.getMessage());
            respuesta.setSuccess(false);
            respuesta.setMensaje(e.getMessage());
        } catch (Exception e) {
            logger.info("###ERROR### " + e.getMessage());
            respuesta.setSuccess(false);
            respuesta.setMensaje(e.getMessage());
        }
        return respuesta;
    }
    public ServicioRespuesta validarMedico() {
        ServicioRespuesta respuesta = new ServicioRespuesta();
        logger.info("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t============ METODO: validarMedico() ============");
        try {
            ServicioDAO servicio = new ServicioDAO();
            
            System.out.println("CEDULA: " + this.medico.getCedulaProfesional());

            respuesta = servicio.buscaMedico(this.medico);
            if ((!respuesta.isSuccess()) || respuesta.getResult() == null) {
                throw new SDTPOException("Ocurrio un error al Buscar al Medico");
            }

            this.medico = (MedicoBean) respuesta.getResult();
        } catch (SDTPOException e) {
            logger.info("" + e.getMessage());
            respuesta.setSuccess(false);
            respuesta.setMensaje(e.getMessage());
        } catch (Exception e) {
            logger.info("###ERROR### " + e.getMessage());
            respuesta.setSuccess(false);
            respuesta.setMensaje(e.getMessage());
        }
        return respuesta;
    }
}

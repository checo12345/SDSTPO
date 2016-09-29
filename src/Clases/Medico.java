/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Beans.MedicoBean;
import DAO.ServicioDAO;
import Excepciones.SDTPOException;
import Formularios.RegistroConsulta;
import java.util.logging.Logger;
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
    public Medico(){}
    public boolean GenerarConsulta(JFrame frame){
        RegistroConsulta r=new RegistroConsulta(frame,true,medico);
    
                 
                r.setVisible(true);
        return true;
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

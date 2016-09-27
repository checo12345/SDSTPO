/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Beans.ConsultaMedicaBean;
import Beans.Imagen;
import Beans.ManifestacionBean;
import Beans.Medicamento;
import Beans.RecetaMedicaBean;
import Beans.RecetaMedicaMedicamento;
import DAO.ServicioDAO;
import Excepciones.SDTPOException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;

/**
 *
 * @author laloe
 */
public class RecetaMedica {
    private static final Logger logger = Logger.getLogger("RecetaMedica");
    private int id;
    private int idConsulta;
    public RecetaMedica(int idConsulta){
        //obtenerSiguienteIdReceta();
        //System.out.println(id);
        this.idConsulta=idConsulta;
        
    }
    public ServicioRespuesta obtenerSiguienteIdReceta(){
        ServicioRespuesta respuesta = new ServicioRespuesta();
        logger.info("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t============ METODO: obtenerSiguienteIdReceta() ============");
        try {
            ServicioDAO servicio = new ServicioDAO();

            respuesta = servicio.getNextReceta();
            if ((!respuesta.isSuccess()) || respuesta.getResult() == null) {
                throw new SDTPOException("Ocurrio un error al Buscar la Siguiente Receta");
            }

            id = (int) respuesta.getResult();
            logger.info("Siguiente Receta: "+id);
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
    public ServicioRespuesta obtenerMedicamentos(){
        ServicioRespuesta respuesta = new ServicioRespuesta();
        logger.info("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t============ METODO: obtenerMedicamentos() ============");
        try {
            ServicioDAO servicio = new ServicioDAO();

            respuesta = servicio.getMedicamentos();
            if ((!respuesta.isSuccess()) || respuesta.getResult() == null) {
                throw new SDTPOException("Ocurrio un error al Buscar los medicamentos");
            }

            //id = (int) respuesta.getResult();
            
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
    public ServicioRespuesta crearMedicamento(Medicamento medicamento){
        ServicioRespuesta respuesta = new ServicioRespuesta();
        logger.info("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t============ METODO: crearMedicamento() ============");
        
        try {
            ServicioDAO servicio = new ServicioDAO();
            respuesta=servicio.insertarMedicamento(medicamento);
            if((int)respuesta.getResult()==0){throw new SDTPOException("Ocurrio un error al insertar consulta");}
            
        }  catch (SDTPOException ex) {
            Logger.getLogger(ConsultaMedica.class.getName()).log(Level.SEVERE, null, ex);
            respuesta.setSuccess(false);
        }
        return respuesta;
    }
     public boolean registrarReceta(String recomendaciones,ArrayList<Medicamento> lista) {
        ServicioRespuesta respuesta = new ServicioRespuesta();
        logger.info("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t============ METODO: registrarReceta() ============");
        
        try {
            
            ServicioDAO servicio = new ServicioDAO();
            RecetaMedicaBean rmb=new RecetaMedicaBean(recomendaciones,new SimpleDateFormat("yyyy-MM-dd").format(new Date()),idConsulta);
            respuesta=servicio.insertarReceta(rmb);
            logger.info("Se registro la receta medica con id: "+rmb.getIdReceta());
            id=rmb.getIdReceta();
            if((int)respuesta.getResult()==0){throw new SDTPOException("Ocurrio un error al insertar la Receta");}
            for (Medicamento med : lista) {
                respuesta=servicio.insertarRecetaMedicamento(new RecetaMedicaMedicamento(id,med.getIdMedicamento(),med.getDosis()));
                 if((int)respuesta.getResult()==0){throw new SDTPOException("Ocurrio un error al insertar una medicamento de la receta");}
            }
            
        } catch (SDTPOException ex) {
            Logger.getLogger(ConsultaMedica.class.getName()).log(Level.SEVERE, null, ex);
            respuesta.setSuccess(false);
        }
        return respuesta.isSuccess();
    }

    public static void main(String[] args){
        new RecetaMedica(1);
    }
}

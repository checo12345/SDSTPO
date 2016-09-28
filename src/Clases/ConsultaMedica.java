/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Beans.ConsultaMedicaBean;
import Beans.Imagen;
import Beans.ManifestacionBean;
import Beans.Medico;
import Beans.Paciente;
import DAO.ServicioDAO;
import Excepciones.SDTPOException;
import Formularios.RegistroReceta;
import Formularios.RegistroReceta;
import java.util.logging.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import org.apache.ibatis.io.Resources;

/**
 *
 * @author laloe
 */
public class ConsultaMedica {

    private static final Logger logger = Logger.getLogger("ConsultaMedica");
    private Paciente paciente = null;
    private Medico medico = null;
    private int id = 0;
    private Imagen ojoDer=null,ojoIzq=null;
    public ServicioRespuesta validarMedico(Medico medico) {
        ServicioRespuesta respuesta = new ServicioRespuesta();
        logger.info("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t============ METODO: validarMedico() ============");
        try {
            ServicioDAO servicio = new ServicioDAO();
            this.medico = medico;
            System.out.println("CEDULA: " + this.medico.getCedulaProfesional());

            respuesta = servicio.buscaMedico(this.medico);
            if ((!respuesta.isSuccess()) || respuesta.getResult() == null) {
                throw new SDTPOException("Ocurrio un error al Buscar al Medico");
            }

            this.medico = (Medico) respuesta.getResult();
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

    public ServicioRespuesta validarPaciente(int id) {
        ServicioRespuesta respuesta = new ServicioRespuesta();
        logger.info("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t============ METODO: validarPaciente() ============");
        try {
            ServicioDAO servicio = new ServicioDAO();
            paciente = new Paciente();
            paciente.setIdPaciente(id);

            respuesta = servicio.buscaPaciente(paciente);
            if ((!respuesta.isSuccess()) || respuesta.getResult() == null) {
                throw new SDTPOException("Ocurrio un error al Buscar al Paciente");
            }

            paciente = (Paciente) respuesta.getResult();
            System.out.println("SANGRE: "+paciente.getTipoSangre());
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

    public ServicioRespuesta obtenerSiguienteIdCosnulta() {
        ServicioRespuesta respuesta = new ServicioRespuesta();
        logger.info("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t============ METODO: obtenerSiguienteIdCosnulta() ============");
        try {
            ServicioDAO servicio = new ServicioDAO();

            respuesta = servicio.getNextConsulta();
            if ((!respuesta.isSuccess()) || respuesta.getResult() == null) {
                throw new SDTPOException("Ocurrio un error al Buscar la Siguiente Consulta");
            }

            id = (int) respuesta.getResult();

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

    public String creaExpediente() {
        logger.info("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t============ METODO: creaExpediente() ============");
        String expediente = "/" + paciente.getIdPaciente() + "_" + paciente.getNombre().replace(" ", "_") + "_" + paciente.getApellidoPaterno().replaceAll(" ", "_") + "_" + paciente.getApellidoMaterno().replaceAll(" ", "_") + "/Consulta_" + id + "_" + new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        File directorio = null;
        try {
            
            Properties properties = Resources.getResourceAsProperties("configuracion.properties");
            // Cargar las propiedades del archivo
            
            directorio = new File(properties.getProperty("directorio") + expediente);
            logger.info(directorio.toString());
            if (!directorio.exists()) {
                directorio.mkdirs();
            }
        } catch (FileNotFoundException e) {
            // System.out.println(e.getMessage());
            logger.info("###ERROR### " + e.getMessage());
        } catch (IOException e) {
            //System.out.println(e.getMessage());
            logger.info("###ERROR### " + e.getMessage());
        }
        return directorio.toString();

    }

    public boolean Registrar(String motivo, DefaultListModel manifestaciones, Imagen ojoDer, Imagen ojoIzq) {
        ServicioRespuesta respuesta = new ServicioRespuesta();
        logger.info("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t============ METODO: Registrar() ============");
        String ruta = creaExpediente() + "/";
        File Derecho = new File(ruta + "OjoDerecho.jpg");
        File Izquierdo = new File(ruta + "OjoIzquierdo.jpg");
        ojoDer.setRuta(Derecho.toString());
        ojoIzq.setRuta(Izquierdo.toString());
        this.ojoDer=ojoDer;
        this.ojoIzq=ojoIzq;
        try {
            ImageIO.write(ojoDer.getFotografia(), "jpg", Derecho);
            ImageIO.write(ojoIzq.getFotografia(), "jpg", Izquierdo);
            ServicioDAO servicio = new ServicioDAO();
            ConsultaMedicaBean cmb=new ConsultaMedicaBean(new SimpleDateFormat("yyyy-MM-dd").format(new Date()),motivo,Izquierdo.toString(),Derecho.toString(),medico.getCedulaProfesional(),paciente.getIdPaciente());
            respuesta=servicio.insertarConsulta(cmb);
            logger.info("Se registro la consulta con el id: "+cmb.getIdConsulta());
            id=cmb.getIdConsulta();
            if((int)respuesta.getResult()==0){throw new SDTPOException("Ocurrio un error al insertar consulta");}
            for(int i=0;i<manifestaciones.size();i++){
                respuesta=servicio.insertarManifestacion(new ManifestacionBean((String)manifestaciones.getElementAt(i),id));
                 if((int)respuesta.getResult()==0){throw new SDTPOException("Ocurrio un error al insertar una manifestacion");}
            }
        } catch (IOException e) {
            
            logger.info("Error de escritura en las imagenes");
            respuesta.setSuccess(false);
        } catch (SDTPOException ex) {
            Logger.getLogger(ConsultaMedica.class.getName()).log(Level.SEVERE, null, ex);
            respuesta.setSuccess(false);
        }
        return respuesta.isSuccess();
    }
public boolean CrearReceta(JFrame frame){
     RegistroReceta r=new RegistroReceta(frame,true,id);
    
                 
                r.setVisible(true);
        
    
    return true;
}
    public static void main(String[] args) {
        try {
            File archivo = Resources.getResourceAsFile("configuracion.properties");
            System.out.println(archivo.toString());
            Properties properties = Resources.getResourceAsProperties("configuracion.properties");
            System.out.println(properties.getProperty("directorio"));
            
        } catch (IOException ex) {
            Logger.getLogger(ConsultaMedica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

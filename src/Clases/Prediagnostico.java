/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Beans.ConsultaMedicaBean;
import Beans.Imagen;
import Beans.ManifestacionBean;
import Beans.PrediagnosticoBean;
import Beans.RecetaMedicaBean;
import Beans.ResultadoPrediagnostico;
import DAO.ServicioDAO;
import Excepciones.SDTPOException;
import Formularios.VisualizarPrediagnostico;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import org.opencv.core.Mat;

/**
 *
 * @author laloe
 */
public class Prediagnostico {

    private static final Logger logger = Logger.getLogger("Prediagnostico");
    private Imagen ojoIzquierdo;
    private Imagen ojoDerecho;
    private Imagen imgOIC = null, imgODC = null, imgOIM = null, imgODM = null, imgOIP = null, imgODP = null;
    private double[] resultado = null;
    private int opcion;
    private String ruta;
    private int idConsulta;
    private String observaciones;
    private boolean Registro;
    public Prediagnostico(JDialog frame,int idConsulta,Imagen imgIzq, Imagen imgDer){
        this.idConsulta=idConsulta;
        PrediagnosticoBean pb=obtenerPrediagnostico(idConsulta);
        if(pb!=null){
        VisualizarPrediagnostico vp = new VisualizarPrediagnostico(frame, true,pb, imgIzq,  imgDer);
        vp.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "No se tiene registrado un pre-diagnóstico para esta consulta", "No se encontro pre-diagnóstico",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    public PrediagnosticoBean obtenerPrediagnostico(int idConsulta){
        ServicioRespuesta respuesta = new ServicioRespuesta();
        logger.info("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t============ METODO: obtenerPrediagnostico() ============");
        try {
            ServicioDAO servicio = new ServicioDAO();

            respuesta = servicio.getPrediagnostico(idConsulta);
            if ((!respuesta.isSuccess()) || respuesta.getResult() == null) {
                throw new SDTPOException("Ocurrio un error al Buscar el prediagnostico");
            }

            logger.info("Receta Encontrada: " + ((RecetaMedicaBean) respuesta.getResult()).getIdReceta());
        } catch (SDTPOException e) {
            logger.info("" + e.getMessage());
            respuesta.setSuccess(false);
            respuesta.setMensaje(e.getMessage());
        } catch (Exception e) {
            logger.info("###ERROR### " + e.getMessage());
            respuesta.setSuccess(false);
            respuesta.setMensaje(e.getMessage());
        }
        return (PrediagnosticoBean)respuesta.getResult();
    }
    public Prediagnostico(Imagen Izq, Imagen Der, JDialog frame, int opcion, String ruta,int idConsulta) {
        ojoIzquierdo = Izq;
        ojoDerecho = Der;
        this.ruta = ruta;
        this.idConsulta=idConsulta;
        Analizador analizador = new Analizador();
        this.opcion=opcion;
        if (opcion == 0) {
            resultado = new double[4];
            imgOIC = new Imagen(analizador.analizarCatarata(ojoIzquierdo.getMatFotografia()));
            resultado[0] = analizador.getResultadoCatarata();
            imgODC = new Imagen(analizador.analizarCatarata(ojoDerecho.getMatFotografia()));
            resultado[1] = analizador.getResultadoCatarata();
            imgOIM = new Imagen(analizador.analizarMelanoma(ojoIzquierdo.getMatFotografia()));
            resultado[2] = analizador.getResultadoMelanoma();
            imgODM = new Imagen(analizador.analizarMelanoma(ojoDerecho.getMatFotografia()));
            resultado[3] = analizador.getResultadoMelanoma();
            VisualizarPrediagnostico vp = new VisualizarPrediagnostico(frame, true, ojoIzquierdo, ojoDerecho, imgOIC, imgODC, imgOIM, imgODM, resultado, this);
            vp.setVisible(true);
        }

    }

    public boolean isRegistro() {
        return Registro;
    }

    public boolean Registrar(String observaciones) {
        Registro=true;
        this.observaciones=observaciones;
        ServicioRespuesta respuesta = new ServicioRespuesta();
        logger.info("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t============ METODO: Registrar() ============");
        if (opcion == 0) {
            File DerechoMel = new File(ruta + "OjoDerechoMelanoma.jpg");
            File IzquierdoMel = new File(ruta + "OjoIzquierdoMelanoma.jpg");
            File DerechoCat = new File(ruta + "OjoDerechoCatarata.jpg");
            File IzquierdoCat = new File(ruta + "OjoIzquierdoCatarata.jpg");
            imgODC.setRuta(DerechoCat.toString());
            imgOIC.setRuta(IzquierdoCat.toString());
            imgODM.setRuta(DerechoMel.toString());
            imgOIM.setRuta(IzquierdoMel.toString());
            
            try {
                ImageIO.write(imgODC.getFotografia(), "jpg", DerechoCat);
                ImageIO.write(imgOIC.getFotografia(), "jpg", IzquierdoCat);
                ImageIO.write(imgODM.getFotografia(), "jpg", DerechoMel);
                ImageIO.write(imgOIM.getFotografia(), "jpg", IzquierdoMel);
                
                ServicioDAO servicio = new ServicioDAO();
                PrediagnosticoBean pb=new PrediagnosticoBean(observaciones,idConsulta);
                respuesta = servicio.insertarPrediagnostico(pb);
                logger.info("respuesta: Se registro el prediagnostico con el id: " + (int)respuesta.getResult());
                                logger.info("pb: Se registro el prediagnostico con el id: " + pb.getIdPreDiag());
                //pb.setIdPreDiag((int)respuesta.getResult());
                if ((int) respuesta.getResult() == 0) {
                    throw new SDTPOException("Ocurrio un error al insertar un prediagnostico");
                }
                
                    respuesta = servicio.insertarResultadoPre(new ResultadoPrediagnostico("Catarata","Izquierdo",resultado[0],imgOIC.getRuta(),pb.getIdPreDiag()));
                    if ((int) respuesta.getResult() == 0) 
                        throw new SDTPOException("Ocurrio un error al insertar un resultado");
                    respuesta = servicio.insertarResultadoPre(new ResultadoPrediagnostico("Catarata","Derecho",resultado[1],imgODC.getRuta(),pb.getIdPreDiag()));
                    if ((int) respuesta.getResult() == 0) 
                        throw new SDTPOException("Ocurrio un error al insertar un resultado");
                    respuesta = servicio.insertarResultadoPre(new ResultadoPrediagnostico("Melanoma","Izquierdo",resultado[2],imgOIM.getRuta(),pb.getIdPreDiag()));
                    if ((int) respuesta.getResult() == 0) 
                        throw new SDTPOException("Ocurrio un error al insertar un resultado");
                    respuesta = servicio.insertarResultadoPre(new ResultadoPrediagnostico("Melanoma","Derecho",resultado[3],imgODM.getRuta(),pb.getIdPreDiag()));
                    if ((int) respuesta.getResult() == 0) 
                        throw new SDTPOException("Ocurrio un error al insertar un resultado");
                    
                
            } catch (IOException e) {

                logger.info("Error de escritura en las imagenes");
                respuesta.setSuccess(false);
            } catch (SDTPOException ex) {
                Logger.getLogger(ConsultaMedica.class.getName()).log(Level.SEVERE, null, ex);
                respuesta.setSuccess(false);
            }
        }else if(opcion==1){
          File DerechoPte = new File(ruta + "OjoDerechoPterigion.jpg");
            File IzquierdoPte = new File(ruta + "OjoIzquierdoPterigion.jpg");
            
            imgODP.setRuta(DerechoPte.toString());
            imgOIP.setRuta(IzquierdoPte.toString());
            
            
            try {
                ImageIO.write(imgODP.getFotografia(), "jpg", DerechoPte);
                ImageIO.write(imgOIP.getFotografia(), "jpg", IzquierdoPte);
                
                
                ServicioDAO servicio = new ServicioDAO();
                PrediagnosticoBean pb=new PrediagnosticoBean(observaciones,idConsulta);
                respuesta = servicio.insertarPrediagnostico(pb);
                logger.info("respuesta: Se registro el prediagnostico con el id: " + (int)respuesta.getResult());
                                logger.info("pb: Se registro el prediagnostico con el id: " + pb.getIdPreDiag());
                //pb.setIdPreDiag((int)respuesta.getResult());
                if ((int) respuesta.getResult() == 0) {
                    throw new SDTPOException("Ocurrio un error al insertar consulta");
                }
                
                    respuesta = servicio.insertarResultadoPre(new ResultadoPrediagnostico("Pterigion","Izquierdo",resultado[0],imgOIP.getRuta(),pb.getIdPreDiag()));
                    if ((int) respuesta.getResult() == 0) 
                        throw new SDTPOException("Ocurrio un error al insertar una manifestacion");
                    respuesta = servicio.insertarResultadoPre(new ResultadoPrediagnostico("Pterigion","Derecho",resultado[1],imgODP.getRuta(),pb.getIdPreDiag()));
                    if ((int) respuesta.getResult() == 0) 
                        throw new SDTPOException("Ocurrio un error al insertar una manifestacion");
                    
                
            } catch (IOException e) {

                logger.info("Error de escritura en las imagenes");
                respuesta.setSuccess(false);
            } catch (SDTPOException ex) {
                Logger.getLogger(ConsultaMedica.class.getName()).log(Level.SEVERE, null, ex);
                respuesta.setSuccess(false);
            }  
        }
        return respuesta.isSuccess();
    }

    public String getObservaciones() {
        return observaciones;
    }

    public Imagen getOjoIzquierdo() {
        return ojoIzquierdo;
    }

    public Imagen getOjoDerecho() {
        return ojoDerecho;
    }

    public Imagen getImgOIC() {
        return imgOIC;
    }

    public Imagen getImgODC() {
        return imgODC;
    }

    public Imagen getImgOIM() {
        return imgOIM;
    }

    public Imagen getImgODM() {
        return imgODM;
    }

    public double[] getResultado() {
        return resultado;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Beans.Imagen;
import Formularios.VisualizarPrediagnostico;
import java.awt.Image;
import javax.swing.JDialog;
import org.opencv.core.Mat;

/**
 *
 * @author laloe
 */
public class Prediagnostico {
    private Imagen ojoIzquierdo;
    private Imagen ojoDerecho;
    public Prediagnostico(Imagen Izq, Imagen Der, JDialog frame,int opcion){
        ojoIzquierdo=Izq;
        ojoDerecho=Der;
        Imagen imgOIC=null,imgODC=null,imgOIM=null,imgODM=null;
        double[] resultado=null;
        Analizador analizador=new Analizador();
        
        if(opcion==0){
            resultado=new double[4];
            imgOIC=new Imagen(analizador.analizarCatarata(ojoIzquierdo.getMatFotografia()));
            resultado[0]=analizador.getResultadoCatarata();
            imgODC=new Imagen(analizador.analizarCatarata(ojoDerecho.getMatFotografia()));
            resultado[1]=analizador.getResultadoCatarata();
            imgOIM=new Imagen(analizador.analizarMelanoma(ojoIzquierdo.getMatFotografia()));
            resultado[2]=analizador.getResultadoMelanoma();
            imgODM=new Imagen(analizador.analizarMelanoma(ojoDerecho.getMatFotografia()));
            resultado[3]=analizador.getResultadoMelanoma();
            VisualizarPrediagnostico vp=new VisualizarPrediagnostico(frame,true,ojoIzquierdo,ojoDerecho,imgOIC,imgODC,imgOIM,imgODM,resultado);
        vp.setVisible(true);
        }
        
    }
}


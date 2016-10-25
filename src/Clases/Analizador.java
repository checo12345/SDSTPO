/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Image;
import java.awt.image.BufferedImage;
import static org.opencv.core.Core.addWeighted;
import static org.opencv.core.Core.countNonZero;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Ventana;

/**
 *
 * @author laloe
 */
public class Analizador {
    private Segmentador segmentador=null;
    private double resultadoMelanoma;
    private double resultadoCatarata;
    private double resultadoPterigion;
    Analizador(){
        segmentador=new Segmentador();
    }

    public double getResultadoMelanoma() {
        return resultadoMelanoma;
    }
    public double getResultadoCatarata() {
        return resultadoCatarata;
    }
    public double getResultadoPterigion(){
        return resultadoPterigion;
    }

    
    
    public BufferedImage analizarCatarata(Mat img) {
        double[] pupila = segmentador.segmentarPupila(img);
        double[] clase = {68.6250, 125.8750, 118.6250};
        double areaPupila=Math.PI*Math.pow(pupila[2],2);
        int acumulador=0;
//Core.circle(img, new Point(pupila[0], pupila[1]), (int) pupila[2], new Scalar(255, 0, 0), 3);
        //Ventana v1 = new Ventana(convertir(max), 1, 0);
        //Ventana v2 = new Ventana(convertir(img), 3, 0);
        Size sizeA = img.size();
        Mat max = img.clone();

        double[] data;
        for (int i = 0; i < sizeA.height; i++) {
            for (int j = 0; j < sizeA.width; j++) {
                if ((Math.pow(pupila[0] - j, 2) + Math.pow(pupila[1] - i, 2) <= Math.pow(pupila[2], 2))) {
                    data = img.get(i, j);
                    double res = Math.sqrt(Math.pow(clase[0] - data[2], 2) + Math.pow(clase[1] - data[1], 2) + Math.pow(clase[2] - data[0], 2));
                    if (res < 50) {
                        data[0] = 0;
                        data[1] = 255;
                        data[2] = 0;
                        acumulador++;
                    }
                    max.put(i, j, data);
                }
            }
        }
        resultadoCatarata=(acumulador*100)/areaPupila;
        resultadoCatarata=(double)((int)(resultadoCatarata*100.00)/100);
        //Core.circle(imagen, new Point(pupila[0], pupila[1]), (int) pupila[2], new Scalar(255, 0, 0), 3);
        //Ventana v1 = new Ventana(segmentador.convertir(max), 0, 0);
        //Ventana v2 = new Ventana(convertir(imagen), 2, 0);
        return segmentador.Mat2BufferedImage(max);
    }
    public BufferedImage analizarMelanoma(Mat img) {
        int totalP, areaM, tamImg = img.width() * img.height();
        Mat imagenCopia=img.clone();
        Mat imagenCopia1=img.clone();
        img = segmentador.dameLaDona(img);
        Mat img2 = segmentador.dameLaDona(imagenCopia);
        img2 = segmentador.descompCanImg(img2, 1);
        img2 = segmentador.umbralizarImg(img2, 254, 255);

        img = segmentador.blurearImg(img, 25);
        img = segmentador.descompCanImg(img, 1);
        //Ventana v = new Ventana(convertir(img2), 0, 0);
        totalP = tamImg - countNonZero(img2);

        img = segmentador.umbralizarImg(img, 30, 150);
        img = segmentador.umbralizarImg(img, 0, 255);
        areaM = tamImg - countNonZero(img);
        resultadoMelanoma=(areaM * 100) / (double)totalP;
        resultadoMelanoma=(double)((int)(resultadoMelanoma*100.00)/100); 
        System.out.println("El area afectada por melanoma es: " + resultadoMelanoma+ "%");
        System.out.println("El area de iris abarca: " + totalP);
        System.out.println("El total de pixeles es: " + tamImg);
        addWeighted(segmentador.descompCanImg(imagenCopia1, 2), 1, img, 0.3, 0.0, img);
        //Ventana v1 = new Ventana(segmentador.convertir(img), 1, 0);

        return segmentador.Mat2BufferedImage(img);
    }

    public BufferedImage analizarPterigion(Mat img) {
        //Imgproc.resize(imagenCopia, imagenCopia, new Size(540,720));
        int areaT=0,areaP=0;
        double por;
        img=segmentador.detectaPterigion(img,30,30,30);
        areaP=segmentador.detectaAreaPterigion(img);
        areaT=segmentador.detectaEsclerotica(img,60,60,60)+areaP;
        //por=((areaP*100)/areaT);
        resultadoPterigion=((areaP*100)/areaT);
        System.out.println("Area total:"+areaT+"\tArea Afectada:"+areaP+"\tPorcentaje:"+resultadoPterigion);
        
        return segmentador.Mat2BufferedImage(img);
    }
}

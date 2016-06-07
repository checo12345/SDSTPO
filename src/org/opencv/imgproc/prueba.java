
package org.opencv.imgproc;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.math.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.imageio.ImageIO;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.CvType;
import org.opencv.core.MatOfByte;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import Imagenes.* ;
import org.opencv.core.Rect;

public class prueba {
    //static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}
    public static void main(String args[]){
        System.out.println("Cargar y Mostrar una Imagen con OpenCV en Java y Netbeans");
        System.loadLibrary("opencv_java2413");
        Procesar procesar = new Procesar();
    }
}
class Procesar {
    
    Mat imagen,imagenCopia;
    int width,height;
     Mat matriz ;

    public Procesar(){

        imagen = Highgui.imread("C:\\Users\\Sergio\\Documents\\TT\\imagenes\\mio.jpg",Highgui.CV_LOAD_IMAGE_COLOR);
         imagenCopia = Highgui.imread("C:\\Users\\Sergio\\Documents\\TT\\imagenes\\mio.jpg",Highgui.CV_LOAD_IMAGE_COLOR);
        if(!imagen.empty()){
            
            /*Imagen original*/
            Image imagenMostrar = convertir(imagen);
            Ventana ventana = new Ventana(imagenMostrar,0,0);

            imagen=descompCanImg(imagen,2) ;
            Ventana ventana3 = new Ventana(convertir(imagen),1,0);
            
            /*Umbralizado*/
            imagen=umbralizarImg(imagen) ;
            Ventana ventana4 = new Ventana(convertir(imagen),2,0);
             
            /* Erosionar*/
            imagen=eriosionarImg(imagen) ;
            Ventana ventana5 = new Ventana(convertir(imagen),0,1);
            
            /* Erosionar*/
            imagen=dilatarImg(imagen) ;
            Ventana ventana6 = new Ventana(convertir(imagen),1,1);
            
            /*Canny*/
            imagen=filtroCanny(imagen) ;
            Ventana ventana7 = new Ventana(convertir(imagen),2,1);
            
             /*Transformada Hough*/
            Vector<Mat> circlesList=TransfHough(imagen) ;
            System.out.println(circlesList);
            
    
            
        }else{
            System.out.println("\tImagen NO encontrada");
        }
    }
 
    private Image convertir(Mat imagen) {
        MatOfByte matOfByte = new MatOfByte();
        Highgui.imencode(".jpg", imagen, matOfByte);
 
        byte[] byteArray = matOfByte.toArray();
        BufferedImage bufImage = null;
 
        try {
 
            InputStream in = new ByteArrayInputStream(byteArray);
            bufImage = ImageIO.read(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (Image)bufImage;
    }
    
     private Mat umbralizarImg(Mat canalRojo) {
        Imgproc.threshold(canalRojo, canalRojo, 20, 60, Imgproc.THRESH_BINARY);
        return canalRojo;
    }
     
     private Mat escalaGrayImg(Mat img) {
        Imgproc.cvtColor(img, img, Imgproc.COLOR_RGB2GRAY);
        return img;
    }
     
     private Mat descompCanImg(Mat grayscale,int canal) {
         List<Mat> rgb = new ArrayList<Mat>(3);
         Core.split(grayscale,rgb);
        return rgb.get(canal);
    }
    
     private Mat eriosionarImg(Mat umbralizada) {
            Mat dste = umbralizada.clone();
            int erosion_size = 5;
            Size s = new Size(2*erosion_size + 1, 2*erosion_size+1);
            Point p = new Point(erosion_size, erosion_size);
            Mat element = Imgproc.getStructuringElement( Imgproc.MORPH_ELLIPSE,s,p);
            Imgproc.erode(umbralizada, dste, element);
        return dste;
    }
     private Mat dilatarImg(Mat umbralizada) {
            Mat dstd = umbralizada.clone();
            int dilatacion_size = 5;
            Size sd = new Size(2*dilatacion_size + 1, 2*dilatacion_size+1);
            Point pd = new Point(dilatacion_size, dilatacion_size);
            Mat elementd = Imgproc.getStructuringElement( Imgproc.MORPH_ELLIPSE,sd,pd);
            Imgproc.dilate(umbralizada, dstd, elementd);
        return dstd;
    }
     
      private Mat filtroCanny(Mat segmentada) {
          int umbralmin=32;
          int umbralmax=100;            
            Imgproc.Canny(segmentada, segmentada, umbralmin,umbralmax);
            
        return segmentada;
    }
     /* private Mat TransfHough(Mat segmentada) {       
            Mat circles = new Mat();
           Imgproc.HoughCircles(segmentada, circles, Imgproc.CV_HOUGH_GRADIENT,1,60, 200, 20, 30, 0);
           //Imgproc.minEnclosingCircle(null, null, radius);
            System.out.println("#rows " + circles.rows() + " #cols " + circles.cols());
    double x = 0.0;
    double y = 0.0;
    int r = 0;

    for( int i = 0; i < circles.rows(); i++ )
    {
      double[] data = circles.get(i, 0);
      for(int j = 0 ; j < data.length ; j++){
           x = data[0];
           y = data[1];
           r = (int) data[2];
      }
      Point center = new Point(x,y);
      // circle center
      Core.circle( segmentada, center, 3, new Scalar(0,255,0), -1);
      // circle outline
      Core.circle( segmentada, center, r, new Scalar(0,0,255), 1);

        
       }       
            return segmentada;
      }*/
      
       public Vector<Mat> TransfHough(Mat edges){
     
           Ventana ventana9 = new Ventana(convertir(imagenCopia),0,2);
           Mat color = imagenCopia;
          edges= descompCanImg(imagenCopia,2) ;
        
    Mat circles = new Mat();
    Vector<Mat> circlesList = new Vector<Mat>();


      Imgproc.HoughCircles(edges, circles, Imgproc.CV_HOUGH_GRADIENT, 1, 200, 1, 30, 20, 40  );
    //Imgproc.HoughCircles(edges, circles, Imgproc.CV_HOUGH_GRADIENT, 1, 1) ;
      System.out.println("#rows " + circles.rows() + " #cols " + circles.cols());   
      
    double x = 0.0;
    double y = 0.0;
    int r = 0;

    for( int i = 0; i < circles.rows(); i++ )
    {
      double[] data = circles.get(i, 0);
      for(int j = 0 ; j < data.length ; j++){
           x = data[0];
           y = data[1];
           r = (int) data[2];
      }
      Point center = new Point(x,y);
      // circle center
      Core.circle( color, center, 2, new Scalar(255,0,0), -1);
      // circle outline
      Core.circle( color, center, r, new Scalar(0,255,0), 1);

     Ventana ventana8 = new Ventana(convertir(color),1,2);

     /*
     Rect bbox = new Rect((int)Math.abs(x-r), (int)Math.abs(y-r), (int)2*r, (int)2*r);
     Mat croped_image = new Mat(edges, bbox);
     Imgproc.resize(croped_image, croped_image, new Size(160,160));
     circlesList.add(croped_image);
     //Ventana ventana10 = new Ventana(convertir(edges),2,2);
             */
    }

    return circlesList;
}
}

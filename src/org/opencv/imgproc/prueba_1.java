package org.opencv.imgproc;
import com.sun.javafx.geom.Vec2f;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.paint.Color.color;
import javax.imageio.ImageIO;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import static org.opencv.core.Core.addWeighted;
import static org.opencv.core.Core.convertScaleAbs;
import static org.opencv.core.Core.countNonZero;
import static org.opencv.core.CvType.CV_16S;
import static org.opencv.core.CvType.CV_8UC1;
import static org.opencv.core.Mat.zeros;
import static org.opencv.imgproc.Imgproc.BORDER_DEFAULT;

public class prueba_1 {
    //static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}
    public static void main(String args[]){
        System.out.println("Cargar y Mostrar una Imagen con OpenCV en Java y Netbeans");
        System.loadLibrary("opencv_java2413");
        Procesar_1 procesar = new Procesar_1();
    }
}
class Procesar_1 {
    private Mat imagen,imagenCopia,imgc;

    public Procesar_1(){
        imagenCopia = Highgui.imread("C:\\Program Files\\Fotos_CICS_2\\fotoIPWebCam6.jpg",Highgui.CV_LOAD_IMAGE_COLOR);
        //15,19
        //imagenCopia = Highgui.imread("C:\\Program Files\\Fotos_CICS\\fotoIPWebCam48.jpg",Highgui.CV_LOAD_IMAGE_COLOR);
        //imagenCopia = Highgui.imread("C:\\Program Files\\Fotos_CICS\\fotoIPWebCam50.jpg",Highgui.CV_LOAD_IMAGE_COLOR);
        //imagenCopia = Highgui.imread("C:\\Program Files\\Fotos_CICS\\fotoIPWebCam86.jpg",Highgui.CV_LOAD_IMAGE_COLOR);
        //imagen=Highgui.imread("C:\\Program Files\\Fotos_CICS\\fotoIPWebCam52.jpg",Highgui.CV_LOAD_IMAGE_COLOR);
        //imagen = Highgui.imread("C:\\Program Files\\Fotos_CICS\\prueba4.jpg",Highgui.CV_LOAD_IMAGE_COLOR);
        //imagenCopia=imagen.clone();
        //imgc=Highgui.imread("C:\\Program Files\\Fotos_CICS\\pterigion.jpg",Highgui.CV_LOAD_IMAGE_COLOR);
        imgc=Highgui.imread("C:\\Program Files\\Fotos_CICS\\fotoIPWebCam86.jpg",Highgui.CV_LOAD_IMAGE_COLOR);
        //imagenCopia=imgc.clone();
        if (!imagenCopia.empty()){
            
            Point[] vertices=new Point[3];
            vertices[0]=new Point(1,1);
            int contador=0;
            Imgproc.resize(imagenCopia, imagenCopia, new Size(540,720));
            imagen=imagenCopia.clone();
            //Ventana v1=new Ventana(convertir(imagenCopia),0,1);
                        
            /*Ventana v3=new Ventana(convertir(imagenCopia),1,0);7
            v3.addMouseListener(
                    new MouseAdapter(){
                        @Override
                        public void mousePressed(MouseEvent e){ 
                           if (contador<3){
                               System.out.println(e.getX()+","+e.getY());
                               //Core.circle(imagenCopia, new Point(e.getX(),e.getY()),150, new Scalar(255,255,0));
                               //vertices[contador]=new Point(e.getX(),e.getY());
                           }
                        }
                    }
            );
            int x,y,x2,y2;
            x=345;y=295;
            x2=345;y2=260;
            Core.circle(imagenCopia, new Point(x,y),100, new Scalar(255,255,0));
            Core.circle(imagenCopia, new Point(x,y),1, new Scalar(255,255,0));
            Core.circle(imagenCopia, new Point(x2,y2),100, new Scalar(255,255,0));
            Core.circle(imagenCopia, new Point(x2,y2),1, new Scalar(255,255,0));*/
            int areaT=0,areaP=0;
            double por;
            imagenCopia=detectaPterigion(imagenCopia,30,30,30);
            areaP=detectaAreaPterigion(imagenCopia);
            areaT=detectaEsclerotica(imagenCopia,60,60,60)+areaP;
            por=((areaP*100)/areaT);
            Ventana v2=new Ventana(convertir(imagenCopia),0,0);
            System.out.println("Area total:"+areaT+"\tArea Afectada:"+areaP+"\tPorcentaje:"+por);
           // imagenCopia=vueltaDosPterigion(imagenCopia);
            //Ventana v3=new Ventana(convertir(imagenCopia),1,1);
        }else{
            System.out.println("\tImagen NO encontrada");
        }
    }
    public void mouseClicked(MouseEvent e){
        int x=e.getX();
        int y=e.getY();
        System.out.println(x+","+y);
    }
    private Mat Segmenta(Mat img_ana){
        
        //CvSeq ptr = new CvSeq();
        return img_ana;
    }
    private Mat detectaPterigion(Mat img_ana,int val1,int val2,int val3){
        int r=200,g=125,b=115;
        for (int y=0;y<img_ana.rows();y++){
            for(int x=0;x<img_ana.cols();x++){
                double[] color=img_ana.get(y, x);
                if(color[2]>=r-val1 && color[2]<=r+val1 && color[1]>=g-val2 && color[1]<=g+val2 && color[0]>=b-val3 && color[0]<=b+val3){
                color[0]=0;
                color[1]=255;
                color[2]=255;    
                }
                img_ana.put(y, x, color);
            }
        }
        return img_ana;
    }
    private int detectaEsclerotica(Mat img_ana,int val1,int val2,int val3){
        int r=190,g=187,b=181,area=0;
        for (int y=0;y<img_ana.rows();y++){
            for(int x=0;x<img_ana.cols();x++){
                double[] color=img_ana.get(y, x);
                if(color[2]>=r-val1 && color[2]<=r+val1 && color[1]>=g-val2 && color[1]<=g+val2 && color[0]>=b-val3 && color[0]<=b+val3){
                    area++;
                }
                img_ana.put(y, x, color);
            }
        }
        return area;
    }
    private int detectaAreaPterigion(Mat img_ana){
        int area=0;
        for (int y=0;y<img_ana.rows();y++){
            for(int x=0;x<img_ana.cols();x++){
                double[] color=img_ana.get(y, x);
                if(color[2]==255 && color[1]==255 && color[0]==0){
                    area++;
                }
            }
        }
        return area;
    }
    private Mat analizarMelanoma(Mat img)
    {       
            int totalP,areaM,tamImg=img.width()*img.height() ;
            
            img= dameLaDona(img) ;
            Mat img2=dameLaDona(imagenCopia) ;
            img2=descompCanImg(img2,1) ;
            img2=umbralizarImg(img2,254,255) ;
            
            img=blurearImg(img,25) ;
            img=descompCanImg(img,1) ;
//            Ventana v= new Ventana (convertir(img2),0,0) ;
            totalP = tamImg-countNonZero(img2);
            
            img=umbralizarImg(img,30,150) ;
            img=umbralizarImg(img,0,255) ;
            areaM = tamImg- countNonZero(img);
            System.out.println("El area afectada por melanoma es: "+(areaM*100)/totalP+ "%");
            System.out.println("El area de iris abarca: "+totalP);
            System.out.println("El total de pixeles es: "+tamImg);
            //addWeighted(descompCanImg(imagenCopia1,2),1,img,0.3,0.0,img) ;
//            Ventana v1 = new Ventana(convertir(img),1,0);
            
            return img ;
    }
    private Mat dameLaDona(Mat img1) {
        double [] iris= segmentarIris(img1) ;
        double [] pupila=segmentarPupila(img1) ;
        
        Size sizeA = img1.size();
        Mat  max=img1.clone() ;
        
        double[] data ;
        for (int i = 0; i < sizeA.height; i++)
            for (int j = 0; j < sizeA.width; j++) {
                 if ((Math.pow(iris[0]-j,2)+Math.pow(iris[1]-i,2)>= Math.pow(iris[2],2)) || (Math.pow(pupila[0]-j,2)+Math.pow(pupila[1]-i,2)<= Math.pow(pupila[2],2)) )
                    {   data = img1.get(i, j);
                        data[0]=255 ;
                        data[1]=255 ;
                        data[2]=255 ;
                        max.put(i, j, data);
                    }
       
    }
        return max;
    }
    private double[] segmentarIris(Mat img){
            /*Imagen original*/
            Image imagenMostrar = convertir(img);
            //Ventana ventana = new Ventana(imagenMostrar,0,0);
            /*Descomponer canales*/
            img=descompCanImg(img,1) ;
            //Ventana ventana3 = new Ventana(convertir(img),1,0);
            /*Filtro Gauss*/
            img=blurearImg(img,25) ;
            //Ventana ventana31 = new Ventana(convertir(img),2,0);
            /*Umbralizado*/
           // img=umbralizarIris(img) ;
            img=umbralizarImg(img,100,150) ;
            //Ventana ventana4 = new Ventana(convertir(img),0,0);
            /* Erosionar*/
            img=eriosionarImg(img) ;
            //Ventana ventana5 = new Ventana(convertir(img),1,1);
            /* Erosionar*/
            img=dilatarImg(img) ;
            //Ventana ventana6 = new Ventana(convertir(img),2,1);
            /*Canny*/
            //imagen=filtroCanny(imagen) ;
            img=umbralizarImg(img,0,255) ;
            //Ventana ventana7 = new Ventana(convertir(img),0,2);
             /*Transformada Hough*/
            return TransfHough(img,1, 200, 1, 10, 100, 150) ;
     }
     private double[] segmentarPupila(Mat img){
         /*Imagen original*/
            Image imagenMostrar = convertir(img);
            //Ventana ventana = new Ventana(imagenMostrar,0,0);

            img=descompCanImg(img,2) ;
            //Ventana ventana3 = new Ventana(convertir(img),1,0);
            
            /*Umbralizado*/
            img=umbralizarImg(img,30,100) ;
            //Ventana ventana4 = new Ventana(convertir(img),2,0);
             
            /* Erosionar*/
            img=eriosionarImg(img) ;
            //Ventana ventana5 = new Ventana(convertir(img),0,1);
            
            /* Dilatar*/
            img=dilatarImg(img) ;
            //Ventana ventana6 = new Ventana(convertir(img),1,1);
            
            /*Canny*/
            img=filtroCanny(img) ;
            //img=umbralizarImg(img,0,255) ;
            //Ventana ventana7 = new Ventana(convertir(img),2,1);
            
            
             /*Transformada Hough*/
             
            //System.out.println(circlesList);
            return TransfHough(img,1, 200, 1, 10, 30, 80)  ;
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
     private Mat umbralizarImg(Mat canalRojo,int min, int max) {
        Imgproc.threshold(canalRojo, canalRojo, min, max, Imgproc.THRESH_BINARY);
        return canalRojo;
    }
     private Mat umbralizarIris(Mat canalRojo) {
        Imgproc.threshold(canalRojo, canalRojo, 50, 100, Imgproc.THRESH_BINARY);
        return canalRojo;
    }
     private Mat blurearImg(Mat canalAzul,int val) {
        Imgproc.medianBlur(canalAzul, canalAzul, val);
        return canalAzul;
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
            int erosion_size = 1;
            Size s = new Size(2*erosion_size + 1, 2*erosion_size+1);
            Point p = new Point(erosion_size, erosion_size);
            Mat element = Imgproc.getStructuringElement( Imgproc.MORPH_ELLIPSE,s,p);
            Imgproc.erode(umbralizada, dste, element);
        return dste;
    }
     private Mat dilatarImg(Mat umbralizada) {
            Mat dstd = umbralizada.clone();
            int dilatacion_size = 1;
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
     private double[] TransfHough(Mat edges,int inv, int distMinCir,int umbMin, int umbMax, int radMin, int radMax){
 
           Mat color = imagenCopia;
           Mat circles = new Mat();
           double[] data=null ;
           //Vector<Mat> circlesList = new Vector<Mat>();
           Imgproc.HoughCircles(edges, circles, Imgproc.CV_HOUGH_GRADIENT,inv,distMinCir,umbMin,umbMax,radMin,radMax);
      //Imgproc.HoughCircles(edges, circles, Imgproc.CV_HOUGH_GRADIENT, 1, 200, 1, 10, 20, 40  );
    //Imgproc.HoughCircles(edges, circles, Imgproc.CV_HOUGH_GRADIENT, 1, 50) ;
    
           System.out.println("#rows " + circles.rows() + " #cols " + circles.cols());   
           double x = 0.0;
           double y = 0.0;
           int r = 0;

           for( int i = 0; i < circles.rows(); i++ )
            {
                data = circles.get(i, 0);
                for(int j = 0 ; j < data.length ; j++)
                {
                    x = data[0];
                    y = data[1];
                    r = (int) data[2];
                }
                Point center = new Point(x,y);
                
      // circle center
                Core.circle( color, center, 1, new Scalar(0,0,0), -1);
      // circle outline
                Core.circle( color, center, r, new Scalar(0,255,0), 1);
                //Ventana ventana8 = new Ventana(convertir((color)),0,2);

     /*
            Rect bbox = new Rect((int)Math.abs(x-r), (int)Math.abs(y-r), (int)2*r, (int)2*r);
            Mat croped_image = new Mat(color, bbox);
            Imgproc.resize(croped_image, croped_image, new Size(200,200));
            circlesList.add(croped_image);
            Ventana ventana9 = new Ventana(convertir(croped_image),1,2);
       */      
            }

    return data;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import org.opencv.core.Core;
import static org.opencv.core.Core.convertScaleAbs;
import static org.opencv.core.CvType.CV_16S;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Point;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;
import static org.opencv.imgproc.Imgproc.BORDER_DEFAULT;
import static org.opencv.imgproc.Imgproc.Sobel;
import org.opencv.imgproc.Ventana;

/**
 *
 * @author laloe
 */
public class Segmentador {

    public Segmentador() {

    }
    public  Mat dameLaDona(Mat img1) {
        double[] iris = segmentarIris(img1);
        double[] pupila = segmentarPupila(img1);

        Size sizeA = img1.size();
        Mat max = img1.clone();

        double[] data;
        for (int i = 0; i < sizeA.height; i++) {
            for (int j = 0; j < sizeA.width; j++) {
                if ((Math.pow(iris[0] - j, 2) + Math.pow(iris[1] - i, 2) >= Math.pow(iris[2], 2)) || (Math.pow(pupila[0] - j, 2) + Math.pow(pupila[1] - i, 2) <= Math.pow(pupila[2], 2))) {
                    data = img1.get(i, j);
                    data[0] = 255;
                    data[1] = 255;
                    data[2] = 255;
                    max.put(i, j, data);
                }

            }
        }
        return max;
    }
    public double[] segmentarIris(Mat img) {
        /*Imagen original*/
        Image imagenMostrar = convertir(img);
        //img=dameLaDonaMayor(img);
        //Ventana ventana = new Ventana(convertir(img),0,0);
            /*Descomponer canales*/
        img = descompCanImg(img, 1);
        //Ventana ventana3 = new Ventana(convertir(img),1,0);
            /*Filtro Gauss*/
        img = blurearImg(img, 31);
        int scale = 1;
        int delta = 0;
        int ddepth = CV_16S;
        Mat grad_x = null, grad_y;
        Mat abs_grad_x = null, abs_grad_y;
        Sobel(img, img, ddepth, 1, 0, 3, scale, delta, BORDER_DEFAULT);
        convertScaleAbs(img, img);
        //Ventana ventana31 = new Ventana(convertir(img), 2, 0);

        //img = blurearImg(img, 25);
        //Ventana ventana31 = new Ventana(convertir(img),2,0);
            /*Umbralizado*/
        // img=umbralizarIris(img) ;
        //img = umbralizarImg(img, 150, 200);
        //Ventana ventana4 = new Ventana(convertir(img),1,0);
            /* Erosionar*/
        //img = eriosionarImg(img);
        //Ventana ventana5 = new Ventana(convertir(img),1,1);
            /* Erosionar*/
        img = dilatarImg(img);
        img = eriosionarImg(img);
            //Ventana ventana6 = new Ventana(convertir(img),2,1);
            /*Canny*/
        //imagen=filtroCanny(imagen) ;
        //img = umbralizarImg(img,30, 255);
        //Ventana ventana7 = new Ventana(convertir(img),1,0);
        // img = eriosionarImg(img);
       //Ventana ventana7 = new Ventana(convertir(img), 1, 0);
        /*Transformada Hough*/

        return TransfHough(img, 1, 200, 1, 10, 100, 170);
    }
    public Mat limitaIris(Mat img1) {

        double[] iris = segmentarIris(img1);
        iris[2] = iris[2] * 0.8;
        Size sizeA = img1.size();
        Mat max = img1.clone();

        double[] data;
        for (int i = 0; i < sizeA.height; i++) {
            for (int j = 0; j < sizeA.width; j++) {
                if ((Math.pow(iris[0] - j, 2) + Math.pow(iris[1] - i, 2) >= Math.pow(iris[2], 2))) {
                    data = img1.get(i, j);
                    data[0] = 255;
                    data[1] = 255;
                    data[2] = 255;
                    max.put(i, j, data);
                }

            }
        }
        return max;
    }
    public double[] segmentarPupila(Mat img) {
        /*Imagen original*/
        Image imagenMostrar = convertir(img);
        // Ventana ventana = new Ventana(imagenMostrar, 0, 0);
        img = limitaIris(img);
        //Ventana ventana3 = new Ventana(convertir(img), 1, 0);
        img = descompCanImg(img, 2);
        //Ventana ventana4 = new Ventana(convertir(img), 2, 0);

        /*Umbralizado*/
        //img = umbralizarImg(img, 60, 80);
        img = blurearImg(img, 31);
        int scale = 1;
        int delta = 0;
        int ddepth = CV_16S;
        Mat grad_x = null, grad_y;
        Mat abs_grad_x = null, abs_grad_y;
        Sobel(img, img, ddepth, 1, 0, 3, scale, delta, BORDER_DEFAULT);
        convertScaleAbs(img, img);
       // Ventana ventana4 = new Ventana(convertir(img), 1, 0);

        /* Dilatar*/
        img = dilatarImg(img);
        //Ventana ventana6 = new Ventana(convertir(img), 1, 1);
/* Erosionar*/
        img = eriosionarImg(img);
        //Ventana ventana5 = new Ventana(convertir(img), 0, 1);
        /*Canny*/
        //img = filtroCanny(img);
        //img=umbralizarImg(img,0,255) ;
        //Ventana ventana7 = new Ventana(convertir(img), 2, 1);

        /*Transformada Hough*/
        //System.out.println(circlesList);
        return TransfHough(img, 1, 200, 1, 10, 30, 70);
    }
    public Image convertir(Mat imagen) {
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
        return (Image) bufImage;
    }
    public Mat umbralizarImg(Mat canalRojo, int min, int max) {
        Imgproc.threshold(canalRojo, canalRojo, min, max, Imgproc.THRESH_BINARY);
        return canalRojo;
    }
    public Mat umbralizarIris(Mat canalRojo) {
        Imgproc.threshold(canalRojo, canalRojo, 50, 100, Imgproc.THRESH_BINARY);
        return canalRojo;
    }
    public Mat blurearImg(Mat canalAzul, int val) {
        Imgproc.medianBlur(canalAzul, canalAzul, val);
        return canalAzul;
    }
    public Mat escalaGrayImg(Mat img) {
        Imgproc.cvtColor(img, img, Imgproc.COLOR_RGB2GRAY);
        return img;
    }
    public Mat descompCanImg(Mat grayscale, int canal) {
        List<Mat> rgb = new ArrayList<Mat>(3);
        Core.split(grayscale, rgb);
        return rgb.get(canal);
    }
    public Mat eriosionarImg(Mat umbralizada) {
        Mat dste = umbralizada.clone();
        int erosion_size = 5;
        Size s = new Size(2 * erosion_size + 1, 2 * erosion_size + 1);
        Point p = new Point(erosion_size, erosion_size);
        Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_ELLIPSE, s, p);
        Imgproc.erode(umbralizada, dste, element);
        return dste;
    }
    public Mat dilatarImg(Mat umbralizada) {
        Mat dstd = umbralizada.clone();
        int dilatacion_size = 5;
        Size sd = new Size(2 * dilatacion_size + 1, 2 * dilatacion_size + 1);
        Point pd = new Point(dilatacion_size, dilatacion_size);
        Mat elementd = Imgproc.getStructuringElement(Imgproc.MORPH_ELLIPSE, sd, pd);
        Imgproc.dilate(umbralizada, dstd, elementd);
        return dstd;
    }
    public Mat filtroCanny(Mat segmentada) {
        int umbralmin = 32;
        int umbralmax = 100;
        Imgproc.Canny(segmentada, segmentada, umbralmin, umbralmax);

        return segmentada;
    }
    public double[] TransfHough(Mat edges, int inv, int distMinCir, int umbMin, int umbMax, int radMin, int radMax) {

        Mat circles = new Mat();
        double[] data = null;
        //Vector<Mat> circlesList = new Vector<Mat>();
        Imgproc.HoughCircles(edges, circles, Imgproc.CV_HOUGH_GRADIENT, inv, distMinCir, umbMin, umbMax, radMin, radMax);
        //Imgproc.HoughCircles(edges, circles, Imgproc.CV_HOUGH_GRADIENT, 1, 200, 1, 10, 20, 40  );
        //Imgproc.HoughCircles(edges, circles, Imgproc.CV_HOUGH_GRADIENT, 1, 50) ;

        System.out.println("#rows " + circles.rows() + " #cols " + circles.cols());
        double x = 0.0;
        double y = 0.0;
        int r = 0;

        for (int i = 0; i < circles.rows(); i++) {
            data = circles.get(i, 0);
            for (int j = 0; j < data.length; j++) {
                x = data[0];
                y = data[1];
                r = (int) data[2];
            }
            Point center = new Point(x, y);

            // circle center
//            Core.circle(color, center, 1, new Scalar(0, 0, 0), -1);
            // circle outline
            //          Core.circle(color, center, r, new Scalar(0, 255, 0), 1);
            //Ventana ventana8 = new Ventana(convertir((color)),0,2);
            //ventana8.setTitle("Houg");
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
    public BufferedImage Mat2BufferedImage(Mat m){
    //source: http://answers.opencv.org/question/10344/opencv-java-load-image-to-gui/
    //Fastest code
    //The output can be assigned either to a BufferedImage or to an Image
     int type = BufferedImage.TYPE_BYTE_GRAY;
     if ( m.channels() > 1 ) {
         type = BufferedImage.TYPE_3BYTE_BGR;
     }
     int bufferSize = m.channels()*m.cols()*m.rows();
     byte [] b = new byte[bufferSize];
     m.get(0,0,b); // get all the pixels
     BufferedImage image = new BufferedImage(m.cols(),m.rows(), type);
     final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
     System.arraycopy(b, 0, targetPixels, 0, b.length);  
     return image;
    }
}

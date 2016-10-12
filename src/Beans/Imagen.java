/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author David Pantaleón
 */
public class Imagen {

    private BufferedImage fotografia;
    private int alto;
    private int ancho;
    private String ruta;

    public Imagen() {
    }

    public Imagen(String ruta) {
        try {
            this.ruta = ruta;
            fotografia = ImageIO.read(new File(ruta));
            alto = fotografia.getHeight();
            ancho = fotografia.getWidth();
        } catch (IOException ex) {
            Logger.getLogger(Imagen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Imagen(BufferedImage fot) {
        fotografia = fot;
        alto = fot.getHeight();
        ancho = fot.getWidth();
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public BufferedImage getFotografia() {
        return fotografia;
    }

    public int getAlto() {
        return alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setFotografia(BufferedImage fot) {
        fotografia = fot;
    }

    public void setAlto(int alt) {
        alto = alt;
    }

    public void setAncho(int anc) {
        ancho = anc;
    }

    public Mat getMatFotografia() {
        byte[] pixels = ((DataBufferByte) fotografia.getRaster().getDataBuffer())
                .getData();

// Create a Matrix the same size of image
        Mat image = new Mat(alto, ancho, CvType.CV_8UC3);
// Fill Matrix with image values
        image.put(0, 0, pixels);
        Imgproc.resize(image, image, new Size(480, 640));
        return image;
    }
}

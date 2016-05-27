/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.util.Imagen;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventAdapter;

/**
 *
 * @author David Pantaleón
 */
public class CapturadorImagen extends JPanel{
    private EmbeddedMediaPlayerComponent player=null;
    private BufferedImage ima=null;
    static{
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:\\Program Files\\VideoLAN\\VLC");
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
    }
    private String video=null;
    private Image imagen=null;
    public CapturadorImagen(){
        this.video="http://192.168.1.150:8080/video";
        //this.setBackground(new java.awt.Color(204, 204, 204));
        this.setMinimumSize(new java.awt.Dimension(100, 100));
        this.setPreferredSize(new java.awt.Dimension(400, 300));
        this.setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));
        player=null;               
        
    }
    public void iniciar(){
        this.removeAll();
        player = new EmbeddedMediaPlayerComponent();        
        player.setSize(this.getSize()); 
        this.add(player);
        this.updateUI();
        player.setVisible(true);
        player.getMediaPlayer().playMedia(video);
    }
    public void parar(){
        player.setVisible(false);
        player.getMediaPlayer().stop();
        player=null;
    }
    public void pausar(){
        player.getMediaPlayer().setPause( player.getMediaPlayer().isPlaying()?true:false );
        
    }
    public void capturar(){
        System.out.println("Captura");
        
        ima=player.getMediaPlayer().getSnapshot();
        try{
        ImageIO.write(ima, "jpg",new File("fotoIPWebCam.jpg"));
        }catch(Exception e){}
        this.parar();
        this.removeAll();
        JLabel label= new JLabel(new ImageIcon(((new ImageIcon(ima)).getImage()).getScaledInstance(this.getWidth(),this.getHeight(), java.awt.Image.SCALE_SMOOTH)));

        label.setSize(this.getWidth(), this.getHeight());
        this.add(label);
        this.updateUI();
    }
    /*public static void main(String[] args){
        Frame f=new Frame("Capturador V1.0");
    }*/
}

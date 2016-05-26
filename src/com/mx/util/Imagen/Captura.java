package com.mx.util.Imagen;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
/**
 *
 * @author Eduardo
 */
public class Captura extends JPanel {
    private EmbeddedMediaPlayerComponent player=null;
    private BufferedImage ima=null;
    static{
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:\\Program Files\\VideoLAN\\VLC");
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
        
    }
    private String video=null;
    private Image imagen=null;
    public Captura(String video){
        this.video="http://"+video+":8080/video";
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
        ImageIO.write(ima, "jpg",new File("C:\\Users\\laloe\\Desktop\\foto.jpg"));
        }catch(Exception e){}
        this.parar();
        this.removeAll();
        JLabel label= new JLabel(new ImageIcon(((new ImageIcon(ima)).getImage()).getScaledInstance(this.getWidth(),this.getHeight(), java.awt.Image.SCALE_SMOOTH)));

        label.setSize(this.getWidth(), this.getHeight());
        this.add(label);
        this.updateUI();
    }
   
    public static void main(String[] args){
        Frame f=new Frame("Capturador V1.0");
    }
}
class Frame extends JFrame implements ActionListener{
        Captura c=null;
        public Frame(String t){
            JFrame frame=new JFrame(t);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);//centrar en pantalla
            JButton b=new JButton("captura") ;
            b.addActionListener(this);
            c=new Captura("192.168.1.149");
            c.setVisible(true);
            frame.getContentPane().add(c, java.awt.BorderLayout.CENTER);        
            frame.getContentPane().add(b, java.awt.BorderLayout.SOUTH);        
            frame.pack();
            c.iniciar();
        }
       @Override
    public void actionPerformed(ActionEvent ae) {
        c.capturar();
        c.iniciar();
    }
}

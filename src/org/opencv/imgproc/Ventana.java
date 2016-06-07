
package org.opencv.imgproc;

import java.awt.Image;
import javax.swing.ImageIcon;


public class Ventana extends javax.swing.JFrame {
     
    public Ventana(Image img ,int f, int c) {
        initComponents();
        jLabel1.setIcon(new ImageIcon(img));
        setVisible(true);
        setSize(img.getWidth(null), img.getHeight(null));
        setLocation(img.getWidth(null)*f, img.getHeight(null)*c);
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 366, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 286, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

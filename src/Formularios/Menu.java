/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Beans.MedicoBean;
import Beans.Sesion;
import Clases.Medico;
import Clases.MedicoAdministrador;
import Clases.ServicioRespuesta;

/**
 *
 * @author laloe
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    Sesion sesion=null;
    Object medico;
    public Menu(Sesion s) {
        this.sesion=s;
        initComponents();
        if (sesion.getRol().equals("Administrador")){
            medico=new MedicoAdministrador(s.getCedulaProfMedico());   
        }else{
            medico=new Medico(s.getCedulaProfMedico());
            //ocultarComponentes();
        }
        ServicioRespuesta respuesta=((Medico)medico).validarMedico();
        MedicoBean datos=(MedicoBean)respuesta.getResult();
        System.out.println(datos.getCedulaProfesional());
        System.out.println(datos.getNombre()+" "+datos.getApellidoPaterno()+" "+datos.getApellidoMaterno());
        System.out.println(datos.getDireccion());
        System.out.println(datos.getFechaNacimiento());
        System.out.println(datos.getEspecialidad());
        System.out.println(datos.getSexo());
        System.out.println(datos.getTelefono());
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        consulta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        consulta.setText("Registrar Consulta");
        consulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                consultaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(consulta)
                .addContainerGap(242, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(consulta)
                .addContainerGap(218, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void consultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_consultaMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        ((Medico)medico).GenerarConsulta(this);
        this.setVisible(true);
    }//GEN-LAST:event_consultaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel consulta;
    // End of variables declaration//GEN-END:variables
}

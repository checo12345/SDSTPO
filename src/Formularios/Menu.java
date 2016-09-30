/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Beans.Medicamento;
import Beans.MedicoBean;
import Beans.Sesion;
import Clases.Medico;
import Clases.MedicoAdministrador;
import Clases.ServicioRespuesta;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author laloe
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    Sesion sesion = null;
    Object medico;

    public Menu(Sesion s) {
        this.sesion = s;
        initComponents();
        if (sesion.getRol().equals("Administrador")) {
            medico = new MedicoAdministrador(s.getCedulaProfMedico());
        } else {
            medico = new Medico(s.getCedulaProfMedico());
            ocultarComponentes();
        }
        ServicioRespuesta respuesta = ((Medico) medico).validarMedico();
        MedicoBean datos = (MedicoBean) respuesta.getResult();
        System.out.println(datos.getCedulaProfesional());
        System.out.println(datos.getNombre() + " " + datos.getApellidoPaterno() + " " + datos.getApellidoMaterno());
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
        gestionMed = new javax.swing.JLabel();
        gestionarPac = new javax.swing.JLabel();
        cerrarSes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        consulta.setText("Registrar Consulta");
        consulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                consultaMouseClicked(evt);
            }
        });

        gestionMed.setText("Gestionar Medicos");
        gestionMed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gestionMedMouseClicked(evt);
            }
        });

        gestionarPac.setText("Gestionar Pacientes");
        gestionarPac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gestionarPacMouseClicked(evt);
            }
        });

        cerrarSes.setText("cerrar sesion");
        cerrarSes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarSesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gestionarPac)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(consulta)
                        .addGap(90, 90, 90)
                        .addComponent(gestionMed)))
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cerrarSes)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cerrarSes)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(consulta)
                    .addComponent(gestionMed))
                .addGap(41, 41, 41)
                .addComponent(gestionarPac)
                .addContainerGap(163, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ocultarComponentes() {
        gestionMed.setVisible(false);
    }
    private void consultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_consultaMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        ((Medico) medico).GenerarConsulta(this);
        this.setVisible(true);
    }//GEN-LAST:event_consultaMouseClicked

    private void gestionMedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gestionMedMouseClicked
        // TODO add your handling code here:
        JPanel panel = new JPanel();
        JRadioButton rbtn1 = new JRadioButton("Registrar nuevo médico", true);
        JRadioButton rbtn2 = new JRadioButton("Actualizar datos de un médico", false);
        //Creación del Grupo de Botones:
        ButtonGroup grupo1 = new ButtonGroup();
        grupo1.add(rbtn1);
        grupo1.add(rbtn2);
        panel.setLayout(new GridLayout(2, 1));
        panel.add(rbtn1);
        panel.add(rbtn2);
        
        int desicion = JOptionPane.showOptionDialog(null, panel, "Gestión de Médicos", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (desicion == 0) {
            this.setVisible(false);
            if(rbtn1.isSelected()){
                ((MedicoAdministrador)medico).registrarMedico(this);
            }else if(rbtn2.isSelected()){
                ((MedicoAdministrador)medico).actualizarMedico(this);
            }
            this.setVisible(true);
        }
    }//GEN-LAST:event_gestionMedMouseClicked

    private void gestionarPacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gestionarPacMouseClicked
        // TODO add your handling code here:
        if(sesion.getRol().equals("Administrador")){
        JPanel panel = new JPanel();
        JRadioButton rbtn1 = new JRadioButton("Registrar nuevo paciente", true);
        JRadioButton rbtn2 = new JRadioButton("Actualizar datos de un paciente", false);
        //Creación del Grupo de Botones:
        ButtonGroup grupo1 = new ButtonGroup();
        grupo1.add(rbtn1);
        grupo1.add(rbtn2);
        panel.setLayout(new GridLayout(2, 1));
        panel.add(rbtn1);
        panel.add(rbtn2);
        
        int desicion = JOptionPane.showOptionDialog(null, panel, "Gestión de Médicos", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (desicion == 0) {
            this.setVisible(false);
            if(rbtn1.isSelected()){
                ((Medico)medico).registrarPaciente(this);
            }else if(rbtn2.isSelected()){
                ((MedicoAdministrador)medico).actualizarPaciente(this);
            }
            this.setVisible(true);
        }
        }
        else{
            this.setVisible(false);
            ((Medico)medico).registrarPaciente(this);
            this.setVisible(true);
        }
    }//GEN-LAST:event_gestionarPacMouseClicked

    private void cerrarSesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarSesMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new inicioSesion().setVisible(true);
    }//GEN-LAST:event_cerrarSesMouseClicked

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
    private javax.swing.JLabel cerrarSes;
    private javax.swing.JLabel consulta;
    private javax.swing.JLabel gestionMed;
    private javax.swing.JLabel gestionarPac;
    // End of variables declaration//GEN-END:variables
}

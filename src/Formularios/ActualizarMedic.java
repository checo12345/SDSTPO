/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Beans.MedicoBean;
import Beans.Sesion;
import Clases.MedicoAdministrador;
import Clases.ServicioRespuesta;
import DAO.ServicioDAO;
import java.awt.Color;
import java.awt.Window;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
/**
 *
 * @author David Pantaleón
 */
public class ActualizarMedic extends javax.swing.JInternalFrame {
    MedicoAdministrador med_adm;
    String nombre,apeP,apeM,dir,espe,tel,usuario,password,sexo;
    Date f_nac=new Date(1,1,1900);
    Boolean admin=false;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    int cedula_prof;
    
    public ActualizarMedic(MedicoAdministrador me_ad) {
        med_adm=me_ad;
        initComponents();
        limpiarLeyendasError();
        ocultarCampos();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtf_cedPro = new javax.swing.JTextField();
        Titulo = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        le_cedPro = new javax.swing.JLabel();
        BtnConsultar = new javax.swing.JButton();
        panelModifica = new javax.swing.JPanel();
        s_hombre = new javax.swing.JRadioButton();
        s_admin = new javax.swing.JRadioButton();
        le_espe = new javax.swing.JLabel();
        lo_usu = new javax.swing.JLabel();
        jtf_nombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        s_mujer = new javax.swing.JRadioButton();
        le_apep = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jtf_apep = new javax.swing.JTextField();
        le_telefono = new javax.swing.JLabel();
        lo_apep = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtf_tel = new javax.swing.JTextField();
        BtnLimpiar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        le_fecha = new javax.swing.JLabel();
        jtf_usu = new javax.swing.JTextField();
        jtf_pass = new javax.swing.JTextField();
        le_nombre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BtnGuardar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jtf_fecha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtf_esp = new javax.swing.JTextField();
        lo_nombre = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        le_apem = new javax.swing.JLabel();
        jtf_apem = new javax.swing.JTextField();
        lo_pas = new javax.swing.JLabel();
        jtf_dir = new javax.swing.JTextField();

        setClosable(true);
        setForeground(java.awt.Color.white);
        setIconifiable(true);
        setTitle("Gestionar Medico");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon("C:\\Users\\David Pantaleón\\Pictures\\iconosTT\\icono_min.png")); // NOI18N

        jtf_cedPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_cedProKeyPressed(evt);
            }
        });

        Titulo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Titulo.setText("Actualizar Medico");

        jLabel10.setText("Cedula Profesional");

        le_cedPro.setForeground(new java.awt.Color(255, 0, 0));
        le_cedPro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        le_cedPro.setText("Solo números");

        BtnConsultar.setText("Consultar");
        BtnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConsultarActionPerformed(evt);
            }
        });

        s_hombre.setText("Masculino");

        s_admin.setText("Administrador");

        le_espe.setForeground(new java.awt.Color(255, 0, 0));
        le_espe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        le_espe.setText("Solo acepta carateres validos (A-Z)");

        lo_usu.setForeground(new java.awt.Color(255, 0, 0));
        lo_usu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lo_usu.setText("*");

        jtf_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_nombreKeyPressed(evt);
            }
        });

        jLabel8.setText("Sexo");

        jLabel3.setText("Apellido Paterno");

        s_mujer.setSelected(true);
        s_mujer.setText("Femenino");

        le_apep.setForeground(new java.awt.Color(255, 0, 0));
        le_apep.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        le_apep.setText("Solo acepta carateres validos (A-Z)");

        jLabel12.setText("Password");

        jtf_apep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_apepKeyPressed(evt);
            }
        });

        le_telefono.setForeground(new java.awt.Color(255, 0, 0));
        le_telefono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        le_telefono.setText("Solo números");

        lo_apep.setForeground(new java.awt.Color(255, 0, 0));
        lo_apep.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lo_apep.setText("*");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Especialidad");

        jtf_tel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_telKeyPressed(evt);
            }
        });

        BtnLimpiar.setText("Limpiar");
        BtnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiarActionPerformed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Dirección");

        le_fecha.setForeground(new java.awt.Color(255, 0, 0));
        le_fecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        le_fecha.setText("Formato dd/MM/yyyy");

        le_nombre.setForeground(new java.awt.Color(255, 0, 0));
        le_nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        le_nombre.setText("Solo acepta carateres validos (A-Z)");

        jLabel2.setText("Nombre");

        BtnGuardar.setText("Guardar");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Apellido Materno");

        jtf_fecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_fechaKeyPressed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Telefono");

        jLabel11.setText("Usuario");

        jtf_esp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_espKeyPressed(evt);
            }
        });

        lo_nombre.setForeground(new java.awt.Color(255, 0, 0));
        lo_nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lo_nombre.setText("*");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Fecha Nacimiento");

        le_apem.setForeground(new java.awt.Color(255, 0, 0));
        le_apem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        le_apem.setText("Solo acepta carateres validos (A-Z)");

        jtf_apem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_apemKeyPressed(evt);
            }
        });

        lo_pas.setForeground(new java.awt.Color(255, 0, 0));
        lo_pas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lo_pas.setText("*");

        javax.swing.GroupLayout panelModificaLayout = new javax.swing.GroupLayout(panelModifica);
        panelModifica.setLayout(panelModificaLayout);
        panelModificaLayout.setHorizontalGroup(
            panelModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModificaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelModificaLayout.createSequentialGroup()
                        .addGroup(panelModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelModificaLayout.createSequentialGroup()
                                .addComponent(s_mujer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s_hombre))
                            .addGroup(panelModificaLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(le_espe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtf_esp, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelModificaLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lo_usu)
                        .addGap(89, 89, 89)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lo_pas))
                    .addGroup(panelModificaLayout.createSequentialGroup()
                        .addComponent(jtf_usu, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtf_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(s_admin))
                    .addGroup(panelModificaLayout.createSequentialGroup()
                        .addComponent(le_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(le_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelModificaLayout.createSequentialGroup()
                        .addGroup(panelModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtf_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtf_tel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtf_dir, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelModificaLayout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(BtnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(272, 272, 272)
                            .addComponent(BtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(104, 104, 104))
                        .addGroup(panelModificaLayout.createSequentialGroup()
                            .addGroup(panelModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(le_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelModificaLayout.createSequentialGroup()
                                    .addGap(68, 68, 68)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lo_nombre))
                                .addComponent(jtf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelModificaLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panelModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(le_apep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jtf_apep, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(panelModificaLayout.createSequentialGroup()
                                    .addGap(60, 60, 60)
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lo_apep)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panelModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtf_apem, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(le_apem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        panelModificaLayout.setVerticalGroup(
            panelModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModificaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(le_nombre)
                    .addComponent(le_apep)
                    .addComponent(le_apem))
                .addGap(2, 2, 2)
                .addGroup(panelModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_apep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_apem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(lo_nombre)
                    .addComponent(lo_apep))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(le_fecha)
                    .addComponent(le_telefono))
                .addGap(2, 2, 2)
                .addGroup(panelModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_dir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(le_espe)
                .addGap(1, 1, 1)
                .addGroup(panelModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(s_hombre)
                    .addComponent(jtf_esp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s_mujer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_usu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s_admin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(lo_pas)
                    .addComponent(lo_usu))
                .addGap(18, 18, 18)
                .addGroup(panelModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Titulo)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(le_cedPro, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtf_cedPro, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnConsultar)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelModifica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(le_cedPro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jtf_cedPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnConsultar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelModifica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        nombre=jtf_nombre.getText();
        apeP=jtf_apep.getText();
        System.out.println(apeP);
        apeM=jtf_apem.getText();
        try {
            f_nac=formatter.parse(jtf_fecha.getText());
        } catch (ParseException ex) {
            le_fecha.setVisible(true);
            Logger.getLogger(NuevoMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        tel=jtf_tel.getText();
        dir=jtf_dir.getText();
        if (s_mujer.isSelected()) {
            sexo="Femenino";
        }else if (s_hombre.isSelected()){
            sexo="Masculino";
        }
        espe=jtf_esp.getText();
        if (jtf_cedPro.getText().length()>0){
            cedula_prof=Integer.parseInt(jtf_cedPro.getText());
        }else{
            cedula_prof=0;
        }
        usuario=jtf_pass.getText();
        password=jtf_usu.getText();
        if (s_admin.isSelected()){
            admin=true;
        }
        
        if (validarContenidoCampos()){
            MedicoAdministrador ma=new MedicoAdministrador();
            String estatus="";
            
            if(admin==true){
                
                med_adm.cargarInfoMedico(nombre,apeP,apeM,f_nac,tel,dir,sexo,espe,cedula_prof,usuario,password, "Administrador");
            }
            else
                med_adm.cargarInfoMedico(nombre,apeP,apeM,f_nac,tel,dir,sexo,espe,cedula_prof,usuario,password,"Usuario");
            estatus=med_adm.updateNuevoMedico();
            if (estatus.equals("OK")){
                JOptionPane.showMessageDialog(null, "El medico fue actualizado exitosamente.", "Actulizar Medico.", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "El medico NO fue actulizado exitosamente.\n\tERROR:"+estatus+".", "Actulizar Medico.", JOptionPane.ERROR_MESSAGE);
            }
        } 
    }//GEN-LAST:event_BtnGuardarActionPerformed
    private void BtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarActionPerformed
        ocultarCampos();
        limpiarCampos();
        limpiarLeyendasError();
    }//GEN-LAST:event_BtnLimpiarActionPerformed
    private void jtf_nombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nombreKeyPressed
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if (Character.isDigit(c)){
            getToolkit().beep();
            evt.consume();
            le_nombre.setVisible(true);
            BtnGuardar.setEnabled(false);
        }else{
            le_nombre.setVisible(false);
            BtnGuardar.setEnabled(true);
        }
        if (jtf_nombre.getText().length()==0){
            lo_nombre.setVisible(true);
            BtnGuardar.enable(false);
        }else{
            lo_nombre.setVisible(false);
            BtnGuardar.enable(true);
        }
    }//GEN-LAST:event_jtf_nombreKeyPressed
    private void jtf_apepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_apepKeyPressed
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if (Character.isDigit(c)){
            getToolkit().beep();
            evt.consume();
            le_apep.setVisible(true);
            BtnGuardar.enable(false);
        }else{
            le_apep.setVisible(false);
            BtnGuardar.enable(true);
        }
    }//GEN-LAST:event_jtf_apepKeyPressed
    private void jtf_apemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_apemKeyPressed
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if (Character.isDigit(c)){
            getToolkit().beep();
            evt.consume();
            le_apem.setVisible(true);
            BtnGuardar.enable(false);
        }else{
            le_apem.setVisible(false);
            BtnGuardar.enable(true);
        }
    }//GEN-LAST:event_jtf_apemKeyPressed
    private void jtf_telKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_telKeyPressed
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if (Character.isLetter(c)){
            getToolkit().beep();
            evt.consume();
            le_telefono.setVisible(true);
            BtnGuardar.enable(false);
        }else{
            le_telefono.setVisible(false);
            BtnGuardar.enable(true);
        }
    }//GEN-LAST:event_jtf_telKeyPressed
    private void jtf_cedProKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_cedProKeyPressed
        // TODO add your handling code here:
        char c=evt.getKeyChar();
            if (Character.isLetter(c) /*|| contieneLetras(jtf_cedPro.getText())*/){
                getToolkit().beep();
                evt.consume();
                le_cedPro.setVisible(true);
                BtnConsultar.setEnabled(false);
            }else{
                le_cedPro.setVisible(false);
                BtnConsultar.setEnabled(true);
            }
    }//GEN-LAST:event_jtf_cedProKeyPressed
    private void jtf_espKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_espKeyPressed
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if (Character.isDigit(c)){
            getToolkit().beep();
            evt.consume();
            le_espe.setVisible(true);
            BtnGuardar.enable(false);
        }else{
            le_espe.setVisible(false);
            BtnGuardar.enable(true);
        }
    }//GEN-LAST:event_jtf_espKeyPressed
    private void jtf_fechaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_fechaKeyPressed
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if (Character.isLetter(c)){
            getToolkit().beep();
            evt.consume();
            le_fecha.setVisible(true);
            BtnGuardar.enable(false);
        }else{
            le_fecha.setVisible(false);
            BtnGuardar.enable(true);
        }
    }//GEN-LAST:event_jtf_fechaKeyPressed
    private void BtnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConsultarActionPerformed
        if (jtf_cedPro.getText().length()<=0){
            JOptionPane.showMessageDialog(null, "El campo de la cedula profesional NO debe ser vacio.\n\tVerifique y vuelva a intentarlo.", "Error en la consulta.", JOptionPane.ERROR_MESSAGE);
        }else{
            cedula_prof=Integer.parseInt(jtf_cedPro.getText());
            ServicioDAO servicio=new ServicioDAO();
            ServicioRespuesta respuesta=new ServicioRespuesta();
            MedicoBean m=new MedicoBean();
            Sesion s=new Sesion();
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        
            respuesta=servicio.getMedico(cedula_prof);
            if (respuesta.isSuccess()){
                m=(MedicoBean)respuesta.getResult();
                jtf_nombre.setText(m.getNombre());
                jtf_apep.setText(m.getApellidoPaterno());
                jtf_apem.setText(m.getApellidoMaterno());
                jtf_fecha.setText(formatter.format(m.getFechaNacimiento()));
                jtf_tel.setText(m.getTelefono());
                jtf_dir.setText(m.getDireccion());
                jtf_esp.setText(m.getEspecialidad());
                if (m.getSexo().equals("Masculino")){
                    s_mujer.setSelected(false);
                    s_hombre.setSelected(true);
                } else if (m.getSexo().equals("Femenino")){
                    s_mujer.setSelected(true);
                    s_hombre.setSelected(false);
                }else{
                    s_mujer.setSelected(false);
                    s_hombre.setSelected(false);
                }
                respuesta=servicio.getSesion(cedula_prof);
                if (respuesta.isSuccess()){
                    s=(Sesion)respuesta.getResult();
                    jtf_usu.setText(s.getUsuario());
                    jtf_pass.setText(s.getPassword());
                    if (s.getRol().equals("Administrador"))
                        s_admin.setSelected(true);
                }else{
                    JOptionPane.showMessageDialog(null, "No se encontro ningun medico con la cedula profesional ingresada.\n\tVerifique y vuelva a intentarlo.", "Error en la consulta.", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro ningun medico con la cedula profesional ingresada.\n\tVerifique y vuelva a intentarlo.", "Error en la consulta.", JOptionPane.ERROR_MESSAGE);
            }
            
            panelModifica.setVisible(true);
        }
    }//GEN-LAST:event_BtnConsultarActionPerformed
    private boolean contieneLetras(String cadena){
        boolean retorno=false;
        char a;
        for (int x=cadena.length();x>0;x--){
            a=cadena.charAt(x);
            if (Character.isLetter(a)){
                retorno=true;
                x=0;
            }
        }
        return retorno;
    }
    private void limpiarCampos(){
        jtf_nombre.setText("");
        jtf_apep.setText("");
        jtf_apem.setText("");
        jtf_fecha.setText("");
        jtf_tel.setText("");
        jtf_dir.setText("");
        jtf_esp.setText("");
        jtf_pass.setText("");
        jtf_cedPro.setText("");
        jtf_usu.setText("");
    }
    private void limpiarLeyendasError(){
        le_apem.setVisible(false);
        le_apep.setVisible(false);
        le_cedPro.setVisible(false);
        le_espe.setVisible(false);
        le_fecha.setVisible(false);
        le_nombre.setVisible(false);
        le_telefono.setVisible(false);
        lo_apep.setVisible(false);
        lo_nombre.setVisible(false);
        lo_pas.setVisible(false);
        lo_usu.setVisible(false);
    }
    private void ocultarCampos(){
        panelModifica.setVisible(false);
    }
    private boolean validarContenidoCampos(){
        boolean respuesta=true;
        if (nombre.length()==0){
            lo_nombre.setVisible(true);
            BtnGuardar.setEnabled(false);
            respuesta=false;
        }
        if (apeP.length()==0){
            lo_apep.setVisible(true);
            BtnGuardar.setEnabled(false);
            respuesta=false;
        }
        if (usuario.length()==0){        
            lo_usu.setVisible(true);
            BtnGuardar.setEnabled(false);
            respuesta=false;
        }
        if (password.length()==0){        
            lo_pas.setVisible(true);
            BtnGuardar.setEnabled(false);
            respuesta=false;
        }
        /*if (cedula_prof==0){
            lo_cedPro.setVisible(true);
            BtnGuardar.setEnabled(false);
            respuesta=false;
        }*/
        return respuesta;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnConsultar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnLimpiar;
    private javax.swing.JLabel Titulo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jtf_apem;
    private javax.swing.JTextField jtf_apep;
    private javax.swing.JTextField jtf_cedPro;
    private javax.swing.JTextField jtf_dir;
    private javax.swing.JTextField jtf_esp;
    private javax.swing.JTextField jtf_fecha;
    private javax.swing.JTextField jtf_nombre;
    private javax.swing.JTextField jtf_pass;
    private javax.swing.JTextField jtf_tel;
    private javax.swing.JTextField jtf_usu;
    private javax.swing.JLabel le_apem;
    private javax.swing.JLabel le_apep;
    private javax.swing.JLabel le_cedPro;
    private javax.swing.JLabel le_espe;
    private javax.swing.JLabel le_fecha;
    private javax.swing.JLabel le_nombre;
    private javax.swing.JLabel le_telefono;
    private javax.swing.JLabel lo_apep;
    private javax.swing.JLabel lo_nombre;
    private javax.swing.JLabel lo_pas;
    private javax.swing.JLabel lo_usu;
    private javax.swing.JPanel panelModifica;
    private javax.swing.JRadioButton s_admin;
    private javax.swing.JRadioButton s_hombre;
    private javax.swing.JRadioButton s_mujer;
    // End of variables declaration//GEN-END:variables
}

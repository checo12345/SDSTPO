/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Beans.Paciente;
import Clases.PacienteClass;
import Clases.ServicioRespuesta;
import datechooser.model.exeptions.IncompatibleDataExeption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laloe
 */
public class RegistrarPaciente extends javax.swing.JDialog {

    /**
     * Creates new form RegistrarPaciente
     */
    int idPaciente;

    public RegistrarPaciente(java.awt.Frame parent, boolean modal, int opcion) {
        super(parent, modal);
        initComponents();

        fechaNac.setDateFormat(DateFormat.getDateInstance(DateFormat.MEDIUM));
        if (opcion == 1) {
            curpPaciente.setVisible(false);
            pacienteLabel.setVisible(false);
            buscarPaciente.setVisible(false);
            jButton1.setText("Registrar");
            jButton1.setEnabled(true);
            titulo.setText("RESGISTRAR PACIENTE");
        }
        errorNombre.setVisible(false);
        errorNombre1.setVisible(false);
        errorNombre2.setVisible(false);
//        errorNombre4.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        enfermedades = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        alergias = new javax.swing.JTextPane();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        observaciones = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        apellidoP = new javax.swing.JTextField();
        errorNombre = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        errorNombre1 = new javax.swing.JLabel();
        apellidoM = new javax.swing.JTextField();
        errorNombre2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        telefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        curp = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        pacienteLabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        curpPaciente = new javax.swing.JTextField();
        deloMun = new javax.swing.JTextField();
        buscarPaciente = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        sexo = new javax.swing.JComboBox();
        tipoSangre = new javax.swing.JComboBox();
        titulo = new javax.swing.JLabel();
        fechaNac = new datechooser.beans.DateChooserCombo();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane2.setViewportView(enfermedades);

        jScrollPane3.setViewportView(alergias);

        jLabel14.setText("Enfermedades Hereditarias:");

        jLabel15.setText("Ingrese comentarios y observaciones importantes sobre el paciente:");

        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });
        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nombreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreKeyTyped(evt);
            }
        });

        observaciones.setColumns(20);
        observaciones.setRows(5);
        jScrollPane1.setViewportView(observaciones);

        jLabel2.setText("Nombre Completo:");

        jButton1.setText("Modificar");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Apellido Paterno:");

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        apellidoP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                apellidoPKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apellidoPKeyTyped(evt);
            }
        });

        errorNombre.setBackground(new java.awt.Color(255, 0, 0));
        errorNombre.setForeground(new java.awt.Color(255, 0, 0));
        errorNombre.setText("No se permiten numeros");

        jLabel4.setText("Apellido Materno:");

        errorNombre1.setBackground(new java.awt.Color(255, 0, 0));
        errorNombre1.setForeground(new java.awt.Color(255, 0, 0));
        errorNombre1.setText("No se permiten numeros");

        apellidoM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                apellidoMKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apellidoMKeyTyped(evt);
            }
        });

        errorNombre2.setBackground(new java.awt.Color(255, 0, 0));
        errorNombre2.setForeground(new java.awt.Color(255, 0, 0));
        errorNombre2.setText("No se permiten numeros");

        jLabel5.setText("Fecha de Nacimiento:");

        jLabel6.setText("Telefono:");

        telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoActionPerformed(evt);
            }
        });
        telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                telefonoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telefonoKeyTyped(evt);
            }
        });

        jLabel7.setText("CURP:");

        curp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curpActionPerformed(evt);
            }
        });

        jLabel8.setText("Sexo:");

        pacienteLabel.setText("INGRESAR CURP DEL PACIENTE A MODIFICAR:");

        jLabel11.setText("Dirección:");

        deloMun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                deloMunKeyPressed(evt);
            }
        });

        buscarPaciente.setText("Buscar");
        buscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPacienteActionPerformed(evt);
            }
        });

        jLabel12.setText("Alergias:");

        jLabel13.setText("Tipo de Sangre:");

        sexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MASCULINO", "FEMENINO" }));

        tipoSangre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A+", "A-", "B+", "B-", "O+", "O-" }));

        titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        titulo.setText("MODIFICAR PACIENTE");

        fechaNac.setFormat(2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(errorNombre)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(312, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(165, 165, 165)
                                .addComponent(jButton1)
                                .addGap(312, 312, 312))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(249, 249, 249))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deloMun, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(187, 187, 187)
                                        .addComponent(jLabel12)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(137, 137, 137))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(telefono, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(errorNombre1)
                                                .addGap(136, 136, 136))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(apellidoP)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel4)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(apellidoM))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(errorNombre2)
                                                .addGap(22, 22, 22))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel13)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(curp, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel8)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(sexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(tipoSangre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))))
                .addGap(61, 61, 61))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pacienteLabel)
                        .addGap(27, 27, 27)
                        .addComponent(curpPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(buscarPaciente)
                        .addGap(195, 195, 195))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(titulo)
                        .addGap(418, 418, 418))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pacienteLabel)
                    .addComponent(curpPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarPaciente))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(errorNombre)
                            .addComponent(errorNombre1)
                            .addComponent(errorNombre2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(apellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(apellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(curp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5)
                            .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(fechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(deloMun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(tipoSangre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void nombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyPressed
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
            errorNombre.setVisible(true);
        } else {
            errorNombre.setVisible(false);
        }
    }//GEN-LAST:event_nombreKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        PacienteClass paciente = new PacienteClass();
        ServicioRespuesta respuesta;
        if (jButton1.getText().contains("Registrar")) {
            respuesta = paciente.validarPaciente();
            if (respuesta.isSuccess()) {
                jOptionPane1.showMessageDialog(null, "Faltan Campos por Llenar", "ALERTA", jOptionPane1.INFORMATION_MESSAGE);
            } else {
                respuesta = paciente.registrarPaciente();
                if (respuesta.isSuccess()) {
                    this.dispose();
                    jOptionPane1.showMessageDialog(null, respuesta.getMensaje(), "REGISTRO DE PACIENTES", jOptionPane1.INFORMATION_MESSAGE);
                } else {
                    jOptionPane1.showMessageDialog(null, respuesta.getMensaje(), "REGISTRO DE PACIENTES", jOptionPane1.ERROR_MESSAGE);
                }
            }

        } else {
            respuesta = paciente.actualizarPaciente(idPaciente);
            if (respuesta.isSuccess()) {
                this.dispose();
                jOptionPane1.showMessageDialog(null, respuesta.getMensaje(), "ACTUALIZACIÓN DE PACIENTES", jOptionPane1.INFORMATION_MESSAGE);
            } else {
                jOptionPane1.showMessageDialog(null, respuesta.getMensaje(), "ACTUALIZACIÓN DE PACIENTES", jOptionPane1.ERROR_MESSAGE);
            }
        }

        //       Sesion user = (Sesion)respuesta.getResult() ;
        //Formulario1 formformulario1 = new Formulario1();
        //formformulario1.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void apellidoPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellidoPKeyPressed
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
            errorNombre1.setVisible(true);
        } else {
            errorNombre1.setVisible(false);
        }
    }//GEN-LAST:event_apellidoPKeyPressed

    private void apellidoMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellidoMKeyPressed
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
            errorNombre2.setVisible(true);
        } else {
            errorNombre2.setVisible(false);
        }
    }//GEN-LAST:event_apellidoMKeyPressed

    private void telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoActionPerformed

    private void telefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoKeyPressed
        /* char c=evt.getKeyChar();
        if (Character.isLetter(c)){
            getToolkit().beep();
            evt.consume();
            errorNombre4.setVisible(true);
        }
        else
        errorNombre4.setVisible(false);*/
    }//GEN-LAST:event_telefonoKeyPressed

    private void curpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_curpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_curpActionPerformed

    private void deloMunKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deloMunKeyPressed
        /*char c=evt.getKeyChar();
        if (Character.isDigit(c)){
            getToolkit().beep();
            evt.consume();
            errorNombre6.setVisible(true);
        }
        else
        errorNombre6.setVisible(false);*/
    }//GEN-LAST:event_deloMunKeyPressed

    private void buscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPacienteActionPerformed
        PacienteClass paciente = new PacienteClass();
        ServicioRespuesta respuesta = paciente.buscarPaciente();
        if (respuesta.isSuccess()) {
            Paciente p = (Paciente) respuesta.getResult();
            nombre.setText(p.getNombre());
            observaciones.setText(p.getObservacion());
            int opSexo, opTipoSangre;

            if (p.getSexo().contains("MASCULINO")) {
                opSexo = 0;
            } else {
                opSexo = 1;
            }

            if (p.getSexo().contains("A")) {
                opTipoSangre = 0;
            } else if (p.getSexo().contains("B+")) {
                opTipoSangre = 1;
            } else if (p.getSexo().contains("B-")) {
                opTipoSangre = 2;
            } else if (p.getSexo().contains("O+")) {
                opTipoSangre = 3;
            } else {
                opTipoSangre = 4;
            }

            sexo.setSelectedIndex(opSexo);
            telefono.setText(p.getTelefono());
            tipoSangre.setSelectedIndex(opTipoSangre);
            alergias.setText(p.getAlergia());
            apellidoM.setText(p.getApellidoMaterno());
            apellidoP.setText(p.getApellidoPaterno());
            curp.setText(p.getCurp());
            enfermedades.setText(p.getPadecimientos());
            deloMun.setText(p.getDireccion());
            idPaciente = p.getIdPaciente();
            /* SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String convertido = formatter.format(p.getFechaNacimiento());*/
            try {
                fechaNac.setDefaultPeriods(
                        new datechooser.model.multiple.PeriodSet(
                                new datechooser.model.multiple.Period(
                                        new java.util.GregorianCalendar(Integer.parseInt(p.getFechaNacimiento().substring(0, 4)), Integer.parseInt(p.getFechaNacimiento().substring(5, 7)) - 1, Integer.parseInt(p.getFechaNacimiento().substring(8))),
                                        new java.util.GregorianCalendar(Integer.parseInt(p.getFechaNacimiento().substring(0, 4)), Integer.parseInt(p.getFechaNacimiento().substring(5, 7)) - 1, Integer.parseInt(p.getFechaNacimiento().substring(8))))));
            } catch (IncompatibleDataExeption ex) {
                Logger.getLogger(NuevoMedico.class.getName()).log(Level.SEVERE, null, ex);
            }
            //this.dispose() ;
            jOptionPane1.showMessageDialog(null, respuesta.getMensaje(), "REGISTRO DE PACIENTES", jOptionPane1.INFORMATION_MESSAGE);
            jButton1.setEnabled(true);

        } else {
            jOptionPane1.showMessageDialog(null, respuesta.getMensaje(), "REGISTRO DE PACIENTES", jOptionPane1.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buscarPacienteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar(); 
        
        if (Character.isDigit(c)&&telefono.getText().length() <10) {
            
        }
        else{
            evt.consume();
        }
    }//GEN-LAST:event_telefonoKeyTyped

    private void nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyTyped
char c=evt.getKeyChar(); 
        
        if (Character.isDigit(c)) {
            evt.consume();
        }
        
    }//GEN-LAST:event_nombreKeyTyped

    private void apellidoPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellidoPKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar(); 
        
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_apellidoPKeyTyped

    private void apellidoMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellidoMKeyTyped
char c=evt.getKeyChar(); 
        
        if (Character.isDigit(c)) {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_apellidoMKeyTyped

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
            java.util.logging.Logger.getLogger(RegistrarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RegistrarPaciente dialog = new RegistrarPaciente(new javax.swing.JFrame(), true, 2);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    private javax.swing.JOptionPane jOptionPane1;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextPane alergias;
    public static javax.swing.JTextField apellidoM;
    public static javax.swing.JTextField apellidoP;
    public static javax.swing.JButton buscarPaciente;
    public static javax.swing.JTextField curp;
    public static javax.swing.JTextField curpPaciente;
    public static javax.swing.JTextField deloMun;
    public static javax.swing.JTextPane enfermedades;
    private javax.swing.JLabel errorNombre;
    private javax.swing.JLabel errorNombre1;
    private javax.swing.JLabel errorNombre2;
    public static datechooser.beans.DateChooserCombo fechaNac;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTextField nombre;
    public static javax.swing.JTextArea observaciones;
    public static javax.swing.JLabel pacienteLabel;
    public static javax.swing.JComboBox sexo;
    public static javax.swing.JTextField telefono;
    public static javax.swing.JComboBox tipoSangre;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}

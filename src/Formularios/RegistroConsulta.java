/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Beans.Imagen;
import Beans.MedicoBean;
import Beans.Paciente;
import Beans.Sesion;
import Clases.CapturadorImagen;
import Clases.ConsultaMedica;
import Clases.MedicoAdministrador;
import Clases.ServicioRespuesta;
import UpperEssential.UpperEssentialLookAndFeel;
import java.awt.Frame;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author laloe
 */
public class RegistroConsulta extends javax.swing.JDialog {

    /**
     * Creates new form RegistroConsulta3
     */
    private ConsultaMedica consulta = null;
    private Paciente paciente = null;
    private MedicoBean medico;
    private DefaultListModel modelo = new DefaultListModel();
    private String ip = "";
    private JButton jButton2;
    private JPanel jPanel1;
    private boolean bandera=false;
    private boolean banderacapturador=false;
    private boolean banderaPaciente=false;
private int opcioncapturador1=0;
private int opcioncapturador2=0;
    private JPanel jPanel2;
    private JPanel jPanel3;
    public RegistroConsulta(java.awt.Frame parent, boolean modal, MedicoBean m) {
        super(parent, modal);
        JPanel panel = new JPanel();
        JRadioButton rbtn1 = new JRadioButton("Utilizar transmision en vivo desde el dispistivo móvil", true);
        JRadioButton rbtn2 = new JRadioButton("Cargar imagenes desde este equipo", false);
        //Creación del Grupo de Botones:
        ButtonGroup grupo1 = new ButtonGroup();
        grupo1.add(rbtn1);
        grupo1.add(rbtn2);
        panel.setLayout(new GridLayout(2, 1));
        panel.add(rbtn1);
        panel.add(rbtn2);

        int desicion = JOptionPane.showOptionDialog(null, panel, "Selección de opción pra obtencion de Imagen", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

        if (desicion == 0) {

            if (rbtn1.isSelected()) {
                ip = JOptionPane.showInputDialog("Ingrese direccion IP: ");
                banderacapturador=true;
                opcioncapturador1=2;
                opcioncapturador2=2;
                if (ip == null) {
                    ip = "";
                    bandera=true;
                }
            } else if (rbtn2.isSelected()) {
                ip = "";
                banderacapturador=false;
                opcioncapturador1=1;
                opcioncapturador2=1;
            }
            

        } else {
            bandera=true;
        }
        initComponents();
        this.setTitle("Registro de Consulta");
        jLabel12.setText("");
        jLabel13.setText("");
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/RegPaciente.png")));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/RegPaciente.png")));
        
            fecha.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            medico = m;
            consulta = new ConsultaMedica(medico);

            doctor.setText(medico.getNombre() + " " + medico.getApellidoPaterno() + " " + medico.getApellidoMaterno());

            consulta.obtenerSiguienteIdCosnulta();
            
        registrar.setEnabled(false);
        receta.setEnabled(false);
        reporte.setEnabled(false);
        prediagnostico.setEnabled(false);
        /*nombreP.setVisible(false);
         direcc.setVisible(false);
         sexo.setVisible(false);
         sangre.setVisible(false);
         fechanac.setVisible(false);*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        motivo = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        manifestacion = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        registrar = new javax.swing.JButton();
        receta = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        reporte = new javax.swing.JButton();
        prediagnostico = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        sangre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        fecha = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        sexo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        fechanac = new javax.swing.JTextField();
        consultaPaciente = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        idPaciente = new javax.swing.JTextField();
        direcc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        doctor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nombreP = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        capturador1 = new CapturadorImagen(ip);
        jLabel13 = new javax.swing.JLabel();
        captura1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        capturador2 = new CapturadorImagen(ip);
        jLabel12 = new javax.swing.JLabel();
        captura2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        motivo.setColumns(20);
        motivo.setRows(5);
        jScrollPane1.setViewportView(motivo);

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jList1);

        jButton1.setLabel("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        registrar.setText("Registrar");
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });

        receta.setText("Crear Receta");
        //receta.setEnabled(false);
        receta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recetaActionPerformed(evt);
            }
        });

        jLabel9.setText("<html><body>Motivo de <br>la Consulta:</body></html>");

        jLabel10.setText("Manifestaciónes:");

        reporte.setText("Generar Reporte");
        reporte.setToolTipText("");
        reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporteActionPerformed(evt);
            }
        });

        prediagnostico.setText("Pre-diagnóstico");
        prediagnostico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prediagnosticoActionPerformed(evt);
            }
        });

        jButton2.setText("Quitar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        sangre.setEditable(false);
        sangre.setName(""); // NOI18N

        jLabel7.setText("<html><body>Tipo de<br> Sangre:</body></html>");

        fecha.setEditable(false);
        fecha.setText("Fecha");

        jLabel2.setText("Fecha de Consulta:");

        sexo.setEditable(false);
        sexo.setName(""); // NOI18N

        jLabel6.setText("Sexo:");

        fechanac.setEditable(false);
        fechanac.setName(""); // NOI18N

        consultaPaciente.setText("Consultar");
        consultaPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaPacienteActionPerformed(evt);
            }
        });

        jLabel5.setText("<html><body>Fecha de<br> Nacimiento:</body></html>");

        direcc.setEditable(false);
        direcc.setName(""); // NOI18N

        jLabel3.setText("CURP del Paciente:");

        jLabel8.setText("Dirección:");

        jLabel1.setText("Nombre del Doctor:");

        doctor.setEditable(false);
        doctor.setText("Dr.");

        jLabel4.setText("Nombre del Paciente:");

        nombreP.setEditable(false);
        nombreP.setName(""); // NOI18N
        nombreP.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nombreP, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(doctor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(direcc, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(fechanac, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(consultaPaciente)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sangre, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(doctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(idPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(consultaPaciente))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(nombreP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fechanac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(direcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sangre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        fecha.getAccessibleContext().setAccessibleName("");

        capturador1.setPreferredSize(new java.awt.Dimension(247, 329));

        jLabel13.setText("Imagen del Ojo Izquierdo");

        javax.swing.GroupLayout capturador1Layout = new javax.swing.GroupLayout(capturador1);
        capturador1.setLayout(capturador1Layout);
        capturador1Layout.setHorizontalGroup(
            capturador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(capturador1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel13)
                .addContainerGap(72, Short.MAX_VALUE))
        );
        capturador1Layout.setVerticalGroup(
            capturador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, capturador1Layout.createSequentialGroup()
                .addContainerGap(153, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(162, 162, 162))
        );

        captura1.setText("Capturar");
        captura1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                captura1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(captura1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(capturador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(capturador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(captura1)
                .addGap(43, 43, 43))
        );

        jPanel3.setPreferredSize(new java.awt.Dimension(366, 421));
capturador2.setPreferredSize(new java.awt.Dimension(247, 329));
        jLabel12.setText("Imagen del Ojo Derecho");

        javax.swing.GroupLayout capturador2Layout = new javax.swing.GroupLayout(capturador2);
        capturador2.setLayout(capturador2Layout);
        capturador2Layout.setHorizontalGroup(
            capturador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, capturador2Layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(63, 63, 63))
        );
        capturador2Layout.setVerticalGroup(
            capturador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(capturador2Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jLabel12)
                .addContainerGap(160, Short.MAX_VALUE))
        );

        captura2.setText("Capturar");
        captura2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                captura2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(captura2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(capturador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(capturador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(captura2)
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(192, 192, 192)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(registrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(receta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(prediagnostico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(reporte))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(358, 358, 358)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(manifestacion, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(153, 153, 153))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10)
                                .addComponent(jButton2))
                            .addGap(20, 20, 20)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(manifestacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(registrar)
                        .addGap(52, 52, 52)
                        .addComponent(receta)
                        .addGap(51, 51, 51)
                        .addComponent(reporte)
                        .addGap(57, 57, 57)
                        .addComponent(prediagnostico)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>                                                                                                                         
private void formWindowActivated(java.awt.event.WindowEvent evt) {                                     
        // TODO add your handling code here:
    if (banderacapturador==false)   {
        captura1.setText("Cargar");
        captura2.setText("Cargar");
    }
        if(bandera)
            this.dispose();
    }   
    private void consultaPacienteActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        ServicioRespuesta respuesta = consulta.validarPaciente(idPaciente.getText());
        if (respuesta.isSuccess()) {
            banderaPaciente=true;
            Paciente p = (Paciente) respuesta.getResult();
            nombreP.setVisible(true);
            direcc.setVisible(true);
            sexo.setVisible(true);
            sangre.setVisible(true);
            fechanac.setVisible(true);
            nombreP.setText(p.getNombre() + " " + p.getApellidoPaterno() + " " + p.getApellidoMaterno());
            direcc.setText(p.getDireccion());
            sexo.setText(p.getSexo());
            sangre.setText(p.getTipoSangre());
            //fechanac.setText(new SimpleDateFormat("yyyy-MM-dd").format(p.getFechaNacimiento()));
            fechanac.setText(p.getFechaNacimiento());
            registrar.setEnabled(true);
            receta.setEnabled(true);
            reporte.setEnabled(true);
            prediagnostico.setEnabled(true);
        } else {
            banderaPaciente=false;
            JOptionPane.showMessageDialog(null, "Paciente No Existe:\n"
                    + "Por favor ingrese un Paciente valido", "Paciente No Encontrado",
                    JOptionPane.ERROR_MESSAGE);
        }
        /*if (!ip.equals("")) {
            capturador1.iniciar();
        }*/

    }

    private void reporteActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void prediagnosticoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        if(!manifestacion.getText().equals("")){
            modelo.addElement(manifestacion.getText());
        jList1.setModel(modelo);
        manifestacion.setText("");
        }

    }

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(!motivo.getText().equals("")&&banderaPaciente==true){
        boolean respuesta = consulta.Registrar(motivo.getText(), modelo, new Imagen(capturador1.getImagen()), new Imagen(capturador2.getImagen()));
        if (respuesta == true) {
            JOptionPane.showMessageDialog(null, "Registro de la Consulta exitoso", "Registro Completado",
                    JOptionPane.INFORMATION_MESSAGE);
            receta.setEnabled(true);
        }
        }else{
            if(motivo.getText().equals(""))
                JOptionPane.showMessageDialog(null, "El campo del motivo de la consulta esta vacio", "No se Completo el registro",
                    JOptionPane.ERROR_MESSAGE);
            if(banderaPaciente==false)
                JOptionPane.showMessageDialog(null, "No se ha asignado un paciente a la consulta.", "No se Completo el registro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void captura1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(opcioncapturador1==2){
            capturador1.iniciar();
            opcioncapturador1=1;
            captura1.setText("Capturar");
        }else{
        capturador1.capturar();
        int ax = JOptionPane.showConfirmDialog(null, "¿Desea realizar otra captura?");
        System.out.println(ax);
        if (ax == JOptionPane.YES_OPTION) {
            //JOptionPane.showMessageDialog(null, "Has seleccionado SI.");
            if (!ip.equals("")) {
                capturador1.iniciar();
            } else {
                capturador1.removeAll();
            }
        } else if (ax == JOptionPane.NO_OPTION || ax == 2) {
            //captura1.setEnabled(false);
            if (!ip.equals("")) {
                //capturador2.iniciar();
            }
        }
        if(opcioncapturador1==0){
            opcioncapturador1=2;
            captura1.setText("Iniciar Video");
        }
        }
        //JOptionPane.showMessageDialog(null, "Has seleccionado NO.");

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here: BOTON QUITAR
        int index=jList1.getSelectedIndex();
        if((index)!=-1){
            modelo.remove(index);
        }else{
            JOptionPane.showMessageDialog(null, "No se ha seleccionado una manifestacion.", "No se logró quitar manifestacion.",
                    JOptionPane.ERROR_MESSAGE);
        }
            
    }

    private void captura2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(opcioncapturador2==2){
            capturador2.iniciar();
            opcioncapturador2=1;
            captura2.setText("Capturar");
        }else{
        capturador2.capturar();
        int ax = JOptionPane.showConfirmDialog(null, "¿Desea realizar otra captura?");
        System.out.println(ax);
        if (ax == JOptionPane.YES_OPTION) //JOptionPane.showMessageDialog(null, "Has seleccionado SI.");
        {
            if (!ip.equals("")) {
                capturador2.iniciar();
            } else {
                capturador2.removeAll();
            }
        } else if (ax == JOptionPane.NO_OPTION || ax == 2) {
            //captura2.setEnabled(false);
        }
        if(opcioncapturador2==0){
            opcioncapturador2=2;
            captura2.setText("Iniciar Video");
        }
        //JOptionPane.showMessageDialog(null, "Has seleccionado NO.");
        }
    }

    private void recetaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.setVisible(false);
        consulta.CrearReceta(this);
        this.setVisible(true);
    }

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
            java.util.logging.Logger.getLogger(RegistroConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /*try {
         UIManager.setLookAndFeel(new UpperEssentialLookAndFeel("C:\\Users\\laloe\\Documents\\TT\\librerias_SDTPO\\Chocolate.theme"));
         } catch (UnsupportedLookAndFeelException e) {

         }*/
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MedicoBean m = new MedicoBean();
                m.setCedulaPrfesional(2013630337);
                // new RegistroConsulta(m).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton captura1;
    private javax.swing.JButton captura2;
    private CapturadorImagen capturador1;
    private CapturadorImagen capturador2;
    private javax.swing.JButton consultaPaciente;
    private javax.swing.JTextField direcc;
    private javax.swing.JTextField doctor;
    private javax.swing.JTextField fecha;
    private javax.swing.JTextField fechanac;
    private javax.swing.JTextField idPaciente;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField manifestacion;
    private javax.swing.JTextArea motivo;
    private javax.swing.JTextField nombreP;
    private javax.swing.JButton receta;
    private javax.swing.JButton registrar;
    private javax.swing.JTextField sangre;
    private javax.swing.JTextField sexo;
    private javax.swing.JButton reporte;
    private javax.swing.JButton prediagnostico;
    // End of variables declaration                   
}


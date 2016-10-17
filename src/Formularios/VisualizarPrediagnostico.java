/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Beans.Imagen;
import Beans.PrediagnosticoBean;
import Beans.ResultadoPrediagnostico;
import Clases.Prediagnostico;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author laloe
 */
public class VisualizarPrediagnostico extends javax.swing.JDialog {

    /**
     * Creates new form VisualizarPrediagnostico
     */
    private Imagen imgOIC, imgODC, imgIzq, imgDer, imgOIM, imgODM, imgOIP, imgODP;
    private double[] resultados;
    private int opcion;
    Prediagnostico prediagnostico;

    public VisualizarPrediagnostico(JDialog parent, boolean modal, Imagen imgIzq, Imagen imgDer, Imagen imgOIC, Imagen imgODC, Imagen imgOIM, Imagen imgODM, double[] resultados, Prediagnostico pre) {
        super(parent, modal);
        initComponents();
        opcion = 0;
        prediagnostico = pre;
        panelOIP.setVisible(false);
        panelODP.setVisible(false);
        labelPteDer.setVisible(false);
        labelPteIzq.setVisible(false);
        resultPteDer.setVisible(false);
        resultPteIzq.setVisible(false);
        this.resultados = resultados;
        this.imgOIC = imgOIC;
        this.imgODC = imgODC;
        this.imgIzq = imgIzq;
        this.imgDer = imgDer;
        this.imgOIM = imgOIM;
        this.imgODM = imgODM;
        JLabel label = new JLabel(new ImageIcon(((new ImageIcon(imgIzq.getFotografia())).getImage()).getScaledInstance(panelOI.getWidth(), panelOI.getHeight(), java.awt.Image.SCALE_SMOOTH)));
        label.setSize(panelOI.getWidth(), panelOI.getHeight());
        panelOI.add(label);
        label = new JLabel(new ImageIcon(((new ImageIcon(imgOIC.getFotografia())).getImage()).getScaledInstance(panelOIC.getWidth(), panelOIC.getHeight(), java.awt.Image.SCALE_SMOOTH)));
        label.setSize(panelOIC.getWidth(), panelOIC.getHeight());
        panelOIC.add(label);
        label = new JLabel(new ImageIcon(((new ImageIcon(imgOIM.getFotografia())).getImage()).getScaledInstance(panelOIM.getWidth(), panelOIM.getHeight(), java.awt.Image.SCALE_SMOOTH)));
        label.setSize(panelOIM.getWidth(), panelOIM.getHeight());
        panelOIM.add(label);

        label = new JLabel(new ImageIcon(((new ImageIcon(imgDer.getFotografia())).getImage()).getScaledInstance(panelOD.getWidth(), panelOD.getHeight(), java.awt.Image.SCALE_SMOOTH)));
        label.setSize(panelOD.getWidth(), panelOD.getHeight());
        panelOD.add(label);
        label = new JLabel(new ImageIcon(((new ImageIcon(imgODC.getFotografia())).getImage()).getScaledInstance(panelODC.getWidth(), panelODC.getHeight(), java.awt.Image.SCALE_SMOOTH)));
        label.setSize(panelODC.getWidth(), panelODC.getHeight());
        panelODC.add(label);
        label = new JLabel(new ImageIcon(((new ImageIcon(imgODM.getFotografia())).getImage()).getScaledInstance(panelODM.getWidth(), panelODM.getHeight(), java.awt.Image.SCALE_SMOOTH)));
        label.setSize(panelODM.getWidth(), panelODM.getHeight());
        panelODM.add(label);
        resulCatIzq.setText(resultados[0] + "% de la área de la pupila detectada con Catarata.");
        resulCatDer.setText(resultados[1] + "% de la área de la pupila detectada con Catarata.");
        resultMeIzq.setText(resultados[2] + "% de la área del iris detectada con Melanoma");
        resultMeDer.setText(resultados[3] + "% de la área del iris detectada con Melanoma");

    }

    public VisualizarPrediagnostico(JDialog parent, boolean modal, PrediagnosticoBean prediag,Imagen imgIzq, Imagen imgDer) {
        super(parent, modal);
        initComponents();
        this.imgIzq = imgIzq;
        this.imgDer = imgDer;
        observaciones.setEditable(false);
        labelCatDer.setVisible(false);
        labelCatIzq.setVisible(false);
        labelMelDer.setVisible(false);
        labelMelIzq.setVisible(false);
        labelPteDer.setVisible(false);
        labelPteIzq.setVisible(false);
        panelODC.setVisible(false);
        panelODM.setVisible(false);
        panelODP.setVisible(false);
        panelOIC.setVisible(false);
        panelOIM.setVisible(false);
        panelOIP.setVisible(false);
        resulCatDer.setVisible(false);
        resulCatIzq.setVisible(false);
        resultMeDer.setVisible(false);
        resultMeIzq.setVisible(false);
        resultPteDer.setVisible(false);
        resultPteIzq.setVisible(false);
        registrar.setVisible(false);
        JLabel label;
        for (ResultadoPrediagnostico rp : prediag.getResultados()) {
            if (rp.getOjo().equals("Derecho")) {
                if (rp.getPatologia().equals("Catarata")) {
                    panelODC.setVisible(true);
                    resulCatDer.setVisible(true);
                    labelCatDer.setVisible(true);
                    imgODC = new Imagen(rp.getRutaImagen());
                    label = new JLabel(new ImageIcon(((new ImageIcon(imgODC.getFotografia())).getImage()).getScaledInstance(panelODC.getWidth(), panelODC.getHeight(), java.awt.Image.SCALE_SMOOTH)));
                    label.setSize(panelODC.getWidth(), panelODC.getHeight());
                    panelODC.add(label);
                    resulCatDer.setText(rp.getResultado() + "% de la área de la pupila detectada con Catarata.");
                } else if (rp.getPatologia().equals("Melanoma")) {
                    panelODM.setVisible(true);
                    resultMeDer.setVisible(true);
                    labelMelDer.setVisible(true);
                    imgODM = new Imagen(rp.getRutaImagen());
                    label = new JLabel(new ImageIcon(((new ImageIcon(imgODM.getFotografia())).getImage()).getScaledInstance(panelODM.getWidth(), panelODM.getHeight(), java.awt.Image.SCALE_SMOOTH)));
                    label.setSize(panelODM.getWidth(), panelODM.getHeight());
                    panelODM.add(label);
                    resultMeDer.setText(rp.getResultado() + "% de la área del iris detectada con Melanoma");
                } else {
                    panelODP.setVisible(true);
                    labelPteDer.setVisible(true);
                    resultPteDer.setVisible(false);
                    imgODP = new Imagen(rp.getRutaImagen());
                    label = new JLabel(new ImageIcon(((new ImageIcon(imgODP.getFotografia())).getImage()).getScaledInstance(panelODP.getWidth(), panelODP.getHeight(), java.awt.Image.SCALE_SMOOTH)));
                    label.setSize(panelODP.getWidth(), panelODP.getHeight());
                    panelODP.add(label);
                }
            } else {
                if (rp.getPatologia().equals("Catarata")) {
                    panelOIC.setVisible(true);
                    resulCatIzq.setVisible(true);
                    labelCatIzq.setVisible(true);
                    imgOIC = new Imagen(rp.getRutaImagen());
                    label = new JLabel(new ImageIcon(((new ImageIcon(imgOIC.getFotografia())).getImage()).getScaledInstance(panelOIC.getWidth(), panelOIC.getHeight(), java.awt.Image.SCALE_SMOOTH)));
                    label.setSize(panelOIC.getWidth(), panelOIC.getHeight());
                    panelOIC.add(label);
                    resulCatIzq.setText(rp.getResultado() + "% de la área de la pupila detectada con Catarata.");
                } else if (rp.getPatologia().equals("Melanoma")) {
                    panelOIM.setVisible(true);
                    resultMeIzq.setVisible(true);
                    labelMelIzq.setVisible(true);
                    imgOIM = new Imagen(rp.getRutaImagen());
                    label = new JLabel(new ImageIcon(((new ImageIcon(imgOIM.getFotografia())).getImage()).getScaledInstance(panelOIM.getWidth(), panelOIM.getHeight(), java.awt.Image.SCALE_SMOOTH)));
                    label.setSize(panelOIM.getWidth(), panelOIM.getHeight());
                    panelOIM.add(label);
                    resultMeIzq.setText(rp.getResultado() + "% de la área del iris detectada con Melanoma");
                } else {
                    panelOIP.setVisible(true);
                    labelPteIzq.setVisible(true);
                    resultPteIzq.setVisible(true);
                    imgOIP = new Imagen(rp.getRutaImagen());
                    label = new JLabel(new ImageIcon(((new ImageIcon(imgOIP.getFotografia())).getImage()).getScaledInstance(panelOIP.getWidth(), panelOIP.getHeight(), java.awt.Image.SCALE_SMOOTH)));
                    label.setSize(panelOIP.getWidth(), panelOIP.getHeight());
                    panelOIP.add(label);
                }
            }
        }

        label = new JLabel(new ImageIcon(((new ImageIcon(imgIzq.getFotografia())).getImage()).getScaledInstance(panelOI.getWidth(), panelOI.getHeight(), java.awt.Image.SCALE_SMOOTH)));
        label.setSize(panelOI.getWidth(), panelOI.getHeight());
        panelOI.add(label);
        label = new JLabel(new ImageIcon(((new ImageIcon(imgDer.getFotografia())).getImage()).getScaledInstance(panelOD.getWidth(), panelOD.getHeight(), java.awt.Image.SCALE_SMOOTH)));
        label.setSize(panelOD.getWidth(), panelOD.getHeight());
        panelOD.add(label);
        observaciones.setText(prediag.getObservaciones());
    }

    public VisualizarPrediagnostico(JDialog parent, boolean modal, Imagen imgIzq, Imagen imgDer, Imagen imgOIP, Imagen imgODP, double[] resultados, Prediagnostico pre) {
        super(parent, modal);
        initComponents();
        this.setTitle("Pre-diagnostico");
        prediagnostico = pre;
        opcion = 1;
        resulCatIzq.setVisible(false);
        resulCatDer.setVisible(false);
        resultMeIzq.setVisible(false);
        resultMeDer.setVisible(false);
        panelODC.setVisible(false);
        panelODM.setVisible(false);
        panelOIC.setVisible(false);
        panelOIM.setVisible(false);
        labelCatDer.setVisible(false);
        labelCatIzq.setVisible(false);
        labelMelDer.setVisible(false);
        labelMelIzq.setVisible(false);

        this.resultados = resultados;
        this.imgOIP = imgOIP;
        this.imgODP = imgODP;
        this.imgIzq = imgIzq;
        this.imgDer = imgDer;

        JLabel label = new JLabel(new ImageIcon(((new ImageIcon(imgIzq.getFotografia())).getImage()).getScaledInstance(panelOI.getWidth(), panelOI.getHeight(), java.awt.Image.SCALE_SMOOTH)));
        label.setSize(panelOI.getWidth(), panelOI.getHeight());
        panelOI.add(label);
        label = new JLabel(new ImageIcon(((new ImageIcon(imgOIP.getFotografia())).getImage()).getScaledInstance(panelOIP.getWidth(), panelOIP.getHeight(), java.awt.Image.SCALE_SMOOTH)));
        label.setSize(panelOIP.getWidth(), panelOIP.getHeight());
        panelOIP.add(label);

        label = new JLabel(new ImageIcon(((new ImageIcon(imgDer.getFotografia())).getImage()).getScaledInstance(panelOD.getWidth(), panelOD.getHeight(), java.awt.Image.SCALE_SMOOTH)));
        label.setSize(panelOD.getWidth(), panelOD.getHeight());
        panelOD.add(label);
        label = new JLabel(new ImageIcon(((new ImageIcon(imgODP.getFotografia())).getImage()).getScaledInstance(panelODP.getWidth(), panelODP.getHeight(), java.awt.Image.SCALE_SMOOTH)));
        label.setSize(panelODP.getWidth(), panelODP.getHeight());
        panelODP.add(label);
        //resultPteDer.setText("RESULTADO DERECHO");
        resultPteDer.setText("El ojo presenta un " + resultados[0] + "% de pterigon en el area de la esclerotica.");
        //resultPteIzq.setText("RESULTADO Izquierdo");
        resultPteIzq.setText("El ojo presenta un " + resultados[1] + "% de pterigon en el area de la esclerotica.");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        panelOIM = new javax.swing.JPanel();
        panelOIC = new javax.swing.JPanel();
        panelOI = new javax.swing.JPanel();
        resulCatIzq = new javax.swing.JLabel();
        resultPteIzq = new javax.swing.JLabel();
        resultMeIzq = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panelOIP = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        labelCatIzq = new javax.swing.JLabel();
        labelMelIzq = new javax.swing.JLabel();
        labelPteIzq = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        panelODM = new javax.swing.JPanel();
        panelODC = new javax.swing.JPanel();
        panelOD = new javax.swing.JPanel();
        resulCatDer = new javax.swing.JLabel();
        resultPteDer = new javax.swing.JLabel();
        resultMeDer = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelODP = new javax.swing.JPanel();
        labelMelDer = new javax.swing.JLabel();
        labelPteDer = new javax.swing.JLabel();
        labelCatDer = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        observaciones = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        registrar = new javax.swing.JButton();
        regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        panelOIM.setBackground(new java.awt.Color(204, 255, 153));
        panelOIM.setPreferredSize(new java.awt.Dimension(75, 100));
        panelOIM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelOIMMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelOIMLayout = new javax.swing.GroupLayout(panelOIM);
        panelOIM.setLayout(panelOIMLayout);
        panelOIMLayout.setHorizontalGroup(
            panelOIMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        panelOIMLayout.setVerticalGroup(
            panelOIMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        panelOIC.setBackground(new java.awt.Color(204, 255, 153));
        panelOIC.setPreferredSize(new java.awt.Dimension(75, 100));
        panelOIC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelOICMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelOICLayout = new javax.swing.GroupLayout(panelOIC);
        panelOIC.setLayout(panelOICLayout);
        panelOICLayout.setHorizontalGroup(
            panelOICLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        panelOICLayout.setVerticalGroup(
            panelOICLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        panelOI.setBackground(new java.awt.Color(204, 255, 153));
        panelOI.setPreferredSize(new java.awt.Dimension(75, 100));
        panelOI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelOIMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelOILayout = new javax.swing.GroupLayout(panelOI);
        panelOI.setLayout(panelOILayout);
        panelOILayout.setHorizontalGroup(
            panelOILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        panelOILayout.setVerticalGroup(
            panelOILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        resulCatIzq.setText("cat");

        resultPteIzq.setText("pter");

        resultMeIzq.setText("mel");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Resultado del Ojo Izquierdo");

        panelOIP.setBackground(new java.awt.Color(204, 255, 153));
        panelOIP.setPreferredSize(new java.awt.Dimension(75, 100));
        panelOIP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelOIPMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelOIPLayout = new javax.swing.GroupLayout(panelOIP);
        panelOIP.setLayout(panelOIPLayout);
        panelOIPLayout.setHorizontalGroup(
            panelOIPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        panelOIPLayout.setVerticalGroup(
            panelOIPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel3.setText("Imagen Obtenida");

        labelCatIzq.setText("Catarata");

        labelMelIzq.setText("Melanoma");

        labelPteIzq.setText("Pterigión");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(318, 318, 318))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelOI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(128, 128, 128)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelOIC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCatIzq))
                        .addGap(138, 138, 138)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelOIM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMelIzq))
                        .addGap(95, 95, 95)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPteIzq)
                            .addComponent(panelOIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(resultPteIzq)
                    .addComponent(resulCatIzq)
                    .addComponent(resultMeIzq))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelCatIzq, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelMelIzq, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelPteIzq, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelOIM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelOIC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelOI, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelOIP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resulCatIzq)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resultPteIzq)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resultMeIzq)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        panelODM.setBackground(new java.awt.Color(204, 255, 153));
        panelODM.setPreferredSize(new java.awt.Dimension(75, 100));
        panelODM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelODMMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelODMLayout = new javax.swing.GroupLayout(panelODM);
        panelODM.setLayout(panelODMLayout);
        panelODMLayout.setHorizontalGroup(
            panelODMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        panelODMLayout.setVerticalGroup(
            panelODMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        panelODC.setBackground(new java.awt.Color(204, 255, 153));
        panelODC.setPreferredSize(new java.awt.Dimension(75, 100));
        panelODC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelODCMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelODCLayout = new javax.swing.GroupLayout(panelODC);
        panelODC.setLayout(panelODCLayout);
        panelODCLayout.setHorizontalGroup(
            panelODCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        panelODCLayout.setVerticalGroup(
            panelODCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        panelOD.setBackground(new java.awt.Color(204, 255, 153));
        panelOD.setPreferredSize(new java.awt.Dimension(75, 100));
        panelOD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelODMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelODLayout = new javax.swing.GroupLayout(panelOD);
        panelOD.setLayout(panelODLayout);
        panelODLayout.setHorizontalGroup(
            panelODLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        panelODLayout.setVerticalGroup(
            panelODLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        resulCatDer.setText("cat");

        resultPteDer.setText("pter");

        resultMeDer.setText("mel");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Resultado del Ojo Derecho");

        panelODP.setBackground(new java.awt.Color(204, 255, 153));
        panelODP.setPreferredSize(new java.awt.Dimension(75, 100));
        panelODP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelODPMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelODPLayout = new javax.swing.GroupLayout(panelODP);
        panelODP.setLayout(panelODPLayout);
        panelODPLayout.setHorizontalGroup(
            panelODPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        panelODPLayout.setVerticalGroup(
            panelODPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        labelMelDer.setText("Melanoma");

        labelPteDer.setText("Pterigión");

        labelCatDer.setText("Catarata");

        jLabel4.setText("Imagen Obtenida");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(310, 310, 310))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(resultMeDer)
                                    .addComponent(resultPteDer)
                                    .addComponent(resulCatDer))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(panelOD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(128, 128, 128)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(panelODC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelCatDer))
                                .addGap(138, 138, 138)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(panelODM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelMelDer))
                                .addGap(95, 95, 95)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelPteDer)
                                    .addComponent(panelODP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(57, 57, 57))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelMelDer)
                        .addComponent(labelCatDer)
                        .addComponent(labelPteDer)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelODC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelOD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelODM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelODP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resulCatDer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resultPteDer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resultMeDer)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Pre-diagnóstico");

        observaciones.setColumns(20);
        observaciones.setRows(5);
        jScrollPane1.setViewportView(observaciones);

        jLabel6.setText("Observaciones:");

        registrar.setText("Registrar");
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });

        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(337, 337, 337)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(59, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(registrar)
                    .addComponent(regresar))
                .addGap(93, 93, 93))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(registrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(regresar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelOIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelOIMouseClicked
        // TODO add your handling code here:
        new VerImagen(this, false, imgIzq);
    }//GEN-LAST:event_panelOIMouseClicked

    private void panelOICMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelOICMouseClicked
        // TODO add your handling code here:
        new VerImagen(this, false, imgOIC);
    }//GEN-LAST:event_panelOICMouseClicked

    private void panelOIMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelOIMMouseClicked
        // TODO add your handling code here:
        new VerImagen(this, false, imgOIM);
    }//GEN-LAST:event_panelOIMMouseClicked

    private void panelODMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelODMouseClicked
        // TODO add your handling code here:
        new VerImagen(this, false, imgDer);
    }//GEN-LAST:event_panelODMouseClicked

    private void panelODCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelODCMouseClicked
        // TODO add your handling code here:
        new VerImagen(this, false, imgODC);
    }//GEN-LAST:event_panelODCMouseClicked

    private void panelODMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelODMMouseClicked
        // TODO add your handling code here:
        new VerImagen(this, false, imgODM);
    }//GEN-LAST:event_panelODMMouseClicked

    private void panelOIPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelOIPMouseClicked
        // TODO add your handling code here:
        new VerImagen(this, false, imgOIP);
    }//GEN-LAST:event_panelOIPMouseClicked

    private void panelODPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelODPMouseClicked
        // TODO add your handling code here:
        new VerImagen(this, false, imgODP);
    }//GEN-LAST:event_panelODPMouseClicked

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        // TODO add your handling code here:
        if (!observaciones.getText().equals("")) {
            if (prediagnostico.Registrar(observaciones.getText())) {
                registrar.setEnabled(false);
                JOptionPane.showMessageDialog(null, "El Pre-diagnóstico se registro exitosamente", "Registro Exitoso",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se logró registrar el Pre-diagnóstico", "Registro Fallido",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El campo de observaciones no se ha llenado", "Registro Fallido",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_registrarActionPerformed

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_regresarActionPerformed

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
            java.util.logging.Logger.getLogger(VisualizarPrediagnostico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisualizarPrediagnostico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisualizarPrediagnostico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisualizarPrediagnostico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
         VisualizarPrediagnostico dialog = new VisualizarPrediagnostico(new javax.swing.JFrame(), true);
         dialog.addWindowListener(new java.awt.event.WindowAdapter() {
         @Override
         public void windowClosing(java.awt.event.WindowEvent e) {
         System.exit(0);
         }
         });
         dialog.setVisible(true);
         }
         });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCatDer;
    private javax.swing.JLabel labelCatIzq;
    private javax.swing.JLabel labelMelDer;
    private javax.swing.JLabel labelMelIzq;
    private javax.swing.JLabel labelPteDer;
    private javax.swing.JLabel labelPteIzq;
    private javax.swing.JTextArea observaciones;
    private javax.swing.JPanel panelOD;
    private javax.swing.JPanel panelODC;
    private javax.swing.JPanel panelODM;
    private javax.swing.JPanel panelODP;
    private javax.swing.JPanel panelOI;
    private javax.swing.JPanel panelOIC;
    private javax.swing.JPanel panelOIM;
    private javax.swing.JPanel panelOIP;
    private javax.swing.JButton registrar;
    private javax.swing.JButton regresar;
    private javax.swing.JLabel resulCatDer;
    private javax.swing.JLabel resulCatIzq;
    private javax.swing.JLabel resultMeDer;
    private javax.swing.JLabel resultMeIzq;
    private javax.swing.JLabel resultPteDer;
    private javax.swing.JLabel resultPteIzq;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Beans.Medicamento;
import Beans.RecetaMedicaBean;
import Clases.RecetaMedica;
import Clases.ServicioRespuesta;
import javax.swing.JDialog;

import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author laloe
 */
public class VerReceta extends javax.swing.JDialog {
Vector columnas = null;
    /**
     * Creates new form VerReceta
     * @param parent
     * @param modal
     * @param idConsulta
     */
private RecetaMedicaBean receta;
    public VerReceta(JDialog parent, boolean modal,int idConsulta) {
        super(parent, modal);
        initComponents();
        RecetaMedica rm=new RecetaMedica(idConsulta);
        ServicioRespuesta respuesta=rm.obtenerReceta();
        if(respuesta.isSuccess()==true){
            receta=(RecetaMedicaBean)respuesta.getResult();
        
        columnas = new Vector();
        columnas.add("Id");
        columnas.add("Nombre");
        columnas.add("Presentacion");
        columnas.add("dosis");
        cargarDatos();
        }
        else{
            JOptionPane.showMessageDialog(null, "No se tiene una receta Regitrada para esta consulta", "No se encontro Receta",
                    JOptionPane.ERROR_MESSAGE);
            cerrar();
        }
        
    }
    public void cerrar(){this.dispose();}
public void cargarDatos(){
    fecha.setText(receta.getFecha());
    recomendaciones.setText(receta.getRecomendaciones());
    llenarTabla();
}
private void llenarTabla() {
        DefaultTableModel datos = new DefaultTableModel();
        for (int i = 0; i < columnas.size(); i++) {
            datos.addColumn(columnas.get(i));
        }
        this.tablaMedicamentos.setModel(datos);
        for (Medicamento med : receta.getMedicamentos()) {
            Vector vec = new Vector();
            vec.add(med.getIdMedicamento());
            vec.add(med.getNombre());
            vec.add(med.getPresentacion());
            vec.add(med.getDosis());
            datos.addRow(vec);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fecha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMedicamentos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        recomendaciones = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        fecha.setEditable(false);

        jLabel4.setText("Medicamentos Agregados:");

        tablaMedicamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "idMedicamento", "Nombre", "Presentación", "Dosis"
            }
        ));
        tablaMedicamentos.setEnabled(false);
        jScrollPane1.setViewportView(tablaMedicamentos);

        jLabel2.setText("Fecha:");

        jLabel5.setText("Recomendaciones:");

        jScrollPane2.setViewportView(recomendaciones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel4)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(VerReceta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerReceta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerReceta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerReceta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VerReceta dialog = new VerReceta(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField fecha;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane recomendaciones;
    private javax.swing.JTable tablaMedicamentos;
    // End of variables declaration//GEN-END:variables
}

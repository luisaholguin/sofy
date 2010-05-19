/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VentanaNuevoContenedor.java
 *
 * Created on 11/04/2010, 01:41:39
 */

package vista;

import dominio.Contenedor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import vista.util.VentanaNuevoContenedorUtil;

/**
 *
 * @author Marcelo
 */
public class VentanaNuevoContenedor extends javax.swing.JFrame
{

    private VentanaNuevoContenedorUtil util = new VentanaNuevoContenedorUtil();
    private Collection alimentos = new ArrayList();
    private Collection contenedores = new ArrayList();
    private boolean guardar = false; //guardar -> true (guardar) ; flase (modificar)
    private boolean seleccionado = false;

    /** Creates new form VentanaNuevoContenedor */
    public VentanaNuevoContenedor()
    {
        initComponents();
        this.inicializar();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableContenedores = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxAlimento = new javax.swing.JComboBox();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabelCantidad = new javax.swing.JLabel();
        jTextFieldCantidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButtonGuardar = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Contenedor");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Contenedores"));

        jTableContenedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Alimento", "Contenedor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableContenedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableContenedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableContenedores);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle"));

        jLabel2.setBackground(new java.awt.Color(255, 255, 204));
        jLabel2.setText("Nombre");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel2.setOpaque(true);

        jLabelCantidad.setBackground(new java.awt.Color(255, 255, 204));
        jLabelCantidad.setText("Alimento");
        jLabelCantidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabelCantidad.setOpaque(true);

        jLabel3.setBackground(new java.awt.Color(255, 255, 204));
        jLabel3.setText("Cantidad");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel3.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxAlimento, 0, 223, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGuardar)
                    .addComponent(jButtonSalir))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonSalirActionPerformed
    {//GEN-HEADEREND:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
//        this.ajustarTamanioColumna();
        this.dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonGuardarActionPerformed
    {//GEN-HEADEREND:event_jButtonGuardarActionPerformed
        // TODO add your handling code here:
        if(this.guardar)
            this.gurdarContenedor();
        else
            this.modificarContenedor();
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jTableContenedoresMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTableContenedoresMouseClicked
    {//GEN-HEADEREND:event_jTableContenedoresMouseClicked
        // TODO add your handling code here:
        this.seleccionado = true;
        this.mostrarFila();
    }//GEN-LAST:event_jTableContenedoresMouseClicked

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaNuevoContenedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JComboBox jComboBoxAlimento;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelCantidad;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableContenedores;
    private javax.swing.JTextField jTextFieldCantidad;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables


    private void inicializar()
    {
        this.centrar();
        this.ajustarTamanioColumna();
        this.cargarCombo();
        this.llenarTabla();
    }

    private void centrar()
    {
        Dimension pantalla, cuadro;
	pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	cuadro = this.getSize();
	this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
    }

    private void ajustarTamanioColumna()
    {
        TableColumn column = null;
        for (int i = 0; i < 4; i++)
        {
            column = jTableContenedores.getColumnModel().getColumn(i);
            switch(i)
            {
                case 0:
                        column.setPreferredWidth(15);
//                        System.out.println("El tamaño de la clumna 1 es: "+column.getPreferredWidth());
                        break;
                case 1:
                        column.setPreferredWidth(142);
//                        System.out.println("El tamaño de la clumna 2 es: "+column.getPreferredWidth());
                        break;
                case 2:
                        column.setPreferredWidth(143);
//                        System.out.println("El tamaño de la clumna 3 es: "+column.getPreferredWidth());
                        break;
                case 3:
                        column.setPreferredWidth(40);
//                        System.out.println("El tamaño de la clumna 4 es: "+column.getPreferredWidth());
                        break;
            }
        }
    }

    private void cargarCombo()
    {
        this.alimentos = this.util.cargarCombo(jComboBoxAlimento, alimentos);
    }

    private void llenarTabla()
    {
        this.contenedores = this.util.traerTodos(jTableContenedores, contenedores, this.alimentos);
    }

    
    private void limpiarTexto()
    {
        this.jTextFieldCantidad.setText("");
        this.jTextFieldNombre.setText("");
        this.jComboBoxAlimento.setSelectedIndex(0);
    }

    private void mostrarFila()
    {
        if(Boolean.parseBoolean(String.valueOf(this.jTableContenedores.getValueAt(this.jTableContenedores.getSelectedRow(), 3))))
        {
            Contenedor c = this.util.getContenedor(contenedores, Integer.parseInt(String.valueOf(this.jTableContenedores.getValueAt(this.jTableContenedores.getSelectedRow(), 0))));
            this.jTextFieldCantidad.setText(String.valueOf(c.getCantidad()));
            this.jTextFieldNombre.setText(c.getNombre().trim());
            this.jComboBoxAlimento.setSelectedItem(c.getNombre().trim());
            this.guardar = false;
        }
        else
        {
            this.jTextFieldNombre.setText(String.valueOf(this.jTableContenedores.getValueAt(this.jTableContenedores.getSelectedRow(), 2)));
            System.out.println("El nombre del contenedor es: "+String.valueOf(this.jTableContenedores.getValueAt(this.jTableContenedores.getSelectedRow(), 2)).trim());
            this.jComboBoxAlimento.setSelectedItem(String.valueOf(this.jTableContenedores.getValueAt(this.jTableContenedores.getSelectedRow(), 2)).trim());
            this.jTextFieldCantidad.setText("0");
            this.guardar = true;
        }
        
    }

    private void gurdarContenedor()
    {
        if(this.controlarBlancos())
        {
            Contenedor contenedor = new Contenedor();
            contenedor.setNombre(this.jTextFieldNombre.getText().trim().toUpperCase());
            contenedor.setCantidad(Double.parseDouble(this.jTextFieldCantidad.getText()));
            contenedor = this.util.getContenedor(jComboBoxAlimento, contenedor, alimentos);
            this.util.nuevoContenedor(contenedor);
            this.limpiarTexto();
            this.llenarTabla();
        }
        else
            JOptionPane.showMessageDialog(null, "Asegurese de que los campos esten llenos","Hay campos en blancos",JOptionPane.ERROR_MESSAGE);
    }

    private void modificarContenedor()
    {
        if(this.controlarBlancos() && this.seleccionado)
        {
            Contenedor contenedor = new Contenedor();
            contenedor.setCodigo(Integer.parseInt(String.valueOf(this.jTableContenedores.getValueAt(this.jTableContenedores.getSelectedRow(), 0))));
            contenedor.setNombre(this.jTextFieldNombre.getText().trim().toUpperCase());
            contenedor.setCantidad(Double.parseDouble(this.jTextFieldCantidad.getText()));
            contenedor = this.util.getContenedor(jComboBoxAlimento, contenedor, alimentos);
            this.util.modificarContenedor(contenedor);
            this.limpiarTexto();
            this.llenarTabla();
        }
        else
            JOptionPane.showMessageDialog(null, "Asegurese de que los campos esten llenos","Hay campos en blancos",JOptionPane.ERROR_MESSAGE);
    }

    private boolean controlarBlancos()
    {
        boolean bandera = true;
        if(this.jTextFieldCantidad.getText().trim().length() == 0)
            bandera = false;
        if(this.jTextFieldNombre.getText().trim().length() == 0)
            bandera = false;
        return bandera;
    }

}

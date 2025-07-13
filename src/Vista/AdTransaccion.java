 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import Conexion.Conexion;
import Controlador.CtrlTransaccion;
import Modelo.DatosTransaccion;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Angelica Guerrero
 */
public class AdTransaccion extends javax.swing.JInternalFrame {
private FMenu ventana;
private FMenu menu;
    DefaultTableModel modelo = new DefaultTableModel();
    private Vector<Integer> idCliente = new Vector<>();
    private int idTransaccion;
    private int id_transaccion = 0;
    private boolean is_selected = false;

    /**
     * Creates new form AdArticulos
     */
    public AdTransaccion(FMenu ventana) {
        initComponents();
        this.ventana=ventana;
        this.ventana.mostrarImagenDeFondo();
        this.setSize(1366,660);
        this.menu=ventana;
        
        this.cargarComboClientes();
        modelo.addColumn("N°");
        modelo.addColumn("Cliente");
        modelo.addColumn("Articulos");
        modelo.addColumn("Importe total");
        modelo.addColumn("A cuenta");
        modelo.addColumn("Por cobrar");
        modelo.addColumn("Fecha");
        modelo.addColumn("Tipo transacción");
        tb_transaccion = new JTable(modelo);
        tb_transaccion.setDefaultEditor(Object.class, null);
        
        tb_transaccion.setRowHeight(60);
        MultiLineTableCellRenderer renderer = new MultiLineTableCellRenderer();
        tb_transaccion.getColumnModel().getColumn(2).setCellRenderer(renderer);
        this.cargarTablaTransaccion();
        
        scp_transaccion.setViewportView(tb_transaccion);
        tb_transaccion.getColumnModel().getColumn(2).setCellRenderer(renderer);
        adjustRowHeights();
        tb_transaccion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_seleccionada = tb_transaccion.rowAtPoint(e.getPoint());
                int columna_seleccionada = 0;
                if (fila_seleccionada > -1) {
                    is_selected = true;
                    id_transaccion = (int) modelo.getValueAt(fila_seleccionada, columna_seleccionada);
                    btn_actualizar.setEnabled(true);
                    cargarInformacionTransaccion(id_transaccion);
                }
            }
        });
    }

    private void adjustRowHeights() {
        for (int row = 0; row < tb_transaccion.getRowCount(); row++) {
        int maxHeight = 0;
        int maxWidth = 0; // Agrega una variable para el ancho máximo
        for (int column = 0; column < tb_transaccion.getColumnCount(); column++) {
            TableCellRenderer cellRenderer = tb_transaccion.getCellRenderer(row, column);
            Component comp = tb_transaccion.prepareRenderer(cellRenderer, row, column);
            maxHeight = Math.max(comp.getPreferredSize().height, maxHeight);
            maxWidth = Math.max(comp.getPreferredSize().width, maxWidth); // Calcula el ancho máximo
        }
        tb_transaccion.setRowHeight(row, maxHeight);
        tb_transaccion.getColumnModel().getColumn(1).setPreferredWidth(150); // Establece el ancho de la columna "Artículos
        tb_transaccion.getColumnModel().getColumn(2).setPreferredWidth(345); // Establece el ancho de la columna "Artículos"
        tb_transaccion.getColumnModel().getColumn(3).setPreferredWidth(30); // Establece el ancho de la columna "Artículos"
        tb_transaccion.getColumnModel().getColumn(4).setPreferredWidth(30); // Establece el ancho de la columna "Artículos"
        tb_transaccion.getColumnModel().getColumn(5).setPreferredWidth(30); // Establece el ancho de la columna "Artículos"
        
        }
    }

    public class MultiLineTableCellRenderer extends JTextArea implements TableCellRenderer {

        public MultiLineTableCellRenderer() {
            setLineWrap(true);
            setWrapStyleWord(true);
            setOpaque(true);
            setBorder(null);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                setBackground(table.getSelectionBackground());
                setForeground(table.getSelectionForeground());
            } else {
                setBackground(table.getBackground());
                setForeground(table.getForeground());
            }

            // Set the text for the cell
            if (value != null) {
                setText(value.toString());
            } else {
                setText("");
            }

            return this;
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

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn_actualizar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        text_importe = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        text_fecha = new javax.swing.JTextField();
        cmb_cliente = new javax.swing.JComboBox<>();
        cmb_transaccion = new javax.swing.JComboBox<>();
        scp_transaccion = new javax.swing.JScrollPane();
        tb_transaccion = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setClosable(true);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        btn_actualizar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar (2).png"))); // NOI18N
        btn_actualizar.setText("Actualizar");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btn_actualizar)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btn_actualizar)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Cliente:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Importe total:");

        text_importe.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        text_importe.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Tipo transacción:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Fecha transacción:");

        text_fecha.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        text_fecha.setEnabled(false);

        cmb_cliente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cmb_cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmb_transaccion.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cmb_transaccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el tipo de transacción", "Venta", "Apartado" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(cmb_transaccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(27, 27, 27)
                        .addComponent(cmb_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(text_importe, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(text_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cmb_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(text_importe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cmb_transaccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        tb_transaccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tb_transaccion.setName("Citas"); // NOI18N
        scp_transaccion.setViewportView(tb_transaccion);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Administrar transacción");

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flecha-izquierda.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoventana.jpeg"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scp_transaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 1345, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(299, 299, 299)
                .addComponent(jLabel9)
                .addGap(40, 40, 40))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8)
                        .addComponent(jButton1))
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(scp_transaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(142, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jPanel3.setVisible(false);
        menu.mostrarImagenDeFondo();
        menu.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        // TODO add your handling code here:
        String cliente=cmb_cliente.getSelectedItem().toString();
        String tipoTransaccion = "";
        tipoTransaccion = cmb_transaccion.getSelectedItem().toString();
        int idcliente = idCliente.get(cmb_cliente.getSelectedIndex() - 1);
        if (cliente.equalsIgnoreCase("Seleccione cliente")) {
                JOptionPane.showMessageDialog(null, "Seleccione un cliente");
        }else{
            if (tipoTransaccion.equalsIgnoreCase("Seleccione el tipo de transacción")) {
                JOptionPane.showMessageDialog(null, "Seleccione un tipo de transaccion");
        }else{
                DatosTransaccion datos=new DatosTransaccion();
                CtrlTransaccion ctTransaccion=new CtrlTransaccion();
                datos.setId_datosTransaccion(id_transaccion);
                datos.setId_cliente(idcliente);
                datos.setTipo_transaccion(tipoTransaccion);
                if(ctTransaccion.actualizarTransaccion(datos)){
                    JOptionPane.showMessageDialog(null, "Transaccion actualizada");
                    this.cargarComboClientes();
                    this.cargarTablaTransaccion();
                    cmb_transaccion.setSelectedItem("Seleccione el tipo de transacción");
                    adjustRowHeights();
                }else{
                    JOptionPane.showMessageDialog(null, "Fallo la actualizacion de transaccion");
          
                }
            }
        }
    }//GEN-LAST:event_btn_actualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JComboBox<String> cmb_cliente;
    private javax.swing.JComboBox<String> cmb_transaccion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane scp_transaccion;
    private javax.swing.JTable tb_transaccion;
    private javax.swing.JTextField text_fecha;
    private javax.swing.JTextField text_importe;
    // End of variables declaration//GEN-END:variables

   

    public void cargarTablaTransaccion() {
        Connection cn = Conexion.Conectar();
        String query = "SELECT dt.id_datosTransaccion AS id, CONCAT(c.nombre_cliente, ' ', c.apellidos_cliente) AS cliente, GROUP_CONCAT(CONCAT(tr.cantidad,' ',a.nombre_articulo, ' - ', a.descripcion_articulo,' - $',a.precio_articulo) SEPARATOR '\\n') AS articulos_comprados, dt.importe_total AS total, dt.aCuenta AS cuenta,dt.valorPagar AS por_cobrar, dt.fecha_transaccion AS fecha, dt.tipo_transaccion AS transaccion FROM datos_transaccion AS dt INNER JOIN cliente AS c ON dt.id_cliente = c.id_cliente INNER JOIN transacciones AS tr ON dt.id_datosTransaccion = tr.id_datosTransaccion INNER JOIN articulos AS a ON tr.id_articulo = a.id_articulo GROUP BY dt.id_datosTransaccion;";
                try (PreparedStatement st = cn.prepareStatement(query)) {
            ResultSet rs = st.executeQuery();
            while (modelo.getRowCount() > 0) {
                modelo.removeRow(0);
            }
            scp_transaccion.setViewportView(tb_transaccion);
            while (rs.next()) {
                Object fila[] = new Object[8];
                for (byte i = 0; i < 8; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
                tb_transaccion.getColumnModel().getColumn(2).setCellRenderer(new MultiLineTableCellRenderer());
            }
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Falló la consulta de transaccion: " + ex);
        }
        is_selected = false;
    }

    private void cargarInformacionTransaccion(int idTransaccion) {
        try {
            Connection cn = Conexion.Conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT dt.id_datosTransaccion, dt.id_cliente, CONCAT(c.nombre_cliente, ' ', c.apellidos_cliente) AS cliente, GROUP_CONCAT(CONCAT(tr.cantidad,' ',cat.categoria,' - ',a.nombre_articulo, ' - ', a.descripcion_articulo,' - $',a.precio_articulo) SEPARATOR '\\n') AS articulos_comprados, dt.importe_total AS total, dt.aCuenta AS cuenta, dt.fecha_transaccion AS fecha, dt.tipo_transaccion AS transaccion FROM datos_transaccion AS dt INNER JOIN cliente AS c ON dt.id_cliente = c.id_cliente INNER JOIN transacciones AS tr ON dt.id_datosTransaccion = tr.id_datosTransaccion INNER JOIN articulos AS a ON tr.id_articulo = a.id_articulo INNER JOIN categorias AS cat ON a.id_categoria=cat.id_categoria WHERE dt.id_datosTransaccion= '" + idTransaccion + "' GROUP BY dt.id_datosTransaccion;");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                cmb_cliente.setSelectedItem(rs.getString("cliente")); // Seleccionar el cliente
                text_importe.setText(rs.getString("total"));
                text_fecha.setText(rs.getString("fecha"));
                cmb_transaccion.setSelectedItem(rs.getString("transaccion"));

            }
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Error al seleccionar transaccion");
        }
    }
    private void cargarComboClientes() {
        Connection cn = Conexion.Conectar();
        String query = "SELECT * FROM cliente";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            cmb_cliente.removeAllItems();
            cmb_cliente.addItem("Seleccione cliente");
            while (rs.next()) {
                cmb_cliente.addItem(rs.getString("nombre_cliente") + " " + rs.getString("apellidos_cliente"));
                idCliente.add(rs.getInt("id_cliente"));
            }
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Error al cargar clientes");
        }
    }
}

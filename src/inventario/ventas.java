/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inventario;

/**
 *
 * @author Cesar
 */
public class ventas extends javax.swing.JFrame {
public static javax.swing.table.DefaultTableModel modeloTablaGlobal = null;
    public ventas() {
    if (modeloTablaGlobal == null) {
    // 1. Añadimos "ID" como la primera columna
    modeloTablaGlobal = new javax.swing.table.DefaultTableModel(
        new Object [][] {},
        new String [] { "ID", "Item", "Cantidad", "Costo", "SubTotal", "Total" }
    );
    }
   

    initComponents();
    if (modeloTablaGlobal == null) {
        modeloTablaGlobal = new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] { "ID", "Item", "Cantidad", "Costo", "SubTotal", "Total" }
        );
    }
    jTable1.setModel(modeloTablaGlobal);
    
    // 2. Ocultamos la columna 0 (el ID) para que no afecte el diseño visual
    jTable1.getColumnModel().getColumn(0).setMinWidth(0);
    jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
    jTable1.getColumnModel().getColumn(0).setWidth(0);

    this.setLocationRelativeTo(null);
    actualizarStockLabel();
    cargarDatosEnCombos();
    actualizarStockYPrecio();
    cargarVentasEnTabla();
   if (jComboBox4.getItemCount() > 0) {
        jComboBox4.setSelectedIndex(0);
    }
}
    public void cargarVentasEnTabla() {
   javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) jTable1.getModel();
    modelo.setRowCount(0); // Limpiar la tabla antes de cargar para evitar duplicados
    
    // 1. Incluimos el id en la consulta SQL
    String sql = "SELECT id, item, cantidad, costo_unitario, subtotal, total FROM ventas";
    
    try (java.sql.Connection conn = Conexion.conectar();
         java.sql.Statement stmt = conn.createStatement();
         java.sql.ResultSet rs = stmt.executeQuery(sql)) {
         
        while (rs.next()) {
            modelo.addRow(new Object[]{
                rs.getInt("id"), // El ID va de primero (Columna 0 oculta)
                rs.getString("item"),
                rs.getInt("cantidad"),
                rs.getDouble("costo_unitario"),
                rs.getDouble("subtotal"),
                rs.getDouble("total")
            });
        }
    } catch (java.sql.SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error al cargar el historial de ventas: " + e.getMessage());
    }
}

    public void actualizarStockYPrecio() {
   Object productoObj = jComboBox4.getSelectedItem();
        
        if (productoObj == null) {
            jLabelStock.setText("0");
            return;
        }

        String productoSeleccionado = productoObj.toString().trim();
        String sql = "SELECT stock FROM productos WHERE nombre = ?";

        try (java.sql.Connection conn = Conexion.conectar();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, productoSeleccionado);
            
            try (java.sql.ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int stock = rs.getInt("stock");
                    // Muestra el stock actualizado inmediatamente en la etiqueta
                    jLabelStock.setText(String.valueOf(stock));
                } else {
                    jLabelStock.setText("0");
                }
            }
            
        } catch (java.sql.SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al consultar el stock: " + e.getMessage());
        }
    }
// Evento cuando cambia la selección en el ComboBox de productos

    public void cargarDatosEnCombos() {
    // 1. Cargar clientes desde la base de datos en jComboBox3 (Clientes)
    jComboBox3.removeAllItems();
    String sqlClientes = "SELECT nombre FROM clientes";
    
    try (java.sql.Connection conn = Conexion.conectar();
         java.sql.Statement stmt = conn.createStatement();
         java.sql.ResultSet rs = stmt.executeQuery(sqlClientes)) {
         
        while (rs.next()) {
            jComboBox3.addItem(rs.getString("nombre"));
        }
    } catch (java.sql.SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error al cargar clientes: " + e.getMessage());
    }

    // 2. Cargar productos desde la base de datos en jComboBox4 (Productos/Items)
    jComboBox4.removeAllItems();
    String sqlProductos = "SELECT nombre FROM productos";
    
    try (java.sql.Connection conn = Conexion.conectar();
         java.sql.Statement stmt = conn.createStatement();
         java.sql.ResultSet rs = stmt.executeQuery(sqlProductos)) {
         
        while (rs.next()) {
            jComboBox4.addItem(rs.getString("nombre"));
        }
    } catch (java.sql.SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error al cargar productos: " + e.getMessage());
    }
}
private void actualizarStockLabel() {
    if (jComboBox4.getSelectedItem() == null) {
        jLabelStock.setText("0");
        return;
    }
    
    String itemSeleccionado = jComboBox4.getSelectedItem().toString();
    int stockActual = 0;
    
    if (ProductosIngresados.modeloTablaGlobal != null) {
        for (int i = 0; i < ProductosIngresados.modeloTablaGlobal.getRowCount(); i++) {
            Object valNombre = ProductosIngresados.modeloTablaGlobal.getValueAt(i, 1); // Columna 1: Producto
            if (valNombre != null && valNombre.toString().equals(itemSeleccionado)) {
                Object valStock = ProductosIngresados.modeloTablaGlobal.getValueAt(i, 5); // Columna 5: Stock
                if (valStock != null) {
                    String stockStr = valStock.toString().replaceAll("[^0-9]", "").trim();
                    if (!stockStr.isEmpty()) {
                        stockActual = Integer.parseInt(stockStr);
                    }
                }
                break;
            }
        }
    }
    
    // Muestra el stock real en la etiqueta al lado de Cantidad
    jLabelStock.setText(String.valueOf(stockActual));
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabelStock = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        LimpiarHistorial = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/MODULO VENTAS.png"))); // NOI18N
        jLabel1.setText("VENTAS");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Cliente: ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Item", "Cantidad", "Costo", "SubTotal", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabelStock.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelStock.setText("Cantidad");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox4ItemStateChanged(evt);
            }
        });
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("Item");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/arrow.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        LimpiarHistorial.setText("LIMPIAR HISTORIAL");
        LimpiarHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarHistorialActionPerformed(evt);
            }
        });

        jButton3.setText("LIMPIAR ITEM");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(94, 94, 94))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(LimpiarHistorial)
                        .addGap(41, 41, 41))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelStock, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LimpiarHistorial)
                            .addComponent(jButton3))
                        .addGap(41, 41, 41))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel3)
                        .addGap(4, 4, 4)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabelStock)))
                        .addGap(18, 18, 18)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(50, 50, 50))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
      
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
     actualizarStockYPrecio();
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
Object clienteObj = jComboBox3.getSelectedItem();
        Object productoObj = jComboBox4.getSelectedItem();
        
        if (clienteObj == null || productoObj == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor seleccione un cliente y un producto.");
            return;
        }

        String cliente = clienteObj.toString().trim();
        String producto = productoObj.toString().trim();

        int cantidadVendida;
        try {
            cantidadVendida = Integer.parseInt(jSpinner1.getValue().toString());
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor ingrese una cantidad válida en el selector.");
            return;
        }

        if (cantidadVendida <= 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a 0.");
            return;
        }

        try (java.sql.Connection conn = Conexion.conectar()) {
            conn.setAutoCommit(false);

            String sqlProd = "SELECT stock, precio, costo FROM productos WHERE nombre = ?";
            int stockActual = 0;
            double precio = 0.0;
            double costo = 0.0;

            try (java.sql.PreparedStatement pstmt = conn.prepareStatement(sqlProd)) {
                pstmt.setString(1, producto);
                try (java.sql.ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        stockActual = rs.getInt("stock");
                        precio = rs.getDouble("precio");
                        costo = rs.getDouble("costo");
                    } else {
                        javax.swing.JOptionPane.showMessageDialog(this, "El producto seleccionado no existe en el inventario.");
                        conn.rollback();
                        return;
                    }
                }
            }

            if (stockActual < cantidadVendida) {
                javax.swing.JOptionPane.showMessageDialog(this, "Stock insuficiente! Stock disponible: " + stockActual);
                conn.rollback();
                return;
            }

            double subtotal = precio * cantidadVendida;
            double total = subtotal;

            String sqlVenta = "INSERT INTO ventas (cliente, item, cantidad, costo_unitario, subtotal, total) VALUES (?, ?, ?, ?, ?, ?)";
            try (java.sql.PreparedStatement pstmtVenta = conn.prepareStatement(sqlVenta)) {
                pstmtVenta.setString(1, cliente);
                pstmtVenta.setString(2, producto);
                pstmtVenta.setInt(3, cantidadVendida);
                pstmtVenta.setDouble(4, costo);
                pstmtVenta.setDouble(5, subtotal);
                pstmtVenta.setDouble(6, total);
                pstmtVenta.executeUpdate();
            }

            String sqlUpdateStock = "UPDATE productos SET stock = stock - ? WHERE nombre = ?";
            try (java.sql.PreparedStatement pstmtStock = conn.prepareStatement(sqlUpdateStock)) {
                pstmtStock.setInt(1, cantidadVendida);
                pstmtStock.setString(2, producto);
                pstmtStock.executeUpdate();
            }

            conn.commit();

            // Obtenemos el ID autoincremental que acaba de generar SQLite para esta venta
            int idGenerado = 0;
            try (java.sql.Statement stmtId = conn.createStatement();
                 java.sql.ResultSet rsId = stmtId.executeQuery("SELECT last_insert_rowid()")) {
                if (rsId.next()) {
                    idGenerado = rsId.getInt(1);
                }
            }

            // Agregamos la fila a la tabla visual incluyendo el idGenerado en la primera posición (columna 0)
            javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) jTable1.getModel();
            modelo.addRow(new Object[]{idGenerado, producto, cantidadVendida, costo, subtotal, total});

            // Asegurarnos de mantener oculta la columna 0 del ID en la interfaz
            jTable1.getColumnModel().getColumn(0).setMinWidth(0);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(0).setWidth(0);

            javax.swing.JOptionPane.showMessageDialog(this, "¡Venta agregada y stock descontado con éxito!");
            jSpinner1.setValue(1);

        } catch (java.sql.SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error de base de datos en la venta: " + e.getMessage());
        }
    
    }//GEN-LAST:event_jButton1ActionPerformed
    private void jComboBox4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox4ItemStateChanged
  // Se ejecuta cada vez que el usuario selecciona un producto del menú desplegable
    if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            actualizarStockYPrecio();
        }
    }//GEN-LAST:event_jComboBox4ItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 
    this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void LimpiarHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarHistorialActionPerformed
     int confirmar = javax.swing.JOptionPane.showConfirmDialog(
        this, 
        "¿Estás seguro de eliminar TODO el historial de ventas? Esta acción no se puede deshacer.", 
        "Confirmar limpieza", 
        javax.swing.JOptionPane.YES_NO_OPTION,
        javax.swing.JOptionPane.WARNING_MESSAGE
    );

    if (confirmar == javax.swing.JOptionPane.YES_OPTION) {
        try (java.sql.Connection conn = Conexion.conectar();
             java.sql.Statement stmt = conn.createStatement()) {
            
            // 1. Borra todos los registros de la tabla ventas en la base de datos
            stmt.executeUpdate("DELETE FROM ventas");
            
            // 2. Reinicia el contador autoincremental del ID de las ventas en SQLite
            stmt.executeUpdate("DELETE FROM sqlite_sequence WHERE name='ventas'");
            
            // 3. Limpia por completo la tabla visual (JTable) en la pantalla
            javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) jTable1.getModel();
            modelo.setRowCount(0);
            
            javax.swing.JOptionPane.showMessageDialog(this, "¡Historial de ventas borrado y limpiado con éxito!", "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
        } catch (java.sql.SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al limpiar las ventas: " + ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    }//GEN-LAST:event_LimpiarHistorialActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
   int filaSeleccionada = jTable1.getSelectedRow();

// 1. Validar que el usuario haya seleccionado una fila
if (filaSeleccionada == -1) {
    javax.swing.JOptionPane.showMessageDialog(this, "Por favor, seleccione una venta de la tabla para eliminar.", "Advertencia", javax.swing.JOptionPane.WARNING_MESSAGE);
    return;
}

int confirmar = javax.swing.JOptionPane.showConfirmDialog(
    this, 
    "¿Está seguro de eliminar esta venta seleccionada?", 
    "Confirmar eliminación", 
    javax.swing.JOptionPane.YES_NO_OPTION,
    javax.swing.JOptionPane.WARNING_MESSAGE
);

if (confirmar == javax.swing.JOptionPane.YES_OPTION) {
    try {
        // 2. Obtenemos el ID real de la base de datos (asegúrate de que el ID esté en la columna 0 de tu tabla)
        Object idVenta = jTable1.getValueAt(filaSeleccionada, 0);

        // 3. Ejecutamos el DELETE en la base de datos SQLite usando el ID
        try (java.sql.Connection conn = Conexion.conectar();
             java.sql.PreparedStatement pstmt = conn.prepareStatement("DELETE FROM ventas WHERE id = ?")) {
            
            pstmt.setObject(1, idVenta);
            int filasAfectadas = pstmt.executeUpdate();
            
            // Verificamos si realmente se borró en la base de datos
            if (filasAfectadas > 0) {
                // 4. Si se borró en la BD, quitamos la fila de la interfaz visual
                javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) jTable1.getModel();
                if (filaSeleccionada < modelo.getRowCount()) {
                    modelo.removeRow(filaSeleccionada);
                }
                javax.swing.JOptionPane.showMessageDialog(this, "¡Venta eliminada de la base de datos con éxito!", "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "No se encontró el registro en la base de datos con ese ID.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
        
    } catch (Exception ex) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error al eliminar la venta: " + ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
        }

    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LimpiarHistorial;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelStock;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

package inventario;

public class ProductosIngresados extends javax.swing.JFrame {

    public static javax.swing.table.DefaultTableModel modeloTablaGlobal = new javax.swing.table.DefaultTableModel(
        new String[]{"Id", "Producto", "Proveedor", "Precio", "Costo", "Stock"}, 0
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public ProductosIngresados() {
        initComponents();
        this.setLocationRelativeTo(null);
        jTable1.setModel(modeloTablaGlobal);
        cargarProductosDesdeBD();
    }
    
    public void cargarProductosDesdeBD() {
        modeloTablaGlobal.setRowCount(0);
        String sql = "SELECT * FROM productos";
        try (java.sql.Connection conn = Conexion.conectar();
             java.sql.Statement stmt = conn.createStatement();
             java.sql.ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                modeloTablaGlobal.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("proveedor"),
                    rs.getDouble("precio"),
                    rs.getDouble("costo"),
                    rs.getInt("stock")
                });
            }
        } catch (java.sql.SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al cargar inventario: " + e.getMessage());
        }
    }

    private void configurarModeloTabla() {
        String[] columnas = {"Id", "Producto", "Proveedor", "Precio", "Costo", "Stock"};
        
        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        jTable1.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("PRODUCTOS INGRESADOS");

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setText("EDITAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton2.setText("ELIMINAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton3.setText("REGISTRAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/bin (1).png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/pencil.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/memo.png"))); // NOI18N

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/arrow.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(116, 116, 116)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(63, 63, 63))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(30, 30, 30))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addComponent(jButton1)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int filaSeleccionada = jTable1.getSelectedRow();

        if (filaSeleccionada == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor seleccione un producto de la tabla para eliminar.", "Advertencia", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirmar = javax.swing.JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar este producto?", "Confirmar eliminación", javax.swing.JOptionPane.YES_NO_OPTION);

        if (confirmar == javax.swing.JOptionPane.YES_OPTION) {
            Object idProducto = jTable1.getValueAt(filaSeleccionada, 0);

            try (java.sql.Connection conn = Conexion.conectar();
                 java.sql.PreparedStatement pstmt = conn.prepareStatement("DELETE FROM productos WHERE id = ?")) {
                
                pstmt.setObject(1, idProducto);
                pstmt.executeUpdate();

                modeloTablaGlobal.removeRow(filaSeleccionada);
                javax.swing.JOptionPane.showMessageDialog(this, "Producto eliminado correctamente.", "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                
            } catch (java.sql.SQLException ex) {
                javax.swing.JOptionPane.showMessageDialog(this, "Error al eliminar en la base de datos: " + ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int filaSeleccionada = jTable1.getSelectedRow();

        if (filaSeleccionada == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor seleccione un producto de la tabla para editar.", "Advertencia", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        String actualNombre = modeloTablaGlobal.getValueAt(filaSeleccionada, 1).toString();
        String actualProveedor = modeloTablaGlobal.getValueAt(filaSeleccionada, 2).toString();
        String actualPrecio = modeloTablaGlobal.getValueAt(filaSeleccionada, 3).toString().replace("$ ", "");
        String actualCosto = modeloTablaGlobal.getValueAt(filaSeleccionada, 4).toString().replace("$ ", "");
        String actualStock = modeloTablaGlobal.getValueAt(filaSeleccionada, 5).toString();

        String nuevoNombre = javax.swing.JOptionPane.showInputDialog(this, "Edite el Nombre:", actualNombre);
        if (nuevoNombre == null) return;

        String nuevoPrecioStr = javax.swing.JOptionPane.showInputDialog(this, "Edite el Precio:", actualPrecio);
        if (nuevoPrecioStr == null) return;

        String nuevoCostoStr = javax.swing.JOptionPane.showInputDialog(this, "Edite el Costo:", actualCosto);
        if (nuevoCostoStr == null) return;

        String nuevoStockStr = javax.swing.JOptionPane.showInputDialog(this, "Edite el Stock:", actualStock);
        if (nuevoStockStr == null) return;

        try {
            double nuevoPrecio = Double.parseDouble(nuevoPrecioStr.trim());
            double nuevoCosto = Double.parseDouble(nuevoCostoStr.trim());
            int nuevoStock = Integer.parseInt(nuevoStockStr.trim());
            
            if (nuevoPrecio <=

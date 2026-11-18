package inventario;

public class ventas extends javax.swing.JFrame {
    public static javax.swing.table.DefaultTableModel modeloTablaGlobal = null;

    public ventas() {
        if (modeloTablaGlobal == null) {
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
        modelo.setRowCount(0);
        
        String sql = "SELECT id, item, cantidad, costo_unitario, subtotal, total FROM ventas";
        
        try (java.sql.Connection conn = Conexion.conectar();
             java.sql.Statement stmt = conn.createStatement();
             java.sql.ResultSet rs = stmt.executeQuery(sql)) {
             
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt("id"),
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
                    jLabelStock.setText(String.valueOf(stock));
                } else {
                    jLabelStock.setText("0");
                }
            }
            
        } catch (java.sql.SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al consultar el stock: " + e.getMessage());
        }
    }

    public void cargarDatosEnCombos() {
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
                Object valNombre = ProductosIngresados.modeloTablaGlobal.getValueAt(i, 1);
                if (valNombre != null && valNombre.toString().equals(itemSeleccionado)) {
                    Object valStock = ProductosIngresados.modeloTablaGlobal.getValueAt(i, 5);
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
        
        jLabelStock.setText(String.valueOf(stockActual));
    }

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
        LimpiarHistorial = new javax.swing

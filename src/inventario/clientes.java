package inventario;

public class clientes extends javax.swing.JFrame {

    public static javax.swing.table.DefaultTableModel modeloClientesGlobal = new javax.swing.table.DefaultTableModel(
        new String[]{"Nombre", "Número ID", "Celular", "Dirección", "Correo"}, 0
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public clientes() {
        initComponents();
        this.setLocationRelativeTo(null);
        jTable1.setModel(modeloClientesGlobal);
        cargarClientesEnTabla();
    }
    
    public void cargarClientesEnTabla() {
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);
        
        String sql = "SELECT numero_id, nombre, celular, direccion, correo FROM clientes";
        
        try (java.sql.Connection conn = Conexion.conectar();
             java.sql.Statement stmt = conn.createStatement();
             java.sql.ResultSet rs = stmt.executeQuery(sql)) {
             
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getString("nombre"),
                    rs.getString("numero_id"),
                    rs.getString("celular"),
                    rs.getString("direccion"),
                    rs.getString("correo")
                });
            }
        } catch (java.sql.SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al cargar clientes: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtclientes = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtCELULAR = new javax.swing.JLabel();
        txtnombre1 = new javax.swing.JLabel();
        txtID1 = new javax.swing.JLabel();
        txtCORREO = new javax.swing.JLabel();
        txtIDIRECCION = new javax.swing.JLabel();
        DIRECCION = new javax.swing.JTextField();
        CELULAR1 = new javax.swing.JTextField();
        CORREO1 = new javax.swing.JTextField();
        NOMBRE1 = new javax.swing.JTextField();
        ID1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        CREAR = new javax.swing.JButton();
        ELIMINAR = new javax.swing.JButton();
        EDITAR = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        txtclientes.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txtclientes.setText("CLIENTES");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/arrow.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(304, 304, 304)
                .addComponent(txtclientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtclientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        txtCELULAR.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtCELULAR.setText("CELULAR:");

        txtnombre1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtnombre1.setText("NOMBRE:");

        txtID1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtID1.setText("NUMERO ID:");

        txtCORREO.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtCORREO.setText("CORREO:");

        txtIDIRECCION.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtIDIRECCION.setText("DIRECCION:");

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

        CREAR.setText("CREAR");
        CREAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CREARActionPerformed(evt);
            }
        });

        ELIMINAR.setText("ELIMINAR");
        ELIMINAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ELIMINARActionPerformed(evt);
            }
        });

        EDITAR.setText("EDITAR");
        EDITAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EDITARActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCELULAR)
                            .addComponent(txtCORREO))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CORREO1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CELULAR1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtnombre1)
                        .addGap(18, 18, 18)
                        .addComponent(NOMBRE1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtIDIRECCION)
                                .addGap(29, 29, 29)
                                .addComponent(DIRECCION, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtID1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(CREAR)
                        .addGap(32, 32, 32)
                        .addComponent(ELIMINAR)
                        .addGap(44, 44, 44)
                        .addComponent(EDITAR)))
                .addContainerGap(73, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(

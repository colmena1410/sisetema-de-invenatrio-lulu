/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inventario;

/**
 *
 * @author Cesar
 */
public class usuarios extends javax.swing.JFrame {
public static javax.swing.table.DefaultTableModel modeloUsuariosGlobal = new javax.swing.table.DefaultTableModel(
    new Object [][] {},
    new String [] { "ID", "Usuario", "Contraseña" }
);
    /**
     * Creates new form usuarios
     */
    public usuarios() {
        
        initComponents();
        this.setLocationRelativeTo(null);
        jTable1.setModel(modeloUsuariosGlobal);
        jTable1.setModel(agregarusuario.modeloUsuariosGlobal);
        cargarUsuariosEnTabla();
    }
public void cargarUsuariosEnTabla() {
    // Obtenemos el modelo de tu JTable (asegúrate de que tu tabla se llame jTable1)
    javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) jTable1.getModel();
    modelo.setRowCount(0); // Limpia la tabla antes de cargar para evitar duplicados
    
    String sql = "SELECT id, usuario, rol FROM usuarios";
    
    try (java.sql.Connection conn = Conexion.conectar();
         java.sql.Statement stmt = conn.createStatement();
         java.sql.ResultSet rs = stmt.executeQuery(sql)) {
         
        while (rs.next()) {
            modelo.addRow(new Object[]{
                rs.getInt("id"),
                rs.getString("usuario"),
                "********", // Ocultamos la contraseña por seguridad en la tabla
                rs.getString("rol")
            });
        }
    } catch (java.sql.SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error al cargar usuarios: " + e.getMessage());
    }
}
       


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("ADMINISTRAR USUARIOS");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/arrow.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addContainerGap())
        );

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

        jButton1.setText("<html><center>AGREGAR<br>USUARIO</center></html>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("PERMISOS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("<html><center>ELIMINAR<br>USUARIO</center></html>");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("<html><center>ACTUALIZAR<br>USUARIO</center></html>");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(145, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
agregarusuario ventana = new agregarusuario();
    ventana.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
   // 1. Verificar si hay una fila seleccionada
int filaSeleccionada = jTable1.getSelectedRow();

if (filaSeleccionada == -1) {
    javax.swing.JOptionPane.showMessageDialog(this, "Por favor, seleccione un usuario de la tabla para actualizar.", "Advertencia", javax.swing.JOptionPane.WARNING_MESSAGE);
    return;
}

// 2. Obtener los datos actuales de la fila seleccionada (usando jTable1 o el modelo global)
Object idActual = jTable1.getValueAt(filaSeleccionada, 0);
String usuarioActual = jTable1.getValueAt(filaSeleccionada, 1).toString();
// Nota: Validamos el índice de la columna del rol según tu estructura real (si está en la 2 o 3)
String rolActual = jTable1.getValueAt(filaSeleccionada, 3).toString();

// 3. Mostrar JOptionPane para editar el nombre de usuario
String nuevoUsuario = javax.swing.JOptionPane.showInputDialog(this, "Modificar Nombre de Usuario:", usuarioActual);
if (nuevoUsuario == null || nuevoUsuario.trim().isEmpty()) {
    return; // Si cancela o lo deja vacío, no hace nada
}

// 4. Mostrar JOptionPane para editar la contraseña
String nuevaContraseña = javax.swing.JOptionPane.showInputDialog(this, "Modificar Contraseña (o dejar ***):", "***");
if (nuevaContraseña == null) {
    return;
}

// 5. Opciones para el rol usando un ComboBox dentro de un JOptionPane
Object[] roles = {"ADMINISTRADOR", "VENDEDOR"};
Object nuevoRol = javax.swing.JOptionPane.showInputDialog(
    this, 
    "Seleccione el nuevo rol:", 
    "Modificar Rol", 
    javax.swing.JOptionPane.QUESTION_MESSAGE, 
    null, 
    roles, 
    rolActual
);

if (nuevoRol == null) {
    return;
}

// 6. Ejecutar la actualización en la base de datos SQLite
try (java.sql.Connection conn = Conexion.conectar();
     java.sql.PreparedStatement pstmt = nuevaContraseña.equals("***") ? 
         // Si la contraseña es "***", no la modificamos en la base de datos
         conn.prepareStatement("UPDATE usuarios SET usuario = ?, rol = ? WHERE id = ?") :
         // Si escribió una contraseña nueva, sí la actualizamos
         conn.prepareStatement("UPDATE usuarios SET usuario = ?, contrasena = ?, rol = ? WHERE id = ?")) {
    
    pstmt.setString(1, nuevoUsuario.trim());
    
    if (nuevaContraseña.equals("***")) {
        pstmt.setString(2, nuevoRol.toString().toUpperCase());
        pstmt.setObject(3, idActual);
    } else {
        pstmt.setString(2, nuevaContraseña.trim());
        pstmt.setString(3, nuevoRol.toString().toUpperCase());
        pstmt.setObject(4, idActual);
    }
    
    pstmt.executeUpdate();

    // 7. Actualizar los datos en el modelo global de la tabla visual
    jTable1.setValueAt(nuevoUsuario.trim(), filaSeleccionada, 1);
    jTable1.setValueAt("***", filaSeleccionada, 2); // Mantiene la contraseña enmascarada
    jTable1.setValueAt(nuevoRol.toString().toUpperCase(), filaSeleccionada, 3);
    
    javax.swing.JOptionPane.showMessageDialog(this, "¡Usuario actualizado exitosamente en la base de datos!", "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);

} catch (java.sql.SQLException ex) {
    javax.swing.JOptionPane.showMessageDialog(this, "Error al actualizar el usuario en la base de datos (el nombre de usuario podría estar repetido): " + ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
   int filaSeleccionada = jTable1.getSelectedRow();

// 1. Validar que realmente haya una fila seleccionada
if (filaSeleccionada == -1) {
    javax.swing.JOptionPane.showMessageDialog(this, "Por favor, seleccione un usuario de la tabla para eliminar.", "Advertencia", javax.swing.JOptionPane.WARNING_MESSAGE);
    return;
}

int confirmar = javax.swing.JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar este usuario?", "Confirmar eliminación", javax.swing.JOptionPane.YES_NO_OPTION);

if (confirmar == javax.swing.JOptionPane.YES_OPTION) {
    try {
        // 2. Obtener el ID del usuario desde la primera columna (índice 0)
        Object idUsuario = jTable1.getValueAt(filaSeleccionada, 0);

        // 3. Ejecutar el DELETE en la base de datos SQLite
        try (java.sql.Connection conn = Conexion.conectar();
             java.sql.PreparedStatement pstmt = conn.prepareStatement("DELETE FROM usuarios WHERE id = ?")) {
            
            pstmt.setObject(1, idUsuario);
            pstmt.executeUpdate();
        }

        // 4. Obtener el modelo directamente del JTable para evitar conflictos de índices
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) jTable1.getModel();
        
        // Verificar que la fila esté dentro del rango actual del modelo antes de borrarla
        if (filaSeleccionada < modelo.getRowCount()) {
            modelo.removeRow(filaSeleccionada);
        }
        
        javax.swing.JOptionPane.showMessageDialog(this, "¡Usuario eliminado exitosamente de la base de datos!", "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        
    } catch (Exception ex) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error al eliminar el usuario: " + ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

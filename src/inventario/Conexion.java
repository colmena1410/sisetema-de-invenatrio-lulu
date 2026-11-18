package inventario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion {

    // Cambiamos la URL fija por una dinámica basada en la carpeta donde se ejecuta el programa (la USB o PC)
    public static Connection conectar() {
        Connection conn = null;
        try {
            // Obtiene la ruta del directorio actual de ejecución
            String directorioActual = System.getProperty("user.dir");
            
            // Construye la ruta portable hacia lulubeauty.db en la misma carpeta
            String url = "jdbc:sqlite:" + directorioActual + "/lulubeauty.db";
            
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con SQLite portable: " + e.getMessage());
        }
        return conn;
    }

    public static void inicializarBaseDeDatos() {
        String sqlUsuarios = "CREATE TABLE IF NOT EXISTS usuarios ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "usuario TEXT UNIQUE NOT NULL, "
                + "contrasena TEXT NOT NULL, "
                + "rol TEXT NOT NULL);";

        String sqlProveedores = "CREATE TABLE IF NOT EXISTS proveedores ("
                + "id TEXT PRIMARY KEY, "
                + "nombre TEXT NOT NULL, "
                + "direccion TEXT, "
                + "correo TEXT);";

        String sqlClientes = "CREATE TABLE IF NOT EXISTS clientes ("
                + "numero_id TEXT PRIMARY KEY, "
                + "nombre TEXT NOT NULL, "
                + "celular TEXT, "
                + "direccion TEXT, "
                + "correo TEXT);";

        String sqlProductos = "CREATE TABLE IF NOT EXISTS productos ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "nombre TEXT UNIQUE NOT NULL, "
                + "proveedor TEXT, "
                + "precio REAL NOT NULL, "
                + "costo REAL NOT NULL, "
                + "stock INTEGER NOT NULL);";

        String sqlVentas = "CREATE TABLE IF NOT EXISTS ventas ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "cliente TEXT NOT NULL, "
                + "item TEXT NOT NULL, "
                + "cantidad INTEGER NOT NULL, "
                + "costo_unitario REAL NOT NULL, "
                + "subtotal REAL NOT NULL, "
                + "total REAL NOT NULL, "
                + "fecha TEXT DEFAULT (DATETIME('now', 'localtime')));";

        // Crea un usuario admin por defecto si la tabla está vacía
        String sqlAdminDefault = "INSERT OR IGNORE INTO usuarios (id, usuario, contrasena, rol) "
                + "VALUES (1, 'admin', '1234', 'ADMINISTRADOR');";

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement()) {
            
            stmt.execute(sqlUsuarios);
            stmt.execute(sqlProveedores);
            stmt.execute(sqlClientes);
            stmt.execute(sqlProductos);
            stmt.execute(sqlVentas);
            stmt.execute(sqlAdminDefault);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al inicializar tablas: " + e.getMessage());
        }
    }
}
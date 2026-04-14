/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Alexç
 */
public class dbConnetion {
    
    private static final String HOST = "almacenitla-db-itla-3837.e.aivencloud.com";
    private static final String PUERTO = "25037";
    private static final String DB = "almacenitlafinal"; 
    // Obtención de credenciales mediante variables de entorno
    // En lugar de almacenar el usuario y la contraseña directamente en el código (lo cual es inseguro),
    // se utilizan variables de entorno del sistema operativo.
    //
    // System.getenv("DB_USER") y System.getenv("DB_PASSWORD") buscan estos valores fuera del programa,
    // por ejemplo en la configuración del sistema o del entorno de ejecución.
    //
    // Ventajas:
    // - Evita exponer credenciales sensibles en el código fuente.
    // - Permite cambiar usuario y contraseña sin modificar el código.
    // - Es una práctica estándar en desarrollo profesional y trabajo en equipo.
    //
    // Nota: Para que esto funcione, debes definir previamente las variables de entorno en tu sistema.
    // Ejemplo en Windows (PowerShell):
    // setx DB_USER "admin"
    // setx DB_PASSWORD "tu_password"
    private static final String USER = System.getenv("DB_USER");
    private static final String PASSWORD = System.getenv("DB_PASSWORD"); // tu contraseña
    private static final String URL = "jdbc:mysql://" + HOST + ":" + PUERTO + "/" + DB
                                        + "?sslMode=REQUIRED&serverTimezone=UTC";

    public static Connection getConexion() {
        Connection conn = null;
        
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa");
        } catch (SQLException e) {
            System.out.println("Error en la conexión: " + e.getMessage());
        }
        
        return conn;
    }
}

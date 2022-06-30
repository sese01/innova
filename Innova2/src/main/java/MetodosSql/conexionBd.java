/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MetodosSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sese4
 */
public class conexionBd {

    public static String url = "jdbc:mysql://localhost/basededatos";
    public static String usuario = "root";
    public static String contraseña = "123456789";
    public static String clase = "com.mysql.jdbc.Driver";

    public static Connection conectar() {
        Connection conexion = null;
        try {
            Class.forName(clase);
            conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexion Establecida");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return conexion;

    }

}

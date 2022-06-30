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
class ConexionBD {

    public static String url = "jdbc:mysql://localhost:3307/login_bd";
    public static String usuario = "root";
    public static String contraseña = "123456789";
    public static String clase = "com.mysql.jdbc.Driver";
    public static Connection conectar(){
        Connection conexion = null;
        
        try {
            Class.forName(clase);
            conexion = (Connection) DriverManager.getConnection(url,usuario,contraseña);
            System.out.println("conexion establecida");
            
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("e");
        }
        return conexion;
    }
     
}

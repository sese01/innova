/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MetodosSql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author sese4
 */
public class MetodosSql {

    public static ConexionBD conexion = new ConexionBD()
    public static PreparedStatement sentencia_preparada;
    public static ResultSet resultado;
    public static String sql;
    public static int resultado_numero = 0;

    public int guardar(String nombre, String apellidos, String correo, String contraseña) {
        int resultado = 0;
        Connection conexion = null;

        String sentencia_guardar = ("INSERT INTO usuarios (nombre,apellidos,correo,contraseña) VALUES(?,?,?,?)");
        try {
            conexion = ConexionBD.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
            sentencia_preparada.setString(3, correo);
            sentencia_preparada.setString(1, nombre);
            sentencia_preparada.setString(4, contraseña);
            sentencia_preparada.setString(2, apellidos);

            resultado = sentencia_preparada.executeUpdate();
            sentencia_preparada.close();
            conexion.close();
        } 
        catch (Exception e) {
            System.out.println(e);
        }
        return resultado;

    }

    public static String buscarNombre(String correo) {
        String busqueda_nombre = null;
        Connection conexion = null;

        try {
            conexion = ConexionBD.conectar();
            String sentencia_buscar = ("SELECT nombre,apellidos FROM usuarios WHERE correo = '" + correo + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                String nombre = resultado.getString("nombre");
                String apellidos = resultado.getString("apellidos");
                busqueda_nombre = (nombre + " " + apellidos);

            }
            conexion.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_nombre;
    }
    
    
    public static String buscarUsuarioRegistrado(String correo, String contraseña){
    String busqueda_usuarios = null;
    Connection conexion = null;
    
        try {
            conexion = ConexionBD.conectar();
            String sentencia_buscar_usuario = ("SELECT nombre,correo,contraseña FROM usuarios WHERE correo = '" + correo + "' && contraseña = '"+contraseña+"'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar_usuario);
            resultado = sentencia_preparada.executeQuery();
            if(resultado.next()){
            busqueda_usuarios = "usuario Encontrado";
            
            }else{
            busqueda_usuarios = "no encontrado";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_usuarios;
    }

}

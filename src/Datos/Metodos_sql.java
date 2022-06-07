/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import static Metodos.Metodos.resultado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Acer
 */
public class Metodos_sql {
   
   Statement sentenciaSQL;
    
    ConexionBD con;

    public static PreparedStatement sentencia_preparada;
    public static String url;
    public static int resultado_numero =0;
    
              public static String buscar_Nombre(String Usuario) {
              String Busqueda_Nombre = null;
              Connection conexion = null;
                  try {
                 ConexionBD con = new ConexionBD();
                 String Sentencia_Buscar = "SELECT Nombre,Apellidos, Usuario,Contraseña ,Tipo FROM Usuario WHERE Usuario=  '" + Usuario + "'";
    
                PreparedStatement sentencia_preparada = con.Conectarse().prepareStatement(Sentencia_Buscar);
                resultado = sentencia_preparada.executeQuery();
                   if (resultado.next()) {
        
                  String Nombre = resultado.getString("Nombre");
                  String Apellidos = resultado.getString("Apellidos");
                  Busqueda_Nombre = Nombre + " " + Apellidos;
                } 
                sentencia_preparada.close();
                conexion.close();
                } catch (Exception exception) {}

                return Busqueda_Nombre;
            }
  
              public static String Buscar_Tipo(String usuario){
                  String tipo="";
                   Connection conexion = null;
                  try {
                 ConexionBD con = new ConexionBD();
                 String Sentencia_Buscar = "SELECT Tipo FROM Usuario WHERE Usuario=  '" + usuario + "'";
    
                PreparedStatement sentencia_preparada = con.Conectarse().prepareStatement(Sentencia_Buscar);
                resultado = sentencia_preparada.executeQuery();
                   if (resultado.next()) {
        
                  tipo = resultado.getString("Tipo");
                } 
                sentencia_preparada.close();
                conexion.close();
                } catch (Exception exception) {}
                  return tipo;
              }
    public static String Buscar_Usuario(String usuario, String contraseña) {
             String Busqueda_Usuario = null;
             Connection conexion = null;
             try {
               ConexionBD con = new ConexionBD();
               String Sentencia_Buscar_Usuario = ("SELECT Nombre, Usuario, Contraseña FROM Usuario WHERE Usuario = '"+usuario+"' && Contraseña = '"+ contraseña+"'");
       
               PreparedStatement sentencia_preparada = con.Conectarse().prepareStatement(Sentencia_Buscar_Usuario);
               resultado = sentencia_preparada.executeQuery();
                   if (resultado.next()) {

    
                Busqueda_Usuario = "Usuario encontrado";
                } else {
    
                Busqueda_Usuario = "Usuario no encontrado";
               } 
               sentencia_preparada.close();
              conexion.close();
           } catch (Exception e) {
           System.out.println(e);
        } 
        return Busqueda_Usuario;
    }
 
    public void Guardar1(String nombre, String apellidos, String correo, String contraseña, String tipo) {
try {
this.con = new ConexionBD();
String insertar = "INSERT INTO Usuario (Nombre, Apellidos, Usuario, Contraseña, Tipo ) VALUES(?,?,?,?,?)";

PreparedStatement sentencia_preparada = this.con.Conectarse().prepareStatement(insertar);
sentencia_preparada.setString(1, nombre);
sentencia_preparada.setString(2, apellidos);
sentencia_preparada.setString(3, correo);
sentencia_preparada.setString(4, contraseña);
sentencia_preparada.setString(5, tipo);
int n = sentencia_preparada.executeUpdate();
if (n > 0)
JOptionPane.showMessageDialog(null, "El usuario ha sido guardado", "Confirm", 1);
this.con.CerrarConexion();
} catch (ClassNotFoundException ex) {
JOptionPane.showMessageDialog(null, "Clase no encontrada..." + ex);
} catch (InstantiationException ex) {
JOptionPane.showMessageDialog(null, "Error de conexion..." + ex);
} catch (IllegalAccessException ex) {
JOptionPane.showMessageDialog(null, "Acceso ilegal a la base de datos..." + ex);
} catch (SQLException ex) {
JOptionPane.showMessageDialog(null, "Error de sentencia..." + ex);
}
}
    
}

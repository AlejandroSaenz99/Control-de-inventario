package Datos;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ConexionBD {
  private Connection conexion = null;
  
  private Statement sentenciaSQL;
  
  private ResultSet resultado;
  
  
  //Este es
  public ConexionBD() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
   try{   
String dbPath="";
String dbName="";
String userDB="";
String passDB="";

String path=new File ("ConfiguracionMADS.txt").getAbsolutePath ();

File file = new File(path);
if(file.exists())
{
Scanner sc = new Scanner(file);

dbPath = sc.nextLine();
dbName = sc.nextLine();
userDB = sc.nextLine();
passDB = sc.nextLine();
System.out.println(dbPath+" "+"" +dbName+" "+" "+userDB+" "+" "+passDB);

}
else{
JOptionPane.showMessageDialog(null, "ConfiguracionMADS.txt not found");
}
      
    String controlador = "com.mysql.jdbc.Driver";
    Class.forName(controlador).newInstance();
 String URL = "jdbc:mysql://localhost:3306/u524173526_MADS?zeroDateTimeBehavior=convertToNull";
//conexion= DriverManager.getConnection("jdbc:mysql://"+dbPath+"/"+dbName+"", ""+userDB+"", ""+passDB+"");
 String usuario = "root";
String password = "";
this.conexion = DriverManager.getConnection(URL, usuario, password);
   }
   catch(Exception ex){
       ex.printStackTrace();
   }
  }
  
  public Connection Conectarse() {
    return this.conexion;
  }
  
  public void CerrarConexion() throws SQLException {
    if (this.resultado != null)
      this.resultado.close(); 
    if (this.sentenciaSQL != null)
      this.sentenciaSQL.close(); 
    if (this.conexion != null)
      this.conexion.close(); 
  }
}
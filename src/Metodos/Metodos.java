/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Datos.ConexionBD;
import Datos.DArticulos;
import Datos.DCategorias;
import Datos.DEntradas;
import Datos.DMotivos;
import Datos.DSalidas;
import Presentacion.IFisico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import com.mxrck.autocompleter.TextAutoCompleter;
import com.toedter.calendar.JDateChooser;
import java.util.Date;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author AlejandroSaenz
 */
public class Metodos {

    Statement sentenciaSQL;

    ConexionBD con;

    public static PreparedStatement sentencia_preparada;

    public static ResultSet resultado;

    public static String url;

    public static int Resultado_numero = 0;

    public JTable MostrarTabla(JTable TablaArticulo) {
        try {

            String sql = "SELECT * FROM articulos ";

            this.con = new ConexionBD();
            this.sentenciaSQL = this.con.Conectarse().createStatement();
            ResultSet rs = this.sentenciaSQL.executeQuery(sql);
            ResultSetMetaData rsm = rs.getMetaData();
            int col = rsm.getColumnCount();
            DefaultTableModel modelo = new DefaultTableModel();
            for (int i = 1; i <= col; i++) {
                modelo.addColumn(rsm.getColumnLabel(i));
            }
            while (rs.next()) {
                String[] fila = new String[col];
                for (int j = 0; j < col; j++) {
                    fila[j] = rs.getString(j + 1);
                }
                modelo.addRow((Object[]) fila);
            }
            TablaArticulo.setModel(modelo);
            rs.close();
            this.con.CerrarConexion();
        } catch (Exception e) {
            System.out.println(e);
        }
        return TablaArticulo;
    }
public JTable mostrarTablaHistorial(JTable TablaArticulo) {
        try {

            String sql = "SELECT * FROM Motivos ";

            this.con = new ConexionBD();
            this.sentenciaSQL = this.con.Conectarse().createStatement();
            ResultSet rs = this.sentenciaSQL.executeQuery(sql);
            ResultSetMetaData rsm = rs.getMetaData();
            int col = rsm.getColumnCount();
            DefaultTableModel modelo = new DefaultTableModel();
            for (int i = 1; i <= col; i++) {
                modelo.addColumn(rsm.getColumnLabel(i));
            }
            while (rs.next()) {
                String[] fila = new String[col];
                for (int j = 0; j < col; j++) {
                    fila[j] = rs.getString(j + 1);
                }
                modelo.addRow((Object[]) fila);
            }
            TablaArticulo.setModel(modelo);
            rs.close();
            this.con.CerrarConexion();
        } catch (Exception e) {
            System.out.println(e);
        }
        return TablaArticulo;
    }

    public JTable MostrarTablaInventarioPorNumero(JTable Tabla, JComboBox NI) {
        try {
            String sql;
            if (NI.getSelectedItem().toString().equals("Todos")) {
                sql = "SELECT Numero as '#Inventario',Id, Nombre,Descripcion,Categoria,Unidad_Medida,Cantidad,Fecha FROM InventarioFisico Order by Numero Desc, id Asc";
            } else {
                sql = "SELECT Numero as '#Inventario',Id, Nombre,Descripcion,Categoria,Unidad_Medida,Cantidad,Fecha FROM InventarioFisico Where Numero='" + NI.getSelectedItem() + "'";
            }
            this.con = new ConexionBD();
            this.sentenciaSQL = this.con.Conectarse().createStatement();
            ResultSet rs = this.sentenciaSQL.executeQuery(sql);
            ResultSetMetaData rsm = rs.getMetaData();
            int col = rsm.getColumnCount();
            DefaultTableModel modelo = new DefaultTableModel();
            for (int i = 1; i <= col; i++) {
                modelo.addColumn(rsm.getColumnLabel(i));
            }
            while (rs.next()) {
                String[] fila = new String[col];
                for (int j = 0; j < col; j++) {
                    fila[j] = rs.getString(j + 1);
                }
                modelo.addRow((Object[]) fila);
            }
            Tabla.setModel(modelo);
            rs.close();
            this.con.CerrarConexion();
        } catch (Exception e) {
            System.out.println(e);
        }
        return Tabla;
    }

    public static String Buscar_Repetido(String Id, int Numero) {
        /*  99 */ String Busqueda_Usuario = null;
        /* 100 */ Connection conexion = null;
        /*     */ try {
            /* 102 */ ConexionBD con = new ConexionBD();
            /* 103 */ String Sentencia_Buscar_Usuario = "SELECT Id FROM InventarioFisico WHERE Id='" + Id + "' AND Numero='" + Numero + "'";
            /*     */
 /* 105 */ PreparedStatement sentencia_preparada = con.Conectarse().prepareStatement(Sentencia_Buscar_Usuario);
            /* 106 */ resultado = sentencia_preparada.executeQuery();
            /* 107 */ if (resultado.next()) {
                /*     */
 /* 109 */ Busqueda_Usuario = "Id ya existe";
                /*     */            } else {
                /*     */
 /* 112 */ Busqueda_Usuario = "Id no existe";
                /*     */            }
            /* 114 */ sentencia_preparada.close();
            /* 115 */ conexion.close();
            /* 116 */        } catch (Exception e) {
            /* 117 */ System.out.println(e);
            /*     */        }
        /* 119 */ return Busqueda_Usuario;
        /*     */    }

    
    public JTable MostrarTablaEnReorden(JTable TablaArticulo) {
        try {

            String sql = "SELECT * FROM articulos WHERE Stock<=Punto_Reorden";
            this.con = new ConexionBD();
            this.sentenciaSQL = this.con.Conectarse().createStatement();
            ResultSet rs = this.sentenciaSQL.executeQuery(sql);
            ResultSetMetaData rsm = rs.getMetaData();
            int col = rsm.getColumnCount();
            DefaultTableModel modelo = new DefaultTableModel();
            for (int i = 1; i <= col; i++) {
                modelo.addColumn(rsm.getColumnLabel(i));
            }
            while (rs.next()) {
                String[] fila = new String[col];
                for (int j = 0; j < col; j++) {
                    fila[j] = rs.getString(j + 1);
                }
                modelo.addRow((Object[]) fila);
            }
            TablaArticulo.setModel(modelo);
            rs.close();
            this.con.CerrarConexion();
        } catch (Exception e) {
            System.out.println(e);
        }
        return TablaArticulo;
    }

    public JTable MostrarTablaIF(JTable TablaArticulo, JLabel Num) {
        try {

            String sql = "SELECT Numero as '#Inventario',Id, Nombre,Descripcion,Categoria,Unidad_Medida,Cantidad,Fecha FROM InventarioFisico Where Numero='" + Num.getText() + "' Order by Numero Desc ";
            this.con = new ConexionBD();
            this.sentenciaSQL = this.con.Conectarse().createStatement();
            ResultSet rs = this.sentenciaSQL.executeQuery(sql);
            ResultSetMetaData rsm = rs.getMetaData();
            int col = rsm.getColumnCount();
            DefaultTableModel modelo = new DefaultTableModel();
            for (int i = 1; i <= col; i++) {
                modelo.addColumn(rsm.getColumnLabel(i));
            }
            while (rs.next()) {
                String[] fila = new String[col];
                for (int j = 0; j < col; j++) {
                    fila[j] = rs.getString(j + 1);
                }
                modelo.addRow((Object[]) fila);
            }
            TablaArticulo.setModel(modelo);
            rs.close();
            this.con.CerrarConexion();
        } catch (Exception e) {
            System.out.println(e);
        }
        return TablaArticulo;
    }

    public JTable MostrarTablaCategoria(JTable TablaCategoria) {
        try {

            String sql = "SELECT * FROM Categoria Order by Id";

            this.con = new ConexionBD();
            this.sentenciaSQL = this.con.Conectarse().createStatement();
            ResultSet rs = this.sentenciaSQL.executeQuery(sql);
            ResultSetMetaData rsm = rs.getMetaData();
            int col = rsm.getColumnCount();
            DefaultTableModel modelo = new DefaultTableModel();
            for (int i = 1; i <= col; i++) {
                modelo.addColumn(rsm.getColumnLabel(i));
            }
            while (rs.next()) {
                String[] fila = new String[col];
                for (int j = 0; j < col; j++) {
                    fila[j] = rs.getString(j + 1);
                }
                modelo.addRow((Object[]) fila);
            }
            TablaCategoria.setModel(modelo);
            rs.close();
            this.con.CerrarConexion();
        } catch (Exception e) {
            System.out.println(e);
        }
        return TablaCategoria;
    }

    public JTable MostrarTablaEntradas(JTable TablaEntradas) {
        try {

            String sql = "SELECT Id,Nombre,Descripcion,Costo_Entrada,Stock,Entrada AS 'Cantidad',Fecha_Ultima_Entrada AS'Fecha Entrada',Hora,Categoria FROM Bitacora  Order by Id";

            this.con = new ConexionBD();
            this.sentenciaSQL = this.con.Conectarse().createStatement();
            ResultSet rs = this.sentenciaSQL.executeQuery(sql);
            ResultSetMetaData rsm = rs.getMetaData();
            int col = rsm.getColumnCount();
            DefaultTableModel modelo = new DefaultTableModel();
            for (int i = 1; i <= col; i++) {
                modelo.addColumn(rsm.getColumnLabel(i));
            }
            while (rs.next()) {
                String[] fila = new String[col];
                for (int j = 0; j < col; j++) {
                    fila[j] = rs.getString(j + 1);
                }
                modelo.addRow((Object[]) fila);
            }
            TablaEntradas.setModel(modelo);
            rs.close();
            this.con.CerrarConexion();
        } catch (Exception e) {
            System.out.println(e);
        }
        return TablaEntradas;
    }

    public JTable MostrarTablaSalidas(JTable TablaSalidas) {
        try {

            String sql = "SELECT Id,Nombre,Descripcion,Costo_Promedio_U,Stock,Salida AS 'Cantidad',Fecha_Salida AS'Fecha Salida',Hora,Categoria FROM Bitacora WHERE Estado = 'Salida' Order by Id";

            this.con = new ConexionBD();
            this.sentenciaSQL = this.con.Conectarse().createStatement();
            ResultSet rs = this.sentenciaSQL.executeQuery(sql);
            ResultSetMetaData rsm = rs.getMetaData();
            int col = rsm.getColumnCount();
            DefaultTableModel modelo = new DefaultTableModel();
            for (int i = 1; i <= col; i++) {
                modelo.addColumn(rsm.getColumnLabel(i));
            }
            while (rs.next()) {
                String[] fila = new String[col];
                for (int j = 0; j < col; j++) {
                    fila[j] = rs.getString(j + 1);
                }
                modelo.addRow((Object[]) fila);
            }
            TablaSalidas.setModel(modelo);
            rs.close();
            this.con.CerrarConexion();
        } catch (Exception e) {
            System.out.println(e);
        }
        return TablaSalidas;
    }

    public JTable MostrarTablaCatalogo(JTable TablaCat, JComboBox Cat) {
        try {

            String sql = "SELECT * FROM articulos WHERE Categoria='" + Cat.getSelectedItem().toString() + "'";

            this.con = new ConexionBD();
            this.sentenciaSQL = this.con.Conectarse().createStatement();
            ResultSet rs = this.sentenciaSQL.executeQuery(sql);
            ResultSetMetaData rsm = rs.getMetaData();
            int col = rsm.getColumnCount();
            DefaultTableModel modelo = new DefaultTableModel();
            for (int i = 1; i <= col; i++) {
                modelo.addColumn(rsm.getColumnLabel(i));
            }
            while (rs.next()) {
                String[] fila = new String[col];
                for (int j = 0; j < col; j++) {
                    fila[j] = rs.getString(j + 1);
                }
                modelo.addRow((Object[]) fila);
            }
            TablaCat.setModel(modelo);
            rs.close();
            this.con.CerrarConexion();
        } catch (Exception e) {
            System.out.println(e);
        }
        return TablaCat;
    }

    public JTable MostrarTablaB(JTable TablaCat, JComboBox Cat) {
        try {
            String sql = "";
            if (Cat.getSelectedItem().toString().equals("Todos")) {
                sql = "SELECT * FROM Bitacora";
            } else if (Cat.getSelectedItem().toString().equals("Entrada")) {
                sql = "SELECT Id,Nombre,Descripcion,Costo_Entrada,Stock,Entrada AS 'Cantidad',Fecha_Ultima_Entrada AS'Fecha Entrada',Hora,Categoria FROM Bitacora WHERE Estado = 'Entrada'  Order by Id";
            } else if (Cat.getSelectedItem().toString().equals("Salida")) {
                sql = "SELECT Id,Nombre,Descripcion,Costo_Promedio_U,Stock,Salida AS 'Cantidad',Fecha_Salida AS'Fecha Salida',Hora,Categoria FROM Bitacora WHERE Estado = 'Salida' Order by Id";
            }
            this.con = new ConexionBD();
            this.sentenciaSQL = this.con.Conectarse().createStatement();
            ResultSet rs = this.sentenciaSQL.executeQuery(sql);
            ResultSetMetaData rsm = rs.getMetaData();
            int col = rsm.getColumnCount();
            DefaultTableModel modelo = new DefaultTableModel();
            for (int i = 1; i <= col; i++) {
                modelo.addColumn(rsm.getColumnLabel(i));
            }
            while (rs.next()) {
                String[] fila = new String[col];
                for (int j = 0; j < col; j++) {
                    fila[j] = rs.getString(j + 1);
                }
                modelo.addRow((Object[]) fila);
            }
            TablaCat.setModel(modelo);
            rs.close();
            this.con.CerrarConexion();
        } catch (Exception e) {
            System.out.println(e);
        }
        return TablaCat;
    }

    public JTable MostrarTablaCatalogoCompleta(JTable TablaCat, JComboBox Cat) {
        try {

            String sql = "SELECT * FROM articulos";

            this.con = new ConexionBD();
            this.sentenciaSQL = this.con.Conectarse().createStatement();
            ResultSet rs = this.sentenciaSQL.executeQuery(sql);
            ResultSetMetaData rsm = rs.getMetaData();
            int col = rsm.getColumnCount();
            DefaultTableModel modelo = new DefaultTableModel();
            for (int i = 1; i <= col; i++) {
                modelo.addColumn(rsm.getColumnLabel(i));
            }
            while (rs.next()) {
                String[] fila = new String[col];
                for (int j = 0; j < col; j++) {
                    fila[j] = rs.getString(j + 1);
                }
                modelo.addRow((Object[]) fila);
            }
            TablaCat.setModel(modelo);
            rs.close();
            this.con.CerrarConexion();
        } catch (Exception e) {
            System.out.println(e);
        }
        return TablaCat;
    }

    public JTable MostrarTablaInventarioSistema(JTable TablaArticulo) {
        try {

            String sql = "SELECT Id,Nombre,Descripcion,Categoria,Unidad_Medida,Stock FROM articulos ";
            this.con = new ConexionBD();
            this.sentenciaSQL = this.con.Conectarse().createStatement();
            ResultSet rs = this.sentenciaSQL.executeQuery(sql);
            ResultSetMetaData rsm = rs.getMetaData();
            int col = rsm.getColumnCount();
            DefaultTableModel modelo = new DefaultTableModel();
            for (int i = 1; i <= col; i++) {
                modelo.addColumn(rsm.getColumnLabel(i));
            }
            while (rs.next()) {
                String[] fila = new String[col];
                for (int j = 0; j < col; j++) {
                    fila[j] = rs.getString(j + 1);
                }
                modelo.addRow((Object[]) fila);
            }
            TablaArticulo.setModel(modelo);
            rs.close();
            this.con.CerrarConexion();
        } catch (Exception e) {
            System.out.println(e);
        }
        return TablaArticulo;
    }

    public JTable MostrarTablaDiferencia(JTable TablaDiferencia, int num) {
        try {

            String sql = "SELECT  InventarioFisico.numero, articulos.Id,articulos.Stock as 'Sistema',InventarioFisico.Cantidad as 'Fisico' FROM articulos, InventarioFisico WHERE InventarioFisico.Numero=" + num + " AND(articulos.id=InventarioFisico.id)";
            System.out.println(sql);
            this.con = new ConexionBD();
            this.sentenciaSQL = this.con.Conectarse().createStatement();
            ResultSet rs = this.sentenciaSQL.executeQuery(sql);
            ResultSetMetaData rsm = rs.getMetaData();
            int col = rsm.getColumnCount();
            DefaultTableModel modelo = new DefaultTableModel();
            for (int i = 1; i <= col; i++) {
                modelo.addColumn(rsm.getColumnLabel(i));
            }
            while (rs.next()) {
                String[] fila = new String[col];
                for (int j = 0; j < col; j++) {
                    fila[j] = rs.getString(j + 1);
                }
                modelo.addRow((Object[]) fila);
            }
            TablaDiferencia.setModel(modelo);
            rs.close();
            this.con.CerrarConexion();
        } catch (Exception e) {
            System.out.println(e);
        }
        return TablaDiferencia;
    }

    public JTable MostrarTablaDiferenciaCombo(JTable TablaDiferencia, int num) {
        try {

            String sql = "SELECT  InventarioFisico.numero, articulos.Id,articulos.Stock as 'Sistema',InventarioFisico.Cantidad as 'Fisico' FROM articulos, InventarioFisico WHERE InventarioFisico.Numero=" + num + " AND(articulos.id=InventarioFisico.id)";
            System.out.println(sql);
            this.con = new ConexionBD();
            this.sentenciaSQL = this.con.Conectarse().createStatement();
            ResultSet rs = this.sentenciaSQL.executeQuery(sql);
            ResultSetMetaData rsm = rs.getMetaData();
            int col = rsm.getColumnCount();
            DefaultTableModel modelo = new DefaultTableModel();
            for (int i = 1; i <= col; i++) {
                modelo.addColumn(rsm.getColumnLabel(i));
            }
            while (rs.next()) {
                String[] fila = new String[col];
                for (int j = 0; j < col; j++) {
                    fila[j] = rs.getString(j + 1);
                }
                modelo.addRow((Object[]) fila);
            }
            TablaDiferencia.setModel(modelo);
            rs.close();
            this.con.CerrarConexion();
        } catch (Exception e) {
            System.out.println(e);
        }
        return TablaDiferencia;
    }

    public JTable Buscar(JTable TablaArticulo, String busqueda, String categoria) {
        try {

            String sql = "SELECT * FROM articulos WHERE " + categoria + " LIKE '" + busqueda + "%'";
            this.con = new ConexionBD();
            this.sentenciaSQL = this.con.Conectarse().createStatement();
            ResultSet rs = this.sentenciaSQL.executeQuery(sql);
            ResultSetMetaData rsm = rs.getMetaData();
            int col = rsm.getColumnCount();
            DefaultTableModel modelo = new DefaultTableModel();
            for (int i = 1; i <= col; i++) {
                modelo.addColumn(rsm.getColumnLabel(i));
            }
            while (rs.next()) {
                String[] fila = new String[col];
                for (int j = 0; j < col; j++) {
                    fila[j] = rs.getString(j + 1);
                }
                modelo.addRow((Object[]) fila);
            }
            TablaArticulo.setModel(modelo);
            rs.close();
            this.con.CerrarConexion();
        } catch (Exception e) {
            System.out.println(e);
        }
        return TablaArticulo;
    }

    public void GuardarArticulo(DArticulos pdto) {
        try {
            this.con = new ConexionBD();
            String insertar = "INSERT INTO articulos (Id, Nombre, Descripcion,Costo_Entrada,Costo_Promedio_U,Stock,Entrada,Fecha_Ultima_Entrada,Categoria,Punto_Reorden,Estado,Unidad_Medida) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement sentencia_preparada = this.con.Conectarse().prepareStatement(insertar);
            sentencia_preparada.setInt(1, pdto.getId());
            sentencia_preparada.setString(2, pdto.getNombre());
            sentencia_preparada.setString(3, pdto.getDescripcion());
            sentencia_preparada.setFloat(4, pdto.getCosto_Entrada());
            sentencia_preparada.setFloat(5, pdto.getCosto_Promedio_U());

            sentencia_preparada.setFloat(6, pdto.getStock());
            sentencia_preparada.setFloat(7, pdto.getEntrada());
            sentencia_preparada.setDate(8, pdto.getFecha_Ultima_Entrada());
            sentencia_preparada.setString(9, pdto.getCategoria());

            sentencia_preparada.setFloat(10, pdto.getPunto_Reorden());
            sentencia_preparada.setString(11, pdto.getEstado());
            sentencia_preparada.setString(12, pdto.getUnidad_Medida());

            int n = sentencia_preparada.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Datos Guardados", "Confirmacion", 1);
            }
            this.con.CerrarConexion();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Class not found..." + ex);
        } catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(null, "connection error..." + ex);
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, "Acceso ilegal a la base de datos..." + ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia..." + ex);
        }
    }
    
    public void GuardarMotivo(DMotivos motivo) {
        try {
            this.con = new ConexionBD();
            String insertar = "INSERT INTO Motivos (Articulo,Tipo, Justificacion, Fecha) VALUES(?,?,?,?)";

            PreparedStatement sentencia_preparada = this.con.Conectarse().prepareStatement(insertar);
            sentencia_preparada.setString(1, motivo.getArticulo());
             sentencia_preparada.setString(2, motivo.getTipo());
            sentencia_preparada.setString(3, motivo.getJustificacion());
            sentencia_preparada.setDate(4, motivo.getFecha());

            int n = sentencia_preparada.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Datos Guardados", "Confirmacion", 1);
               
            }
            this.con.CerrarConexion();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Class not found..." + ex);
        } catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(null, "connection error..." + ex);
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, "Acceso ilegal a la base de datos..." + ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia..." + ex);
        }
    }

    public void GuardarInventarioFisico(JLabel Num, int id, String Nombre, String Descripcion, String Categoria, String Unidad_Medida, float Cantidad, String Fecha) {
        try {
            this.con = new ConexionBD();
            String insertar = "INSERT INTO InventarioFisico (Numero, Id, Nombre,Descripcion,Categoria,Unidad_Medida,Cantidad,Fecha) VALUES(?,?,?,?,?,?,?,?)";

            PreparedStatement sentencia_preparada = this.con.Conectarse().prepareStatement(insertar);
            sentencia_preparada.setInt(1, Integer.parseInt(Num.getText()));
            sentencia_preparada.setInt(2, id);
            sentencia_preparada.setString(3, Nombre);
            sentencia_preparada.setString(4, Descripcion);
            sentencia_preparada.setString(5, Categoria);

            sentencia_preparada.setString(6, Unidad_Medida);
            sentencia_preparada.setFloat(7, Cantidad);
            sentencia_preparada.setString(8, Fecha);

            int n = sentencia_preparada.executeUpdate();
            if (n > 0) {
                //JOptionPane.showMessageDialog(null, "Datos Guardados", "Confirmacion", 1);
            }
            this.con.CerrarConexion();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Class not found..." + ex);
        } catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(null, "connection error..." + ex);
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, "Acceso ilegal a la base de datos..." + ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia..." + ex);
        }
    }

    public void GuardarEntradas(DEntradas pdto) {
        try {
            this.con = new ConexionBD();
            String insertar = "INSERT INTO Bitacora ( Nombre, Descripcion,Costo_Entrada,Stock,Entrada,Fecha_Ultima_Entrada,Hora,Estado,Categoria) VALUES(?,?,?,?,?,?,?,?,?)";

            PreparedStatement sentencia_preparada = this.con.Conectarse().prepareStatement(insertar);
            //sentencia_preparada.setInt(1, pdto.getId());
            sentencia_preparada.setString(1, pdto.getNombre());
            sentencia_preparada.setString(2, pdto.getDescripcion());
            sentencia_preparada.setFloat(3, pdto.getCosto_Entrada());
            sentencia_preparada.setFloat(4, pdto.getStock());
            sentencia_preparada.setFloat(5, pdto.getEntrada());
            sentencia_preparada.setDate(6, pdto.getFecha_Ultima_Entrada());
            sentencia_preparada.setString(7, pdto.getHora());
            sentencia_preparada.setString(8, pdto.getEstado());
            sentencia_preparada.setString(9, pdto.getCategoria());

            int n = sentencia_preparada.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Datos Guardados", "Confirmacion", 1);
            }
            this.con.CerrarConexion();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Class not found..." + ex);
        } catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(null, "connection error..." + ex);
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, "Acceso ilegal a la base de datos..." + ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia..." + ex);
        }
    }

    public void GuardarSalidas(DSalidas pdto) {
        try {
            this.con = new ConexionBD();
            String insertar = "INSERT INTO Bitacora ( Nombre, Descripcion,Stock,Salida,Fecha_Salida,Hora,Estado,Categoria) VALUES(?,?,?,?,?,?,?,?)";

            PreparedStatement sentencia_preparada = this.con.Conectarse().prepareStatement(insertar);
            //sentencia_preparada.setInt(1, pdto.getId());
            sentencia_preparada.setString(1, pdto.getNombre());
            sentencia_preparada.setString(2, pdto.getDescripcion());
            sentencia_preparada.setFloat(3, pdto.getStock());
            sentencia_preparada.setFloat(4, pdto.getSalida());
            sentencia_preparada.setDate(5, pdto.getFecha_Salida());
            sentencia_preparada.setString(6, pdto.getHora());
            sentencia_preparada.setString(7, pdto.getEstado());
            sentencia_preparada.setString(8, pdto.getCategoria());

            int n = sentencia_preparada.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Datos Guardados", "Confirmacion", 1);
            }
            this.con.CerrarConexion();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Class not found..." + ex);
        } catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(null, "connection error..." + ex);
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, "Acceso ilegal a la base de datos..." + ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia..." + ex);
        }
    }

    public void Eliminar(int Id) {
        try {
            String sql = "DELETE FROM articulos WHERE Id=" + Id;
            this.con = new ConexionBD();
            this.sentenciaSQL = this.con.Conectarse().createStatement();
            int n = this.sentenciaSQL.executeUpdate(sql);
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado: ", "Confimacion", 1);
            }
            this.con.CerrarConexion();
            this.sentenciaSQL.close();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error 1: " + ex);
        } catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(null, "Error 2: " + ex);
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, "Error 3: " + ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 4: " + ex);
        }
    }

    public void BorrarTodo() {
        try {
            String sql = "DELETE FROM InventarioFisico";
            this.con = new ConexionBD();
            this.sentenciaSQL = this.con.Conectarse().createStatement();
            int n = this.sentenciaSQL.executeUpdate(sql);
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado: ", "Confimacion", 1);
            }
            this.con.CerrarConexion();
            this.sentenciaSQL.close();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error 1: " + ex);
        } catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(null, "Error 2: " + ex);
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, "Error 3: " + ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 4: " + ex);
        }
    }

    public void BorrarEspecifico(int Numero) {
        try {
            String sql = "DELETE FROM InventarioFisico Where Numero=" + Numero;
            this.con = new ConexionBD();
            this.sentenciaSQL = this.con.Conectarse().createStatement();
            int n = this.sentenciaSQL.executeUpdate(sql);
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado: ", "Confimacion", 1);
            }
            this.con.CerrarConexion();
            this.sentenciaSQL.close();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error 1: " + ex);
        } catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(null, "Error 2: " + ex);
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, "Error 3: " + ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 4: " + ex);
        }
    }

    public void BorrarTablaProvisional(int Num) {
        try {
            String sql = "DELETE FROM InventarioFisico WHERE Numero=" + Num;
            this.con = new ConexionBD();
            this.sentenciaSQL = this.con.Conectarse().createStatement();
            int n = this.sentenciaSQL.executeUpdate(sql);
            if (n > 0) {
                //JOptionPane.showMessageDialog(null, "Registro Eliminado: ", "Confimacion", 1);
            }
            this.con.CerrarConexion();
            this.sentenciaSQL.close();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error 1: " + ex);
        } catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(null, "Error 2: " + ex);
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, "Error 3: " + ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 4: " + ex);
        }
    }

    public void ActualizarArticulo(DArticulos pdto) {
        String sql = "UPDATE articulos SET Id=?, Nombre=?,Descripcion=?, Costo_Entrada=?,Costo_Promedio_U=?,  Stock=?,Entrada=?,Fecha_Ultima_Entrada=?,"
                + "Categoria=?,Punto_Reorden=? ,Estado=?, Unidad_Medida=? WHERE Id=?";
        try {
            this.con = new ConexionBD();
            PreparedStatement sentencia_preparada = this.con.Conectarse().prepareStatement(sql);
            sentencia_preparada.setInt(1, pdto.getId());
            sentencia_preparada.setString(2, pdto.getNombre());
            sentencia_preparada.setString(3, pdto.getDescripcion());
            sentencia_preparada.setFloat(4, pdto.getCosto_Entrada());
            sentencia_preparada.setFloat(5, pdto.getCosto_Promedio_U());
            sentencia_preparada.setFloat(6, pdto.getStock());
            sentencia_preparada.setFloat(7, pdto.getEntrada());
            sentencia_preparada.setDate(8, pdto.getFecha_Ultima_Entrada());
            sentencia_preparada.setString(9, pdto.getCategoria());
            sentencia_preparada.setFloat(10, pdto.getPunto_Reorden());
            sentencia_preparada.setString(11, pdto.getEstado());
            sentencia_preparada.setString(12, pdto.getUnidad_Medida());
            sentencia_preparada.setInt(13, pdto.getId());

            int n = sentencia_preparada.executeUpdate();
            if (n >= 0) {
                JOptionPane.showMessageDialog(null, "Articulo Modificado", "Confirmacion", 1);
            }
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

    public void ActualizarArticuloEstado(DArticulos pdto) {
        String sql = "UPDATE articulos SET Estado=? WHERE Id=?";
        try {
            this.con = new ConexionBD();
            PreparedStatement sentencia_preparada = this.con.Conectarse().prepareStatement(sql);
            sentencia_preparada.setString(1, pdto.getEstado());

            sentencia_preparada.setInt(2, pdto.getId());
            System.out.println(sql);

            int n = sentencia_preparada.executeUpdate();
            if (n >= 0) {
                JOptionPane.showMessageDialog(null, "Articulo Activado", "Confirmacion", 1);
            }
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

    public void CambiarEstado(DArticulos pdto) {
        String sql = "UPDATE articulos SET Estado=?"
                + "WHERE Id=?";
        try {
            this.con = new ConexionBD();
            PreparedStatement sentencia_preparada = this.con.Conectarse().prepareStatement(sql);

            sentencia_preparada.setString(1, pdto.getEstado());
            sentencia_preparada.setInt(2, pdto.getId());

            int n = sentencia_preparada.executeUpdate();
            if (n >= 0) {
                JOptionPane.showMessageDialog(null, "Producto Inactivo", "Confirmacion", 1);
            }
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

    public void ActualizarEstadoCategoria(int Id, String Estado) {
        String sql = "UPDATE Categoria SET Estado=?"
                + "WHERE Id=?";
        try {
            this.con = new ConexionBD();
            PreparedStatement sentencia_preparada = this.con.Conectarse().prepareStatement(sql);

            sentencia_preparada.setString(1, Estado);
            sentencia_preparada.setInt(2, Id);

            int n = sentencia_preparada.executeUpdate();
            if (n >= 0) {
                JOptionPane.showMessageDialog(null, "Estado Actualizado", "Confirmacion", 1);
            }
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

    public void ModificarStock(float suma, JTextField txtBuscar) {
        String sql = "UPDATE articulos SET Stock=?"
                + "WHERE Id=?";
        try {
            this.con = new ConexionBD();
            PreparedStatement sentencia_preparada = this.con.Conectarse().prepareStatement(sql);

            sentencia_preparada.setFloat(1, suma);
            sentencia_preparada.setInt(2, Integer.parseInt(txtBuscar.getText()));

            int n = sentencia_preparada.executeUpdate();
            if (n >= 0) {
                JOptionPane.showMessageDialog(null, "Stock modificado", "Confirmacion", 1);
            }
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

    public void ModificarCantidad(float Cantidad, String Id) {
        String sql = "UPDATE articulos SET Stock=?"
                + "WHERE Id=?";
        try {
            this.con = new ConexionBD();
            PreparedStatement sentencia_preparada = this.con.Conectarse().prepareStatement(sql);

            sentencia_preparada.setFloat(1, Cantidad);
            sentencia_preparada.setString(2, Id);

            int n = sentencia_preparada.executeUpdate();
            if (n >= 0) {
                JOptionPane.showMessageDialog(null, "Stock modificado", "Confirmacion", 1);
            }
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

    public void ModificarCantidad2(float Cantidad, String Id, int Numero) {
        String sql = "UPDATE InventarioFisico SET Cantidad=?"
                + "WHERE Id=? AND Numero=?";
        try {
            this.con = new ConexionBD();
            PreparedStatement sentencia_preparada = this.con.Conectarse().prepareStatement(sql);

            sentencia_preparada.setFloat(1, Cantidad);
            sentencia_preparada.setString(2, Id);
            sentencia_preparada.setInt(3, Numero);

            int n = sentencia_preparada.executeUpdate();
            if (n >= 0) {
                JOptionPane.showMessageDialog(null, "Stock modificado", "Confirmacion", 1);
            }
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

    public void ModificarStockYPrecioU(float suma, float costopromediounitario, JTextField txtBuscar) {
        String sql = "UPDATE articulos SET Stock=?,Costo_Promedio_U=?"
                + "WHERE Id=?";
        try {
            this.con = new ConexionBD();
            PreparedStatement sentencia_preparada = this.con.Conectarse().prepareStatement(sql);

            sentencia_preparada.setFloat(1, suma);
            sentencia_preparada.setFloat(2, costopromediounitario);
            sentencia_preparada.setInt(3, Integer.parseInt(txtBuscar.getText()));

            int n = sentencia_preparada.executeUpdate();
            if (n >= 0) {
                JOptionPane.showMessageDialog(null, "Stock modificado", "Confirmacion", 1);
            }
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

    public void ModificarCategoria(DCategorias Pdto) {
        String sql = "UPDATE Categoria SET Id=?, Nombre=? WHERE Id=?";
        System.out.println(sql);
        try {
            this.con = new ConexionBD();
            PreparedStatement sentencia_preparada = this.con.Conectarse().prepareStatement(sql);
            sentencia_preparada.setInt(1, Pdto.getId());
            sentencia_preparada.setString(2, Pdto.getNombre());
            sentencia_preparada.setInt(3, Pdto.getId());

            int n = sentencia_preparada.executeUpdate();
            if (n >= 0) {
                JOptionPane.showMessageDialog(null, "Data modified", "Confirm", 1);
            }
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

    public static String Buscar_Id(String Id) {
        /*  99 */ String Busqueda_Id = null;
        /* 100 */ Connection conexion = null;
        /*     */ try {
            /* 102 */ ConexionBD con = new ConexionBD();
            /* 103 */ String Sentencia_Buscar_Ticket = "SELECT Id FROM articulos WHERE Id='" + Id + "'";
            /*     */
 /* 105 */ PreparedStatement sentencia_preparada = con.Conectarse().prepareStatement(Sentencia_Buscar_Ticket);
            /* 106 */ resultado = sentencia_preparada.executeQuery();
            /* 107 */ if (resultado.next()) {
                /*     */
 /* 109 */ Busqueda_Id = "Id ya existe";
                /*     */            } else {
                /*     */
 /* 112 */ Busqueda_Id = "Id no existe";
                /*     */            }
            /* 114 */ sentencia_preparada.close();
            /* 115 */ conexion.close();
            /* 116 */        } catch (Exception e) {
            /* 117 */ System.out.println(e);
            /*     */        }
        /* 119 */ return Busqueda_Id;
        /*     */    }

    public static String Buscar_Nombre(String Nombre) {
        /*  99 */ String Busqueda_Id = null;
        /* 100 */ Connection conexion = null;
        /*     */ try {
            /* 102 */ ConexionBD con = new ConexionBD();
            /* 103 */ String Sentencia_Buscar_Ticket = "SELECT Nombre FROM articulos WHERE Nombre='" + Nombre + "'";
            /*     */
 /* 105 */ PreparedStatement sentencia_preparada = con.Conectarse().prepareStatement(Sentencia_Buscar_Ticket);
            /* 106 */ resultado = sentencia_preparada.executeQuery();
            /* 107 */ if (resultado.next()) {
                /*     */
 /* 109 */ Busqueda_Id = "Id ya existe";
                /*     */            } else {
                /*     */
 /* 112 */ Busqueda_Id = "Id no existe";
                /*     */            }
            /* 114 */ sentencia_preparada.close();
            /* 115 */ conexion.close();
            /* 116 */        } catch (Exception e) {
            /* 117 */ System.out.println(e);
            /*     */        }
        /* 119 */ return Busqueda_Id;
        /*     */    }

    public DArticulos ConsultarDatosArticulos(DArticulos prov) {
        try {
            String sql = "SELECT * FROM articulos WHERE Id=" + prov.getId();
            this.con = new ConexionBD();
            this.sentenciaSQL = this.con.Conectarse().createStatement();
            ResultSet rs = this.sentenciaSQL.executeQuery(sql);
            if (rs.next()) {
                prov.setId(rs.getInt("Id"));
                prov.setNombre(rs.getString("Nombre"));
                prov.setDescripcion(rs.getString("Descripcion"));
                prov.setCosto_Entrada(rs.getFloat("Costo_Entrada"));
                prov.setStock(rs.getFloat("Stock"));
                prov.setEntrada(rs.getFloat("Entrada"));
                prov.setEstado(rs.getString("Estado"));
                prov.setPunto_Reorden(rs.getFloat("Punto_Reorden"));
                prov.setFecha_Ultima_Entrada(rs.getDate("Fecha_Ultima_Entrada"));
                prov.setUnidad_Medida(rs.getString("Unidad_Medida"));
                prov.setCosto_Promedio_U(rs.getFloat("Costo_Promedio_U"));

                JOptionPane.showMessageDialog(null, "Producto encontrado", "Atencion", 1);
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado", "Atencion", 0);
            }
            this.sentenciaSQL.close();
            this.con.CerrarConexion();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error por clase no encontrada, instancia, acceso ilegal y sentencia: " + ex, "Error", 0);
        }
        return prov;
    }
    public String  BuscarEstadoCategoria(JComboBox Categoria) {
        String Estado="";
        try {
            String sql = "SELECT Estado FROM Categoria WHERE Nombre='" + Categoria.getSelectedItem().toString() + "'";
            this.con = new ConexionBD();
            this.sentenciaSQL = this.con.Conectarse().createStatement();
            ResultSet rs = this.sentenciaSQL.executeQuery(sql);
            if (rs.next()) {
                 Estado=rs.getString("Estado");
               

                
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado", "Atencion", 0);
            }
            this.sentenciaSQL.close();
            this.con.CerrarConexion();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error por clase no encontrada, instancia, acceso ilegal y sentencia: " + ex, "Error", 0);
        }
        return Estado;
    }

    public DArticulos ConsultarDatosArticulosNombre(DArticulos prov) {
        try {
            String sql = "SELECT * FROM articulos WHERE Nombre='" + prov.getNombre() + "'";
            System.out.println(sql);
            this.con = new ConexionBD();
            this.sentenciaSQL = this.con.Conectarse().createStatement();
            ResultSet rs = this.sentenciaSQL.executeQuery(sql);
            if (rs.next()) {
                prov.setId(rs.getInt("Id"));
                prov.setNombre(rs.getString("Nombre"));
                prov.setDescripcion(rs.getString("Descripcion"));
                prov.setCosto_Entrada(rs.getFloat("Costo_Entrada"));
                prov.setStock(rs.getFloat("Stock"));
                prov.setEntrada(rs.getFloat("Entrada"));
                prov.setEstado(rs.getString("Estado"));
                prov.setPunto_Reorden(rs.getFloat("Punto_Reorden"));
                prov.setFecha_Ultima_Entrada(rs.getDate("Fecha_Ultima_Entrada"));
                prov.setUnidad_Medida(rs.getString("Unidad_Medida"));
                prov.setCategoria(rs.getString("Categoria"));

                JOptionPane.showMessageDialog(null, "Producto encontrado", "Atencion", 1);
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado", "Atencion", 0);
            }
            this.sentenciaSQL.close();
            this.con.CerrarConexion();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error por clase no encontrada, instancia, acceso ilegal y sentencia: " + ex, "Error", 0);
        }
        return prov;
    }

    public DArticulos ConsultarDatosArticulos2(DArticulos prov) {
        try {
            String sql = "SELECT * FROM articulos WHERE Id=" + prov.getId();
            this.con = new ConexionBD();
            this.sentenciaSQL = this.con.Conectarse().createStatement();
            ResultSet rs = this.sentenciaSQL.executeQuery(sql);
            if (rs.next()) {
                prov.setId(rs.getInt("Id"));
                prov.setNombre(rs.getString("Nombre"));
                prov.setDescripcion(rs.getString("Descripcion"));
                prov.setStock(rs.getFloat("Stock"));
                prov.setCategoria(rs.getString("Categoria"));
                prov.setCosto_Promedio_U(rs.getFloat("Costo_Promedio_U"));
                JOptionPane.showMessageDialog(null, "Producto encontrado", "Atencion", 1);
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado", "Atencion", 0);
            }
            this.sentenciaSQL.close();
            this.con.CerrarConexion();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error por clase no encontrada, instancia, acceso ilegal y sentencia: " + ex, "Error", 0);
        }
        return prov;
    }

    public DArticulos Search(DArticulos prov) {
        try {
            String sql = "SELECT * FROM articulos WHERE Id=" + prov.getId();
            this.con = new ConexionBD();
            this.sentenciaSQL = this.con.Conectarse().createStatement();
            ResultSet rs = this.sentenciaSQL.executeQuery(sql);
            if (rs.next()) {
                prov.setId(rs.getInt("Id"));
                prov.setNombre(rs.getString("Nombre"));
                prov.setDescripcion(rs.getString("Descripcion"));
                prov.setStock(rs.getFloat("Stock"));
                prov.setCategoria(rs.getString("Categoria"));
                prov.setUnidad_Medida(rs.getString("Unidad_Medida"));

                //JOptionPane.showMessageDialog(null, "Producto encontrado", "Atencion", 1);
            } else {
                prov.setId(0);
                prov.setNombre("");
                prov.setDescripcion("");
                prov.setStock(0);
                prov.setCategoria("");
                JOptionPane.showMessageDialog(null, "Producto no encontrado", "Atencion", 0);
            }
            this.sentenciaSQL.close();
            this.con.CerrarConexion();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error por clase no encontrada, instancia, acceso ilegal y sentencia: " + ex, "Error", 0);
        }
        return prov;
    }

    public int numInventario() {
        int Id = 0;
        try {
            String sql = "SELECT * FROM InventarioFisico ORDER BY Numero Desc limit 1";
            this.con = new ConexionBD();
            this.sentenciaSQL = this.con.Conectarse().createStatement();
            ResultSet rs = this.sentenciaSQL.executeQuery(sql);
            if (rs.first()) {
                Id = rs.getInt("Numero");
            }
            rs.close();
            this.con.CerrarConexion();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error por clase no encontrada, instancia, acceso ilegal y sentencia: " + ex, "Error", 0);
        }
        return Id + 1;
    }

    public DArticulos ConsultarDatosArticulos2Nombre(DArticulos prov) {
        try {
            String sql = "SELECT * FROM articulos WHERE Nombre='" + prov.getNombre() + "'";
            this.con = new ConexionBD();
            this.sentenciaSQL = this.con.Conectarse().createStatement();
            ResultSet rs = this.sentenciaSQL.executeQuery(sql);
            if (rs.next()) {
                prov.setId(rs.getInt("Id"));
                prov.setNombre(rs.getString("Nombre"));
                prov.setDescripcion(rs.getString("Descripcion"));
                prov.setStock(rs.getFloat("Stock"));
                prov.setCategoria(rs.getString("Categoria"));
                prov.setCosto_Promedio_U(rs.getFloat("Costo_Promedio_U"));
                JOptionPane.showMessageDialog(null, "Producto encontrado", "Atencion", 1);
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado", "Atencion", 0);
            }
            this.sentenciaSQL.close();
            this.con.CerrarConexion();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error por clase no encontrada, instancia, acceso ilegal y sentencia: " + ex, "Error", 0);
        }
        return prov;
    }

    public JTable BuscarArticuloTabla(JTable TablaDatos, JTextField txtId) {
        try {
            String sql = "SELECT * FROM articulos where Id ='" + txtId.getText() + "'" + "ORDER BY Id Asc";

            // String sql = "SELECT *   FROM pagos Where First_Name ='" + txtFirst.getText() + "' AND Last_Name='" + txtLast.getText() +"'AND Year= '" + combo.getSelectedItem() + "'"+"ORDER BY No_Trip Desc limit 1";
            this.con = new ConexionBD();
            this.sentenciaSQL = this.con.Conectarse().createStatement();
            ResultSet rs = this.sentenciaSQL.executeQuery(sql);
            ResultSetMetaData rsm = rs.getMetaData();
            int col = rsm.getColumnCount();
            DefaultTableModel modelo = new DefaultTableModel();
            for (int i = 1; i <= col; i++) {
                modelo.addColumn(rsm.getColumnLabel(i));
            }
            while (rs.next()) {
                String[] fila = new String[col];
                for (int j = 0; j < col; j++) {
                    fila[j] = rs.getString(j + 1);
                }
                modelo.addRow((Object[]) fila);
            }
            TablaDatos.setModel(modelo);
            rs.close();
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
        return TablaDatos;
    }

    public TextAutoCompleter autocompletar(JTextField texto) {
        TextAutoCompleter ac = null;
        ac = new TextAutoCompleter(texto);
        try {
            String sql = "SELECT Descripcion FROM articulos";
            this.con = new ConexionBD();
            this.sentenciaSQL = this.con.Conectarse().createStatement();
            ResultSet rs = this.sentenciaSQL.executeQuery(sql);
            while (rs.next()) {
                ac.addItem(rs.getString("Descripcion"));
            }
            this.sentenciaSQL.close();
            this.con.CerrarConexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return ac;
    }

    public TextAutoCompleter autocompletarNombre(JTextField texto) {
        TextAutoCompleter ac2 = null;
        ac2 = new TextAutoCompleter(texto);
        try {
            String sql = "SELECT Nombre FROM articulos";
            this.con = new ConexionBD();
            this.sentenciaSQL = this.con.Conectarse().createStatement();
            ResultSet rs = this.sentenciaSQL.executeQuery(sql);
            while (rs.next()) {
                ac2.addItem(rs.getString("Nombre"));
            }
            this.sentenciaSQL.close();
            this.con.CerrarConexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return ac2;
    }

    public int ConsultarIdCategoria() {
        System.out.println("hola");
        int Id = 0;
        try {
            String sql = "SELECT * FROM Categoria ORDER BY Id Desc limit 1";
            System.out.println(sql);
            this.con = new ConexionBD();
            this.sentenciaSQL = this.con.Conectarse().createStatement();
            ResultSet rs = this.sentenciaSQL.executeQuery(sql);
            if (rs.first()) {
                Id = rs.getInt("Id");
            }
            rs.close();
            this.con.CerrarConexion();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error por clase no encontrada, instancia, acceso ilegal y sentencia: " + ex, "Error", 0);
        }
        return Id + 1;
    }

    public void GuardarCategoria(DCategorias pdto, String Estado) {
        try {
            this.con = new ConexionBD();
            String insertar = "INSERT INTO Categoria (Id, Nombre,Estado) VALUES(?,?,?)";

            PreparedStatement sentencia_preparada = this.con.Conectarse().prepareStatement(insertar);
            sentencia_preparada.setInt(1, pdto.getId());
            sentencia_preparada.setString(2, pdto.getNombre());
            sentencia_preparada.setString(3, Estado);

            int n = sentencia_preparada.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Datos Guardados", "Confirmacion", 1);
            }
            this.con.CerrarConexion();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Class not found..." + ex);
        } catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(null, "connection error..." + ex);
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, "Acceso ilegal a la base de datos..." + ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia..." + ex);
        }
    }

    public void ActualizarCategoria(DCategorias pdto) {
        String sql = "UPDATE Categoria SET Id=?, Nombre=? WHERE Id=?";
        try {
            this.con = new ConexionBD();
            PreparedStatement sentencia_preparada = this.con.Conectarse().prepareStatement(sql);
            sentencia_preparada.setInt(1, pdto.getId());
            sentencia_preparada.setString(2, pdto.getNombre());

            sentencia_preparada.setInt(3, pdto.getId());

            int n = sentencia_preparada.executeUpdate();
            if (n >= 0) {
                JOptionPane.showMessageDialog(null, "Data modified", "Confirm", 1);
            }
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

    public void EliminarCategoria(int Id) {
        try {
            String sql = "DELETE FROM Categoria WHERE Id=" + Id;
            this.con = new ConexionBD();
            this.sentenciaSQL = this.con.Conectarse().createStatement();
            int n = this.sentenciaSQL.executeUpdate(sql);
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado: ", "Confimacion", 1);
            }
            this.con.CerrarConexion();
            this.sentenciaSQL.close();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error 1: " + ex);
        } catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(null, "Error 2: " + ex);
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, "Error 3: " + ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 4: " + ex);
        }
    }

    public ComboBoxModel llenarCategorias() {
        JComboBox combo = null;
        combo = new JComboBox();
        combo.addItem("Categoria");
        try {

            String sql = "SELECT Nombre FROM Categoria Order by Id";

            this.con = new ConexionBD();
            this.sentenciaSQL = this.con.Conectarse().createStatement();
            ResultSet rs = this.sentenciaSQL.executeQuery(sql);
            while (rs.next()) {

                combo.addItem(rs.getString("Nombre"));
            }
            rs.close();
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
        return combo.getModel();
    }

    public ComboBoxModel llenarNumeroInventarioFisico() {
        JComboBox combo = null;
        combo = new JComboBox();
        combo.addItem("Todos");
        try {

            String sql = "SELECT Numero FROM InventarioFisico  Group by Numero order by Numero Desc";

            this.con = new ConexionBD();
            this.sentenciaSQL = this.con.Conectarse().createStatement();
            ResultSet rs = this.sentenciaSQL.executeQuery(sql);
            while (rs.next()) {

                combo.addItem(rs.getString("Numero"));
            }
            rs.close();
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
        return combo.getModel();
    }

    public static String BuscarHijos(String Categoria) {
        /*  99 */ String Busqueda_Hijos = null;
        /* 100 */ Connection conexion = null;
        /*     */ try {
            /* 102 */ ConexionBD con = new ConexionBD();
            /* 103 */ String Sentencia_Buscar_Usuario = "SELECT Categoria FROM articulos WHERE Categoria='" + Categoria + "'";
            /*     */
 /* 105 */ PreparedStatement sentencia_preparada = con.Conectarse().prepareStatement(Sentencia_Buscar_Usuario);
            /* 106 */ resultado = sentencia_preparada.executeQuery();
            /* 107 */ if (resultado.next()) {
                /*     */
 /* 109 */ Busqueda_Hijos = "Categoria ya existe";
                /*     */            } else {
                /*     */
 /* 112 */ Busqueda_Hijos = "Categoria no existe";
                /*     */            }
            /* 114 */ sentencia_preparada.close();
            /* 115 */ conexion.close();
            /* 116 */        } catch (Exception e) {
            /* 117 */ System.out.println(e);
            /*     */        }
        /* 119 */ return Busqueda_Hijos;
        /*     */    }

    public static String Buscar_User(String Usuario) {
        /*  99 */ String Busqueda_Usuario = null;
        /* 100 */ Connection conexion = null;
        /*     */ try {
            /* 102 */ ConexionBD con = new ConexionBD();
            /* 103 */ String Sentencia_Buscar_Usuario = "SELECT Usuario FROM Usuario WHERE Usuario='" + Usuario + "'";
            /*     */
 /* 105 */ PreparedStatement sentencia_preparada = con.Conectarse().prepareStatement(Sentencia_Buscar_Usuario);
            /* 106 */ resultado = sentencia_preparada.executeQuery();
            /* 107 */ if (resultado.next()) {
                /*     */
 /* 109 */ Busqueda_Usuario = "Usuario ya existe";
                /*     */            } else {
                /*     */
 /* 112 */ Busqueda_Usuario = "Usuario no existe";
                /*     */            }
            /* 114 */ sentencia_preparada.close();
            /* 115 */ conexion.close();
            /* 116 */        } catch (Exception e) {
            /* 117 */ System.out.println(e);
            /*     */        }
        /* 119 */ return Busqueda_Usuario;
        /*     */    }

}

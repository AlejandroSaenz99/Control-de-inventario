/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Puentes;

import Datos.DArticulos;
import Datos.DCategorias;
import Metodos.Metodos;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author AlejandroSaenz
 */
public class PuenteArticulo {
     Metodos mp;
  
  public JTable PuenteMostrarTabla(JTable TablaArticulo) {
    this.mp = new Metodos();
    JTable tbl = this.mp.MostrarTabla(TablaArticulo);
    return tbl;
  }
  
   public JTable PuenteMostrarTablaCatalogo(JTable TablaCat,JComboBox Catalogo) {
    this.mp = new Metodos();
    JTable tbl = this.mp.MostrarTablaCatalogo(TablaCat,Catalogo);
    return tbl;
  }
     public JTable PuenteMostrarTablaBi(JTable TablaCat,JComboBox Catalogo) {
    this.mp = new Metodos();
    JTable tbl = this.mp.MostrarTablaB(TablaCat,Catalogo);
    return tbl;
  }
    public JTable PuenteMostrarTablaCatalogoCompleta(JTable TablaCat,JComboBox Catalogo) {
    this.mp = new Metodos();
    JTable tbl = this.mp.MostrarTablaCatalogoCompleta(TablaCat,Catalogo);
    return tbl;
  }
  public void PuenteGuardarArticulo(DArticulos pdto) {
    this.mp = new Metodos();
    this.mp.GuardarArticulo(pdto);
  }
   public void PuenteActualizar(DArticulos pdto) {
    this.mp = new Metodos();
    this.mp.ActualizarArticulo(pdto);
  }
     public void PuenteActualizarEstado(DArticulos pdto) {
    this.mp = new Metodos();
    this.mp.ActualizarArticuloEstado(pdto);
  }
   public void PuenteEstado(DArticulos pdto) {
    this.mp = new Metodos();
    this.mp.CambiarEstado(pdto);
  }
   
   public void PuenteBuscarDatosArticulo(DArticulos prov) {
    this.mp = new Metodos();
    this.mp.ConsultarDatosArticulos(prov);
  }
   public void PuenteBuscarDatosArticuloNombre(DArticulos prov) {
    this.mp = new Metodos();
    this.mp.ConsultarDatosArticulosNombre(prov);
  }
   public void PuenteBuscarDatosArticulo2(DArticulos prov) {
    this.mp = new Metodos();
    this.mp.ConsultarDatosArticulos2(prov);
  }
    public void PuenteBuscarDatosArticulo2Nombre(DArticulos prov) {
    this.mp = new Metodos();
    this.mp.ConsultarDatosArticulos2Nombre(prov);
  }
    public JTable PuenteMostrarTablaTotalStaff(JTable TablaDatos, JTextField txtId) {
    this.mp = new Metodos();
    JTable tbl = this.mp.BuscarArticuloTabla(TablaDatos,txtId);
    return tbl;
    
  }
    
    public void PuenteGuardarCategoria(DCategorias pdto,String Estado) {
    this.mp = new Metodos();
    this.mp.GuardarCategoria(pdto,Estado);
  }

    public JTable MostrarTablaCategoria(JTable TablaCategoria) {
    this.mp = new Metodos();
    JTable tbl = this.mp.MostrarTablaCategoria(TablaCategoria);
    return tbl;
  }}

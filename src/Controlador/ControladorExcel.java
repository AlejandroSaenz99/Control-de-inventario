/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import Presentacion.IFisico;
import Presentacion.Catalogos;
import Modelo.ModeloExcel;
import Presentacion.Marticulos;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;


public class ControladorExcel implements ActionListener{
    ModeloExcel modeloE = new ModeloExcel();
    IFisico vistaE= new IFisico();
    Marticulos VistaM=new Marticulos();
    JFileChooser selecArchivo = new JFileChooser();
    File archivo,Archivo2;
    int contAccion=0;
  
     
     public ControladorExcel(IFisico vistaE, ModeloExcel modeloE, Marticulos VistaM){
        this.vistaE= vistaE;
        this.modeloE=modeloE;
        this.VistaM=VistaM;
        //this.vistaE.btnImportar.addActionListener(this);
        this.vistaE.xd.addActionListener(this);
     this.VistaM.btnReporte.addActionListener(this);
    }
    
    public void AgregarFiltro(){
        selecArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xls)", "xls"));
        selecArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xlsx)", "xlsx"));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        contAccion++;
        if(contAccion==1)AgregarFiltro();
        
        
        
        if(e.getSource() == vistaE.xd){
            if(selecArchivo.showDialog(null, "Generar")==JFileChooser.APPROVE_OPTION){
                archivo=selecArchivo.getSelectedFile();
                
                if(archivo.getName().endsWith("xls") || archivo.getName().endsWith("xlsx")){

                    JOptionPane.showMessageDialog(null,modeloE.Exportar(archivo, vistaE.Tabla,vistaE.Titulo,vistaE.TablaSistema,vistaE.TablaDiferencia) + "\n Formato ."+ archivo.getName().substring(archivo.getName().lastIndexOf(".")+1));

                }else{
                    JOptionPane.showMessageDialog(null, "PorFavor añade la extension '.xls'o'.xlsx' al final del nombre.");
                }
            }
        }
        if(e.getSource() == VistaM.btnReporte){
            if(selecArchivo.showDialog(null, "Generar")==JFileChooser.APPROVE_OPTION){
                archivo=selecArchivo.getSelectedFile();
                
                if(archivo.getName().endsWith("xls") || archivo.getName().endsWith("xlsx")){

                    JOptionPane.showMessageDialog(null,modeloE.Exportar(archivo, VistaM.TablaArticulo) + "\n Formato ."+ archivo.getName().substring(archivo.getName().lastIndexOf(".")+1));

                }else{
                    JOptionPane.showMessageDialog(null, "PorFavor añade la extension '.xls'o'.xlsx' al final del nombre.");
                }
            }
        }
        
        
       
    }
    
}



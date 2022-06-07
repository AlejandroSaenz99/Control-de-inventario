/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.*;

/**
 *
 * @author AlejandroSaenz
 */
public class ModeloExcel {
   Workbook wb;
    
    
         public String Exportar(File archivo, JTable Tabla,JLabel Titulo,JTable TablaSistema,JTable TablaDiferencia){
             String Respuesta="Archivo abierto actualmente";
           int numFila = Tabla.getRowCount(), numColumna = Tabla.getColumnCount();
           int numFila2 = TablaSistema.getRowCount(), numColumna2 = TablaSistema.getColumnCount();
           int numFila3 = TablaDiferencia.getRowCount(), numColumna3 = TablaDiferencia.getColumnCount();
        if (archivo.getName().endsWith("xls")) {
            wb = new HSSFWorkbook();
        } else {
            wb = new XSSFWorkbook();
        }
         Sheet hoja = wb.createSheet("Inventario Fisico");
         Sheet hoja2 = wb.createSheet("Inventario Del Sistema");
         Sheet hoja3 = wb.createSheet("Diferencia");
         hoja.addMergedRegion(new CellRangeAddress(
	            0, //first row (0-based)
	            1, //last row  (0-based)
	            1, //first column (0-based)
	            6  //last column  (0-based)
	    ));
         hoja2.addMergedRegion(new CellRangeAddress(
	            0, //first row (0-based)
	            1, //last row  (0-based)
	            1, //first column (0-based)
	            4  //last column  (0-based)
	    ));
         hoja3.addMergedRegion(new CellRangeAddress(
	            0, //first row (0-based)
	            1, //last row  (0-based)
	            1, //first column (0-based)
	            4  //last column  (0-based)
	    ));
         CellStyle CeldaCentral = wb.createCellStyle();
             CeldaCentral.setAlignment(CellStyle.ALIGN_CENTER); // horizontal
                CeldaCentral.setVerticalAlignment(CellStyle.ALIGN_CENTER);
             CeldaCentral.setBorderBottom(HSSFCellStyle.BORDER_THIN);
             CeldaCentral.setBorderLeft(HSSFCellStyle.BORDER_THIN);
             CeldaCentral.setBorderRight(HSSFCellStyle.BORDER_THIN);
             CeldaCentral.setBorderTop(HSSFCellStyle.BORDER_THIN);
             CeldaCentral.setFillBackgroundColor(IndexedColors.RED.getIndex()); // color de fondo
             CeldaCentral.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex()); // color de primer plano
             CeldaCentral.setFillPattern(CellStyle.SOLID_FOREGROUND);
         
         
         
          CellStyle CeldaGris = wb.createCellStyle();
             CeldaGris.setAlignment(CellStyle.ALIGN_CENTER); // horizontal

             CeldaGris.setBorderBottom(HSSFCellStyle.BORDER_THIN);
             CeldaGris.setBorderLeft(HSSFCellStyle.BORDER_THIN);
             CeldaGris.setBorderRight(HSSFCellStyle.BORDER_THIN);
             CeldaGris.setBorderTop(HSSFCellStyle.BORDER_THIN);
             CeldaGris.setFillBackgroundColor(IndexedColors.RED.getIndex()); // color de fondo
             CeldaGris.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex()); // color de primer plano
             CeldaGris.setFillPattern(CellStyle.SOLID_FOREGROUND);
             
              CellStyle CeldaNormal = wb.createCellStyle();
             CeldaNormal.setAlignment(CellStyle.ALIGN_CENTER); // horizontal

             CeldaNormal.setBorderBottom(HSSFCellStyle.BORDER_THIN);
             CeldaNormal.setBorderLeft(HSSFCellStyle.BORDER_THIN);
             CeldaNormal.setBorderRight(HSSFCellStyle.BORDER_THIN);
             CeldaNormal.setBorderTop(HSSFCellStyle.BORDER_THIN);
          try {//Tabla Fisica
              Row filaT=hoja.createRow(0);
              Cell celdaT = filaT.createCell(1);
              celdaT.setCellValue(String.valueOf("Inventario Fisico "+Titulo.getText()));
              celdaT.setCellStyle(CeldaCentral);
            for (int i = -1; i < numFila; i++) {
                Row fila = hoja.createRow(i+3);//(i+numero de filas que bajara)
                for (int j = 0; j < numColumna; j++) {
                    Cell celda = fila.createCell(j);//(j) numero de columnas que avanzara
                    celda.setCellStyle(CeldaNormal);
                    if(i==-1){
                        celda.setCellValue(String.valueOf(Tabla.getColumnName(j)));
                        celda.setCellStyle(CeldaGris);
                    }else{
                        celda.setCellValue(String.valueOf(Tabla.getValueAt(i, j)));
                        
                    }
                    wb.write(new FileOutputStream(archivo));
                }
            }
            Respuesta="Reporte hecho correctamente";
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
          
          
          try {//Tabla Sistema
              Row filaT=hoja2.createRow(0);
              Cell celdaT = filaT.createCell(1);
              celdaT.setCellValue(String.valueOf("Inventario del sistema"));
              celdaT.setCellStyle(CeldaCentral);
            for (int i = -1; i < numFila2; i++) {
                Row fila = hoja2.createRow(i+3);//(i+numero de filas que bajara)
                for (int j = 0; j < numColumna2; j++) {
                    Cell celda = fila.createCell(j);//(j) numero de columnas que avanzara
                    celda.setCellStyle(CeldaNormal);
                    if(i==-1){
                        celda.setCellValue(String.valueOf(TablaSistema.getColumnName(j)));
                        celda.setCellStyle(CeldaGris);
                    }else{
                        celda.setCellValue(String.valueOf(TablaSistema.getValueAt(i, j)));
                        
                    }
                    wb.write(new FileOutputStream(archivo));
                }
            }
            Respuesta="Reporte hecho correctamente";
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
          
          try {//Tabla Diferencia
              Row filaT=hoja3.createRow(0);
              Cell celdaT = filaT.createCell(1);
              celdaT.setCellValue(String.valueOf("Diferencia"));
              celdaT.setCellStyle(CeldaCentral);
            for (int i = -1; i < numFila3; i++) {
                Row fila = hoja3.createRow(i+3);//(i+numero de filas que bajara)
                for (int j = 0; j < numColumna3; j++) {
                    Cell celda = fila.createCell(j+1);//(j) numero de columnas que avanzara
                    celda.setCellStyle(CeldaNormal);
                    if(i==-1){
                        celda.setCellValue(String.valueOf(TablaDiferencia.getColumnName(j)));
                        celda.setCellStyle(CeldaGris);
                    }else{
                        celda.setCellValue(String.valueOf(TablaDiferencia.getValueAt(i, j)));
                        
                    }
                    wb.write(new FileOutputStream(archivo));
                }
            }
            Respuesta="Reporte hecho correctamente";
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return Respuesta;
    }

    public String Exportar(File archivo, JTable TablaArticulo) {
     String Respuesta="Archivo abierto actualmente";
           int numFila = TablaArticulo.getRowCount(), numColumna = TablaArticulo.getColumnCount();
          
        if (archivo.getName().endsWith("xls")) {
            wb = new HSSFWorkbook();
        } else {
            wb = new XSSFWorkbook();
        }
         Sheet hoja = wb.createSheet("Punto de Reorden");
       
         hoja.addMergedRegion(new CellRangeAddress(
	            0, //first row (0-based)
	            1, //last row  (0-based)
	            1, //first column (0-based)
	            10  //last column  (0-based)
	    ));
         
	 
         CellStyle CeldaCentral = wb.createCellStyle();
             CeldaCentral.setAlignment(CellStyle.ALIGN_CENTER); // horizontal
                CeldaCentral.setVerticalAlignment(CellStyle.ALIGN_CENTER);
             CeldaCentral.setBorderBottom(HSSFCellStyle.BORDER_THIN);
             CeldaCentral.setBorderLeft(HSSFCellStyle.BORDER_THIN);
             CeldaCentral.setBorderRight(HSSFCellStyle.BORDER_THIN);
             CeldaCentral.setBorderTop(HSSFCellStyle.BORDER_THIN);
             CeldaCentral.setFillBackgroundColor(IndexedColors.RED.getIndex()); // color de fondo
             CeldaCentral.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex()); // color de primer plano
             CeldaCentral.setFillPattern(CellStyle.SOLID_FOREGROUND);
         
         
         
          CellStyle CeldaGris = wb.createCellStyle();
             CeldaGris.setAlignment(CellStyle.ALIGN_CENTER); // horizontal

             CeldaGris.setBorderBottom(HSSFCellStyle.BORDER_THIN);
             CeldaGris.setBorderLeft(HSSFCellStyle.BORDER_THIN);
             CeldaGris.setBorderRight(HSSFCellStyle.BORDER_THIN);
             CeldaGris.setBorderTop(HSSFCellStyle.BORDER_THIN);
             CeldaGris.setFillBackgroundColor(IndexedColors.RED.getIndex()); // color de fondo
             CeldaGris.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex()); // color de primer plano
             CeldaGris.setFillPattern(CellStyle.SOLID_FOREGROUND);
             
              CellStyle CeldaNormal = wb.createCellStyle();
             CeldaNormal.setAlignment(CellStyle.ALIGN_CENTER); // horizontal

             CeldaNormal.setBorderBottom(HSSFCellStyle.BORDER_THIN);
             CeldaNormal.setBorderLeft(HSSFCellStyle.BORDER_THIN);
             CeldaNormal.setBorderRight(HSSFCellStyle.BORDER_THIN);
             CeldaNormal.setBorderTop(HSSFCellStyle.BORDER_THIN);
          try {//Tabla punto reorden
              Row filaT=hoja.createRow(0);
              Cell celdaT = filaT.createCell(1);
              celdaT.setCellValue(String.valueOf("Punto de Reorden"));
              celdaT.setCellStyle(CeldaCentral);
            for (int i = -1; i < numFila; i++) {
                Row fila = hoja.createRow(i+3);//(i+numero de filas que bajara)
                for (int j = 0; j < numColumna; j++) {
                    Cell celda = fila.createCell(j);//(j) numero de columnas que avanzara
                    celda.setCellStyle(CeldaNormal);
                    if(i==-1){
                        celda.setCellValue(String.valueOf(TablaArticulo.getColumnName(j)));
                        celda.setCellStyle(CeldaGris);
                    }else{
                        celda.setCellValue(String.valueOf(TablaArticulo.getValueAt(i, j)));
                        
                    }
                    wb.write(new FileOutputStream(archivo));
                }
            }
            Respuesta="Reporte hecho correctamente";
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }   
       return Respuesta;
    }

    
}

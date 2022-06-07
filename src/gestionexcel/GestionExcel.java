/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionexcel;
import Modelo.ModeloExcel;
import Presentacion.IFisico;
import Controlador.ControladorExcel;
import Presentacion.Marticulos;

/**
 *
 * @author ricardo
 */
public class GestionExcel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ModeloExcel modeloE = new ModeloExcel();
        IFisico vistaE = new IFisico();
        Marticulos VistaM=new Marticulos();
        ControladorExcel contraControladorExcel = new ControladorExcel(vistaE, modeloE,VistaM);
       
       vistaE.setVisible(true);
        vistaE.setLocationRelativeTo(null);
    }
    
}

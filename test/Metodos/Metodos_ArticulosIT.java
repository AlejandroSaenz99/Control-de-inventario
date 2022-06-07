/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Metodos;

import Datos.DArticulos;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author oscar
 */
public class Metodos_ArticulosIT {
    
    public Metodos_ArticulosIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of MostrarTabla method, of class Metodos_Articulos.
     */
    @Test
    public void testMostrarTabla() {
        System.out.println("MostrarTabla");
        JTable TablaArticulo = null;
        Metodos instance = new Metodos();
        JTable expResult = null;
        JTable result = instance.MostrarTabla(TablaArticulo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Buscar method, of class Metodos_Articulos.
     */
    @Test
    public void testBuscar() {
        System.out.println("Buscar");
        JTable TablaArticulo = null;
        String busqueda = "";
        String categoria = "";
        Metodos instance = new Metodos();
        JTable expResult = null;
        JTable result = instance.Buscar(TablaArticulo, busqueda, categoria);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GuardarArticulo method, of class Metodos_Articulos.
     */
    @Test
    public void testGuardarArticulo() {
        System.out.println("GuardarArticulo");
        DArticulos pdto = null;
        Metodos instance = new Metodos();
        instance.GuardarArticulo(pdto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Eliminar method, of class Metodos_Articulos.
     */
    @Test
    public void testEliminar() {
        System.out.println("Eliminar");
        int Id = 0;
        Metodos instance = new Metodos();
        instance.Eliminar(Id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ActualizarArticulo method, of class Metodos_Articulos.
     */
    @Test
    public void testActualizarArticulo() {
        System.out.println("ActualizarArticulo");
        DArticulos pdto = null;
        Metodos instance = new Metodos();
        instance.ActualizarArticulo(pdto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Buscar_Id method, of class Metodos_Articulos.
     */
    @Test
    public void testBuscar_Id() {
        System.out.println("Buscar_Id");
        String Id = "";
        String expResult = "";
        String result = Metodos.Buscar_Id(Id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ConsultarDatosArticulos method, of class Metodos_Articulos.
     */
    @Test
    public void testConsultarDatosArticulos() {
        System.out.println("ConsultarDatosArticulos");
        DArticulos prov = null;
        Metodos instance = new Metodos();
        DArticulos expResult = null;
        DArticulos result = instance.ConsultarDatosArticulos(prov);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarArticuloTabla method, of class Metodos_Articulos.
     */
    @Test
    public void testBuscarArticuloTabla() {
        System.out.println("BuscarArticuloTabla");
        JTable TablaDatos = null;
        JTextField txtId = null;
        Metodos instance = new Metodos();
        JTable expResult = null;
        JTable result = instance.BuscarArticuloTabla(TablaDatos, txtId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

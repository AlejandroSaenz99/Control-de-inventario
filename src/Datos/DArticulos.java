/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Date;

public class DArticulos {
    private int Id;
    private String Nombre;
    private String Descripcion;
    private float Costo_Entrada;
    private float Costo_Promedio_U;
    private float Stock;
    private float Entrada;
    private Date Fecha_Ultima_Entrada;
    private String Categoria;
    private float Punto_Reorden;
    private String Estado;

    private String Unidad_Medida;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public float getCosto_Entrada() {
        return Costo_Entrada;
    }

    public void setCosto_Entrada(float Costo_Entrada) {
        this.Costo_Entrada = Costo_Entrada;
    }

    public float getCosto_Promedio_U() {
        return Costo_Promedio_U;
    }

    public void setCosto_Promedio_U(float Costo_Promedio_U) {
        this.Costo_Promedio_U = Costo_Promedio_U;
    }

    public float getStock() {
        return Stock;
    }

    public void setStock(float Stock) {
        this.Stock = Stock;
    }

    public float getEntrada() {
        return Entrada;
    }

    public void setEntrada(float Entrada) {
        this.Entrada = Entrada;
    }

    public Date getFecha_Ultima_Entrada() {
        return Fecha_Ultima_Entrada;
    }

    public void setFecha_Ultima_Entrada(Date Fecha_Ultima_Entrada) {
        this.Fecha_Ultima_Entrada = Fecha_Ultima_Entrada;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public float getPunto_Reorden() {
        return Punto_Reorden;
    }

    public void setPunto_Reorden(float Punto_Reorden) {
        this.Punto_Reorden = Punto_Reorden;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    

    public String getUnidad_Medida() {
        return Unidad_Medida;
    }

    public void setUnidad_Medida(String Unidad_Medida) {
        this.Unidad_Medida = Unidad_Medida;
    }

    public DArticulos(int Id, String Nombre, String Descripcion, float Costo_Entrada, float Costo_Promedio_U, float Stock, float Entrada, Date Fecha_Ultima_Entrada, String Categoria, float Punto_Reorden, String Estado,  String Unidad_Medida) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Costo_Entrada = Costo_Entrada;
        this.Costo_Promedio_U = Costo_Promedio_U;
        this.Stock = Stock;
        this.Entrada = Entrada;
        this.Fecha_Ultima_Entrada = Fecha_Ultima_Entrada;
        this.Categoria = Categoria;
        this.Punto_Reorden = Punto_Reorden;
        this.Estado = Estado;
       
        this.Unidad_Medida = Unidad_Medida;
    }

    public DArticulos() {
    }
}

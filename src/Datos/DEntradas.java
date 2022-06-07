/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Date;

/**
 *
 * @author del.sistemas_res
 */
public class DEntradas {
    private int Id;
    private String Nombre;
    private String Descripcion;
    private float Costo_Entrada;
    private float Stock;
    private float Entrada;
    private Date Fecha_Ultima_Entrada;
    public String Hora;
    private String Estado;
    private String Categoria;

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

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public DEntradas(int Id, String Nombre, String Descripcion, float Costo_Entrada, float Stock, float Entrada, Date Fecha_Ultima_Entrada, String Hora, String Estado, String Categoria) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Costo_Entrada = Costo_Entrada;
        this.Stock = Stock;
        this.Entrada = Entrada;
        this.Fecha_Ultima_Entrada = Fecha_Ultima_Entrada;
        this.Hora = Hora;
        this.Estado = Estado;
        this.Categoria = Categoria;
    }

    public DEntradas() {
    }

}

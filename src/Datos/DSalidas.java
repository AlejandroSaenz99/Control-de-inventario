package Datos;

import java.sql.Date;

public class DSalidas {
    private int Id;
    private String Nombre;
    private String Descripcion;
    private float Stock;
    private float Salida;
    private Date Fecha_Salida;
    private String Hora;
    private String Estado;
    private String Categoria;

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Descripcion
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * @param Descripcion the Descripcion to set
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    /**
     * @return the Stock
     */
    public float getStock() {
        return Stock;
    }

    /**
     * @param Stock the Stock to set
     */
    public void setStock(float Stock) {
        this.Stock = Stock;
    }

    /**
     * @return the Salida
     */
    public float getSalida() {
        return Salida;
    }

    /**
     * @param Salida the Salida to set
     */
    public void setSalida(float Salida) {
        this.Salida = Salida;
    }

    /**
     * @return the Fecha_Salida
     */
    public Date getFecha_Salida() {
        return Fecha_Salida;
    }

    /**
     * @param Fecha_Salida the Fecha_Salida to set
     */
    public void setFecha_Salida(Date Fecha_Salida) {
        this.Fecha_Salida = Fecha_Salida;
    }

    /**
     * @return the Hora
     */
    public String getHora() {
        return Hora;
    }

    /**
     * @param Hora the Hora to set
     */
    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    /**
     * @return the Estado
     */
    public String getEstado() {
        return Estado;
    }

    /**
     * @param Estado the Estado to set
     */
    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    /**
     * @return the Categoria
     */
    public String getCategoria() {
        return Categoria;
    }

    /**
     * @param Categoria the Categoria to set
     */
    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }
}

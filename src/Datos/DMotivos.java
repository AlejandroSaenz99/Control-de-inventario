package Datos;

import java.sql.Date;

public class DMotivos {
    private String Tipo;
    private String Justificacion;
    private Date Fecha;
    private String Articulo;

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getJustificacion() {
        return Justificacion;
    }

    public void setJustificacion(String Justificacion) {
        this.Justificacion = Justificacion;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getArticulo() {
        return Articulo;
    }

    public void setArticulo(String Articulo) {
        this.Articulo = Articulo;
    }

    public DMotivos(String Tipo, String Justificacion, Date Fecha, String Articulo) {
        this.Tipo = Tipo;
        this.Justificacion = Justificacion;
        this.Fecha = Fecha;
        this.Articulo = Articulo;
    }

    public DMotivos() {
    }
}
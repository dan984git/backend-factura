package com.factura.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Factura")
public class Factura {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFactura;

    @Column(name = "NombreEmisor",nullable = false)
    private String nombreEmisor;
    private String numeroFactura;
    private Date fechaFactura;
    private float precioUnitario;
    private float precioTotal;
    private String descripcionProducto;
    private int cantidadProducto;

    public Factura(){

    }

    public Factura(int idFactura, String nombreEmisor, String numeroFactura, Date fechaFactura, float precioUnitario, float precioTotal, String descripcionProducto, int cantidadProducto) {
        this.idFactura = idFactura;
        this.nombreEmisor = nombreEmisor;
        this.numeroFactura = numeroFactura;
        this.fechaFactura = fechaFactura;
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioTotal;
        this.descripcionProducto = descripcionProducto;
        this.cantidadProducto = cantidadProducto;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getNombreEmisor() {
        return nombreEmisor;
    }

    public void setNombreEmisor(String nombreEmisor) {
        this.nombreEmisor = nombreEmisor;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }
}

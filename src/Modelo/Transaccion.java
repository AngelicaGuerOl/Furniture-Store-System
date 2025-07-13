/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Angelica Guerrero
 */
public class Transaccion {
    private int id_transaccion;
    private int id_datosTransaccion;
    private int id_articulo;
    private String categoria;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private double precio_unitario;
    private double importe;
    private double importe_total;
    private String metodo_pago;
    public Transaccion() {
    }

    public Transaccion(int id_transaccion, int id_datosTransaccion, int id_articulo, String categoria, String nombre, String descripcion, int cantidad, double precio_unitario, double importe, double importe_total, String metodo_pago) {
        this.id_transaccion = id_transaccion;
        this.id_datosTransaccion = id_datosTransaccion;
        this.id_articulo = id_articulo;
        this.categoria = categoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.importe = importe;
        this.importe_total = importe_total;
        this.metodo_pago = metodo_pago;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public int getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public int getId_datosTransaccion() {
        return id_datosTransaccion;
    }

    public void setId_datosTransaccion(int id_datosTransaccion) {
        this.id_datosTransaccion = id_datosTransaccion;
    }

    public int getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(int id_articulo) {
        this.id_articulo = id_articulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getImporte_total() {
        return importe_total;
    }

    public void setImporte_total(double importe_total) {
        this.importe_total = importe_total;
    }

    @Override
    public String toString() {
        return "Transaccion{" + "id_transaccion=" + id_transaccion + ", id_datosTransaccion=" + id_datosTransaccion + ", id_articulo=" + id_articulo + ", categoria=" + categoria + ", nombre=" + nombre + ", descripcion=" + descripcion + ", cantidad=" + cantidad + ", precio_unitario=" + precio_unitario + ", importe=" + importe + ", importe_total=" + importe_total + ", metodo_pago=" + metodo_pago + '}';
    }

    
    
    
    
    
}

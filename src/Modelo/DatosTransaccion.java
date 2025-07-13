/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Angelica Guerrero
 */
public class DatosTransaccion {
    private int id_datosTransaccion;
    private int id_cliente;
    private int id_usuario;
    private String fecha_transaccion;
    private double importe_total;
    private double valorPagar;
    private double cuenta;
    private String tipo_transaccion;
    private String condicion_transaccion;

    public DatosTransaccion() {
    }

    public DatosTransaccion(int id_datosTransaccion, int id_cliente, int id_usuario, String fecha_transaccion, double importe_total, double valorPagar, double cuenta, String tipo_transaccion, String condicion_transaccion) {
        this.id_datosTransaccion = id_datosTransaccion;
        this.id_cliente = id_cliente;
        this.id_usuario = id_usuario;
        this.fecha_transaccion = fecha_transaccion;
        this.importe_total = importe_total;
        this.valorPagar = valorPagar;
        this.cuenta = cuenta;
        this.tipo_transaccion = tipo_transaccion;
        this.condicion_transaccion = condicion_transaccion;
    }

    

    public double getImporte_total() {
        return importe_total;
    }

    public void setImporte_total(double importe_total) {
        this.importe_total = importe_total;
    }

    

    public int getId_datosTransaccion() {
        return id_datosTransaccion;
    }

    public void setId_datosTransaccion(int id_datosTransaccion) {
        this.id_datosTransaccion = id_datosTransaccion;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getFecha_transaccion() {
        return fecha_transaccion;
    }

    public void setFecha_transaccion(String fecha_transaccion) {
        this.fecha_transaccion = fecha_transaccion;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }

    public String getTipo_transaccion() {
        return tipo_transaccion;
    }

    public void setTipo_transaccion(String tipo_transaccion) {
        this.tipo_transaccion = tipo_transaccion;
    }

    public String getCondicion_transaccion() {
        return condicion_transaccion;
    }

    public void setCondicion_transaccion(String condicion_transaccion) {
        this.condicion_transaccion = condicion_transaccion;
    }

    public double getCuenta() {
        return cuenta;
    }

    public void setCuenta(double cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return "DatosTransaccion{" + "id_datosTransaccion=" + id_datosTransaccion + ", id_cliente=" + id_cliente + ", id_usuario=" + id_usuario + ", fecha_transaccion=" + fecha_transaccion + ", importe_total=" + importe_total + ", valorPagar=" + valorPagar + ", cuenta=" + cuenta + ", tipo_transaccion=" + tipo_transaccion + ", condicion_transaccion=" + condicion_transaccion + '}';
    }

    
    
    
    
}

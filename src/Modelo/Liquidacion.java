/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Angelica Guerrero
 */
public class Liquidacion {
    private int id_cliente;
    private int id_datosTransaccion;
    private int id_usuario;
    private String fecha_liquidacion;
    private double monto_liquidacion;

    public Liquidacion() {
    }

    public Liquidacion(int id_cliente, int id_datosTransaccion, int id_usuario, String fecha_liquidacion, double monto_liquidacion) {
        this.id_cliente = id_cliente;
        this.id_datosTransaccion = id_datosTransaccion;
        this.id_usuario = id_usuario;
        this.fecha_liquidacion = fecha_liquidacion;
        this.monto_liquidacion = monto_liquidacion;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_datosTransaccion() {
        return id_datosTransaccion;
    }

    public void setId_datosTransaccion(int id_datosTransaccion) {
        this.id_datosTransaccion = id_datosTransaccion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getFecha_liquidacion() {
        return fecha_liquidacion;
    }

    public void setFecha_liquidacion(String fecha_liquidacion) {
        this.fecha_liquidacion = fecha_liquidacion;
    }

    public double getMonto_liquidacion() {
        return monto_liquidacion;
    }

    public void setMonto_liquidacion(double monto_liquidacion) {
        this.monto_liquidacion = monto_liquidacion;
    }
}

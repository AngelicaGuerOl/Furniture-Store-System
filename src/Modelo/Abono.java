/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Angelica Guerrero
 */
public class Abono {
    private int id_abono;
    private int id_cliente;
    private int id_datosTransaccion;
    private int id_usuario;
    private String fecha_abono;
    private double monto_abono;

    public Abono() {
    }

    public Abono(int id_abono, int id_cliente, int id_datosTransaccion, int id_usuario, String fecha_abono, double monto_abono) {
        this.id_abono = id_abono;
        this.id_cliente = id_cliente;
        this.id_datosTransaccion = id_datosTransaccion;
        this.id_usuario = id_usuario;
        this.fecha_abono = fecha_abono;
        this.monto_abono = monto_abono;
    }

    public int getId_abono() {
        return id_abono;
    }

    public void setId_abono(int id_abono) {
        this.id_abono = id_abono;
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

    public String getFecha_abono() {
        return fecha_abono;
    }

    public void setFecha_abono(String fecha_abono) {
        this.fecha_abono = fecha_abono;
    }

    public double getMonto_abono() {
        return monto_abono;
    }

    public void setMonto_abono(double monto_abono) {
        this.monto_abono = monto_abono;
    }

    @Override
    public String toString() {
        return "Abono{" + "id_abono=" + id_abono + ", id_cliente=" + id_cliente + ", id_datosTransaccion=" + id_datosTransaccion + ", id_usuario=" + id_usuario + ", fecha_abono=" + fecha_abono + ", monto_abono=" + monto_abono + '}';
    }
    
    
}

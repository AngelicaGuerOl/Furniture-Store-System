/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Angelica Guerrero
 */
public class Cliente {
    private int id_cliente;
    private String nombre_cliente;
    private String apellidos_cliente;
    private String telefono_cliente;
    private String colonia_cliente;
    private String calle_cliente;
    private String numero_ext_cliente;
    private String codigo_postal_cliente;
    
    public Cliente() {
    }

    public Cliente(int id_cliente, String nombre_cliente, String apellidos_cliente, String telefono_cliente, String colonia_cliente, String calle_cliente, String numero_ext_cliente, String codigo_postal_cliente) {
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.apellidos_cliente = apellidos_cliente;
        this.telefono_cliente = telefono_cliente;
        this.colonia_cliente = colonia_cliente;
        this.calle_cliente = calle_cliente;
        this.numero_ext_cliente = numero_ext_cliente;
        this.codigo_postal_cliente = codigo_postal_cliente;
    }

   

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getApellidos_cliente() {
        return apellidos_cliente;
    }

    public void setApellidos_cliente(String apellidos_cliente) {
        this.apellidos_cliente = apellidos_cliente;
    }

    public String getTelefono_cliente() {
        return telefono_cliente;
    }

    public void setTelefono_cliente(String telefono_cliente) {
        this.telefono_cliente = telefono_cliente;
    }

    

    public String getColonia_cliente() {
        return colonia_cliente;
    }

    public void setColonia_cliente(String colonia_cliente) {
        this.colonia_cliente = colonia_cliente;
    }

    public String getCalle_cliente() {
        return calle_cliente;
    }

    public void setCalle_cliente(String calle_cliente) {
        this.calle_cliente = calle_cliente;
    }

    public String getNumero_ext_cliente() {
        return numero_ext_cliente;
    }

    public void setNumero_ext_cliente(String numero_ext_cliente) {
        this.numero_ext_cliente = numero_ext_cliente;
    }

    public String getCodigo_postal_cliente() {
        return codigo_postal_cliente;
    }

    public void setCodigo_postal_cliente(String codigo_postal_cliente) {
        this.codigo_postal_cliente = codigo_postal_cliente;
    }

    
    
    
}

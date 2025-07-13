/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Angelica Guerrero
 */
public class Articulos {
    private int id_articulo;
    private int id_categoria;
    private String nombre_articulo;
    private String descripcion_articulo;
    private String condicion_articulo;
    private String color_articulo;
    private double precio_articulo;
    private int stock_articulo;

    public Articulos() {
    }

    public Articulos(int id_articulo, int id_categoria, String nombre_articulo, String descripcion_articulo, String condicion_articulo, String color_articulo, double precio_articulo, int stock_articulo) {
        this.id_articulo = id_articulo;
        this.id_categoria = id_categoria;
        this.nombre_articulo = nombre_articulo;
        this.descripcion_articulo = descripcion_articulo;
        this.condicion_articulo = condicion_articulo;
        this.color_articulo = color_articulo;
        this.precio_articulo = precio_articulo;
        this.stock_articulo = stock_articulo;
    }

    public int getId_articulo() {
        return id_articulo;
    }
    

    public void setId_articulo(int id_articulo) {
        this.id_articulo = id_articulo;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre_articulo() {
        return nombre_articulo;
    }

    public void setNombre_articulo(String nombre_articulo) {
        this.nombre_articulo = nombre_articulo;
    }

    public String getDescripcion_articulo() {
        return descripcion_articulo;
    }

    public void setDescripcion_articulo(String descripcion_articulo) {
        this.descripcion_articulo = descripcion_articulo;
    }

    public String getCondicion_articulo() {
        return condicion_articulo;
    }

    public void setCondicion_articulo(String condicion_articulo) {
        this.condicion_articulo = condicion_articulo;
    }

    public String getColor_articulo() {
        return color_articulo;
    }

    public void setColor_articulo(String color_articulo) {
        this.color_articulo = color_articulo;
    }

    public double getPrecio_articulo() {
        return precio_articulo;
    }

    public void setPrecio_articulo(double precio_articulo) {
        this.precio_articulo = precio_articulo;
    }

    public int getStock_articulo() {
        return stock_articulo;
    }

    public void setStock_articulo(int stock_articulo) {
        this.stock_articulo = stock_articulo;
    }
    
    
}

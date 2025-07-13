/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import Modelo.Articulos;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Angelica Guerrero
 */
public class CtrlArticulos {
    public boolean agregar(Articulos obj){
        Connection cn=Conexion.Conectar();
        String query="INSERT INTO articulos(id_articulo,id_categoria,nombre_articulo,descripcion_articulo,condicion_articulo,color_articulo,precio_articulo,stock_articulo) VALUES (?,?,?,?,?,?,?,?)";
        try(PreparedStatement st=cn.prepareStatement(query)){
            st.setInt(1,0 );
            st.setInt(2, obj.getId_categoria());
            st.setString(3, obj.getNombre_articulo());
            st.setString(4, obj.getDescripcion_articulo());
            st.setString(5, obj.getCondicion_articulo());
            st.setString(6, obj.getColor_articulo());
            st.setDouble(7, obj.getPrecio_articulo());
            st.setInt(8, obj.getStock_articulo());
            st.executeUpdate();
            st.close();
            return true;
        }catch(SQLException e){
            System.out.println("Falló la inserción en articulos" + e);
            return false;
        }
    }
    public boolean actualizar(Articulos obj, int id_articulo) {
    boolean respuesta = false;
    String errorMessage = "";
    Connection cn = Conexion.Conectar();
    String query = "UPDATE articulos SET id_categoria=?,nombre_articulo=?,descripcion_articulo=?,condicion_articulo=?,color_articulo=?,precio_articulo=?,stock_articulo=? WHERE id_articulo=?";
    try (PreparedStatement st = cn.prepareStatement(query)) {
        st.setInt(1, obj.getId_categoria());
        st.setString(2, obj.getNombre_articulo());
        st.setString(3, obj.getDescripcion_articulo());
        st.setString(4, obj.getCondicion_articulo());
        st.setString(5, obj.getColor_articulo());
        st.setDouble(6, obj.getPrecio_articulo());
        st.setInt(7, obj.getStock_articulo());
        st.setInt(8, id_articulo);
        if (st.executeUpdate()> 0) {
            
            respuesta = true;
        }
    } catch (SQLException e) {
        errorMessage = "Falló actualización de articulos: " + e.getMessage();
    } 
    
    return respuesta;
}
    public boolean eliminar(int idArticulo){
        Connection cn=Conexion.Conectar();
        String query="DELETE FROM articulos WHERE id_articulo =?";
        try(PreparedStatement st = cn.prepareStatement(query)){
             st.setInt(1, idArticulo);
             // Se ejecuta la consulta de eliminación y se obtiene el número de filas afectadas.
             byte n_filasafectadas = (byte) st.executeUpdate();
             // Se cierra la conexión a la base de datos.
             cn.close();
             // Se retorna true si se eliminó al menos una fila, de lo contrario false.
             return n_filasafectadas > 0;
        }catch(SQLException e){
            System.out.println("Fallo la eliminación de articulos: "+e);
            return false;
        }
    }
}

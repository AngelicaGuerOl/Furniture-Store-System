/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import Modelo.Categoria;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Angelica Guerrero
 */
public class CtrlCategoria {
    public boolean agregar(Categoria obj){
        Connection cn=Conexion.Conectar();
        String query = "INSERT INTO categorias (id_categoria,categoria) VALUES(?,?)";
        try(PreparedStatement st = cn.prepareStatement(query)){
            st.setInt(1, 0);
            st.setString(2, obj.getCategoria());
            st.executeUpdate();
            st.close();
            return true;
        }catch(SQLException e){
            System.out.println("Falló la inserción en categorias" + e);
            return false;
        }
    }
    public boolean actualizar(Categoria obj){
        Connection cn=Conexion.Conectar();
        String query="UPDATE categorias SET categoria=? WHERE id_categoria=?";
        try(PreparedStatement st=cn.prepareStatement(query)){
            st.setString(1, obj.getCategoria());
            st.setInt(2, obj.getId_categoria());
            st.executeUpdate();
            return true;
        }catch(SQLException e){
            System.out.println("Error al actualizar categoria "+e);
            return false;
        }
    }
    public boolean eliminar(int idCategoria){
        Connection cn=Conexion.Conectar();
        String query="DELETE FROM categorias WHERE id_categoria=?";
        try(PreparedStatement st = cn.prepareStatement(query)){
           st.setInt(1, idCategoria);
           byte n_filasafectadas = (byte)st.executeUpdate();//Sirve para insertar y actualizar
           cn.close();
           return n_filasafectadas > 0;  
        }catch(SQLException e){
            System.out.println("Falló la eliminación de la categoria");
            return false;
        }
    }
}

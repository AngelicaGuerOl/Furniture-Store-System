/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import Modelo.Cliente;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author Angelica Guerrero
 */
public class CtrlCliente {
    public boolean agregar(Cliente obj){
        Connection cn=Conexion.Conectar();
        String query="INSERT INTO cliente(id_cliente,nombre_cliente,apellidos_cliente,telefono_cliente,colonia_cliente,calle_cliente,numero_ext_cliente,codigo_postal_cliente) VALUES (?,?,?,?,?,?,?,?)";
        try(PreparedStatement st=cn.prepareStatement(query)){
            st.setInt(1, 0);
            st.setString(2, obj.getNombre_cliente());
            st.setString(3, obj.getApellidos_cliente());
            st.setString(4, obj.getTelefono_cliente());
            st.setString(5, obj.getColonia_cliente());
            st.setString(6, obj.getCalle_cliente());
            st.setString(7, obj.getNumero_ext_cliente());
            st.setString(8, obj.getCodigo_postal_cliente());
            st.executeUpdate();
            st.close();
            return true;
        }catch(SQLException e){
            System.out.println("Falló la inserción en cliente" + e);
            return false;
        }
    }
    public boolean actualizar(Cliente obj){
        Connection cn=Conexion.Conectar();
        String query="UPDATE cliente SET nombre_cliente=?,apellidos_cliente=?,telefono_cliente=?,colonia_cliente=?,calle_cliente=?,numero_ext_cliente=?,codigo_postal_cliente=? WHERE id_cliente=?";
        try(PreparedStatement st=cn.prepareStatement(query)){
            st.setString(1, obj.getNombre_cliente());
            st.setString(2, obj.getApellidos_cliente());
            st.setString(3, obj.getTelefono_cliente());
            st.setString(4, obj.getColonia_cliente());
            st.setString(5, obj.getCalle_cliente());
            st.setString(6, obj.getNumero_ext_cliente());
            st.setString(7, obj.getCodigo_postal_cliente());
            st.setInt(8, obj.getId_cliente());
            st.executeUpdate();
            return true;
        }catch(SQLException e){
            System.out.println("Falló actualización de cliiente: " + e);
            return false;
        }
    }
    public boolean eliminar(int idCliente){
        Connection cn=Conexion.Conectar();
        String query="DELETE FROM cliente WHERE id_cliente =?";
        try(PreparedStatement st = cn.prepareStatement(query)){
             st.setInt(1, idCliente);
             // Se ejecuta la consulta de eliminación y se obtiene el número de filas afectadas.
             byte n_filasafectadas = (byte) st.executeUpdate();
             // Se cierra la conexión a la base de datos.
             cn.close();
             // Se retorna true si se eliminó al menos una fila, de lo contrario false.
             return n_filasafectadas > 0;
        }catch(SQLException e){
            System.out.println("Fallo la eliminación de cliente: "+e);
            return false;
        }
    }
}

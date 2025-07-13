/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Conexion.Conexion;
import Modelo.Abono;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Angelica Guerrero
 */
public class CtrlAbono {
    public boolean registrar(Abono obj){
        Connection cn=Conexion.Conectar();
        String query="INSERT INTO abonos(id_abono,id_cliente,id_datosTransaccion,id_usuario,fecha_abono,monto_abono) VALUES (?,?,?,?,?,?)";
        try(PreparedStatement st=cn.prepareStatement(query)){
            st.setInt(1, 0);
            st.setInt(2, obj.getId_cliente());
            st.setInt(3, obj.getId_datosTransaccion());
            st.setInt(4, obj.getId_usuario());
            st.setString(5, obj.getFecha_abono());
            st.setDouble(6, obj.getMonto_abono());
            st.executeUpdate();
            st.close();
            return true;
        }catch(SQLException e){
            System.out.println("Falló la inserción en abono" + e);
            return false;
        }
    }
    // Método para obtener el id_datosTransaccion del cliente
public int obtenerIdDatosTransaccion(int idTransaccion) {
    int idDatosTransaccion = 0; // Valor predeterminado o manejo de errores
    
    try {
        Connection cn = Conexion.Conectar();
        String sql = "SELECT id_datosTransaccion FROM datos_transaccion WHERE id_cliente = ?";
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setInt(1, idDatosTransaccion);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            idDatosTransaccion = rs.getInt("id_datosTransaccion");
        }
        
        cn.close();
    } catch (SQLException e) {
        System.out.println("Error al obtener id_datosTransaccion: " + e);
    }
    
    return idDatosTransaccion;
}
}

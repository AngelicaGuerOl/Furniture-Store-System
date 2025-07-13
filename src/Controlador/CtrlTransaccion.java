/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import Modelo.Transaccion;
import Modelo.Articulos;
import Modelo.DatosTransaccion;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author Angelica Guerrero
 */
public class CtrlTransaccion {
    public static int idDatosRegistrados;
    java.math.BigDecimal IdColValor;
    public boolean agregar(DatosTransaccion obj){
        Connection cn=Conexion.Conectar();
        String query="INSERT INTO datos_transaccion(id_datosTransaccion,id_usuario,id_cliente,fecha_transaccion,importe_total,aCuenta,valorPagar,tipo_transaccion,condicion_transaccion) VALUES (?,?,?,?,?,?,?,?,?)";
        try(PreparedStatement st=cn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS)){
            st.setInt(1,0 );
            st.setInt(2, obj.getId_usuario());
            st.setInt(3, obj.getId_cliente());
            st.setString(4, obj.getFecha_transaccion());
            st.setDouble(5, obj.getImporte_total());
            st.setDouble(6, obj.getCuenta());
            st.setDouble(7, obj.getValorPagar());
            st.setString(8, obj.getTipo_transaccion());
            st.setString(9, obj.getCondicion_transaccion());
            st.execute();
            ResultSet rs=st.getGeneratedKeys();
            while(rs.next()){
                IdColValor=rs.getBigDecimal(1);
                idDatosRegistrados=IdColValor.intValue();
            }
            
            st.close();
            return true;
        }catch(SQLException e){
            System.out.println("Falló la inserción en transaccion" + e);
            return false;
        }
    }
    public boolean agregarDetalleTransaccion(Transaccion obj){
        Connection cn=Conexion.Conectar();
        String query="INSERT INTO transacciones(id_transaccion,id_datosTransaccion,id_articulo,cantidad,precio_unitario,importe,metodo_pago) VALUES (?,?,?,?,?,?,?)";
        try(PreparedStatement st=cn.prepareStatement(query)){
            st.setInt(1,0 );
            st.setInt(2, idDatosRegistrados);
            st.setInt(3, obj.getId_articulo());
            st.setInt(4, obj.getCantidad());
            st.setDouble(5, obj.getPrecio_unitario());
            st.setDouble(6, obj.getImporte());
            st.setString(7, obj.getMetodo_pago());

            st.executeUpdate();
            st.close();
            return true;
        }catch(SQLException e){
            System.out.println("Falló la inserción en detalle transaccion" + e);
            return false;
        }
    }
    public boolean actualizarTransaccion(DatosTransaccion obj){
        Connection cn=Conexion.Conectar();
        String query="UPDATE datos_transaccion SET id_cliente=?, tipo_transaccion=? WHERE id_datosTransaccion=?";
        try (PreparedStatement st = cn.prepareStatement(query)) {
            st.setInt(1, obj.getId_cliente());
            st.setString(2, obj.getTipo_transaccion());
            st.setInt(3, obj.getId_datosTransaccion());
            st.executeUpdate();
            return true;
        }catch(SQLException e){
            System.out.println("Falló actualización de transaccion: " + e);
            return false;
        }
    }
}

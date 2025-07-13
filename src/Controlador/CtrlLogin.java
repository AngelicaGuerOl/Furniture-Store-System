/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Angelica Guerrero
 */
public class CtrlLogin {
    public boolean comprobacion(Usuario obj){
        try{
            Connection cn = Conexion.Conectar();
            String query = "SELECT * FROM usuarios WHERE nombre_usuario=? AND password_usuario=?";
            PreparedStatement st = cn.prepareStatement(query);
            st.setString(1, obj.getNombre_usuario());
            st.setString(2, obj.getPassword_usuario());
            ResultSet rs = st.executeQuery();
            boolean comprobado = rs.next();
            rs.close();
            st.close();
            cn.close();
            return comprobado;
        }catch(SQLException e){
            System.out.println("El usuario no está registrado en la base de datos: " + e);
            return false;
        }
    }
}

package com.example.bookside;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginUser extends AsyncTask<Usuario, Void, Usuario> {
    /**
     * Metodo que realiza la consulta en la bd del usuario logueado
     * @param datos
     * @return
     */
    protected Usuario doInBackground(Usuario... datos){
        Usuario user = new Usuario();
        String sql = "select email, nombre, apellido, id_rol, id_estado, estado_cuenta from bookside.usuario " +
                "where email = '"+datos[0].getEmail()+"' " +
                "and password = '"+datos[0].getPassword()+"'";
        try{
            Conexion conexion = new Conexion();
            Connection conn = conexion.connect();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                rs.beforeFirst();
                while(rs.next()){
                    user.setEmail(rs.getString("email"));
                    user.setNombre(rs.getString("nombre"));
                    user.setApellido(rs.getString("apellido"));
                    user.setIdRol(rs.getInt("id_rol"));
                    user.setIdEstado(rs.getInt("id_estado"));
                    user.setEstadoCuenta(rs.getInt("estado_cuenta"));
                }
            } else{
                user = null;
            }
        } catch(Exception ex){
            user = null;
            ex.printStackTrace();
        }
        return user;
    }
}

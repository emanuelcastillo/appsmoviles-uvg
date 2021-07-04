package com.example.bookside;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class RecuperarContrasena extends AsyncTask <Usuario, Void, Usuario> {
    @Override
    protected Usuario doInBackground(Usuario... datos) {
        Usuario user = new Usuario();
        String sql = "select email, nombre, apellido, cui_usuario, id_estado, password from bookside.usuario " +
                "where email = '"+datos[0].getEmail()+"'";
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
                    user.setCuiusuairo(rs.getString("cui_usuario"));
                    user.setIdEstado(rs.getInt("id_estado"));
                    user.setPassword(rs.getString("password"));
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

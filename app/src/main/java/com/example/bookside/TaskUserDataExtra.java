package com.example.bookside;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TaskUserDataExtra extends AsyncTask<Usuario, Void, Usuario> {

    @Override
    protected Usuario doInBackground(Usuario... datos) {

        Usuario user = new Usuario();
        String sql = "select email, password, nombre, apellido, pin, cui_usuario, id_rol , id_estado, estado_cuenta from bookside.usuario where email = '"+datos[0].getEmail()+"' ";
        try{
            Conexion conexion = new Conexion();
            Connection Con = conexion.connect();
            Statement st = Con.createStatement();
            ResultSet rs = st.executeQuery(sql);
                /*
                    puede que aqui este el error
                 */
            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()) {
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    user.setNombre(rs.getString("nombre"));
                    user.setApellido(rs.getString("apellido"));
                    user.setPin(rs.getString("pin"));
                    user.setCuiusuairo(rs.getString("cui_usuario"));
                    user.setIdRol(rs.getInt("id_rol"));
                    user.setIdEstado(rs.getInt("id_estado"));
                    user.setEstadoCuenta(rs.getInt("estado_cuenta"));
                }
            }
            else{
                user = null;
            }
        }
        catch(Exception ex){
            user = null;
            ex.printStackTrace();
        }
        return user;
    }
}


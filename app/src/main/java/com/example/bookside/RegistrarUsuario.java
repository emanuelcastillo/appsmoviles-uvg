package com.example.bookside;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.Statement;


public class RegistrarUsuario extends AsyncTask<Usuario, Void, String> {

    /**
     * Metodo que guarda el nuevo usuario
     * @param datos
     * @return
     */
    protected String doInBackground(Usuario... datos){
        String resultado = "";
        try{
            String sql;
            Conexion conexion = new Conexion();
            Connection conn = conexion.connect();

            sql = "insert into bookside.usuario (email, password, nombre, apellido, pin, cui_usuario, id_rol, id_estado, estado_cuenta) " +
                    "values ('"+datos[0].getEmail()+"', '"+datos[0].getPassword()+"', '"+datos[0].getNombre()+"', '"+datos[0].getApellido()+"', '"+datos[0].getPin()+"', '"+datos[0].getCuiusuairo()+"', "+datos[0].getIdRol()+", "+datos[0].getIdEstado()+", 0)";
                    //"values ('"+datos[0].getLoginName()+"', '"+datos[0].getPassword()+"', '"+datos[0].getNombres()+"', '"+datos[0].getApellidos()+"', "+datos[0].getIdRol()+", "+datos[0].getIdEstado()+", '"+datos[0].getCorreo()+"', '"+datos[0].getPin()+"', 0)";

            Statement st = conn.createStatement();
            int rs = st.executeUpdate(sql);

            if(rs == 1){
                resultado = "exito";
            } else{
                resultado = "error";
            }

        } catch(Exception ex){
            resultado = "error";
            ex.printStackTrace();
        }
        return resultado;
    }
}


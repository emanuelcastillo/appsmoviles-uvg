package com.example.bookside;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.Statement;

public class ActivacionCuenta extends AsyncTask<Usuario, Void, String> {
    @Override
    protected String doInBackground(Usuario... usuarios) {
        String resultado;
        try{

            Conexion connect = new Conexion();
            Connection conn = connect.connect();

            String sql = "UPDATE usuario SET estado_cuenta = "+usuarios[0].getEstadoCuenta()+" WHERE email = '"+usuarios[0].getEmail()+"'";
            Statement st = conn.createStatement();

            int rs = st.executeUpdate(sql);
            if(rs == 1){
                resultado = "exito";
            } else{
                resultado = "error";
            }
        }
        catch (Exception exception){
            exception.printStackTrace();
            String errorfatal = exception.toString();
            return errorfatal;
        }
        return resultado;
    }
}
package com.example.bookside;

import android.os.AsyncTask;

public class ConnctFtpTask extends AsyncTask <Void, Void, String> {
    @Override
    protected String doInBackground(Void... voids) {
        try{
            Conexion ftpConn = new Conexion();
            return ftpConn.ConexionToFtp();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}

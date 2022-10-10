package com.example.bookside;


import android.os.AsyncTask;


import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class UploadFileTask extends AsyncTask<String,Void,String> {

    Conexion var = new Conexion();
    int portftp = var.portftp;
    String server = var.server;
    String user = var.user;
    String passwordftp = var.passwordftp;

    @Override
    protected String doInBackground(String... strings) {
        String dato = strings[0];
        FTPClient ftpClient = new FTPClient();
        try {

            ftpClient.connect(server);
            ftpClient.login(user, passwordftp);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            File rutaCompleta = new File(dato);

            BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(rutaCompleta));

            String filename=dato.substring(dato.lastIndexOf("/")+1);

            boolean result = ftpClient.storeFile(filename, buffer);

            if(result){
                ftpClient.logout();
                ftpClient.disconnect();
                return "exito";
            }
            else {
                ftpClient.logout();
                ftpClient.disconnect();
                return dato;
            }
        }
        catch (Exception exception){
            String excep;
            exception.printStackTrace();
            excep = exception.toString();
            return excep;
        }
    }
}

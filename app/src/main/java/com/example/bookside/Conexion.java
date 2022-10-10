package com.example.bookside;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion{

    //atributos para la conexion a la base de datos
    private Connection conn = null;
    private String driver = "com.mysql.jdbc.Driver";
    String host = "172.24.4.38";
    String port = "3306";
    String dbName = "bookside";
    String userName = "root";
    String password = "emanuel";

    //atrb para conectaser al servido
    int portftp = 21;
    int portlogin = 14147;
    String server = "172.24.4.38";
    String user = "emanuel";
    String passwordftp = "emanuel";

    /**
     * Constructor de la clase
     */
    public Conexion(){
    }

    /**
     * Metodo que obtiene la conexion a la base de datos
     */
    public Connection connect(){
        try {
            Class.forName(driver).newInstance();
            String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
            conn = DriverManager.getConnection(url, userName, password);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return conn;
    }
    /**
     * Metodo que cierra la conexion a la base de datos
     */
    public void disconnect(Connection conn) throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

    /*
    metodo para conectar al servidor ftp
    */
    public String ConexionToFtp() {
        FTPClient ftpClient = new FTPClient();
        String res = "";
        try {
            ftpClient.connect(server, portftp);

            int resultado = ftpClient.getReplyCode();

            if (!FTPReply.isPositiveCompletion(resultado)) {

                res = "error";
            } else {
                boolean loginexitoso = ftpClient.login(user, passwordftp);
                if (loginexitoso) {
                    //si la conexion con el servidor ftp fue exitosa devuelve conn
                    res = "bookside";
                } else {
                    res = "problem";
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return  res;
    }
}

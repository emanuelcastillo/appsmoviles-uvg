package com.example.bookside;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ExecutionException;

public class ForgottenPassword extends AppCompatActivity {

    Button btnEnviarConfirmacion,btnConfirmarPin;
    EditText txtCorreo, txtcodigo;
    String nombre, email, apellido, cuiusuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotten_password);
        getSupportActionBar().setTitle("Recuperar contraseña");
        getSupportActionBar().setHomeButtonEnabled(true);

        btnEnviarConfirmacion = findViewById(R.id.btnEnviarPin);
        btnConfirmarPin = findViewById(R.id.btnConfirmarPin);
        txtCorreo = findViewById(R.id.txtCorreodeRecuperacion);
        txtcodigo = findViewById(R.id.txtConfirmarCodigo);

        btnEnviarConfirmacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Usuario usuario = new Usuario();
                    Usuario user = new Usuario();
                    user.setEmail(txtCorreo.getText().toString());
                    usuario = new RecuperarContrasena().execute(user).get();

                    if(txtCorreo.getText().toString().equals(""))
                    {
                        Toast.makeText(ForgottenPassword.this, "Ingrese su correo eléctronico", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        RecuperarContrasena(usuario);
                        String resultadoCorreo = new MailJob("booksideuvg@gmail.com", "n_D2cGi8qZvR:Wr").execute(
                                new MailJob.Mail("booksideuvg@gamil.com", txtCorreo.getText().toString(), "Metodo de recuperacion para: " + nombre + " " + apellido,
                                        "Hola estimado "+ nombre +" este es tu codigo unico de identificación de usuario: <<"+ cuiusuario +">> por favor ingresalo en el modulo de recuperación de contraseña"
                                        + " si tu no solicitaste este codigo puedes obviar este correo. ")).get();
                        if (resultadoCorreo.equals("exito")) {
                            Toast.makeText(ForgottenPassword.this, "Correo de confirmacion enviado revise su correo", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });

        btnConfirmarPin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Usuario usuario = new Usuario();
                    Usuario user = new Usuario();
                    user.setEmail(txtCorreo.getText().toString());
                    usuario = new RecuperarContrasena().execute(user).get();
                    RecuperarContrasena(usuario);

                    if(txtcodigo.getText().toString().equals(usuario.getCuiusuairo()))
                    {
                        String resultadoCorreo = new MailJob("booksideuvg@gmail.com", "n_D2cGi8qZvR:Wr").execute(
                                new MailJob.Mail("booksideuvg@gamil.com", txtCorreo.getText().toString(), "Metodo de recuperacion para: " + nombre + " " + apellido,
                                        "Hola estimado "+ nombre +" esta es tu contraseña: <<" + usuario.getPassword() +">> por favor no compartas este correo con ninguna persona")).get();
                        if (resultadoCorreo.equals("exito")) {
                            Toast.makeText(ForgottenPassword.this, "Correo de recuperación enviado revise su correo", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(ForgottenPassword.this, "Código unico de usuario invalido revisa nuevamente el correo de confirmación", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }




    public void RecuperarContrasena (Usuario usuario){
        if(usuario != null){
            if(usuario.getIdEstado() != 1){
                Toast.makeText(getApplicationContext(), "Usuario Inactivo", Toast.LENGTH_SHORT).show();
            } else{
                nombre = usuario.getNombre();
                apellido = usuario.getApellido();
                email = usuario.getEmail();
                cuiusuario = usuario.getCuiusuairo();
            }
        } else{
            Toast.makeText(getApplicationContext(), "Correo no registrado", Toast.LENGTH_SHORT).show();
        }
    }
}
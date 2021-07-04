package com.example.bookside;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    public static String nombre,apellido,email;
    EditText txtLoginEmailUser, txtLoginPasswordUser;
    Button btnLogin, btnForgotPassword;
    String FatalError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Iniciar Sesión");
        getSupportActionBar().setHomeButtonEnabled(true);

        txtLoginEmailUser = findViewById(R.id.txtLoginEmailUser);
        txtLoginPasswordUser = findViewById(R.id.txtLoginPasswordUser);

        btnLogin = findViewById(R.id.btnLogin);
        btnForgotPassword = findViewById(R.id.btnForgotPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 try {
                    Usuario usuario = new Usuario();
                    Usuario user = new Usuario();
                    user.setEmail(txtLoginEmailUser.getText().toString().toLowerCase());
                    user.setPassword(txtLoginPasswordUser.getText().toString());
                    usuario = new LoginUser().execute(user).get();
                    if(txtLoginEmailUser.getText().toString().equals("") || txtLoginPasswordUser.getText().toString().equals(""))
                    {
                        Toast.makeText(Login.this, "Rellene todos los campos", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if(usuario != null){
                            if(usuario.getIdEstado() != 1){
                                Toast.makeText(Login.this, "Usuario Inactivo", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                if(usuario.getEstadoCuenta() != 1){

                                    AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                                    builder.setTitle("CUENTA NO CONFIRMADA");
                                    builder.setMessage("Su cuenta no esta confirmada, confirmela en el modulo de registro.");
                                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                        }
                                    });
                                    builder.create();
                                    builder.show();

                                }
                                else {
                                    nombre = usuario.getNombre();
                                    apellido = usuario.getApellido();
                                    email = usuario.getEmail();
                                    Intent navegacion = new Intent(Login.this, Home.class);
                                    startActivity(navegacion);
                                }
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Usuario y/o Contraseña incorrectos", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                    FatalError = exception.toString();
                    Toast.makeText(Login.this, "Error fatal: " + FatalError, Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent FttPassword = new Intent(Login.this, ForgottenPassword.class);
                    startActivity(FttPassword);
                    //finish();
                }
                catch (Exception exception)
                {
                    String FatalError;
                    exception.printStackTrace();
                    FatalError = exception.toString();
                    Toast.makeText(Login.this, "Error fatal: " + FatalError, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

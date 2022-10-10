package com.example.bookside;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Signup extends AppCompatActivity {

    private EditText txtSignupEmailUser, txtSingupPasswordUser, txtSingupPasswordReforcedUser,
            txtSingupFirstNameUser, txtSignupSecondNameUser, txtPin;
    Button btnSignup, btnConfirmarPin, btnReeviarPin;
    private final String TAG = "Signup";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().setTitle("Registrarte");
        getSupportActionBar().setHomeButtonEnabled(true);

        txtSignupEmailUser = findViewById(R.id.txtSigunEmailUser);
        txtSingupPasswordUser = findViewById(R.id.txtSignupPasswordUser);
        txtSingupPasswordReforcedUser = findViewById(R.id.txtSigupPasswordUserReforced);
        txtSingupFirstNameUser = findViewById(R.id.txtSignupFirstNameUser);
        txtSignupSecondNameUser = findViewById(R.id.txtSignupSecondNameUser);
        txtPin = findViewById(R.id.txtPin);

        btnConfirmarPin = findViewById(R.id.btnconfirmarcuenta);
        btnReeviarPin = findViewById(R.id.btnReenviar);
        btnSignup = findViewById(R.id.btnSingup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                    if(
                            txtSignupEmailUser.getText().toString().equals("")||
                            txtSingupPasswordUser.getText().toString().equals("") ||
                            txtSingupPasswordReforcedUser.getText().toString().equals("") ||
                            txtSingupFirstNameUser.getText().toString().equals("") ||
                            txtSignupSecondNameUser.getText().toString().equals("")
                    )
                    {
                        Toast.makeText(Signup.this, "Rellene los campos correctamente", Toast.LENGTH_SHORT).show();
                    }
                    else {
                            if (!txtSignupEmailUser.getText().toString().contains("@") || !txtSignupEmailUser.getText().toString().contains(".")) {
                                    Toast.makeText(Signup.this, "El correo es invalido", Toast.LENGTH_SHORT).show();
                            }
                            else if (txtSingupPasswordUser.getText().toString().length() <= 7) {
                                Toast.makeText(Signup.this, "La Contraseña debe tener mas de siete caracteres", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                if (txtSingupPasswordUser.getText().toString().equals(txtSingupPasswordReforcedUser.getText().toString())) {

                                    Usuario user = new Usuario();
                                    user.setEmail(txtSignupEmailUser.getText().toString().toLowerCase());
                                    user.setPassword(txtSingupPasswordUser.getText().toString());
                                    user.setNombre(txtSingupFirstNameUser.getText().toString().toUpperCase());
                                    user.setApellido(txtSignupSecondNameUser.getText().toString().toUpperCase());
                                    user.setPin(generarPin());
                                    user.setCuiusuairo(generarCodigoUnicodeUsuario());
                                    user.setIdEstado(1);
                                    user.setIdRol(1);

                                    //asdfghjklqwertyuioppoiuytrewqasdfghjkloiuytrewqasd /50 caracteres
                                    //emanuel.castillo0118@outlook.es /30 caracteres

                                    String resultado = new RegistrarUsuario().execute(user).get();

                                        if (resultado.equals("exito")) {
                                            String resultadoCorreo = new MailJob("booksideuvg@gmail.com", "n_D2cGi8qZvR:Wr").execute(
                                                    new MailJob.Mail("booksideuvg@gmail.com", txtSignupEmailUser.getText().toString(), "Confirmación de cuenta", "Copia este código en el módulo de validación de la cuenta: " + user.getPin() + " " + user.getCuiusuairo())).get();
                                            if(resultadoCorreo.equals("exito")){
                                                Toast.makeText(Signup.this, "Cuenta creada revise su correo", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                        else {
                                            Toast.makeText(Signup.this, "Error al registrar el usuario " + generarCodigoUnicodeUsuario(), Toast.LENGTH_SHORT).show();
                                        }
                                }
                                else {
                                    Toast.makeText(Signup.this, "Las contraseñas no coinsiden", Toast.LENGTH_SHORT).show();
                                }
                            }
                    }
                }
                catch (Exception exception)
                {
                    String FatalError;
                    exception.printStackTrace();
                    FatalError = exception.toString();
                    Toast.makeText(Signup.this, "Error fatal: " + FatalError, Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnConfirmarPin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(txtSignupEmailUser.getText().toString().equals("")){
                        Toast.makeText(Signup.this, "Ingrese el correo para buscar el pin", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if(txtPin.getText().toString().equals("")){
                            Toast.makeText(Signup.this, "Ingrese el pin de confirmacion", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Usuario user2 = new Usuario();
                            user2.setEmail(txtSignupEmailUser.getText().toString().toLowerCase());
                            Usuario usuario = new TaskUserDataExtra().execute(user2).get();

                            if(usuario.getPin().equals(txtPin.getText().toString())){
                                Usuario user = new Usuario();
                                user.setEstadoCuenta(1);
                                user.setEmail(txtSignupEmailUser.getText().toString().toLowerCase());
                                String res = new ActivacionCuenta().execute(user).get();
                                if(res.equals("exito")){
                                    Toast.makeText(Signup.this, "Cuenta activada", Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    Toast.makeText(Signup.this, "Algo salio mal al tratar de activar la cuenta", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else {
                                Toast.makeText(Signup.this, "El pin es incorrecto verifique su correo", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
                catch (Exception exception){
                    exception.printStackTrace();
                    String error = exception.toString();
                    Toast.makeText(Signup.this, "Error caused by: "+ error, Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnReeviarPin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (txtSignupEmailUser.getText().toString().equals("")){
                        Toast.makeText(Signup.this, "Ingrese el correo para enviar el pin", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Usuario usuario = new Usuario();
                        usuario.setEmail(txtSignupEmailUser.getText().toString().toUpperCase());
                        Usuario user = new TaskUserDataExtra().execute(usuario).get();

                        String resultadoCorreo = new MailJob("booksideuvg@gmail.com", "n_D2cGi8qZvR:Wr").execute(
                                new MailJob.Mail("booksideuvg@gmail.com", txtSignupEmailUser.getText().toString(), "Confirmación de cuenta", "Copia este código en el módulo de validación de la cuenta: <<" + user.getPin() + ">>")).get();
                        if(resultadoCorreo.equals("exito")) {
                            Toast.makeText(Signup.this, "Pin reenviado revise su correo", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                catch (Exception exception){
                    exception.printStackTrace();
                    String error = exception.toString();
                    Toast.makeText(Signup.this, "Error caused by: " + error, Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    public String generarCodigoUnicodeUsuario() {
        String resultado = "";
        int longitud = 10;
        try{
            for(int count = 0; count<longitud ; count++)
            {
                int num = (int) ((26 * Math.random()) + 'a');

                char letra = (char) num;
                resultado = resultado+letra;
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return resultado;
    }

    public String generarPin(){
        String pin = "";
        try{
            int numero1 = (int)(10 * Math.random());
            int numero2 = (int)(10 * Math.random());
            int numero3 = (int)(10 * Math.random());
            int numero4 = (int)(10 * Math.random());
            pin = String.valueOf(numero1) + String.valueOf(numero2) + String.valueOf(numero3) + String.valueOf(numero4);
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return pin;
    }
}
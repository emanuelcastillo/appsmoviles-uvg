package com.example.bookside;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnMainLogin,btnMainSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("BooksideUVG");
        getSupportActionBar().setIcon(R.drawable.ic_open_book);

        btnMainLogin = findViewById(R.id.btnMailLogin);
        btnMainSignup = findViewById(R.id.btnMainSignup);

        btnMainLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent Login = new Intent(MainActivity.this, Login.class);
                    startActivity(Login);
                }
                catch (Exception exception)
                {
                    String FatalError;
                    exception.printStackTrace();
                    FatalError = exception.toString();
                    Toast.makeText(MainActivity.this, "Error fatal: " + FatalError, Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnMainSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent Signup = new Intent(MainActivity.this, Signup.class);
                    startActivity(Signup);
                }
                catch (Exception exception)
                {
                    String FatalError;
                    exception.printStackTrace();
                    FatalError = exception.toString();
                    Toast.makeText(MainActivity.this, "Error fatal: " + FatalError, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
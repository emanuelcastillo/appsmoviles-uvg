package com.example.bookside;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookside.fragment.FragmentBookFav;

import java.io.Serializable;

public class BookDetail extends AppCompatActivity implements Serializable {


    public static Books books;
    FragmentBookFav BooksFav = new FragmentBookFav();
    Button btnAddFavoritos,btnLeerpdf;
    TextView Titulo,Autor,Descripcion;
    ImageView portada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        books = (Books) getIntent().getSerializableExtra("DetalleLibro");
        btnAddFavoritos = findViewById(R.id.btnAddFavorit);
        Titulo = findViewById(R.id.lblTituloLibro);
        Autor = findViewById(R.id.lblAutorLibro);
        Descripcion = findViewById(R.id.lblDescripcion);
        portada = findViewById(R.id.PortadaLibro);
        btnLeerpdf = findViewById(R.id.btnLeerpdf);

        Titulo.setText(books.titulo);
        Autor.setText(books.Autor);
        Descripcion.setText(books.Desc);
        portada.setImageResource(books.portada);

        btnAddFavoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BookDetail.this, "se añadio a favoritos", Toast.LENGTH_SHORT).show();
                //BooksFav.booksfav = books;
            }
        });

        btnLeerpdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BookDetail.this, "funcion no disponible", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
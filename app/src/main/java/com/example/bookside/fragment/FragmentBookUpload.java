package com.example.bookside.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bookside.Adapter;
import com.example.bookside.Books;
import com.example.bookside.R;
import com.example.bookside.UploadBook;

import java.util.ArrayList;
import java.util.List;


public class FragmentBookUpload extends Fragment {

    View view;
    Button btnSubirpdf,btnRecargar;
    ListView listViewBookfav;
    List<Books> list;

    public FragmentBookUpload(){
        //requiere tipo constructor vacio
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_book_upload,container,false);

        btnSubirpdf = view.findViewById(R.id.btnSubirPdf);
        btnRecargar = view.findViewById(R.id.btnRecargar);

        listViewBookfav = view.findViewById(R.id.listuploadbooks);
        Adapter adapter = new Adapter(getContext(), GetData());
        listViewBookfav.setAdapter(adapter);

        btnSubirpdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), UploadBook.class);
                startActivity(intent);
            }
        });
        btnRecargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Prueba", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private List<Books> GetData() {
        list = new ArrayList<>();
        list.add(new Books(1,R.string.EjemploDesc,"Título: Ejemplo","Autor: Ejemplo",R.drawable.a_portada_de_libro_ejemplo));
        list.add(new Books(2,R.string.EjemploDesc,"Título: Ejemplo","Autor: Ejemplo",R.drawable.a_portada_de_libro_ejemplo));
        list.add(new Books(3,R.string.EjemploDesc,"Título: Ejemplo","Autor: Ejemplo",R.drawable.a_portada_de_libro_ejemplo));
        list.add(new Books(4,R.string.EjemploDesc,"Título: Ejemplo","Autor: Ejemplo",R.drawable.a_portada_de_libro_ejemplo));
        list.add(new Books(5,R.string.EjemploDesc,"Título: Ejemplo","Autor: Ejemplo",R.drawable.a_portada_de_libro_ejemplo));
        list.add(new Books(6,R.string.EjemploDesc,"Título: Ejemplo","Autor: Ejemplo",R.drawable.a_portada_de_libro_ejemplo));
        list.add(new Books(7,R.string.EjemploDesc,"Título: Ejemplo","Autor: Ejemplo",R.drawable.a_portada_de_libro_ejemplo));
        list.add(new Books(8,R.string.EjemploDesc,"Título: Ejemplo","Autor: Ejemplo",R.drawable.a_portada_de_libro_ejemplo));
        list.add(new Books(10,R.string.EjemploDesc,"Título: Ejemplo","Autor: Ejemplo",R.drawable.a_portada_de_libro_ejemplo));
        list.add(new Books(11,R.string.EjemploDesc,"Título: Ejemplo","Autor: Ejemplo",R.drawable.a_portada_de_libro_ejemplo));

        return  list;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
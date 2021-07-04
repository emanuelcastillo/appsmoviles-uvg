package com.example.bookside.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bookside.Adapter;
import com.example.bookside.Books;
import com.example.bookside.R;

import java.util.ArrayList;
import java.util.List;


public class FragmentBookFav extends Fragment {

    public static Books booksfav;
    ListView listViewBookfav;
    List<Books> list;
    View view;

    public FragmentBookFav(){
        //requiere tipo constructor vacio
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_book_fav,container,false);



            listViewBookfav = view.findViewById(R.id.listviewbooksfav);
            Adapter adapter = new Adapter(getContext(), GetData());
            listViewBookfav.setAdapter(adapter);


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
            list.add(new Books(9,R.string.EjemploDesc,"Título: Ejemplo","Autor: Ejemplo",R.drawable.a_portada_de_libro_ejemplo));
            list.add(new Books(10,R.string.EjemploDesc,"Título: Ejemplo","Autor: Ejemplo",R.drawable.a_portada_de_libro_ejemplo));
            list.add(new Books(11,R.string.EjemploDesc,"Título: Ejemplo","Autor: Ejemplo",R.drawable.a_portada_de_libro_ejemplo));

        return  list;
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}

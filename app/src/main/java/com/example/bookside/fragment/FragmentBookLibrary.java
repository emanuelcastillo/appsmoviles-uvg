package com.example.bookside.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bookside.Adapter;
import com.example.bookside.BookDetail;
import com.example.bookside.Books;
import com.example.bookside.R;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class FragmentBookLibrary extends Fragment {

    ListView listViewBook;
    List<Books> list;
    View view;


    public FragmentBookLibrary(){
        //requiere tipo constructor vacio
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_book_library,container,false);

        listViewBook = view.findViewById(R.id.listviewbooks);
        Adapter adapter = new Adapter(getContext(), GetData());
        listViewBook.setAdapter(adapter);

        listViewBook.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Books books = list.get(position);

                Intent DetalleLibro = new Intent(getContext(), BookDetail.class);
                DetalleLibro.putExtra("DetalleLibro", books);
                startActivity(DetalleLibro);

            }
        });

        return view;
    }

    private List<Books> GetData() {

        list = new ArrayList<>();

        list.add(new Books(
                1,R.string.Desc1,
                "Título: Psicológicamente hablando: Un recorrido por las maravillas de la mente",
                "Autor: Adrián Triglia, Bertrand Regader," + " Jonathan García-Allen",
                R.drawable.a_psicologicamente_hablando_default));
        list.add(new Books(
                2,
                R.string.Desc2,
                "Título: Historia de dos ciudades",
                "Autor: Charles Dickens",
                R.drawable.a_historia_dos_ciudades_default));
        list.add(new Books(
                3,
                R.string.Desc3,
                "Título: Guerra y Paz",
                "Autor: León Tolstói",
                R.drawable.a_guerra_paz_default));
        list.add(new Books(
                4,
                R.string.Desc4,
                "Título: La insoportable levedad del ser",
                "Autor: Milan Kudera",
                R.drawable.a_la_insoportable_levedad_default));
        list.add(new Books(
                5,
                R.string.Desc5,
                "Título: El viaje a la felicidad: Las nuevas claves cientificas",
                "Autor: Eduard Punset",
                R.drawable.a_viaje_felicidad_punset_default));
        list.add(new Books(
                6,
                R.string.Desc6,
                "Título: En busca del tiempo perdido",
                "Autor: Marcel Proust",
                R.drawable.a_proust_tiempo_perdido_default));
        list.add(new Books(
                7,
                R.string.Desc7,
                "Título: Don Quijote de la Mancha",
                "Autor: Miguel de Cervantes",
                R.drawable.a_quijote_default));
        list.add(new Books(
                8,
                R.string.Desc8,
                "Título: Cien años de soledad",
                "Autor: Gabriel García Márquez",
                R.drawable.a_cien_anos_de_soledad_de_gabriel_garcia_marquez_default));
        list.add(new Books(
                9,
                R.string.Desc9,
                "Título: Inteligencia Emocional", "Autor: Daniel Goleman",
                R.drawable.a_inteligencia_emocional_default));
        list.add(new Books(
                10,
                R.string.Desc10,
                "Título: El guardián entre el centeno",
                "Autor: J. D. Salinger",
                R.drawable.a_guardian_entre_el_centeno_default));

        return list;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}

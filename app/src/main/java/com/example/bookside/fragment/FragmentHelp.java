package com.example.bookside.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bookside.R;

public class FragmentHelp  extends Fragment {

    Button btnProbemas,btnCambiarCuenta,btnRecuperarCuenta,btnCambiarContasena,btnEliminarCuenta;

    View view;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_help,container,false);

        btnProbemas = view.findViewById(R.id.problemasiniciar);
        btnCambiarCuenta = view.findViewById(R.id.cambiarcuenta);
        btnCambiarContasena = view.findViewById(R.id.cambiarcontrasena);
        btnRecuperarCuenta = view.findViewById(R.id.recuperarcuenta);
        btnEliminarCuenta = view.findViewById(R.id.eliminarcuenta);


        btnProbemas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Selecciono problemas al iniciar seción", Toast.LENGTH_SHORT).show();
            }
        });
        btnCambiarCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Selecciono Cambiar cuenta", Toast.LENGTH_SHORT).show();
            }
        });
        btnCambiarContasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Selecciono Cambiar contraseña", Toast.LENGTH_SHORT).show();
            }
        });
        btnRecuperarCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Selecciono Recuperar Cuenta", Toast.LENGTH_SHORT).show();
            }
        });
        btnEliminarCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Selecciono Eliminar Cuenta", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}

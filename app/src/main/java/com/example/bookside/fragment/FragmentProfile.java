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

public class FragmentProfile extends Fragment {

    View view;
    Button btnCambiarFotodePerfil,btnCambiarNombre,btnCambiarApellido,btnCambiarCorreoElectronico;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile,container,false);

        btnCambiarFotodePerfil = view.findViewById(R.id.btnCambiarPerfil);
        btnCambiarNombre = view.findViewById(R.id.btnCambiarNombre);
        btnCambiarApellido = view.findViewById(R.id.btnCambiarApellido);
        btnCambiarCorreoElectronico = view.findViewById(R.id.btnCambiarCorreo);



        btnCambiarFotodePerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Selecciono Cambiar foto de perfil", Toast.LENGTH_SHORT).show();
            }
        });
        btnCambiarNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Selecciono Cambiar nombre", Toast.LENGTH_SHORT).show();
            }
        });
        btnCambiarApellido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Selecciono Cambiar apellido", Toast.LENGTH_SHORT).show();
            }
        });
        btnCambiarCorreoElectronico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Selecciono cambiar correo eléctronico", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}

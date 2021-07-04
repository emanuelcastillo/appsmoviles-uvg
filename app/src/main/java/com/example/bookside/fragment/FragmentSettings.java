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

import com.example.bookside.Conexion;
import com.example.bookside.ConnctFtpTask;
import com.example.bookside.R;

public class FragmentSettings extends Fragment {

    View view;
    Button btnCompartir,btnPorbarconn;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_settings,container,false);


        btnCompartir = view.findViewById(R.id.btnCompartir);
        btnPorbarconn = view.findViewById(R.id.btnTestConFtp);


        btnCompartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Selecciono Compartir", Toast.LENGTH_SHORT).show();
            }
        });

        btnPorbarconn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String res = new ConnctFtpTask().execute().get();
                    if(res.equals("bookside")){
                        Toast.makeText(getContext(), "Conexion establecida con " + res, Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getContext(), "¡Ocurrio un problema! desc: " + res, Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                    String error = exception.toString();
                    Toast.makeText(getContext(), "Error caused by: " + error, Toast.LENGTH_SHORT).show();
                }
            }
        });


        return view;
    }
}

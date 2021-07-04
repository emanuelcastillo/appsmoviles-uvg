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

public class FragmentError extends Fragment {

    View view;
    Button btnReportarError;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_error,container,false);

        btnReportarError = view.findViewById(R.id.btnReportarError);



        btnReportarError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Selecciono reportar error vía sitio web", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
}

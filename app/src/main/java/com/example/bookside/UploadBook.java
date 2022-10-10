package com.example.bookside;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;

import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;



public class UploadBook extends AppCompatActivity {


    Button btnSelectfile, btnUploadfile;
    EditText txtSubirTitulolibro, txtSubirAutorLibro, txtSubirFechaLibro, txtNombreArchivo;
    String s;
    ImageView imgImagenCargar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_book);
        getSupportActionBar().setTitle("BooksideUVG");
        getSupportActionBar().setHomeButtonEnabled(true);

        btnSelectfile = findViewById(R.id.btnSelectfIle);
        btnUploadfile = findViewById(R.id.btnUploadfile);
        txtSubirTitulolibro = findViewById(R.id.txtuploadbooktitle);
        txtSubirAutorLibro = findViewById(R.id.txtuploadbookautor);
        txtSubirFechaLibro = findViewById(R.id.txtuploadbookdate);
        txtNombreArchivo = findViewById(R.id.txtNombreArchivo);
        imgImagenCargar = findViewById(R.id.imgImagenCargar);

        btnSelectfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    selectPdf();
                } catch (Exception exception) {
                    exception.printStackTrace();
                    String error = exception.toString();
                    Toast.makeText(UploadBook.this, "Error caused by: " + error, Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnUploadfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if(ContextCompat.checkSelfPermission(UploadBook.this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                        String res = new UploadFileTask().execute(s).get();
                        if(res.equals("exito")){
                            Toast.makeText(UploadBook.this, "Imagen "+ res +" subida con exito", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(UploadBook.this, "Error al subir archivo caused by: " + res, Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(UploadBook.this);
                        builder.setTitle("SE NECESITA PERMISO DE ACCESO A ARCHIVOS");
                        builder.setMessage("Vaya a: Ajustes/aplicaciones/cinemolis/<<Accesos>> o <<Permisos>>/Alamacenamiento/Seleccione permitir.");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.create();
                        builder.show();
                    }
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                    String error = ex.toString();
                    Toast.makeText(UploadBook.this, "Fatal error caused by: " + error, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void selectPdf() {
        Intent selector = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        selector.setType("image/*");
        startActivityForResult(selector.createChooser(selector, "Seleccione una aplicación"), 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if(resultCode == RESULT_OK){
                Uri path = data.getData();
                imgImagenCargar.setImageURI(path);
                s = getRealPathFromURI(path);
                String filename=s.substring(s.lastIndexOf("/")+1);
                txtNombreArchivo.setText(filename);
            }
            else {
                Toast.makeText(this, "se cancelo la seleccion de archivo", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
            String error = ex.toString();
            Toast.makeText(this, "Error caused by: " + error, Toast.LENGTH_SHORT).show();
        }
    }

    private String getRealPathFromURI(Uri uri){
        String[] projection = { MediaStore.Images.Media.DATA };
        @SuppressWarnings("deprecation")
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }
}
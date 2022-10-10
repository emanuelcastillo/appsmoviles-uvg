package com.example.bookside;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {

    Context context;
    List<Books> list;

    public Adapter(Context context, List<Books> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public int getCount() {

        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {

        Books books = list.get(i);

            view = LayoutInflater.from(context).inflate(R.layout.book_list,null);

            TextView txtTitutlo = view.findViewById(R.id.txtBookTitle);
            TextView txtAutor = view.findViewById(R.id.txtAuthor);
            ImageView bookiimage = view.findViewById(R.id.bookimage);

            bookiimage.setImageResource(books.portada);
            txtTitutlo.setText(books.titulo);
            txtAutor.setText(books.Autor);

        return view;
    }
}

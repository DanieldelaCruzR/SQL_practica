package com.example.danni.sql_practica;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListaFragment extends Fragment {


    public ListaFragment() {
        // Required empty public constructor
    }

    private Button bConsultar;
    private LibrosSQLiteHelper libros;
    private SQLiteDatabase dbLibros;
    private String libro="mundo";
    private ArrayList<Libros> lista_datos;
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_lista, container, false);
        bConsultar=(Button)view.findViewById(R.id.bConsultar);

        libros = new LibrosSQLiteHelper(getContext(), "LibrosDB", null,1);
        dbLibros=libros.getWritableDatabase();
        recyclerView=(RecyclerView)view.findViewById(R.id.contentRecycler);
        bConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lista_datos = new ArrayList<Libros>();
                Cursor c = dbLibros.rawQuery("select * from Libros",null);
                while(c.moveToNext()){
                    Libros temp = new Libros();
                    temp.setId(c.getInt(0));
                    temp.setLibro(c.getString(1));
                    temp.setAutor(c.getString(2));
                    temp.setPersona(c.getString(3));
                    temp.setTelefono(c.getString(4));
                    lista_datos.add(temp);
                }


                adapter=new MyAdapter(getContext(),lista_datos);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            }
        });

        return view;
    }

}

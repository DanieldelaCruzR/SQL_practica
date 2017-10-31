package com.example.danni.sql_practica;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class EliminarFragment extends Fragment {


    public EliminarFragment() {
        // Required empty public constructor
    }

    private EditText eId;
    private Button bEliminar;
    private LibrosSQLiteHelper libros;
    private SQLiteDatabase dbLibros;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_eliminar, container, false);

        eId=(EditText)view.findViewById(R.id.eId);
        bEliminar=(Button)view.findViewById(R.id.bEliminar);
        libros = new LibrosSQLiteHelper(getContext(), "LibrosDB", null,1);
        dbLibros=libros.getWritableDatabase();

        bEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(eId.getText().toString().isEmpty()){
                    Toast.makeText(getContext(),"Complete campo ID",Toast.LENGTH_SHORT).show();
                }else{
                    int id = Integer.parseInt(eId.getText().toString());
                    dbLibros.delete("Libros","id='"+id+"'",null);
                }
            }
        });
        return view;
    }

}

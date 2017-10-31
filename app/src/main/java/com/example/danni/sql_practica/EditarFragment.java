package com.example.danni.sql_practica;


import android.database.Cursor;
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
public class EditarFragment extends Fragment {

/*
    public EditarFragment() {
        // Required empty public constructor
    }*/
    private EditText eLibro, eId, ePersona, eAutor, eTelefono;
    private Button bEditar;
    private LibrosSQLiteHelper libros;
    private SQLiteDatabase dbLibros;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_editar, container, false);

        eId = (EditText)view.findViewById(R.id.eId);
        eLibro = (EditText)view.findViewById(R.id.eLibro);
        eAutor = (EditText)view.findViewById(R.id.eAutor);
        ePersona = (EditText)view.findViewById(R.id.ePersona);
        eTelefono = (EditText)view.findViewById(R.id.eTelefono);
        bEditar = (Button)view.findViewById(R.id.bEditar);
        libros = new LibrosSQLiteHelper(getContext(), "LibrosDB", null,1);
        dbLibros=libros.getWritableDatabase();

        bEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String libro = eLibro.getText().toString();
                String autor = eAutor.getText().toString();
                String persona = ePersona.getText().toString();
                String telefono = eTelefono.getText().toString();
                if(libro.isEmpty()||autor.isEmpty()||persona.isEmpty()||telefono.isEmpty()){
                    Toast.makeText(getContext(),"Complete todos los campos",Toast.LENGTH_SHORT).show();
                }else{
                    int id = Integer.parseInt(eId.getText().toString());
                    dbLibros.execSQL("UPDATE Libros SET libro='"+libro+"',autor='"+autor+"',persona='"+persona+"',telefono='"+telefono+"'"+"WHERE id='"+id+"'");
                }
            }
        });

        return view;
    }

}

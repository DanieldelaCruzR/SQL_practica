package com.example.danni.sql_practica;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    FragmentManager fm;
    FragmentTransaction ft;
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.insertar:
                    ft = fm.beginTransaction();
                    AgregarFragment agregarFragment = new AgregarFragment();
                    ft.replace(R.id.content,agregarFragment).commit();
                    System.out.println("hola");
                    return true;
                case R.id.lista:
                    ft = fm.beginTransaction();
                    ListaFragment listaFragment = new ListaFragment();
                    ft.replace(R.id.content,listaFragment).commit();
                    return true;
                case R.id.editar:
                    ft = fm.beginTransaction();
                    EditarFragment editarFragment=new EditarFragment();
                    ft.replace(R.id.content,editarFragment).commit();
                    return true;
                case R.id.eliminar:
                    ft = fm.beginTransaction();
                    EliminarFragment eliminarFragment = new EliminarFragment();
                    ft.replace(R.id.content,eliminarFragment).commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fm=getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.add(R.id.content,new AgregarFragment()).commit();
    }

}

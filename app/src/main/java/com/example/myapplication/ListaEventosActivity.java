package com.example.myapplication;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.models.Evento;
import com.example.myapplication.models.ListaEventos;

import java.util.ArrayList;

public class ListaEventosActivity extends ListActivity {

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cargarLista();
    }

    public void cargarLista(){
        lista=getListView();

        ArrayList<Evento> eventos = ListaEventos.getInstancia().getListaEventos();

        ArrayAdapter<Evento> listaAdapter = new ArrayAdapter<Evento>(this,
                android.R.layout.simple_list_item_1,
                eventos);

        lista.setAdapter(listaAdapter);
    }

    public void onListItemClick(ListView listView, View view, int posicion, long id){
        Intent intent = new Intent(ListaEventosActivity.this, DetalleActivity.class);
        intent.putExtra("idEvento", (int)id);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==1)
        {
            if(resultCode==RESULT_OK)
            {
                cargarLista();
            }
        }
    }
}
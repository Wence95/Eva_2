package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.models.Evento;
import com.example.myapplication.models.ListaEventos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListaEventos listaEventos = ListaEventos.getInstancia();
    private ArrayList<Evento> eventos = listaEventos.getListaEventos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addButton = findViewById(R.id.button_add_evento);
        addButton.setOnClickListener(view -> {
            Intent intent=new Intent(MainActivity.this, NuevoEventoActivity.class);
            startActivity(intent);
        });

        Button viewListButton = findViewById(R.id.button_ver_agenda);
        viewListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(eventos.size()>0) {
                    Intent intent = new Intent(MainActivity.this, ListaEventosActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "La lista está vacía",Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button eliminarPasados = findViewById(R.id.button_limpiar);
        eliminarPasados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listaEventos.eliminarEventosPasados();
                Toast.makeText(MainActivity.this, "Se han limpiado los eventos anteriores al día de hoy.",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
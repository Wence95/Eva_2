package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.models.Evento;
import com.example.myapplication.models.ListaEventos;

public class DetalleActivity extends AppCompatActivity {

    public Evento evento;
    public Intent intent;
    private ListaEventos listaEventos = ListaEventos.getInstancia();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        intent = getIntent();
        int id=(Integer) intent.getExtras().get("idEvento");

        evento = listaEventos.getEvento(id);

        TextView txtNombre = (TextView) findViewById(R.id.textNombre);
        txtNombre.setText(evento.getNombre());

        TextView txtFecha=(TextView) findViewById(R.id.textFecha);
        txtFecha.setText(evento.getFechaString());

        TextView txtAsunto=(TextView) findViewById(R.id.textAsunto);
        txtAsunto.setText(evento.getAsunto());

        if (evento.isReversable()){
            Button buttonReverse = (Button) findViewById(R.id.buttonReverse);
            buttonReverse.setVisibility(View.VISIBLE);
            buttonReverse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    evento.reverse();
                    Intent intent = new Intent(DetalleActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });
        }

        Button buttonCambiarNombre = (Button) findViewById(R.id.buttonCambiarNombre);
        buttonCambiarNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetalleActivity.this, CambiarNombreActivity.class);
                intent.putExtra("idEvento", id);
                startActivity(intent);
            }
        });

        Button buttonEliminar = (Button) findViewById(R.id.buttonEliminar);
        buttonEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listaEventos.eliminarEvento(id);
                Toast.makeText(DetalleActivity.this, "Se ha eliminado el evento " + evento.getNombre(),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(DetalleActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button buttonInicio =(Button) findViewById(R.id.buttonVolver);
        buttonInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetalleActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
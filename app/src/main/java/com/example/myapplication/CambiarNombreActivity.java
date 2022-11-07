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

public class CambiarNombreActivity extends AppCompatActivity {

    public Evento evento;
    public Intent intent;
    private ListaEventos listaEventos = ListaEventos.getInstancia();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_nombre);

        intent = getIntent();
        int id =(Integer) intent.getExtras().get("idEvento");
        evento = listaEventos.getEvento(id);

        TextView editTextNombre = (TextView) findViewById(R.id.editTextNombre);
        editTextNombre.setHint(evento.getNombre());



        Button buttonConfirmar = (Button) findViewById(R.id.buttonConfirmar);
        buttonConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nuevoNombre = editTextNombre.getText().toString();
                if (nuevoNombre.isEmpty()){
                    Toast.makeText(CambiarNombreActivity.this, "Ingrese un nombre.",Toast.LENGTH_SHORT).show();
                }
                else if (nuevoNombre.equals(evento.getNombre())){
                    Toast.makeText(CambiarNombreActivity.this, "El nombre no debe ser igual al anterior",Toast.LENGTH_SHORT).show();

                }
                else{
                    evento.setNombre(nuevoNombre);
                    Intent intent = new Intent(CambiarNombreActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
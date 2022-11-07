package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.models.Evento;
import com.example.myapplication.models.ListaEventos;

import java.util.Calendar;

public class NuevoEventoActivity extends AppCompatActivity {

    private ListaEventos listaEventos = ListaEventos.getInstancia();
    private CalendarView mCalendarView;
    private long fechaMili;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_evento);

        mCalendarView = (CalendarView) findViewById(R.id.calendarView);

        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                Calendar c = Calendar.getInstance();
                c.set(i, i1, i2);
                fechaMili = c.getTimeInMillis();
            }
        });

        Button aceptarButton=(Button) findViewById(R.id.aceptarButton);
        aceptarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingresarEvento(view);
            }
        });
    }

    public void ingresarEvento(View view){
        long currentDate = Calendar.getInstance().getTimeInMillis();

        String nombre=((TextView) findViewById(R.id.editTextEvento)).getText().toString();
        String asunto = ((Spinner) findViewById(R.id.asuntoSpinner)).getSelectedItem().toString();

        if (nombre.isEmpty()){
            Toast.makeText(this, "Ingrese un nombre.", Toast.LENGTH_SHORT).show();
        }

        else if (fechaMili < currentDate) {
            Toast.makeText(this, "Ingrese una fecha posterior a hoy.", Toast.LENGTH_SHORT).show();
        }

        else {
            Evento evento = new Evento(nombre, fechaMili, asunto);
            listaEventos.agregarEvento(evento);
            finish();
        }
    }
}
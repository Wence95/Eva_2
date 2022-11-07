package com.example.myapplication.models;

import java.text.SimpleDateFormat;

public class Evento {
    private String nombre;
    private long fecha;
    private String asunto;
    private  String oldNombre;

    public Evento(String nombre, long fecha, String asunto) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.asunto = asunto;
        this.oldNombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public long getFecha() {
        return fecha;
    }

    public String getFechaString() {
        String fechaString = new SimpleDateFormat("dd/MM/yyyy").format(fecha);
        return fechaString;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setNombre(String newNombre){
        if (isReversable()) { oldNombre = nombre; }
        nombre = newNombre;
    }

    public boolean isReversable(){
        return !nombre.equals(oldNombre);
    }

    public void reverse() {
        String aux = nombre;
        nombre = oldNombre;
        oldNombre = aux;
    }

    @Override
    public String toString() {
        return nombre + " " + getFechaString();
    }
}

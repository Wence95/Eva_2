package com.example.myapplication.models;

import java.util.ArrayList;
import java.util.Calendar;

public class ListaEventos {
    private static ListaEventos instancia=new ListaEventos();
    private ArrayList<Evento> listaEventos;

    private ListaEventos() {
        listaEventos=new ArrayList<>();
    }
    public static ListaEventos getInstancia(){
        return instancia;
    }

    public void agregarEvento(Evento evento){
        listaEventos.add(evento);
    }

    public Evento getEvento(int id){
        return listaEventos.get(id);
    }

    public ArrayList<Evento> getListaEventos(){
        return listaEventos;
    }

    public void eliminarEvento(int id) { listaEventos.remove(id); }

    public void eliminarEventosPasados(){
        for(int i=0; i< listaEventos.size(); i++){
            if(listaEventos.get(i).getFecha() < Calendar.getInstance().getTimeInMillis()){
                listaEventos.remove(i);
                i--;
            }
        }
    }
}

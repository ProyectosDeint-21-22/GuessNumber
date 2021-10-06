package com.nachomg.guessnumber.data;

import android.app.Application;

import java.io.Serializable;

public class Number extends Application implements Serializable {
    String jugador;
    Integer nIntentos;
    Integer numero;

    public Number() {
    }

    public Number(String jugador, Integer nIntentos) {
        this.jugador = jugador;
        this.nIntentos = nIntentos;
    }

    public Number(String jugador, Integer nIntentos, Integer numero) {
        this.jugador = jugador;
        this.nIntentos = nIntentos;
        this.numero = numero;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public Integer getnIntentos() {
        return nIntentos;
    }

    public void setnIntentos(Integer nIntentos) {
        this.nIntentos = nIntentos;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }


}

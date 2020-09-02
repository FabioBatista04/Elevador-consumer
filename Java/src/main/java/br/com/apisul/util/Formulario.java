package br.com.apisul.util;

import br.com.apisul.entity.Turno;

public class Formulario {
    int andar;
    char elevador;
    Turno turno;

    public Formulario() {
    }

    public Formulario(int andar, char elevador, Turno turno) {
        this.andar = andar;
        this.elevador = elevador;
        this.turno = turno;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public char getElevador() {
        return elevador;
    }

    public void setElevador(char elevador) {
        this.elevador = elevador;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }
}

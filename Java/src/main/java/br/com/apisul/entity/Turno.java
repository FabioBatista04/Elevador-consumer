package br.com.apisul.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Turno {
    M, V, N;

    public static List<Turno> getTurnos(){
        return new ArrayList<>(Arrays.asList(M, V, N));
    }

}

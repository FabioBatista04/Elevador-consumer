package br.com.apisul.entity;


import java.util.List;

public class PredioEntity {
    Integer andares;
    List<ElevadorEntity> elevadores;

    public PredioEntity(Integer andares, List<ElevadorEntity> elevadores) {
        this.andares = andares;
        this.elevadores = elevadores;
    }

    public Integer getAndares() {
        return andares;
    }

    public void setAndares(Integer andares) {
        this.andares = andares;
    }

    public List<ElevadorEntity> getElevadores() {
        return elevadores;
    }

    public void setElevadores(List<ElevadorEntity> elevadores) {
        this.elevadores = elevadores;
    }
}

package br.com.apisul.entity;

import java.util.Objects;

public class ElevadorEntity {
    private Character name;

    public ElevadorEntity( Character name ){
        this.name = name;
    }
    public Character getName() {
        return name;
    }

    public void setName(Character name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElevadorEntity that = (ElevadorEntity) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "name=" + name;
    }
}

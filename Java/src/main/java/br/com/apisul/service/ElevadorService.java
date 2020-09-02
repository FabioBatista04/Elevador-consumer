package br.com.apisul.service;

import br.com.apisul.entity.ElevadorEntity;
import br.com.apisul.entity.PredioEntity;
import br.com.apisul.entity.Turno;
import br.com.apisul.util.Formulario;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ElevadorService implements IElevadorService {

    private final HashMap<ElevadorEntity, List<Formulario>> estatisicaDeUsoElevador;
    private final List<Formulario> formularios;
    private final PredioEntity predioEntity;

    {
        estatisicaDeUsoElevador = new HashMap<>();
    }

    public ElevadorService( List<Formulario> formularios, PredioEntity predio){
        this.predioEntity = predio;
        this.formularios = formularios;
        popularEstatisticaDeUsoElevador();
    }
    @Override
    public List<Integer> andarMenosUtilizado() {
        HashMap<Integer, Integer> estatisicaDeUsoAndar = new HashMap<>();
        IntStream.range(0,predioEntity.getAndares()).forEach(i -> estatisicaDeUsoAndar.put(i, formularios.stream().filter(f -> i == f.getAndar()).toArray().length));
        return estatisicaDeUsoAndar.entrySet().stream().sorted(Map.Entry.comparingByValue()).map(Map.Entry::getKey).collect(Collectors.toList());
    }

    @Override
    public List<Character> elevadorMaisFrequentado() {
        HashMap<ElevadorEntity, Integer> estatisicaElevadorMaisFrequentado = new HashMap<>();
        estatisicaDeUsoElevador.keySet().forEach(elevedaor -> estatisicaElevadorMaisFrequentado.put( elevedaor, formularios.stream().filter(formulario ->  elevedaor.getName().equals(formulario.getElevador())).toArray().length));
        return estatisicaElevadorMaisFrequentado.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).map(entry -> entry.getKey().getName()).collect(Collectors.toList());
    }

    @Override
    public List<Character> periodoMaiorFluxoElevadorMaisFrequentado() {
        HashMap<Turno, Integer> estatisicaDeUsoPeriodo = new HashMap<>();
        Turno.getTurnos().forEach(turno -> estatisicaDeUsoPeriodo.put(turno,formularios.stream().filter(formulario -> elevadorMaisFrequentado().get(0).equals(formulario.getElevador())).filter(t -> turno.equals(t.getTurno())).toArray().length));
        return estatisicaDeUsoPeriodo.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).map(entry -> entry.getKey().name().charAt(0)).collect(Collectors.toList());
    }

    @Override
    public List<Character> elevadorMenosFrequentado() {
        HashMap<ElevadorEntity, Integer> estatisicaElevadorMenosFrequentado = new HashMap<>();
        estatisicaDeUsoElevador.keySet().forEach(elevedaor -> estatisicaElevadorMenosFrequentado.put( elevedaor, formularios.stream().filter(formulario ->  elevedaor.getName().equals(formulario.getElevador())).toArray().length));
        return estatisicaElevadorMenosFrequentado.entrySet().stream().sorted(Map.Entry.comparingByValue()).map(entry -> entry.getKey().getName()).collect(Collectors.toList());
    }

    @Override
    public List<Character> periodoMenorFluxoElevadorMenosFrequentado() {
        HashMap<Turno, Integer> estatisicaDeUsoPeriodo = new HashMap<>();
        Turno.getTurnos().forEach(turno -> estatisicaDeUsoPeriodo.put(turno,formularios.stream().filter(formulario -> elevadorMenosFrequentado().get(0).equals(formulario.getElevador())).filter(t -> turno.equals(t.getTurno())).toArray().length));
        return estatisicaDeUsoPeriodo.entrySet().stream().sorted(Map.Entry.comparingByValue()).map(entry -> entry.getKey().name().charAt(0)).collect(Collectors.toList());
    }

    @Override
    public List<Character> periodoMaiorUtilizacaoConjuntoElevadores() {
        HashMap<Turno, Integer> estatisicaDeUsoPeriodo = new HashMap<>();
        Turno.getTurnos().forEach(turno -> estatisicaDeUsoPeriodo.put(turno,formularios.stream().filter(formulario -> turno.equals(formulario.getTurno())).toArray().length));
        return estatisicaDeUsoPeriodo.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).map(entry -> entry.getKey().name().charAt(0)).collect(Collectors.toList());
    }

    @Override
    public float percentualDeUsoElevadorA() {
        return estatisicaDeUsoElevador.get(new ElevadorEntity('A')).size() * 100F / formularios.size();
    }

    @Override
    public float percentualDeUsoElevadorB() {
        return estatisicaDeUsoElevador.get(new ElevadorEntity('B')).size() * 100F / formularios.size();
    }

    @Override
    public float percentualDeUsoElevadorC() {
        return estatisicaDeUsoElevador.get(new ElevadorEntity('C')).size() * 100F / formularios.size();
    }

    @Override
    public float percentualDeUsoElevadorD() {
        return estatisicaDeUsoElevador.get(new ElevadorEntity('D')).size() * 100F / formularios.size();
    }

    @Override
    public float percentualDeUsoElevadorE() {
        return estatisicaDeUsoElevador.get(new ElevadorEntity('E')).size() * 100F / formularios.size() ;
    }

    private void popularEstatisticaDeUsoElevador() {
        predioEntity.getElevadores().forEach(e -> estatisicaDeUsoElevador.put(e, formularios.stream().filter(f -> f.getElevador() == e.getName()).collect(Collectors.toList())));
    }
}

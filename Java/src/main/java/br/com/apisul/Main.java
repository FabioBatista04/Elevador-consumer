package br.com.apisul;

import br.com.apisul.entity.ElevadorEntity;
import br.com.apisul.entity.PredioEntity;
import br.com.apisul.service.ElevadorService;
import br.com.apisul.util.Formulario;
import com.google.gson.Gson;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
	    String json = String.join(" ", Files.readAllLines(Paths.get("../input.json"), StandardCharsets.UTF_8));
        Formulario[] levantamento = new Gson().fromJson(json, Formulario[].class);

        List<ElevadorEntity> elevadores = new ArrayList<>();

        elevadores.add(new ElevadorEntity(('A')));
        elevadores.add(new ElevadorEntity(('B')));
        elevadores.add(new ElevadorEntity(('C')));
        elevadores.add(new ElevadorEntity(('D')));
        elevadores.add(new ElevadorEntity(('E')));

        PredioEntity _99a = new PredioEntity(16,elevadores);
        ElevadorService elevadorService = new ElevadorService(Arrays.asList(levantamento), _99a);

        System.out.println("\n\n Andar menos utilizado!");
        System.out.println(elevadorService.andarMenosUtilizado());

        System.out.println("\n\n Elevador mais frequentado!");
        System.out.println(elevadorService.elevadorMaisFrequentado());

        System.out.println("\n\n Periodo de maior fluxo do elevador mais frequentado!");
        System.out.println(elevadorService.periodoMaiorFluxoElevadorMaisFrequentado());

        System.out.println("\n\n Elevador menos frequentado!");
        System.out.println(elevadorService.elevadorMenosFrequentado());

        System.out.println("\n\n Periodo de menor fluxo do elevador menos frequentado!");
        System.out.println(elevadorService.periodoMenorFluxoElevadorMenosFrequentado());

        System.out.println("\n\n Periodo de maior utilização de todos os elevadores!");
        System.out.println(elevadorService.periodoMaiorUtilizacaoConjuntoElevadores());

        System.out.println("\n\n Percentual de Uso elevador A!");
        System.out.println(elevadorService.percentualDeUsoElevadorA() + "%");

        System.out.println("\n\n Percentual de Uso elevador B!");
        System.out.println(elevadorService.percentualDeUsoElevadorB() + "%");

        System.out.println("\n\n Percentual de Uso elevador C!");
        System.out.println(elevadorService.percentualDeUsoElevadorC() + "%");

        System.out.println("\n\n Percentual de Uso elevador D!");
        System.out.println(elevadorService.percentualDeUsoElevadorD() + "%");

        System.out.println("\n\n Percentual de Uso elevador E!");
        System.out.println(elevadorService.percentualDeUsoElevadorE() +"%");
    }
}

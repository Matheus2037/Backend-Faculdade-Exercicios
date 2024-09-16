package Mth_2037_ex08.com.example.exercicio08.controllers;
import Mth_2037_ex08.com.example.exercicio08.Ano;
import Mth_2037_ex08.com.example.exercicio08.Modelo;
import Mth_2037_ex08.com.example.exercicio08.FipeResponse;
import Mth_2037_ex08.com.example.exercicio08.Marca;
import Mth_2037_ex08.com.example.exercicio08.CarroRequest;
import Mth_2037_ex08.com.example.exercicio08.ModeloResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/fipe")
public class FipeController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/valor")
    public ResponseEntity<FipeResponse> getValorFipe(@RequestBody CarroRequest carroRequest) {
        Marca[] marcas = restTemplate.getForObject("https://parallelum.com.br/fipe/api/v1/carros/marcas", Marca[].class);
        Marca marca = Arrays.stream(marcas)
                .filter(m -> m.getNome().equalsIgnoreCase(carroRequest.getMarca()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Marca não encontrada"));

        ModeloResponse modeloResponse = restTemplate.getForObject(
                "https://parallelum.com.br/fipe/api/v1/carros/marcas/{marcaId}/modelos",
                ModeloResponse.class,
                marca.getCodigo()
        );
        Modelo modelo = modeloResponse.getModelos().stream()
                .filter(m -> m.getNome().equalsIgnoreCase(carroRequest.getModelo()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Modelo não encontrado"));

        Ano[] anos = restTemplate.getForObject(
                "https://parallelum.com.br/fipe/api/v1/carros/marcas/{marcaId}/modelos/{modeloId}/anos",
                Ano[].class,
                marca.getCodigo(),
                modelo.getCodigo()
        );
        Ano ano = Arrays.stream(anos)
                .filter(a -> a.getNome().contains(String.valueOf(carroRequest.getAno())))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Ano não encontrado"));

        FipeResponse fipeResponse = restTemplate.getForObject(
                "https://parallelum.com.br/fipe/api/v1/carros/marcas/{marcaId}/modelos/{modeloId}/anos/{anoId}",
                FipeResponse.class,
                marca.getCodigo(),
                modelo.getCodigo(),
                ano.getCodigo()
        );

        return ResponseEntity.ok(fipeResponse);
    }
}
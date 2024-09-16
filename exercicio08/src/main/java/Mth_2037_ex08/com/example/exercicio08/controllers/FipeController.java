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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@RestController
@RequestMapping("/fipe")
public class FipeController {

    private static final Logger logger = LoggerFactory.getLogger(FipeController.class);

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/valor")
    public ResponseEntity<FipeResponse> getValorFipe(@RequestBody CarroRequest carroRequest) {
        logger.info("Recebendo requisição para marca: {}, modelo: {}, ano: {}", carroRequest.getMarca(), carroRequest.getModelo(), carroRequest.getAno());

        Marca[] marcas = restTemplate.getForObject("https://parallelum.com.br/fipe/api/v1/carros/marcas", Marca[].class);
        logger.info("Marcas recebidas: {}", Arrays.toString(marcas));

        Marca marca = Arrays.stream(marcas)
                .filter(m -> m.getNome().equalsIgnoreCase(carroRequest.getMarca()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Marca não encontrada"));

        ModeloResponse modeloResponse = restTemplate.getForObject(
                "https://parallelum.com.br/fipe/api/v1/carros/marcas/{marcaId}/modelos",
                ModeloResponse.class,
                marca.getCodigo()
        );
        logger.info("Modelos recebidos para a marca {}: {}", marca.getNome(), modeloResponse.getModelos());

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
        logger.info("Anos recebidos para o modelo {}: {}", modelo.getNome(), Arrays.toString(anos));

        Ano ano = Arrays.stream(anos)
                .filter(a -> a.getNome().equalsIgnoreCase(carroRequest.getAno()))
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
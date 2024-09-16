package Mth_2037_ex08.com.example.exercicio08.controllers;
import Mth_2037_ex08.com.example.exercicio08.Ano;
import Mth_2037_ex08.com.example.exercicio08.Modelos;
import Mth_2037_ex08.com.example.exercicio08.Modelo;
import Mth_2037_ex08.com.example.exercicio08.FipeResponse;
import Mth_2037_ex08.com.example.exercicio08.FipeValorResponse;
import Mth_2037_ex08.com.example.exercicio08.Marca;
import Mth_2037_ex08.com.example.exercicio08.Carro;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;



@RestController
@RequestMapping("/fipe")
public class FipeController {

    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/consulta")
    public ResponseEntity<FipeValorResponse> consultarFipe(@RequestBody Carro carro) {

        // 1. Obter o código da marca
        String marcasUrl = "https://parallelum.com.br/fipe/api/v1/carros/marcas";
        Marca[] marcas = restTemplate.getForObject(marcasUrl, Marca[].class);
        String marcaCodigo = findCodigoByNome(marcas, carro.marca);

        // 2. Obter o código do modelo
        String modelosUrl = String.format("https://parallelum.com.br/fipe/api/v1/carros/marcas/%s/modelos", marcaCodigo);
        Modelos modelos = restTemplate.getForObject(modelosUrl, Modelos.class);
        String modeloCodigo = findCodigoByNome(modelos.modelos, carro.modelo);

        // 3. Obter o código do ano
        String anosUrl = String.format("https://parallelum.com.br/fipe/api/v1/carros/marcas/%s/modelos/%s/anos", marcaCodigo, modeloCodigo);
        Ano[] anos = restTemplate.getForObject(anosUrl, Ano[].class);
        String anoCodigo = findCodigoByAno(anos, carro.ano);

        // 4. Buscar o valor do carro
        String valorUrl = String.format("https://parallelum.com.br/fipe/api/v1/carros/marcas/%s/modelos/%s/anos/%s", marcaCodigo, modeloCodigo, anoCodigo);
        FipeResponse fipeResponse = restTemplate.getForObject(valorUrl, FipeResponse.class);

        // Retornar o valor e o mês de referência
        FipeValorResponse resposta = new FipeValorResponse();
        resposta.valor = Double.parseDouble(fipeResponse.Valor.replace("R$", "").replace(".", "").replace(",", "."));
        resposta.mes = fipeResponse.MesReferencia;

        return ResponseEntity.ok(resposta);
    }

    // Métodos auxiliares para buscar códigos
    private String findCodigoByNome(Marca[] marcas, String nome) {
        for (Marca marca : marcas) {
            if (marca.nome.equalsIgnoreCase(nome)) {
                return marca.codigo;
            }
        }
        return null;
    }

    private String findCodigoByNome(Modelo[] modelos, String nome) {
        for (Modelo modelo : modelos) {
            if (modelo.nome.equalsIgnoreCase(nome)) {
                return modelo.codigo;
            }
        }
        return null;
    }

    private String findCodigoByAno(Ano[] anos, int ano) {
        for (Ano anoModelo : anos) {
            if (anoModelo.nome.contains(String.valueOf(ano))) {
                return anoModelo.codigo;
            }
        }
        return null;
    }
}
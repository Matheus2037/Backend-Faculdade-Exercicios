package br.net.mth2037_backend.exercicio07.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilmeController {

    @GetMapping("/recomendar")
    public String recomendarFilme(
            @RequestParam(required = false) String genero,
            @RequestParam(required = false) String ambiente) {

        if(ambiente != null && genero != null) {
            if(ambiente.equalsIgnoreCase("futurista") && genero.equalsIgnoreCase("comedia")) {
                return "Sugerimos o filme Homens de Preto.";
            }
            else if (ambiente.equalsIgnoreCase("futurista") && genero.equalsIgnoreCase("drama")) {
                return "Sugerimos o filme Arrival.";
            }
            else if (ambiente.equalsIgnoreCase("medieval") && genero.equalsIgnoreCase("comedia")) {
                return "Sugerimos o filme Shrek.";
            }
            else if (ambiente.equalsIgnoreCase("medieval") && genero.equalsIgnoreCase("drama")) {
                return "Sugerimos o filme Gladiador.";
            }
        }

        return "Nenhuma preferência identificada! As combinações possíveis são:\n" +
                "- Futurista e Comédia: Homens de Preto\n" +
                "- Futurista e Drama: Arrival\n" +
                "- Medieval e Comédia: Shrek\n" +
                "- Medieval e Drama: Gladiador";
    }
}

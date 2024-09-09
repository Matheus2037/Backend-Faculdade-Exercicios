package br.net.mth2037_backend.exercicio07.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controlador {
    @GetMapping("/teste")
    public String teste(@RequestParam String aluno){
        return "Ola "+ aluno +"!";
    }
}

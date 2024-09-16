package Mth_2037_ex08.com.example.exercicio08;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FipeResponse {
    @JsonProperty("Valor")
    private String valor;

    @JsonProperty("MesReferencia")
    private String mesReferencia;

    // Getters e Setters
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
    }
}

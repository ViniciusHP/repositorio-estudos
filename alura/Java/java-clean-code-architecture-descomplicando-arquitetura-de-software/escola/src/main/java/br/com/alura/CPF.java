package br.com.alura;

public class CPF {
    private String numero;

    public CPF(String numero) {
        if(numero == null) {
            throw new IllegalArgumentException("Número é obrigatório");
        }

        if(!numero.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            throw new IllegalArgumentException("Número inválido!");
        }
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }
}

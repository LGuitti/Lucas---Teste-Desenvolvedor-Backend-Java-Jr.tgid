package com.example.demo;

// Classe que representa um Cliente
public class Cliente {
    private String nome;
    private String cpf;

    // Construtor da classe Cliente
    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    // Método para obter o nome do cliente
    public String getNome() {
        return nome;
    }

    // Método para obter o CPF do cliente
    public String getCpf() {
        return cpf;
    }
}
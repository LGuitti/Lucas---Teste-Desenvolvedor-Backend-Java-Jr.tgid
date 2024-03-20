package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

// Classe que representa uma Empresa
@Component
public class Empresa {
    private String nome;
    private String cnpj;
    private double saldo;
    private List<Taxa> taxas;
    private List<Cliente> clientes;

    // Construtor padrão da classe Empresa
    public Empresa() {
        clientes = new ArrayList<>();
    }

    // Método para definir o nome da empresa
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método para definir o CNPJ da empresa com validação
    public boolean setCnpj(String cnpj) {
        // Validar CNPJ
        if (ValidadorCpfCnpj.validarCNPJ(cnpj)) {
            this.cnpj = cnpj;
            return true;
        } else {
            System.out.println("CNPJ inválido: " + cnpj);
            return false;
        }
    }

    // Método para definir as taxas da empresa
    public void setTaxas(List<Taxa> taxas) {
        this.taxas = taxas;
    }

    // Método para obter o nome da empresa
    public String getNome() {
        return nome;
    }

    // Método para obter o CNPJ da empresa
    public String getCnpj() {
        return cnpj;
    }

    // Método para obter o saldo da empresa
    public double getSaldo() {
        return saldo;
    }

    // Método para realizar um depósito na empresa
    public void depositar(double valor, Cliente cliente) {
        saldo += valor;
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
        }
    }

    // Método para realizar um saque na empresa
    public void sacar(double valor, Cliente cliente) {
        double totalTaxas = calcularTaxas();
        if (saldo - valor - totalTaxas >= 0) {
            saldo -= (valor + totalTaxas);
        } else {
            throw new IllegalArgumentException("Saldo insuficiente para saque.");
        }
    }

    // Método privado para calcular as taxas da empresa
    private double calcularTaxas() {
        if (taxas == null) {
            return 0;
        }
    
        double totalTaxas = 0;
        for (Taxa taxa : taxas) {
            totalTaxas += taxa.calcularTaxa();
        }
        return totalTaxas;
    }

    // Método para adicionar um cliente à empresa
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    // Método para remover um cliente da empresa
    public void removerCliente(Cliente cliente) {
        clientes.remove(cliente);
    }
}

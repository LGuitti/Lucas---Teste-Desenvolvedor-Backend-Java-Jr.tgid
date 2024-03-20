package com.example.demo;

// Classe que representa uma requisição de transação
public class TransacaoRequest {
private String cnpjEmpresa;
private String cpfCliente;
private double valor;
// Construtor da classe TransacaoRequest
public TransacaoRequest() {
}

// Método para obter o CNPJ da empresa
public String getCnpjEmpresa() {
    return cnpjEmpresa;
}

// Método para definir o CNPJ da empresa com validação
public void setCnpjEmpresa(String cnpjEmpresa) {
    if (ValidadorCpfCnpj.validarCNPJ(cnpjEmpresa)) {
        this.cnpjEmpresa = cnpjEmpresa;
    } else {
        throw new IllegalArgumentException("CNPJ inválido.");
    }
}

// Método para obter o CPF do cliente
public String getCpfCliente() {
    return cpfCliente;
}

// Método para definir o CPF do cliente com validação
public void setCpfCliente(String cpfCliente) {
    if (ValidadorCpfCnpj.validarCPF(cpfCliente)) {
        this.cpfCliente = cpfCliente;
    } else {
        throw new IllegalArgumentException("CPF inválido.");
    }
}

// Método para obter o valor da transação
public double getValor() {
    return valor;
}

// Método para definir o valor da transação
public void setValor(double valor) {
    this.valor = valor;
}
}
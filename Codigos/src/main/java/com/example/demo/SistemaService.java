package com.example.demo;

import org.springframework.stereotype.Service;

// Serviço do sistema
@Service
public class SistemaService {
    private EmpresaService empresaService;

    // Construtor do serviço do sistema

    public SistemaService(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    // Método para realizar uma transação
    public void realizarTransacao(String cnpjEmpresa, String cpfCliente, double valor) {
        // Verifica se o CPF do cliente é válido
        if (!ValidadorCpfCnpj.validarCPF(cpfCliente)) {
            System.out.println("Erro: CPF do cliente inválido.");
            return;
        }
    
        // Verifica se o CNPJ da empresa é válido
        if (!ValidadorCpfCnpj.validarCNPJ(cnpjEmpresa)) {
            System.out.println("Erro: CNPJ da empresa inválido.");
            return;
        }
    
        Empresa empresa = buscarEmpresaPorCnpj(cnpjEmpresa);
        Cliente cliente = buscarClientePorCpf(cpfCliente);
        if (empresa != null && cliente != null) {
            try {
                empresa.sacar(valor, cliente); // Passa o cliente como argumento
                // Enviar callback para a empresa
                enviarCallback(empresa, "Transação realizada com sucesso");
                // Enviar notificação para o cliente (simulado)
                enviarNotificacao(cliente, "Sua transação foi realizada com sucesso");
            } catch (IllegalArgumentException e) {
                // Enviar callback para a empresa com erro
                System.out.println("Erro ao realizar transação: " + e.getMessage());
            }
        } else {
            // Empresa não encontrada ou cliente não encontrado
            System.out.println("Empresa ou cliente não encontrado.");
        }
    }
    // Método privado para buscar uma empresa pelo CNPJ
    private Empresa buscarEmpresaPorCnpj(String cnpj) {
        for (Empresa empresa : empresaService.getEmpresas()) {
            if (empresa.getCnpj().equals(cnpj)) {
                return empresa;
            }
        }
        return null;
    }

    // Método privado para buscar um cliente pelo CPF
    private Cliente buscarClientePorCpf(String cpf) {
        return new Cliente("Fulano", cpf);
    }

    // Método privado para enviar callback para a empresa
    private void enviarCallback(Empresa empresa, String mensagem) {
        System.out.println("Callback enviado para empresa " + empresa.getNome() + ": " + mensagem);
    }

    // Método privado para enviar notificação para o cliente
private void enviarNotificacao(Cliente cliente, String mensagem) {
    System.out.println("Notificação enviada para cliente " + cliente.getNome() + ": " + mensagem);
    }
}
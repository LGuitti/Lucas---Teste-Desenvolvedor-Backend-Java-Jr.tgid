package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

// Serviço de empresas
@Service
public class EmpresaService {
    private List<Empresa> empresas;

    // Construtor do serviço de empresas
    public EmpresaService(List<Empresa> empresas) {
        this.empresas = empresas;
    }

    // Método para adicionar uma empresa à lista de empresas
    public void adicionarEmpresa(Empresa empresa) {
        empresas.add(empresa);
    }

    // Método para obter a lista de empresas
    public List<Empresa> getEmpresas() {
        return empresas;
    }

    // Métodos para adicionar e remover clientes das empresas
    public void adicionarClienteEmpresa(Empresa empresa, Cliente cliente) {
        empresa.adicionarCliente(cliente);
    }

    public void removerClienteEmpresa(Empresa empresa, Cliente cliente) {
        empresa.removerCliente(cliente);
    }
}

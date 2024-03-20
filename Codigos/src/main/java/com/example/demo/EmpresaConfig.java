package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Classe de configuração das empresas
@Configuration
public class EmpresaConfig {

    // Método para criar o serviço de empresa com empresas pré-definidas
    @Bean
    public EmpresaService empresaService() {
        List<Empresa> empresas = new ArrayList<>();
        empresas.add(criarEmpresa("Empresa A", "61029211000141"));
        empresas.add(criarEmpresa("Empresa B", "83349471000137"));
        return new EmpresaService(empresas);
    }

    // Método privado para criar uma empresa
    private Empresa criarEmpresa(String nome, String cnpj) {
        Empresa empresa = new Empresa();
        empresa.setNome(nome);
        empresa.setCnpj(cnpj);
        return empresa;
    }
}
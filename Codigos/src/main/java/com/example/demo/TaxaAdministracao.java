package com.example.demo;

import org.springframework.stereotype.Component;

// Implementação da Taxa de Administração
@Component
public class TaxaAdministracao implements Taxa {
@Override
public double calcularTaxa() {
// Lógica para calcular a taxa de administração
return 0.05; // Exemplo: 5%
}
}
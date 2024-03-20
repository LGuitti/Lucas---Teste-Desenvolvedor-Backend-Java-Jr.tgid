package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// Controlador para transações
@RestController
public class TransacaoController {
    private SistemaService sistemaService;

// Construtor do controlador de transações

public TransacaoController(SistemaService sistemaService) {
    this.sistemaService = sistemaService;
}

// Endpoint para realizar transações
@PostMapping("/transacao")
public void realizarTransacao(@RequestBody TransacaoRequest transacaoRequest) {
    sistemaService.realizarTransacao(transacaoRequest.getCnpjEmpresa(), transacaoRequest.getCpfCliente(), transacaoRequest.getValor());
}
}
package com.example.demo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TestTGIDTest {

    @Test
    public void testeValidadorCPF() {
        assertTrue(ValidadorCpfCnpj.validarCPF("12345678909"));
        assertFalse(ValidadorCpfCnpj.validarCPF("12345678901"));
    }

    @Test
    public void testeValidadorCNPJ() {
        assertTrue(ValidadorCpfCnpj.validarCNPJ("08122674000173"));
        assertFalse(ValidadorCpfCnpj.validarCNPJ("08122674000170"));
    }

    @Test
    public void testeDepositoESaque() {
        Empresa empresa = new Empresa();
        empresa.setNome("Minha Empresa");
        empresa.setCnpj("12345678901234");
        Cliente cliente = new Cliente("Fulano", "12345678909");
        empresa.depositar(1000, cliente);
        assertEquals(1000, empresa.getSaldo(), 0);
        empresa.sacar(500, cliente);
        assertEquals(500, empresa.getSaldo(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testeSaldoInsuficiente() {
        Empresa empresa = new Empresa();
        empresa.setNome("Minha Empresa");
        empresa.setCnpj("12345678901234");
        Cliente cliente = new Cliente("Fulano", "12345678909");
        empresa.sacar(1000, cliente);
    }

    @Test
    public void testeRealizarTransacao() {
        Empresa empresa = new Empresa();
        empresa.setNome("Minha Empresa");
        empresa.setCnpj("12345678901234");
        empresa.depositar(1000, new Cliente("Fulano", "12345678909"));
        SistemaService sistemaService = new SistemaService(new EmpresaService(List.of(empresa)));
        sistemaService.realizarTransacao("12345678901234", "12345678909", 500);
        assertEquals(495, empresa.getSaldo(), 0);
    }
}


package com.example.demo;

// Classe responsável pela validação de CPF e CNPJ
public class ValidadorCpfCnpj {

    // Método para validar CPF
public static boolean validarCPF(String cpf) {
    cpf = cpf.replaceAll("[^0-9]", "");

    if (cpf.length() != 11) {
        return false;
    }

    boolean digitosIguais = true;
    for (int i = 1; i < cpf.length(); i++) {
        if (cpf.charAt(i) != cpf.charAt(i - 1)) {
            digitosIguais = false;
            break;
        }
    }
    if (digitosIguais) {
        return false;
    }

    int soma = 0;
    for (int i = 0; i < 9; i++) {
        soma += (cpf.charAt(i) - '0') * (10 - i);
    }
    int digito1 = 11 - (soma % 11);
    if (digito1 > 9) {
        digito1 = 0;
    }

    soma = 0;
    for (int i = 0; i < 10; i++) {
        soma += (cpf.charAt(i) - '0') * (11 - i);
    }
    int digito2 = 11 - (soma % 11);
    if (digito2 > 9) {
        digito2 = 0;
    }

    return (digito1 == cpf.charAt(9) - '0') && (digito2 == cpf.charAt(10) - '0');
}

// Método para validar CNPJ
public static boolean validarCNPJ(String cnpj) {
    cnpj = cnpj.replaceAll("[^0-9]", "");

    if (cnpj.length() != 14) {
        return false;
    }

    boolean digitosIguais = true;
    for (int i = 1; i < cnpj.length(); i++) {
        if (cnpj.charAt(i) != cnpj.charAt(i - 1)) {
            digitosIguais = false;
            break;
        }
    }
    if (digitosIguais) {
        return false;
    }

    int soma = 0;
    int peso = 2;
    for (int i = 11; i >= 0; i--) {
        soma += (cnpj.charAt(i) - '0') * peso;
        peso++;
        if (peso == 10) {
            peso = 2;
        }
    }
    int digito1 = soma % 11;
    if (digito1 < 2) {
        digito1 = 0;
    } else {
        digito1 = 11 - digito1;
    }

    soma = 0;
    peso = 2;
    for (int i = 12; i >= 0; i--) {
        soma += (cnpj.charAt(i) - '0') * peso;
        peso++;
        if (peso == 10) {
            peso = 2;
        }
    }
    int digito2 = soma % 11;
    if (digito2 < 2) {
        digito2 = 0;
    } else {
        digito2 = 11 - digito2;
    }

    return (digito1 == cnpj.charAt(12) - '0') && (digito2 == cnpj.charAt(13) - '0');
}
}
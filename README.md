# Lucas Guitti Bonando - Teste Desenvolvedor Backend Java Jr.

## Descrição do Projeto

Este projeto consiste em um sistema de transações financeiras entre empresas e clientes, implementado em Java utilizando Spring Boot. O sistema permite que empresas realizem transações como depósitos e saques, aplicando taxas de administração definidas. Além disso, clientes podem interagir com as empresas para realizar transações.

## Objetivos

- Implementar um sistema com dois tipos de usuários: Empresa e Cliente.
- Validar CPF para clientes e CNPJ para empresas.
- Aplicar taxas de sistema sobre transações.
- Manter o saldo das empresas com o abatimento das taxas de administração.
- Permitir que clientes realizem depósitos e saques nas empresas.
- Enviar callbacks para as empresas informando as transações e notificações para os clientes.

## Pontos Principais

- Lógica para regras de negócio: Implementada a lógica para realizar transações, validar CPFs e CNPJs, aplicar taxas e atualizar saldos das empresas.
- Modelagem de dados: Utilização de classes Cliente, Empresa e Taxa para modelar os dados do sistema.
- Clean Code: Código bem estruturado, legível e seguindo boas práticas de programação.
- Manutenibilidade de código: Utilização de padrões de projeto e boas práticas que facilitam a manutenção do código.
- Tratamento de erros: Tratamento adequado de exceções em diferentes cenários do sistema.
- Desacoplamento de componentes: Componentes do sistema estão desacoplados e seguem princípios de coesão.

## Como Executar

1. Clone o repositório: `git clone https://github.com/seuusuario/nome-do-repositorio.git`
2. Navegue até o diretório do projeto: `cd nome-do-repositorio`
3. Execute o projeto utilizando o Spring Boot: `./mvnw spring-boot:run`

## Testes com Postman

Os testes foram realizados utilizando o Postman, uma plataforma amplamente utilizada para testes de APIs. Foram criadas coleções de requisições para validar os endpoints do sistema, incluindo casos de sucesso e casos de erro.

As coleções de testes foram configuradas para simular diferentes cenários, como transações bem-sucedidas, transações com saldos insuficientes, validação de CPFs e CNPJs, entre outros. Foram incluídos também testes para verificar se as callbacks foram enviadas corretamente para as empresas e se as notificações foram enviadas aos clientes.

## Contato

Lucas Guitti Bonando  
E-mail: lucasbonando@example.com  
LinkedIn: [linkedin.com/in/lucasbonando](https://www.linkedin.com/in/lucasbonando)

Se houver alguma dúvida ou sugestão, sinta-se à vontade para entrar em contato. Estou disponível para discussões e colaborações.


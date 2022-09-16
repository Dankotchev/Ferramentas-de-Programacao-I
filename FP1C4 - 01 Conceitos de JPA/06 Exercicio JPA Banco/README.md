# Exercício: JPA - Livraria

## Objetivo:

Faça um projeto para uma livraria que precisa manter seus Clientes e Funcionário, bem como os livros de seu catálogo a venda.

Também é necessário manter todas as compras dos clientes.

Os Livros são consultados por código único, por isbn, por correspondência exata de nome do autor e por partes de seu título.

Deve ser possível consultar todas as vendas de um determinado cliente.

## Estratégias utilizadas:

- Uso de herança para as classes de Cliente e Funcionários vindo da classe Pessoa
  - Utilizando a estratégia de _Table per Class_
- O relacionamento entre Venda e Livro usou da classe ItemVenda  que necessitou de uma chave primária composta, vindo dos relacionamentos _One to Many_
  - Uso da estratégia de classe _@Embeddable_ para gerar a chave primária composta da Classe ItemVenda
- Relacionamento de _One to Many_ entre Cliente e Venda
- _Named Queries_ gerando consultas para a Classe Livro 


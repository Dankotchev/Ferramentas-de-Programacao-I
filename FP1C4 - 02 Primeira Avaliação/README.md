# Avaliação Prática I

### Enunciado

Uma locadora de veículos possui três tipos de veículos disponíveis para locação: carro, moto e van. Considere que:

- Os veículos possuem pelo menos estas informações: o número da placa, a cidade, o modelo e o ano de fabricação.
- O valor da diária de locação é de acordo com os tipos de veículos.
- Podem existir veículos com a mesma placa em cidades diferentes.
- Um cliente pode locar um ou mais veículos de uma única vez e com período de locação diferente.
- Um veículo não pode ser locado para mais de um cliente ao mesmo tempo.

**Crie um projeto em java, utilizando os conceitos abordados na disciplina, que:**

- Gere o banco de dados.
- Contenha métodos para as seguintes ações:
    - Inserir 2 instâncias para cada tipo de veículo e implementar a validação, via software, para não inserir instâncias com o mesmo identificador.
    - Realizar a locação de veículos e apresentar o valor total da locação.
    - Exibir os veículos que estão disponíveis para locação.
    - Realizar a devolução dos veículos. Os veículos podem ser devolvidos em datas diferentes mesmo que tenham sido locados juntos. Apresentar o valor a ser pago, caso o veículo tenha sido devolvido com atraso. Caso deseje, o número da locação pode ser informado para facilitar a localização da locação.

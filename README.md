# Gerenciamento de Funcionários

Este é um projeto em Java para gerenciamento de funcionários, incluindo funcionalidades como aumento de salário, agrupamento por função e cálculo de quantos salários mínimos cada funcionário recebe.

## Funcionalidades

- Cadastro de funcionários com nome, data de nascimento, salário e função.
- Remoção de um funcionário específico.
- Aumento de 10% nos salários de todos os funcionários.
- Agrupamento dos funcionários por função.
- Listagem de aniversariantes de outubro e dezembro.
- Identificação do funcionário mais velho.
- Ordenação alfabética dos funcionários.
- Cálculo do total de salários pagos pela empresa.
- Cálculo de quantos salários mínimos cada funcionário recebe (com arredondamento para baixo e indicando "cerca de").

## Tecnologias Utilizadas

- OpenJDK 21
- API de datas `java.time`
- `BigDecimal` para cálculos financeiros
- `ArrayList` e `Streams` para manipulação de dados

## Como Executar o Projeto

1. Clone este repositório:
   ```sh
   git clone https://github.com/PHziinn/Teste-Pratico-Iniflex.git
   ```
2. Navegue até a pasta do projeto:
   ```sh
   cd Teste-Pratico-Iniflex
   ```
3. Compile o código:
   ```sh
   javac Principal.java
   ```
4. Execute o programa:
   ```sh
   java Principal
   ```

## Exemplo de Saída

```
Funcionários que receberam 10% de aumento.

Operador
Nome: Maria, Data Nasc: 18/10/2000, Salário: 2.210,38, Função: Operador
Nome: Heitor, Data Nasc: 19/11/1999, Salário: 1.740,99, Função: Operador

Eletricista
Nome: Heloísa, Data Nasc: 24/05/2003, Salário: 1.767,54, Função: Eletricista


Aniversariantes de Outubro e Dezembro:
Nome: Maria, Data Nasc: 18/10/2000, Salário: 2.210,38, Função: Operador
Nome: Miguel, Data Nasc: 14/10/1988, Salário: 21.031,87, Função: Diretor


Funcionário mais velho: Caio, Idade: 64 anos

Todos os funcionários em ordem alfabética:
Nome: Alice, Data Nasc: 05/01/1995, Salário: 2.458,15, Função: Recepcionista
Nome: Arthur, Data Nasc: 31/03/1993, Salário: 4.479,02, Função: Contador
Nome: Caio, Data Nasc: 02/05/1961, Salário: 10.819,75, Função: Coordenador


Total dos salários dos funcionários: 56.789,12

Quantos Salários mínimo cada funcionario ganha:
Maria ganha cerca de 2 salários mínimos
```

## Author

- [Wesley Santos](https://github.com/PHziinn)

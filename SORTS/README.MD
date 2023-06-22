# Projeto de Comparação de Algoritmos de Ordenação

Este projeto tem como objetivo comparar o desempenho de diferentes algoritmos de ordenação em três tipos de arrays: ordenado, reverso e aleatório. Os algoritmos de ordenação testados são:

- Bubble Sort
- Insertion Sort
- Selection Sort
- Merge Sort
- Quick Sort
- Bucket Sort

## Como executar o projeto

1. Clone o repositório em sua máquina local.
2. Abra o projeto em sua IDE favorita (por exemplo, Eclipse ou IntelliJ).
3. Compile e execute a classe `Main`.

Ao executar o projeto, ele testará todos os algoritmos de ordenação em arrays de dois tamanhos diferentes (100.000 e 1.000.000) e exibirá o tempo gasto em milissegundos para cada algoritmo em cada tipo de array.

## Estrutura do projeto

O projeto consiste em uma classe principal `Main` que contém o ponto de entrada do programa (`main`), métodos auxiliares para criar diferentes tipos de arrays e testar os algoritmos de ordenação, e uma interface `Interface_Ordenada` que representa um algoritmo de ordenação genérico.

Cada algoritmo de ordenação deve ser implementado em sua própria classe e fornecer um método `sort` que aceita um array de inteiros e ordena-os. O método `sort` deve ser compatível com a interface `Interface_Ordenada`.

## Contribuindo

Se você deseja adicionar um novo algoritmo de ordenação ou melhorar os algoritmos existentes, sinta-se à vontade para criar um fork do projeto e enviar um pull request com suas alterações. Por favor, certifique-se de seguir a estrutura do projeto e fornecer testes adequados para suas alterações.

## Análise de Algoritmos de Ordenação

Este projeto apresenta uma análise de vários algoritmos de ordenação. A seguir, será explicado resumidamente como executar a análise.

### Execução

1. Certifique-se de ter o Python instalado em seu sistema.

2. Instale as bibliotecas necessárias executando o seguinte comando em seu terminal ou prompt de comando:

pip install pandas plotly

3. Abra um editor de código ou ambiente de desenvolvimento Python.

4. Crie um novo arquivo Python e importe as bibliotecas necessárias:


```python
import pandas as pd
import plotly.graph_objects as go 
```


5. Atualize os dados relacionados aos algoritmos de ordenação com as informações corretas, incluindo o número de comparações, o número de trocas e o tempo de execução.

6. Crie um DataFrame usando a biblioteca Pandas para organizar os dados:

```
data = {
    'Algoritmo': ['Bubble Sort', 'Insertion Sort', 'Selection Sort', 'Merge Sort', 'Quick Sort', 'Bucket Sort', 'Radix Sort'],
    'Total de Comparações': [0, 0, 0, 0, 0, 0, 0],
    'Total de Trocas': [0, 0, 0, 0, 0, 0, 0],
    'Tempo (ms)': [0, 0, 0, 0, 0, 0, 0]
}
df = pd.DataFrame(data)
```

7. Utilize a biblioteca Plotly para criar gráficos de pizza com base nos dados do DataFrame. Por exemplo, para criar um gráfico de pizza para o total de comparações:
```
fig1 = go.Figure(data=[go.Pie(labels=df['Algoritmo'], values=df['Total de Comparações'], textinfo='label+percent', hole=0.3)])
fig1.update_layout(title='Total de Comparações por Algoritmo')
fig1.show()
```

8. Repita o passo 7 para criar gráficos de pizza para o total de trocas e tempo de execução.

9. Execute o arquivo Python.

Ao seguir essas etapas, você poderá executar a análise dos algoritmos de ordenação e visualizar os gráficos de pizza que mostram o total de comparações, o total de trocas e o tempo de execução para cada algoritmo. Certifique-se de atualizar os dados com informações relevantes antes de executar o código.

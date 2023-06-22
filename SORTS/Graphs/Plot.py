import pandas as pd
import plotly.graph_objects as go

# Dados atualizados
data = {
    'Algoritmo': ['Bubble Sort', 'Insertion Sort', 'Selection Sort', 'Merge Sort', 'Quick Sort', 'Bucket Sort', 'Radix Sort'],
    'Total de Comparações': [0, 0, 0, 0, 0, 0, 0],
    'Total de Trocas': [0, 0, 0, 0, 0, 0, 0],
    'Tempo (ms)': [0, 0, 0, 0, 0, 0, 0]
}

# Criar DataFrame
df = pd.DataFrame(data)

# Gráfico de pizza - Total de Comparações
fig1 = go.Figure(data=[go.Pie(labels=df['Algoritmo'], values=df['Total de Comparações'], textinfo='label+percent', hole=0.3)])
fig1.update_layout(title='Total de Comparações por Algoritmo')
fig1.show()

# Gráfico de pizza - Total de Trocas
fig2 = go.Figure(data=[go.Pie(labels=df['Algoritmo'], values=df['Total de Trocas'], textinfo='label+percent', hole=0.3)])
fig2.update_layout(title='Total de Trocas por Algoritmo')
fig2.show()

# Gráfico de pizza - Tempo (ms)
fig3 = go.Figure(data=[go.Pie(labels=df['Algoritmo'], values=df['Tempo (ms)'], textinfo='label+percent', hole=0.3)])
fig3.update_layout(title='Tempo de Execução por Algoritmo')
fig3.show()

import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt

# Nome do algoritmo que queremos filtrar
algoritmo_especifico = "Dijkstra Lista"  # Certifique-se de usar o nome correto

# Lista para armazenar os dados com o nome do arquivo associado
boxplot_data = []

# Loop pelos arquivos (de arq1.csv até arq15.csv)
for i in range(1, 16):
    arquivo = f"arq{i}.csv"
    try:
        # Carrega o arquivo CSV
        df = pd.read_csv(arquivo, sep=",")  # Ajustado para separador de vírgula

        # Filtra as linhas do algoritmo específico
        valores = df.loc[df['Algoritmo utilizado'] == algoritmo_especifico, df.columns[1:]]  # Seleciona todas as colunas de teste
        
        # Verifica se o algoritmo existe no arquivo
        if not valores.empty:
            # Adiciona os valores ao boxplot_data, associando ao arquivo
            for valor in valores.values.flatten():
                boxplot_data.append({'Arquivo': f'arq{i}', 'Valores': valor})
    except Exception as e:
        print(f"Erro ao processar {arquivo}: {e}")

# Verifica se há dados suficientes para o box plot
if boxplot_data:
    # Criar um DataFrame com os dados coletados
    boxplot_df = pd.DataFrame(boxplot_data)

    # Plotar o box plot
    plt.figure(figsize=(16, 8))  # Ajuste do tamanho do gráfico
    sns.boxplot(data=boxplot_df, x="Arquivo", y="Valores")
    plt.title(f"Box Plot por Arquivo para o Algoritmo: {algoritmo_especifico}")
    #plt.yscale("log")
    plt.ylabel("Valores")
    plt.xlabel("Arquivos")
    plt.xticks(rotation=45)  # Rotação das etiquetas no eixo X
    #nomes_personalizados = [f"Grafo {i}" for i in range(1, 16)]  # Renomeando arq1 para Grafo 1, arq2 para Grafo 2, etc.
    #plt.xticks(ticks=range(15), labels=nomes_personalizados, rotation=45)

    plt.tight_layout()
    plt.show()
else:
    print("Nenhum dado encontrado para o algoritmo especificado.")

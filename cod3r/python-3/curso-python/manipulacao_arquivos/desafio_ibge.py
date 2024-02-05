#!python
import csv

with open('desafio-ibge.csv', encoding='ISO-8859-1') as dados_ibge:
    linhas = list(csv.reader(dados_ibge))

    with open('saida_desafio_ibge.txt', 'w') as saida:
        for linha in linhas[1:]:
            print('{}, {}'.format(linha[8], linha[3]), file=saida)

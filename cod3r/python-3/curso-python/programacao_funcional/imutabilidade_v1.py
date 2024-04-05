#!python
from locale import setlocale, LC_ALL
from calendar import mdays, month_name
from functools import reduce

# Português do Brasil
setlocale(LC_ALL, 'pt_BR')  # Listar todos os meses do ano com 31 dias

# Listar todos os meses do ano com 31 dias

# 1. (filter) pegar os índice de todos os meses com 31 dias
meses_31 = filter(lambda mes: mdays[mes] == 31, range(1, 13))

# 2. (map) transformar os índices em nome
meses_nomes = map(lambda i: month_name[i], meses_31)

# 3. (reduce) juntar tudo para imprimir
juntar_meses = reduce(lambda frase, mes: frase +
                      '\n' + f'- {mes}', meses_nomes,
                      'Mêses com 31 dias:')

print(juntar_meses)

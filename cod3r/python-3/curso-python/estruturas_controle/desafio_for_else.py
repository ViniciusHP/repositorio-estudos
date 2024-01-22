# Função sortear_dado deve retornar números entre 1 e 6
# For com range 1 a 6 (incluindo o 6)
# Se for ímpar -> continue
# Se o número for par e for igual ao valor sorteado
# pela função dado imprimir 'ACERTOU' e depois chamar o break
# Se não acertar chamar o else imprime 'Não acertou o número!'
from random import randint


def sortear_dado():
    return randint(1, 6)


for numero in range(1, 7):
    if numero % 2 == 1:
        continue

    if numero == sortear_dado():
        print('ACERTOU', numero)
        break  # Não executa o else
else:
    print('Não acertou o número')

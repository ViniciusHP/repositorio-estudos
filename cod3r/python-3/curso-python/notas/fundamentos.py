# Primeiros exemplos

print('Primeiro programa')

1 + 2

# Identação importa

1 \
    + 2

print(1
      + 2)

# Tipos básicos

# boolean
print(True)
print(False)

# float
print(1.2 + 1)

# int
print(1)

# string
print('Aqui eu falo a minha língua!')
print("Tbm funciona")

# Multiplicação de textos
print('Você é ' + 3 * 'muito ' + 'legal!')

# Problema de TypeError
# print(3 + '3') -> Ambiguidade

# Lista
print([1, 2, 3])

# Dicionário
print({'nome': 'Pedro', 'idade': 22})

# Equivalente ao null ou undefined (ausência de valor)
print(None)

# Variáveis

# Atribuição
a = 10
b = 5.2

print(a + b)

a = 'Agora sou uma string!'
print(a)

# Comentários

# Minhas variáveis
salario = 3460.45
despesas = 2456.2

"""
A ideia é calcular o quanto
vai sobrar no final do mês!
"""
print(salario - despesas)

print('Fim')

'''
Comentário de multiplas linhas
'''

# Operadores Aritméticos

print(2 + 3)
print(4 - 7)
print(2 * 5.3)
print(9.4 / 3)

# Divisão com resultado inteiro
print(9.4 // 3)

# Exponenciação
print(2 ** 8)

# Módulo
print(10 % 3)

# Operadores Relacionais

3 > 4
4 >= 3
1 < 2
3 <= 1
3 != 2
3 == 3
2 == '2'

# Operadores de Atribuição

a = 3
a = a + 7
print(a)

# Forma reduzida de a = a + 5
a += 5
print(a)

a -= 3
print(a)

a *= 2
print(a)

a /= 4
print(a)

a %= 4
print(a)

a **= 8
print(a)

a //= 127
print(a)

# Operadores Lógicos

True or False
7 != 3 and 2 > 3

# Tabela verdade do AND
True and True
True and False
False and True
False and False

# Tabela verdade do OR
True or True
True or False
False or True
False or False

# Tabela verdade do XOR
True != True
True != False
False != True
False != False

# Operador de Negação (unário)
not True
not False

# Operadores bit-a-bit
True & False
False | True
True ^ False

# AND Bit-a-bit
# 3 = 11
# 2 = 10
# _ = 1 0
3 & 2

# OR Bit-a-bit
# 3 = 11
# 2 = 10
# _ = 11
3 | 2

# XOR Bit-a-bit
# 3 = 11
# 2 = 10
# _ = 01
3 ^ 2

# Um pouco de realidade
saldo = 1000
salario = 4000
despesas = 2967

saldo_positivo = saldo > 0
despesas_controladas = salario - despesas >= 0.2 * salario

meta = saldo_positivo and despesas_controladas
print(meta)

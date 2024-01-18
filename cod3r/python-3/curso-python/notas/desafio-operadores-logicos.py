# Desafio Operadores Lógicos

# Os Trabalhos
trabalho_terca = True
trabalho_quinta = False

"""
- Confirmando os 2: TV 50' + Sorvete
- Confirmando apenas 1: TV 32' + Sorvete
- Nenhum confirmado: Fica em casa
"""

comprar_tv_50 = trabalho_terca and trabalho_quinta
comprar_tv_32 = trabalho_terca != trabalho_quinta
tomar_sorvete = trabalho_terca or trabalho_quinta
mais_saudavel = not tomar_sorvete

print('Tv50={} Tv32={} Sorvete={} Saudável={}'
      .format(comprar_tv_50, comprar_tv_32, tomar_sorvete, mais_saudavel))

# Interpolação com índice
# "{1}, {2} = {0}".format(1, False, 'resultado')

# Operadores unários
a = 3

# a++ (não existe esta sintaxe no python)
a += 1

# a-- (não existe esta sintaxe no python)
a -= 1

# Tornar valor negativo
-a

# Não muda o sinal do valor
+a

not 0
not 1
not -2
not False
not not True

# Operadores Ternários

esta_chovendo = False

print('Hoje estou com as roupas ' + ('secas.', 'molhadas.')[esta_chovendo])
print('Hoje estou com as roupas ' + ('molhadas.'
                                     if esta_chovendo else 'secas.'))

# Mais Operadores

# Operador de Membro
lista = [1, 2, 3, 'Ana', 'Carla']
print(2 in lista)
print('Ana' not in lista)

# Operador de Identidade
x = 3
y = x
z = 3
print(x is y)
print(y is z)
print(x is not z)

lista_a = [1, 2, 3]
lista_b = lista_a
lista_c = [1, 2, 3]

print(lista_a is lista_b)
print(lista_b is lista_c)
print(lista_a is not lista_c)

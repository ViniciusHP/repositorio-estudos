# Tupla (Não pode ser modificada)
tupla = tuple()
# ou
tupla = ()

print(type(tupla))

# tipo str
tupla = ('um')
print(type(tupla))

# tipo tupla
tupla = ("um",)
print(type(tupla))

print(tupla[0])

# É imutável
# tupla[0] = 'novo'

cores = ('verde', 'amarelo', 'azul', 'azul', 'azul', 'branco')

print(cores[0])
print(cores[-1])
print(cores[1:])

print(cores.index('amarelo'))
print(cores.count('azul'))

print(len(cores))

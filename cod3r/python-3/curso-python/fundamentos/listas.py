# Lista
lista = []

print(type(lista))
print(len(lista))

lista.append(1)
lista.append(5)
print(lista)

nova_lista = [1, 5, 'Ana', 'Bia']
print(nova_lista)

nova_lista.remove(5)
print(nova_lista)

nova_lista.reverse()
print(nova_lista)

lista = [1, 5, 'Rebeca', 'Guilherme', 3.1415]

# Por índice
print(lista.index('Guilherme'))
# print(lista.index(42))
print(lista[2])
print(lista[0])
print(lista[4])
# print(lista[5])
print(lista[-1])
print(lista[-5])

print(1 in lista)
print('Rebeca' in lista)
print('Pedro' not in lista)

lista = ['Ana', 'Lia', 'Rui', 'Paulo', 'Dani']
print(lista[1: 3])
print(lista[1:-1])
print(lista[1:])
print(lista[:-1])
print(lista[:])
print(lista[::2])
print(lista[::-1])

del lista[2]
print(lista)

del lista[1:]
print(lista)

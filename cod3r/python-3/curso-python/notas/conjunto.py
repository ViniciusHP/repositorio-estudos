# Conjunto
a = {1, 2, 3}
print(type(a))
# a[0]

# Sem repetição de elementos
a = set('codddddddddd3r')
print(a)

print('3' in a, 4 not in a)

print({1, 2, 3} == {3, 2, 1, 3})

# operações
c1 = {1, 2}
c2 = {2, 3}
print(c1.union(c2))
print(c1.intersection(c2))

c1.update(c2)
print(c1)

# c2 é subconjunto de c1
print(c2 <= c1)

# c1 contém de c2
print(c1 >= c2)

# Removendo elementos
print({1, 2, 3} - {2})
print(c1 - c2)

c1 -= {2}
print(c1)

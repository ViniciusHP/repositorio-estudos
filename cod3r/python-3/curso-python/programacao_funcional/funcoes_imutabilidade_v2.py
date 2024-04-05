#!python
from functools import reduce
from operator import add

valores = (30, 10, 25, 70, 100, 94)


# Mutável
# valores.sort()
# print(valores)

print(sorted(valores))
print(min(valores))
print(max(valores))
print(sum(valores))
print(reduce(add, valores))
print(tuple(reversed(valores)))
print(valores)

from string import Template

nome, idade = 'Ana', 30

# mais antiga
print('Nome: %s Idade: %d %r %r' % (nome, idade, True, False))

# Python < 3.6
print('Nome: {0} Idade: {1}'.format(nome, idade))

# Python >= 3.6
print(f'Nome: {nome} Idade: {idade} {2 ** 8 + 1}')

s = Template('Nome: $n Idade: $idade')
print(s.substitute(n=nome, idade=idade))

# Dicionário
nomeChave = 'chave'

pessoa = {'nome': 'Prof(a). Ana', 'idade': 38, nomeChave: 38, 'cursos': [
    'Inglês', 'Português']}
print(type(pessoa))
print(len(pessoa))
print(pessoa['nome'])
print(pessoa['cursos'][1])
# print(pessoa['tags'])

print(pessoa.keys())
print(pessoa.values())
print(pessoa.items())

print(pessoa.get('cursos'))
print(pessoa.get('tags'))
print(pessoa.get('tags', []))

pessoa['idade'] = 44
pessoa['cursos'].append('Angular')
print(pessoa.pop('idade'))
print(pessoa)
pessoa.update({'idade': 40, 'Sexo': 'M'})

del pessoa['cursos']
print(pessoa)

pessoa.clear()
print(pessoa)

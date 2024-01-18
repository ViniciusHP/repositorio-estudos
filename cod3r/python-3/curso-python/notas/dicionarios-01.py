# Dicionário
nomeChave = 'chave'

pessoa = {'nome': 'Prof(a). Ana', nomeChave: 38, 'cursos': [
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

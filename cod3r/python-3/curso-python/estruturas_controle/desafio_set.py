PALAVRAS_PROIBIDAS = {'futebol', 'religião', 'política'}
textos = [
    'João gosta de futebol e política',
    'A praia foi divertida'
]

for texto in textos:
    palavras = set(texto.lower().split())
    intersecao = PALAVRAS_PROIBIDAS.intersection(palavras)

    if intersecao:
        print('Texto possui palavras proibidas:', intersecao)
    else:
        print('Texto autorizado:', texto)

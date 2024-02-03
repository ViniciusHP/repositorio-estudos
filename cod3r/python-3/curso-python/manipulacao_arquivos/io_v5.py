#!python
# o with abre um recurso e libera o recurso quando é finalizado
with open('pessoas.csv') as arquivo:
    # stream
    for registro in arquivo:
        print('Nome: {}, Idade: {}'.format(*registro.strip().split(',')))


if arquivo.closed:
    print('Arquivo já foi fechado!')

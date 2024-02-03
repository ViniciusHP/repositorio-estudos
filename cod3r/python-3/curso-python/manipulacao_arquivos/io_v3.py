#!python
arquivo = open('pessoas.csv')

# stream
for registro in arquivo:
    print('Nome: {}, Idade: {}'.format(*registro.strip().split(',')))

arquivo.close()

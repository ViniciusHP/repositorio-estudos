#!python
try:
    arquivo = open('pessoas.csv')
    # stream
    for registro in arquivo:
        print('Nome: {}, Idade: {}'.format(*registro.strip().split(',')))
except IndexError:
    # 'pass' - palavra reservada que é usada em um bloco que não tem instruções
    # não fem efeito algum
    pass
finally:
    arquivo.close()

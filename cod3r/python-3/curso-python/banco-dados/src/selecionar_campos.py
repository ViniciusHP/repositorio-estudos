from bd import nova_conexao
from mysql.connector import ProgrammingError

sql = 'SELECT nome, tel FROM contatos'

try:
    with nova_conexao() as conexao:
        try:
            cursor = conexao.cursor()
            cursor.execute(sql)
            contatos = cursor.fetchall()
        except ProgrammingError as e:
            print(f'Erro: {e.msg}')
        else:
            for contato in contatos:
                print('\t'.join(str(campo) for campo in contato))
except ProgrammingError as e:
    print(f'Erro CONEXÃO: {e.msg}')

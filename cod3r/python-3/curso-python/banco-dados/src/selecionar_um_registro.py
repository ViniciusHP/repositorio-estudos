from bd import nova_conexao
from mysql.connector import ProgrammingError

sql = 'SELECT nome, tel FROM contatos'

try:
    with nova_conexao() as conexao:
        try:
            cursor = conexao.cursor()
            cursor.execute(sql)
            print(cursor.fetchone())
            print(cursor.fetchone())
            print(cursor.fetchone())
            print(cursor.fetchone())
        except ProgrammingError as e:
            print(f'Erro: {e.msg}')
except ProgrammingError as e:
    print(f'Erro CONEXÃO: {e.msg}')

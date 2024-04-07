from bd import nova_conexao
from mysql.connector import ProgrammingError

comando_exclusao = 'DROP TABLE emails'

try:
    with nova_conexao() as conexao:
        try:
            cursor = conexao.cursor()
            cursor.execute(comando_exclusao)
        except ProgrammingError as e:
            print(f'Erro: {e.msg}')
except ProgrammingError as e:
    print(f'Erro CONEXÃO: {e.msg}')

from bd import nova_conexao
from mysql.connector import ProgrammingError

sql = 'SELECT nome, id FROM contatos ORDER BY nome DESC'

try:
    with nova_conexao() as conexao:
        try:
            cursor = conexao.cursor()
            cursor.execute(sql)

            print('\n'.join(str(registro) for registro in cursor))
        except ProgrammingError as e:
            print(f'Erro: {e.msg}')
except ProgrammingError as e:
    print(f'Erro CONEXÃO: {e.msg}')

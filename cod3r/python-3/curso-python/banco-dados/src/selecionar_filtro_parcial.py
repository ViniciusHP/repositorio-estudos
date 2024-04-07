from bd import nova_conexao
from mysql.connector import ProgrammingError

sql = "SELECT * FROM contatos WHERE nome like 'Lu%'"

try:
    with nova_conexao() as conexao:
        try:
            cursor = conexao.cursor()
            cursor.execute(sql)

            for x in cursor:
                print(x)
        except ProgrammingError as e:
            print(f'Erro: {e.msg}')
except ProgrammingError as e:
    print(f'Erro CONEXÃO: {e.msg}')

from bd import nova_conexao
from mysql.connector import ProgrammingError

sql = 'UPDATE contatos SET nome = %s WHERE id = %s'
args = ('Gabriela', 5)

try:
    with nova_conexao() as conexao:
        try:
            cursor = conexao.cursor()
            cursor.execute(sql, args)
            conexao.commit()
        except ProgrammingError as e:
            print(f'Erro: {e.msg}')
        else:
            print(f'{cursor.rowcount} registor(s) alterados(s).')
except ProgrammingError as e:
    print(f'Erro CONEXÃO: {e.msg}')

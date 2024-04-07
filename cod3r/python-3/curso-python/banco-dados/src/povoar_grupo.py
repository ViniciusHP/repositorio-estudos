from bd import nova_conexao
from mysql.connector import ProgrammingError

sql = "INSERT INTO grupos(descricao) VALUES (%s)"
args = (
    ('Casa',),
    ('Trabalho',),
    ('Família',),
    ('Amigos',)
)

try:
    with nova_conexao() as conexao:
        try:
            cursor = conexao.cursor()
            cursor.executemany(sql, args)
            conexao.commit()
        except ProgrammingError as e:
            print(f'Erro: {e.msg}')
        else:
            print(f'{cursor.rowcount} registro(s) inserido(s)')
except ProgrammingError as e:
    print(f'Erro CONEXÃO: {e.msg}')

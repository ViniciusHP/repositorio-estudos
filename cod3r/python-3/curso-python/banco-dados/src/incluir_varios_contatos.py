from bd import nova_conexao
from mysql.connector import ProgrammingError

sql = 'INSERT INTO contatos(nome, tel) VALUES (%s, %s)'
args = (
    ('Ana', '96765-4321'),
    ('Bia', '223123-4321'),
    ('Gabi', '23253-4321'),
    ('Luca', '12251-4321'),
    ('Lu', '54623-4321'),
    ('Gui', '32552-4321'),
    ('Helena', '23113-4321')
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
            print(f'Foram incluídos {cursor.rowcount} registros!')
except ProgrammingError as e:
    print(f'Erro CONEXÃO: {e.msg}')

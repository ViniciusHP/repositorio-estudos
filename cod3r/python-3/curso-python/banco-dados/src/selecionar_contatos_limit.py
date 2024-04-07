from bd import nova_conexao
from mysql.connector import ProgrammingError

sql = 'SELECT * FROM contatos LIMIT 5'

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
                print(f'{contato[2]:2d} - {contato[0]:10s} Telefone: {
                    contato[1]}')
except ProgrammingError as e:
    print(f'Erro CONEXÃO: {e.msg}')

from bd import nova_conexao
from mysql.connector import ProgrammingError

sql = "SELECT * FROM contatos WHERE nome like %s"

try:
    with nova_conexao() as conexao:
        try:
            nome = input('Contato a localizar: ')
            args = (f'%{nome}%', )
            cursor = conexao.cursor()
            cursor.execute(sql, args)

            for x in cursor:
                print(x)
        except ProgrammingError as e:
            print(f'Erro: {e.msg}')
except ProgrammingError as e:
    print(f'Erro CONEXÃO: {e.msg}')

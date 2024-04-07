from bd import nova_conexao
from mysql.connector import ProgrammingError

sql = """
    SELECT
        grupos.descricao AS grupo,
        contatos.nome AS nome
    FROM contatos
    INNER JOIN grupos ON contatos.grupo_id = grupos.id
    ORDER BY grupo, nome
"""

try:
    with nova_conexao() as conexao:
        try:
            cursor = conexao.cursor(dictionary=True)
            cursor.execute(sql)
            contatos = cursor.fetchall()
        except ProgrammingError as e:
            print(f'Erro: {e.msg}')
        else:
            for contato in contatos:
                print(f'{contato['grupo']}: {contato['nome']}')
except ProgrammingError as e:
    print(f'Erro CONEXÃO: {e.msg}')

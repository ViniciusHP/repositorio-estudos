# Desafio Operadores Lógicos

# Os Trabalhos
trabalho_terca = True
trabalho_quinta = False

"""
- Confirmando os 2: TV 50' + Sorvete
- Confirmando apenas 1: TV 32' + Sorvete
- Nenhum confirmado: Fica em casa
"""

comprar_tv_50 = trabalho_terca and trabalho_quinta
comprar_tv_32 = trabalho_terca != trabalho_quinta
tomar_sorvete = trabalho_terca or trabalho_quinta
mais_saudavel = not tomar_sorvete

print('Tv50={} Tv32={} Sorvete={} Saudável={}'
      .format(comprar_tv_50, comprar_tv_32, tomar_sorvete, mais_saudavel))

# Interpolação com índice
# "{1}, {2} = {0}".format(1, False, 'resultado')

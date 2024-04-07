#!python

try:
    from mysql import connector
except ModuleNotFoundError:
    print('MySQL Connector não intalado!')
else:
    print('MySQL Connector instalado e pronto!')

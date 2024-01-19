# Tipos strings
nome = 'Saulo Pedro'

print(nome[0])

# Não é possível alterar por índice
# nome[0] = 'P'

# 'marca d'água'
print("Dias D'Avila" == 'Dias D\'Avila')
texto = 'Texto entre apóstrofos pode ter "aspas"'
print("Teste \" funciona!")

doc = """Texto com múltiplas
...linhas"""
print(doc)
print("Texto com múltiplas\n...linhas")

doc2 = '''Também é possível
... com 3 as pas simples'''
print(doc2)

nome = 'Ana Paula'
print(nome[0])
print(nome[6])
print(nome[-3])
print(nome[4:])
print(nome[-5:])
print(nome[:3])
print(nome[2:5])

numeros = '1234567890'
print(numeros[::])
print(numeros[::2])
print(numeros[1::2])

print(numeros[::-1])
print(numeros[::-2])

frase = 'Python é uma linguagem excelente'
print('py' in frase)
print('ing' in frase)
print(len(frase))
print(frase.lower())
print(frase.upper())

frase = frase.upper()

print(frase.split())
print(frase.split('A'))

print(help(str.center))

a = '123'
b = ' de Olivreira 4'
print(a + b)
print(a.__add__(b))
print(str.__add__(a, b))

print('1' in a)
print(a.__contains__('1'))

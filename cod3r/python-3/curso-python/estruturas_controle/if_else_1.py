#!python
import sys
# Conceitos       Notas
# A               De 10,0 à 9,1
# A-              De 9,0 à 8,1
# B               De 8,0 à 7,1
# B-              De 7,0 à 6,1
# C               De 6,0 à 5,1
# C-              De 5,0 à 4,1
# D               De 4,0 à 3,1
# D-              De 3,0 à 2,1
# E               De 2,0 à 1,1
# E-              De 1,0 à 0,0

# *Para notas maiores que 10 e menores que 0 será impresso 'Nota inválida'


def nota_conceito(nota):
    print(type(nota))

    nota_numerica = float(nota)

    if nota_numerica > 10 or nota_numerica < 0:
        return 'Nota inválida'
    elif nota_numerica >= 9.1:
        return "A"
    elif nota_numerica >= 8.1:
        return "A-"
    elif nota_numerica >= 7.1:
        return "B"
    elif nota_numerica >= 6.1:
        return "B-"
    elif nota_numerica >= 5.1:
        return "C"
    elif nota_numerica >= 4.1:
        return "C-"
    elif nota_numerica >= 3.1:
        return "D"
    elif nota_numerica >= 2.1:
        return "D-"
    elif nota_numerica >= 1.1:
        return "E"
    elif nota_numerica >= 0:
        return "E-"
    else:
        return 'Nota inválida'


if __name__ == '__main__':
    nota = sys.argv[1]
    conceito = nota_conceito(nota)
    print('Para a nota {}, o conceito é {}'.format(nota, conceito))

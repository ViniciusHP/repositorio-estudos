#!python
from math import pi


def area(raio):
    return pi * float(raio) ** 2


if __name__ == '__main__':
    raio = input('Informe o raio: ')
    area_cirulo = area(raio)
    print('Área do círculo', area)

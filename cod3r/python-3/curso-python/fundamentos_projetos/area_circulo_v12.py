#!python
from math import pi
import sys


def area(raio):
    return pi * float(raio) ** 2


def help():
    print('É necessário informar o raio do círculo.')
    print('Sintaxe: {} <raio>'.format(sys.argv[0][2:]))


if __name__ == '__main__':
    if len(sys.argv) < 2:
        help()
    else:
        raio = sys.argv[1]
        area_cirulo = area(raio)
        print('Área do círculo', area_cirulo)

#!python
from math import pi
import sys


def area(raio):
    return pi * float(raio) ** 2


if __name__ == '__main__':
    raio = sys.argv[1]
    area_cirulo = area(raio)
    print('Área do círculo', area_cirulo)

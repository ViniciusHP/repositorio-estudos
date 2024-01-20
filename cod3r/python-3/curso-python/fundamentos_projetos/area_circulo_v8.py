#!python
from math import pi


def area(raio):
    area = pi * float(raio) ** 2
    print(f'Área do círculo: {area}')


if __name__ == '__main__':
    raio = input('Informe o raio: ')
    area(raio)

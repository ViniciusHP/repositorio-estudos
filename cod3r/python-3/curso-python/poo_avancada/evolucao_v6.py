#!python
from abc import ABCMeta, abstractmethod

# Método de instância
# Método estático
# Método de classe


class Humano(metaclass=ABCMeta):
    # atributo de classe
    especie = 'Homo Sapiens'

    def __init__(self, nome):
        self.nome = nome
        self._idade = None

    # @abstractproperty
    @property
    @abstractmethod
    def inteligente(self):
        pass

    @property
    def idade(self):
        return self._idade

    @idade.setter
    def idade(self, idade):
        if idade < 0:
            raise ValueError('Idade deve ser um número positivo!')
        self._idade = idade

    def das_cavernas(self):
        self.especie = 'Homo Neanderthalensis'
        return self

    @staticmethod
    def especies():
        adjetivos = ('Habilis', 'Erectus', 'Neanderthalensis', 'Sapiens')
        return ('Australopiteco', ) + tuple(f'Homo {adj}' for adj in adjetivos)

    @classmethod
    def is_evoluido(cls):
        # cls é a classe
        return cls.especie == cls.especies()[-1]


class Neanderthal(Humano):
    especie = Humano.especies()[-2]

    @property
    def inteligente(self):
        return False


class HomoSapies(Humano):
    especie = Humano.especies()[-1]

    @property
    def inteligente(self):
        return True


if __name__ == '__main__':
    try:
        anonimo = Humano('John Doe')
        print(anonimo.inteligente)
    except TypeError:
        print('Classe abstrata')

    jose = HomoSapies('José')
    print('{} da classe {}, inteligente: {}'
          .format(jose.nome, jose.__class__.__name__, jose.inteligente))
    grogn = Neanderthal('Grogn')
    print('{} da classe {}, inteligente: {}'
          .format(grogn.nome, grogn.__class__.__name__, grogn.inteligente))

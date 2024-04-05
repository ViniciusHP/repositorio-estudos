#!python

# Método de instância
# Método estático
# Método de classe

class Humano:
    # atributo de classe
    especie = 'Homo Sapiens'

    def __init__(self, nome):
        self.nome = nome

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


class HomoSapies(Humano):
    especie = Humano.especies()[-1]


if __name__ == '__main__':
    jose = HomoSapies('José')
    # Humano.das_cavernas(jose)
    grokn = Neanderthal('Grokn')

    print(f'Evolução (a partir da classe): {", ".join(HomoSapies.especies())}')
    print(f'Evolução (a partir da instância): {", ".join(jose.especies())}')
    print(f'Homo Sapiens evoluído? {HomoSapies.is_evoluido()}')
    print(f'Neanderthal evoluído? {Neanderthal.is_evoluido()}')
    print(f'José evoluído? {jose.is_evoluido()}')
    print(f'Grokn evoluído? {grokn.is_evoluido()}')

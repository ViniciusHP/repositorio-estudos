class Carro:
    def __init__(self, velocidade_maxima=200):
        self.velocidade_maxima = velocidade_maxima
        self.velocidade_atual = 0

    def acelerar(self, delta=5):
        nova_velocidade = self.velocidade_atual + delta
        self.velocidade_atual = nova_velocidade \
            if nova_velocidade <= self.velocidade_maxima \
            else self.velocidade_maxima
        return self.velocidade_atual

    def frear(self, delta=5):
        nova_velocidade = self.velocidade_atual - delta
        self.velocidade_atual = nova_velocidade if nova_velocidade >= 0 else 0
        return self.velocidade_atual


if __name__ == '__main__':
    c1 = Carro(180)

    for _ in range(25):
        print(c1.acelerar(8))

    for _ in range(10):
        print(c1.frear(delta=20))

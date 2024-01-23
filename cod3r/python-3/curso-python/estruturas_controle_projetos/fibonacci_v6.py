#!python
def fibonnacci(quantidade):
    resultado = [0, 1]
    while True:
        resultado.append(sum(resultado[-2:]))
        if len(resultado) == quantidade:
            break
    return resultado


if __name__ == '__main__':
    # Listar os 20 primeeiros números da sequência
    for fib in fibonnacci(20):
        print(fib)

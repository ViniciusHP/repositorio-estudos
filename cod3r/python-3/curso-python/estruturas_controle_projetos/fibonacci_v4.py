#!python
def fibonnacci(limite):
    resultado = [0, 1]
    while resultado[-1] < limite:
        resultado.append(resultado[-2] + resultado[-1])
    return resultado


if __name__ == '__main__':
    for fib in fibonnacci(10000):
        print(fib)

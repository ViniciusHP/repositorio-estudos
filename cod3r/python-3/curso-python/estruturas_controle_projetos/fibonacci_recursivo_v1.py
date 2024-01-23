#!python
def fibonnacci(quantidade, sequencia=(0, 1)):
    # Condição de parada
    if len(sequencia) == quantidade:
        return sequencia
    return fibonnacci(quantidade, sequencia + (sum(sequencia[-2:]),))


if __name__ == '__main__':
    # Listar os 20 primeiros números da sequência
    for fib in fibonnacci(20):
        print(fib)

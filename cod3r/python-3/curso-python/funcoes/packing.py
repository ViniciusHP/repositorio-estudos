def soma_2(a, b):
    return a+b


def soma_3(a, b, c):
    return a+b+c


def soma_n(*numeros):
    # packing
    soma = 0
    for n in numeros:
        soma += n
    return soma


if __name__ == '__main__':

    # packing
    print(soma_2(2, 3))
    print(soma_3(2, 4, 6))
    print(soma_n(1))
    print(soma_n(1, 1))
    print(soma_n(1, 1, 1, 1, 1, 1, 1))

    tupla_nums = (1, 2, 3)
    print(soma_3(*tupla_nums))  # unpacking

    lista_nums = [1, 2, 3]
    print(soma_3(*lista_nums))  # unpacking

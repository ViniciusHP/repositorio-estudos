#!python
def mdc(numeros):
    valor_min = 2
    valor_max = min(numeros) + 1
    divisores = range(valor_min, valor_max)
    valores_divisiveis = [1]

    for divisor in divisores:
        is_valores_divisiveis = list(
            map(lambda n: n % divisor == 0, numeros))
        if all(is_valores_divisiveis):
            valores_divisiveis.append(divisor)

    return max(valores_divisiveis)


if __name__ == '__main__':
    print(mdc([21, 7]))  # 7
    print(mdc([125, 40]))  # 5
    print(mdc([9, 564, 66, 3]))  # 7
    print(mdc([55, 22]))  # 11
    print(mdc([15, 150]))  # 15
    print(mdc([7, 9]))  # 1

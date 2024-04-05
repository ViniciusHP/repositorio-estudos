#!python

def fatorial(n):
    return 1 if n <= 1 else n * (fatorial(n - 1))


if __name__ == '__main__':
    print(f'10! = {fatorial(10)}')
    # 6 semanas em segundos é igual a 10!
    print(6 * 7 * 24 * 60 * 60)

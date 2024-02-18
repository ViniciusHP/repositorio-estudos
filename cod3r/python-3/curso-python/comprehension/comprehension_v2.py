# [ expressão for item in list if condicional ]
# se a condicional for false, o valor não será gerado
dobros_dos_pares = [i * 2 for i in range(10) if i % 2 == 0]
print(dobros_dos_pares)

# Vesão "normal"
dobros_dos_pares = []
for i in range(10):
    if i % 2 == 0:
        dobros_dos_pares.append(i * 2)

print(dobros_dos_pares)

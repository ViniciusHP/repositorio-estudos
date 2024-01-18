a = '123'
b = ' de Olivreira 4'
print(a + b)
print(a.__add__(b))
print(str.__add__(a, b))

print('1' in a)
print(a.__contains__('1'))

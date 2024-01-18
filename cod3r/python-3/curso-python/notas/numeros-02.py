# Importando do módulo "decimal"
from decimal import Decimal, getcontext

print(Decimal(1) / Decimal(7))

getcontext().prec = 4


print(Decimal(1) / Decimal(7))

print(Decimal.max(Decimal(1), Decimal(7)))

print(1.1 + 2.2)
print(Decimal(1.1) + Decimal(2.2))

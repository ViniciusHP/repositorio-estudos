# language: pt
Funcionalidade: Pronpondo lances ao leilão

Cenário: Propondo um único lance válido
 Dado um lance valido
 Quando propõe ao leilão
 Então o lance é aceito
 
Cenário: Propondo vários lances válidos
 Dado vários lances válidos
 Quando propõe vários lances ao leilão
 Então os lances são aceitos
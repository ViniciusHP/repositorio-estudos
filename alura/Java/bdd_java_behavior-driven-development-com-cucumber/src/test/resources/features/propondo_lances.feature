# language: pt
Funcionalidade: Pronpondo lances ao leilão

Cenário: Propondo um único lance válido
Dado um lance valido
Quando propõe ao leilão
Então o lance é aceito
 
Cenário: Propondo vários lances válidos
Dado um lance de 10.0 reais do usuário "fulano"
E um lance de 15.0 reais do usuário "beltrano"
Quando propõe vários lances ao leilão
Então os lances são aceitos
 
Esquema do Cenário: Propondo um lance inválido
Dado um lance de <valor> reais do usuário com nome <nomeUsuario>
Quando propõe ao leilão
Então o lance não é aceito

Exemplos:
| valor |	nomeUsuario |
|	0			| "beltrano"	|
| -1		|	"fulano"		|

Cenário: Propondo uma sequência de lances
Dado dois lances
| valor |	nomeUsuario |
|	10		| "beltrano"	|
| 15		|	"beltrano"	|
Quando propõe vários lances ao leilão
Então o segundo lance não é aceito
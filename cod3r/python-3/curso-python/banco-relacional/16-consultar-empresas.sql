select
    e.nome Empresa,
    c.nome Cidade
from empresas e, empresas_unidades eu, cidades c
where eu.empresa_id = e.id
and eu.cidade_id = c.id
and sede;

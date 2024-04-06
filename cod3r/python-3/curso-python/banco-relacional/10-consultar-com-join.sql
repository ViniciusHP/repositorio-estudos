-- Produto cartesiano entre as tabelas
-- (todas linhas da tabela estado estarão relacionadas a todas linhas da tabela cidades)
select *
from estados e, cidades c;


select
    e.nome as estado,
    c.nome as cidade,
    regiao
from estados e, cidades c
where e.id = c.estado_id;

select
    c.nome as cidade,
    e.nome as estado,
    regiao
from estados e
inner join cidades c on c.estado_id = e.id;
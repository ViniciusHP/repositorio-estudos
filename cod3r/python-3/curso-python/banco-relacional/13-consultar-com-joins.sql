select c.nome cidade,
    p.nome prefeito
from cidades c
inner join prefeitos p on c.id = p.cidade_id;

select c.nome cidade,
    p.nome prefeito
from cidades c
left outer join prefeitos p on c.id = p.cidade_id;

select c.nome cidade,
    p.nome prefeito
from cidades c
right outer join prefeitos p on c.id = p.cidade_id;

-- Não suportado pelo MySql
-- select c.nome cidade,
--     p.nome prefeito
-- from cidades c
-- full join prefeitos p on c.id = p.cidade_id;

-- Full join
select c.nome cidade,
    p.nome prefeito
from cidades c
left outer join prefeitos p on c.id = p.cidade_id
union
select c.nome cidade,
    p.nome prefeito
from cidades c
right outer join prefeitos p on c.id = p.cidade_id;
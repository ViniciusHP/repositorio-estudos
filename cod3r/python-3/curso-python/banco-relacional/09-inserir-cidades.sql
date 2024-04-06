INSERT INTO cidades(nome, area, estado_id)
VALUES ('Campinhas', 795, 25);

INSERT INTO cidades(nome, area, estado_id)
VALUES ('Niterói', 795, 19);

INSERT INTO cidades(nome, area, estado_id)
VALUES (
    'Caruaru',
    920.6,
    (select id from estados where sigla = 'PE' limit 1)
);

INSERT INTO cidades(nome, area, estado_id)
VALUES (
    'Juazeiro do Norte',
    248.2,
    (select id from estados where sigla = 'CE' limit 1)
);


SELECT * FROM cidades;
INSERT INTO prefeitos
    (nome, cidade_id)
VALUES
    ('Rodrigo Neves', (select id from cidades where nome = 'Niterói' limit 1)),
    ('Raquel Lyra', (select id from cidades where nome = 'Caruaru' limit 1)),
    ('Zenaldo Coutinho', null);

select * from prefeitos;

INSERT INTO prefeitos
    (nome, cidade_id)
VALUES
    ('Rafael Greca', null);

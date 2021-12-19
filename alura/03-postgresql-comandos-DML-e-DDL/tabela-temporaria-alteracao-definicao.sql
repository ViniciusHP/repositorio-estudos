create temporary table a (
	coluna varchar(255) not null check(coluna <> '')
);

insert into a values ('');

create temporary table b (
	coluna1 varchar(255) not null check(coluna1 <> ''),
	coluna2 varchar(255) not null,
	UNIQUE (coluna1, coluna2)
);

insert into b values ('a', 'b');
insert into b values ('a', 'b');

ALTER TABLE b RENAME TO teste;
ALTER TABLE teste RENAME coluna1 TO primeira_coluna;
ALTER TABLE teste RENAME coluna2 TO segunda_coluna;

CREATE TABLE pessoa(
	id SERIAL PRIMARY KEY
);

ALTER TABLE pessoa ADD COLUMN nome VARCHAR(128) NOT NULL;

SELECT * FROM pessoa;
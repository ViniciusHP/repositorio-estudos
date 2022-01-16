-- Caso o instrutor inserido receba acima da média, cancele a instrução, ou seja, não permita que a inserção ocorra.

CREATE OR REPLACE FUNCTION rejeita_acima_media_instrutor() RETURNS TRIGGER AS $$
	DECLARE
		media_salarial DECIMAL DEFAULT 0;
		soma_salarios DECIMAL DEFAULT 0;
		contagem_salarios INTEGER DEFAULT 0;
		salario DECIMAL;
	BEGIN
		
		FOR salario IN SELECT instrutor.salario FROM instrutor LOOP
			contagem_salarios := contagem_salarios + 1;
			soma_salarios := soma_salarios + salario;
		END LOOP;
		
		media_salarial = soma_salarios / contagem_salarios::DECIMAL;
		
		IF NEW.salario > media_salarial THEN
			RETURN NULL;
		ELSE
			RETURN NEW;
		END IF;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION media_salarial() RETURNS DECIMAL AS $$
	DECLARE
		media_salarial DECIMAL DEFAULT 0;
		soma_salarios DECIMAL DEFAULT 0;
		contagem_salarios INTEGER DEFAULT 0;
		salario DECIMAL;
	BEGIN
		
		FOR salario IN SELECT instrutor.salario FROM instrutor LOOP
			contagem_salarios := contagem_salarios + 1;
			soma_salarios := soma_salarios + salario;
		END LOOP;
		
		media_salarial = soma_salarios / contagem_salarios::DECIMAL;
		
		RETURN media_salarial;
	END;
$$ LANGUAGE PLPGSQL;

DROP TRIGGER verifica_instrutores ON instrutor;

CREATE TRIGGER rejeita_instrutores_com_maior_media_salarial BEFORE INSERT ON instrutor
	FOR EACH ROW EXECUTE FUNCTION rejeita_acima_media_instrutor();

SELECT media_salarial();

INSERT INTO instrutor(nome, salario) VALUES ('Kerrigan', 2000);
INSERT INTO instrutor(nome, salario) VALUES ('Serena', 500);

SELECT * FROM instrutor;
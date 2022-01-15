DROP TRIGGER verifica_instrutores ON instrutor;
DROP FUNCTION verifica_instrutor;

CREATE OR REPLACE FUNCTION verifica_instrutor() RETURNS TRIGGER AS $$
	DECLARE
		instrutores_recebem_menos INTEGER DEFAULT 0;
		total_instrutores INTEGER DEFAULT 0;
		salario DECIMAL;
		percentual DECIMAL(5, 2);
		novo_salario DECIMAL;
	BEGIN
		FOR salario IN SELECT instrutor.salario FROM instrutor LOOP
			total_instrutores := total_instrutores + 1;
			
			IF salario < NEW.salario THEN
				instrutores_recebem_menos := instrutores_recebem_menos + 1;
			END IF;
		END LOOP;
		
		percentual := instrutores_recebem_menos::DECIMAL / total_instrutores::DECIMAL * 100;
		
		IF percentual >= 100.0 THEN
			SELECT MAX(instrutor.salario) INTO novo_salario FROM instrutor LIMIT 1;
			NEW.salario := novo_salario;
		END IF;
		
		RETURN NEW;
	END;
$$ LANGUAGE PLPGSQL;

CREATE TRIGGER verifica_instrutores BEFORE INSERT ON instrutor
	FOR EACH ROW EXECUTE FUNCTION verifica_instrutor();
	
SELECT * FROM instrutor;

INSERT INTO instrutor(nome, salario) VALUES ('Gojo', 2000);

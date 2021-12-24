INSERT INTO instrutor (nome, salario) VALUES ('Vinicius Henrique', 200);
INSERT INTO instrutor (nome, salario) VALUES ('Angela Vasconcelos', 300);
INSERT INTO instrutor (nome, salario) VALUES ('Agatha da Silva', 400);
INSERT INTO instrutor (nome, salario) VALUES ('Ítalo Vargas', 500);

CREATE FUNCTION instrutores_bem_pagos(valor_salario DECIMAL) RETURNS instrutor AS $$
	SELECT * FROM instrutor WHERE salario > valor_salario;
$$ LANGUAGE SQL;

SELECT * FROM instrutores_bem_pagos(300);

DROP FUNCTION instrutores_bem_pagos;
CREATE FUNCTION instrutores_bem_pagos(valor_salario DECIMAL) RETURNS SETOF instrutor AS $$
	SELECT * FROM instrutor WHERE salario > valor_salario;
$$ LANGUAGE SQL;

SELECT * FROM instrutores_bem_pagos(300);

-- Forma diferente de fazer
DROP FUNCTION instrutores_bem_pagos;
CREATE FUNCTION instrutores_bem_pagos(valor_salario DECIMAL) RETURNS TABLE (id INTEGER, nome VARCHAR, salario DECIMAL) AS $$
	SELECT * FROM instrutor WHERE salario > valor_salario;
$$ LANGUAGE SQL;

SELECT * FROM instrutores_bem_pagos(300);

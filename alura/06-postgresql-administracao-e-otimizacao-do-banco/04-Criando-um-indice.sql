CREATE INDEX idx_salario ON instrutor(salario);
EXPLAIN SELECT * FROM instrutor WHERE salario > 1000;

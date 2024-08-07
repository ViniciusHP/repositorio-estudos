CREATE DATABASE loja_virtual;
USE loja_virtual;
CREATE TABLE PRODUTO (ID INT AUTO_INCREMENT, NOME VARCHAR(50) NOT NULL, DESCRICAO VARCHAR(255), PRIMARY KEY(ID)) Engine = InnoDB;

CREATE TABLE CATEGORIA (ID INT AUTO_INCREMENT, NOME VARCHAR(50) NOT NULL, PRIMARY KEY(ID)) Engine = InnoDB;

INSERT INTO CATEGORIA (NOME) VALUES ('ELETRONICOS');
INSERT INTO CATEGORIA (NOME) VALUES ('ELETRODOMESTICOS');
INSERT INTO CATEGORIA (NOME) VALUES ('MOVEIS');

ALTER TABLE PRODUTO ADD COLUMN CATEGORIA_ID INT;
ALTER TABLE PRODUTO ADD FOREIGN KEY (CATEGORIA_ID) REFERENCES CATEGORIA (ID);

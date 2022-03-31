CREATE DATABASE projeto;

USE projeto;

CREATE TABLE marcas(
	codigo INT PRIMARY KEY auto_increment,
    nome VARCHAR(20)
);

INSERT INTO marcas (nome) VALUES
('Apple'),
('LG'),
('Motorola'),
('Xiaomi'),
('Samsung');
INSERT INTO marcas (nome) VALUE ('Nokia');

SELECT * FROM marcas;

CREATE TABLE produtos(
	codigo INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(30),
    valor DOUBLE,
    marca INT,
    FOREIGN KEY(marca) REFERENCES marcas(codigo)
);

SELECT * FROM produtos;

INSERT INTO produtos (nome, valor, marca) VALUES
('Galaxy S22', 7000, 5),
('iPhone 13', 8000, 1),
('Galaxy Fold', 14000, 5),
('Note 9', 500, 4),
('iPhone 12', 5000, 1),
('Moto G', 2000, 3);
INSERT INTO produtos (nome, valor, marca) VALUES ('Galaxy S', 7000, 8); -- não adiciona se FK não existir

SELECT
	produtos.codigo,
    produtos.nome,
    produtos.valor,
    marcas.nome
FROM produtos 
INNER JOIN marcas
ON produtos.marca = marcas.codigo;

SELECT 
	marcas.nome,
    COUNT(produtos.nome) AS quantidade
FROM marcas
LEFT JOIN produtos
ON marcas.codigo = produtos.marca
GROUP BY marcas.nome;


-- create view (tipo uma variavel)
CREATE VIEW visao AS
SELECT
	produtos.codigo,
    produtos.nome, 
    produtos.valor,
    marcas.nome AS marca
FROM produtos 
INNER JOIN marcas
ON produtos.marca = marcas.codigo;

SELECT nome, marca FROM visao;

-- Procedure
CREATE PROCEDURE cadastrarMarca(IN nomeMarca VARCHAR(20))
INSERT INTO marcas (nome) VALUES (nomeMarca);

CALL cadastrarMarca("Sony");

SELECT * FROM marcas;
SELECT * FROM produtos;




















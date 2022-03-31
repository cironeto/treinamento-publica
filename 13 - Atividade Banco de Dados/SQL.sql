CREATE DATABASE atividade_sql;

USE atividade_sql;

CREATE TABLE marcas(
	id INT PRIMARY KEY auto_increment,
    nome VARCHAR(30) UNIQUE
);

CREATE TABLE produtos(
	id INT PRIMARY KEY auto_increment,
	nome VARCHAR(50),
    categoria VARCHAR(50),
    valor DOUBLE,
    marca INT,
    FOREIGN KEY(marca) REFERENCES marcas(id)
);

SET SQL_SAFE_UPDATES = 0;
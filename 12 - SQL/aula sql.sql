CREATE DATABASE aula01;
USE aula01;
CREATE TABLE alunos(
	nome VARCHAR(20),
    nota1 DOUBLE,
    nota2 DOUBLE,
    turno CHAR
);

INSERT INTO alunos VALUE('Ciro', 8, 9, 'M');
INSERT INTO alunos (nota1, nota2) VALUE (5, 9);
INSERT INTO alunos VALUES
('Neto', 10, 6, 'V'),
('Amanda', 7, 7, 'M'),
('Fer', 6, 8, 'M');

SELECT * FROM alunos;
SELECT nome, turno FROM alunos;
SELECT nome, ((nota1 + nota2) / 2) AS média FROM alunos;
SELECT nome, IF(((nota1 + nota2) / 2) >= 7, 'Aprovado', 'Reprovado') AS 'situação' FROM alunos;

SELECT 
CONCAT(nome, IF(((nota1 + nota2) / 2) >= 7, ' está aprovado', ' está reprovado')) AS 'situação' 
FROM alunos;

SELECT COUNT(nota1) AS quantidade FROM alunos WHERE nota1 < 8;

SELECT AVG(nota1) FROM alunos;
SELECT AVG(nota2) FROM alunos;

SELECT MAX(nota1) FROM alunos;
SELECT MIN(nota1) FROM alunos;

SELECT
	CASE
		WHEN turno = 'M' THEN 'Matutino'
        WHEN turno = 'V' THEN 'Vespertino'
        ELSE 'Turno não encontrado'
	END AS turnos
FROM alunos;

SELECT * FROM alunos WHERE nome = 'ciro';
SELECT * FROM alunos WHERE nome IS NOT NULL;
SELECT * FROM alunos WHERE turno = 'v';
SELECT turno, COUNT(turno) AS quant FROM alunos WHERE nome IS NOT NULL GROUP BY turno;
SELECT nome FROM alunos WHERE nome IS NOT NULL ORDER BY nome ASC;
SELECT nome FROM alunos WHERE nome IS NOT NULL ORDER BY nome DESC;

SELECT nome FROM alunos WHERE nome LIKE 'c%';
SELECT nome FROM alunos WHERE nome LIKE '%a';
SELECT nome FROM alunos WHERE nome LIKE '%n%';
SELECT nome FROM alunos WHERE nome LIKE '%n__%';

SELECT * FROM alunos;

SET SQL_SAFE_UPDATES = 0;
UPDATE alunos SET nome = 'Denis' WHERE nome IS NULL;

DELETE FROM alunos WHERE nome = 'Denis';
DELETE FROM alunos WHERE nome = 'ciro';

DROP TABLE alunos;

DROP DATABASE aula01;



















Create database at4;
Use at4;
CREATE TABLE animais (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    especie VARCHAR(50) NOT NULL,
    peso FLOAT NOT NULL
);
INSERT INTO animais (nome, especie, peso) 
VALUES ('Tigre', 'Felino', 220.5),
       ('Elefante', 'Mamífero', 5400.0),
       ('Arara', 'Ave', 1.2);
select * from animais;
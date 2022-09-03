-- Crea tion de la base de donnees book_app:
CREATE DATABASE book_app
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

COMMENT ON DATABASE book_app
    IS 'base de donnees de l''apllication de gestion de livre avec Spring Boot';




-- creation de la table book
DROP TABLE IF EXISTS books;

CREATE TABLE books(
id INT PRIMARY KEY,
title VARCHAR(200) NOT NULL,
author VARCHAR(200)  NOT NULL,
quantity INT NOT NULL
);

INSERT INTO books (title, author, quantity) VALUES 
(1, 'HTML/CSS', 'Pierre Geraud', 18),
(2, 'sql', 'KINDO', 22),
(3, 'java', 'Dr BELEM', 9),
(4, 'CONDUITE DE PROJET', 'Thiombiano', 12),
(5, 'Decouverte de Git/GITHUB', 'geekguid', 10);
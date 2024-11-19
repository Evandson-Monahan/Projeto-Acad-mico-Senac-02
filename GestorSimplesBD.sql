CREATE DATABASE GestorSimples;

USE GestorSimples;

CREATE TABLE tarefas(
	id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR (100) NOT NULL UNIQUE,
    descricao TEXT NOT NULL
);

CREATE TABLE usuarios (
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR (100),
    telefone VARCHAR (15),
    login VARCHAR (20),
    senha VARCHAR (15)
);

INSERT INTO usuarios (nome, telefone, login, senha) VALUES ('Evandson Vieira', '(21) 99288-5081', 'admin', 'admin');
SELECT * FROM tarefas;
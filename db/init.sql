CREATE DATABASE kanban;

USE kanban;

CREATE TABLE IF NOT EXISTS users(
    id INT AUTO_INCREMENT PRIMARY KEY,

    username VARCHAR(50) NOT NULL,
    psw VARCHAR(255) NOT NULL,

    nome VARCHAR(100),
    sobrenome VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE ticket(
    id INT AUTO_INCREMENT PRIMARY KEY,
    status enum('a fazer','em andamento','concluido'),
    titulo VARCHAR(100),
    texto VARCHAR(500)
);
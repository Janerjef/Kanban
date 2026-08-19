USE kanban;

CREATE TABLE IF NOT EXISTS users(
    id INT AUTO_INCREMENT PRIMARY KEY,

    username VARCHAR(50) NOT NULL,
    psw VARCHAR(255) NOT NULL,

    nome VARCHAR(100),
    sobrenome VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS areas(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255)
);

CREATE TABLE  IF NOT EXISTS  ticket(
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100),
    texto VARCHAR(500),
    area_id INT,
    CONSTRAINT fk_ticket_area
    FOREIGN KEY (area_id) REFERENCES areas(id)
);

INSERT INTO areas (id,nome) VALUES
(1, 'Backlog'),
(2, 'A fazer'),
(3, 'Em andamento'),
(4, 'Concluido');
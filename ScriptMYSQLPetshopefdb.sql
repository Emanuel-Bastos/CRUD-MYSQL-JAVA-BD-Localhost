CREATE DATABASE IF NOT EXISTS petshopefdb;

USE petshopefdb;

CREATE TABLE IF NOT EXISTS cadastro_clientes_pets (
    id INT AUTO_INCREMENT,
    nome_tutor VARCHAR(100) NOT NULL,
    nome_pet VARCHAR(100) NOT NULL,
    raca VARCHAR(50),
    telefone VARCHAR(20),
    PRIMARY KEY (id)
);



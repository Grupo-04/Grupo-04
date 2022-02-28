#unlock é palavra reservada, por isso declaramos com adicional de _db

#criando banco de dados
CREATE DATABASE unlock_db;

#utilziando banco ded dados
USE unlock_db;

#Criando tabela Endereco
CREATE TABLE Endereco (
    id INT PRIMARY KEY AUTO_INCREMENT,
    cep CHAR(8) NOT NULL,
    logradouro VARCHAR(100) NOT NULL,
    numero VARCHAR(6) NOT NULL,
    estado VARCHAR(45) NOT NULL,
    cidade VARCHAR(45) NOT NULL,
    bairro VARCHAR(45) NOT NULL
);

#Consultando tabela Endereco
select * from Endereco;

#Criando tabela Estabelcimento
CREATE TABLE Estabelecimento (
    id INT PRIMARY KEY AUTO_INCREMENT,
    cnpj CHAR(14) NOT NULL UNIQUE,
    nome_estabelecimento VARCHAR(45) NOT NULL,
    telefone_estabelecimento CHAR(15) NOT NULL,
    email_estabelecimento VARCHAR(100) NOT NULL UNIQUE,
    senha_estabelecimento VARCHAR(45) NOT NULL,
    horario_atendimento VARCHAR(200),
    tipo_estabelecimento VARCHAR(45) NOT NULL,
    fk_endereco_estabelecimento INT,
    FOREIGN KEY (fk_endereco_estabelecimento) REFERENCES Endereco(id)
);

#Consultando tabela Estabelecimento
select * from Estabelecimento;

CREATE TABLE Artista (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome_artista VARCHAR(45) NOT NULL,
    telefone_artista CHAR(15) NOT NULL,
    cpf_artista CHAR(14) NOT NULL UNIQUE,
    tipo_artista VARCHAR(45) NOT NULL,
    email_artista VARCHAR(100) NOT NULL UNIQUE,
    senha_artista VARCHAR(45) NOT NULL,
    fk_endereco_artista INT,
    FOREIGN KEY (fk_endereco_artista) REFERENCES Endereco(id)
);

#Consultando tabela Artista;
select * from Artista;
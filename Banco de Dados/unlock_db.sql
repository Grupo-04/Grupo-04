#unlock é palavra reservada, por isso declaramos com adicional de _db

#criando banco de dados
CREATE DATABASE unlock_db;

#utilziando banco de dados
USE unlock_db;

#Criando tabela Endereco
CREATE TABLE Endereco (
    id INT PRIMARY KEY AUTO_INCREMENT,
    cep CHAR(8) NOT NULL,
    logradouro VARCHAR(100) NOT NULL,
    numero VARCHAR(6) NOT NULL,
    uf CHAR(2) NOT NULL,
    cidade VARCHAR(45) NOT NULL,
    bairro VARCHAR(45) NOT NULL
);

#Inserindo dados na tabela Endereco
INSERT INTO Endereco values (null, '03873000', 'Rua Brasileira do Brasil', '55', 'SP', 'São Paulo', 'Penha');

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
    quantidade_artistas_suportados INT NOT NULL,
    autenticado BOOLEAN NULL,
    fk_endereco_estabelecimento INT,
    FOREIGN KEY (fk_endereco_estabelecimento) REFERENCES Endereco(id)
);

#Inserindo dados na tabela Estabelecimento
INSERT INTO Estabelecimento values (null, '38420733000158', 'Bar do JUCA', '20480070', 'juca@gmail.com', 'juca123', 'SEGUNDA A SEXTA 19:00 - 00:00', 'Bar', 3, 0, 1);

#Consultando tabela Estabelecimento
select * from Estabelecimento;

#Criando tabela GrupoArtista
CREATE TABLE GrupoArtista (
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome_grupo VARCHAR(45) NOT NULL,
    estilo_grupo VARCHAR(45) NOT NULL
);

#Inserindo dados na tabela GrupoArtista
INSERT INTO GrupoArtista values (null, 'Axé Band', 'Axé');

#Consultando tabela GrupoArtista
select * from GrupoArtista;

#Criando tabela Artista
CREATE TABLE Artista (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome_artista VARCHAR(45) NOT NULL,
    telefone_artista CHAR(15) NOT NULL,
    cpf_artista CHAR(14) NOT NULL UNIQUE,
    tipo_artista VARCHAR(45) NOT NULL,
    email_artista VARCHAR(100) NOT NULL UNIQUE,
    senha_artista VARCHAR(45) NOT NULL,
    grupo TINYINT NOT NULL,
    autenticado TINYINT,
    fk_grupo INT,
    FOREIGN KEY (fk_grupo) REFERENCES GrupoArtista(id)
);

#Inserindo dados na tabela Artista
INSERT INTO Artista values (1, 'Robson Lima', '995943394', '48101411118', 'Musico', 'robson@gmail.com', 'robson123', 0, 0, null);

#Consultando tabela Artista;
select * from Artista;

#Criando tabela ArtistaHasEndereco
CREATE TABLE ArtistaHasEndereco (
	fk_artista INT,
    FOREIGN KEY (fk_artista) REFERENCES Artista(id),
    fk_endereco INT,
    FOREIGN KEY (fk_endereco) REFERENCES Endereco(id)
);

#Inserindo dados na tabela ArtistaHasEstabelecimento
INSERT INTO ArtistaHasEndereco values (1, 1);

#Consultando tabela ArtistaHasEndereco
select * from ArtistaHasEndereco;

#Criando tabela Agendamento
CREATE TABLE Agendamento (
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    codigo_agendamento VARCHAR(45) NOT NULL,
    status_agendamento VARCHAR(45) NOT NULL,
    data_evento DATETIME NOT NULL,
    valor_cobrado DOUBLE(5,2) NOT NULL,
    fk_artista INT,
    FOREIGN KEY (fk_artista) REFERENCES Artista(id),
    fk_estabelecimento INT, 
    FOREIGN KEY (fk_estabelecimento) REFERENCES Estabelecimento(id)
);

#Inserindo dados na tabela Agendamento
INSERT INTO Agendamento values (100, 'ABC123', 'Confirmado', '2022-09-11 15:00', 500.89, 1, 1);
INSERT INTO Agendamento values (null, 'ABC123', 'Confirmado', '2022-09-11 15:00', 500.89, 1, 1);

#Consultando tabela Agendamento
select * from Agendamento;

#Criando tabela ArtistaAvaliacaoAgendamento
CREATE TABLE ArtistaAvaliacaoAgendamento (
	fk_artista INT,
    FOREIGN KEY (fk_artista) REFERENCES Artista(id),
    fk_agendamento INT,
    FOREIGN KEY (fk_agendamento) REFERENCES Agendamento(id),
    nota DOUBLE(2,1) NULL, 
    comentario VARCHAR(45) NULL
);

#Inserindo dados na tabela ArtistaAvaliaçãoAgendamento
INSERT INTO ArtistaAvaliacaoAgendamento values (1, 100, 5.0, 'TOP PARA MINHA BANDA, COMI DE GRAÇA AINDA');

#Consultando tabela ArtistaAvaliacaoAgendamento
select * from ArtistaAvaliacaoAgendamento;

#Criando tabela EstabelecimentoAvaliacaoAgendamento
CREATE TABLE EstabelecimentoAvaliacaoAgendamento (
	fk_estabelecimento INT,
    FOREIGN KEY (fk_estabelecimento) REFERENCES Estabelecimento(id),
    fk_agendamento INT,
    FOREIGN KEY (fk_agendamento) REFERENCES Agendamento(id),
    nota DOUBLE(2,1) NULL, 
    comentario VARCHAR(45) NULL
);	

#Inserindo dados na tabela EstabelecimentoAvaliacaoAgendamento
INSERT INTO EstabelecimentoAvaliacaoAgendamento values (1, 100, 5.0, 'Agitaram o publico e foram muito atenciosos');

#Consultando tabela EstabelecimentoAvaliacaoAgendamento
select * from EstabelecimentoAvaliacaoAgendamento;
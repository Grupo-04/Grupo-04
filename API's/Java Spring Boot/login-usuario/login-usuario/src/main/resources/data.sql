insert into endereco (cep, logradouro, numero, uf, cidade, bairro)
values ('15557180', 'Rua da Couves', '1544', 'SP', 'São Paulo', 'Centro'),
('95351181', 'Rua das Camélias', '2147', 'SP', 'Diadema', 'Zona Leste'),
('55557129', 'Av. Dom Pedro', '11', 'MT', 'São Caetano', 'Zona Sul'),
('12385496', 'Rua dos milhões', '998', 'MS', 'Suzano', 'Zona Norte'),
('97423651', 'Rua richards', '850', 'PA', 'Piracicaba', 'Conceição');

insert into estabelecimento
(nome, telefone, email, senha, autenticado, cnpj, tipo,
interesse_match_cidade, quantidade_artistas_suportados, fk_endereco_estabelecimento)
values
('Leds Burger', '99175-9897', 'enan.oliveira@bandtec.com.br', 'senha123', true, '12345678912345', 'Hamburgueria',false, 7, 1),
('Burger King', '94578-1452', 'renan2003lima@hotmail.com', 'senha321', false, '09845678912543', 'Hamburgueria',false, 10, 2),
('Mac Donalds', '93644-3642', 'mac.donalds@gmail.com', '123senha', false, '58445678912098', 'Hamburgueria',false, 3, 3),
('Jackan Rest', '93654-1254', 'jackan.rest@hotmail.com', '321senha', false, '55548678912345', 'Restaurante',false, 2, 4),
('RestFull', '94758-3674', 'rest.full@gmail.com', 'senhaSecreta', false, '65999678912345', 'Restaurante',false, 1, 5);

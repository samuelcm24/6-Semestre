CREATE DATABASE IF NOT EXISTS Loja_cosmeticos;
USE Loja_cosmeticos;
drop database loja_cosmeticos;


CREATE TABLE CLIENTE(
		cpf char(11) not null,
        Nome_cliente varchar(30) not null, 
        Endereco varchar(20) not null,
        Telefone char(11),
        primary key(cpf)
);

CREATE TABLE FUNCIONARIO (
    ID_FUNC INT NOT NULL,
    cpf CHAR(11) NOT NULL,
    Nome_Func VARCHAR(50) NOT NULL,
    Endereco VARCHAR(50),
    Telefone VARCHAR(15),
    Cargo VARCHAR(50),
    
    PRIMARY KEY (ID_FUNC),
    UNIQUE (CPF)
);

CREATE TABLE FORNECEDOR(
	CNPJ char(14) not null,
    Nome_Fornecedor varchar(50) not null,
    Telefone char(11) not null,
    Email varchar(50) not null,
    
    primary key(CNPJ)
);

CREATE TABLE CAT_Prod(
	ID_categoria char(11) not null,
    Nome_categoria varchar(50) not null,
    
    primary key(ID_categoria)
);

CREATE TABLE PRODUTO(
	ID_produto char(11) not null,
    Nome varchar(50) not null,
    Marca varchar(50) not null,
    Preco_unitario decimal(10, 2) not null, -- Definicao de precos sendo 10 o valor dos digitos maximos e 2 a quantidade de casas decimais apos a virgula
    QTD_prod_disponivel int not null,
    ID_Categoria char(11) not null,
    
    primary key(ID_produto)
);

CREATE TABLE VENDA(
	ID_venda char(11) not null,
    DT_venda date not null,
    CPF char(11) not null,
    ID_FUNC INT not null,
    
    primary key(ID_venda)
);

CREATE TABLE FORNECER(
	CNPJ char(14) not null,
    ID_produto char(11) not null,
    
    primary key(CNPJ, ID_produto)
);

CREATE TABLE CONTEM(
	ID_venda char(11) not null,
    ID_Produto char(11) not null,
    QTD_vendida int not null,
    Preco_venda decimal(10, 2) not null,
    
    primary key(ID_venda, ID_produto)
);

-- Associando as chaves estrageiras com alter as tabelas --


alter table produto
	add constraint fk_produto_categoria
    foreign key (ID_categoria)
    references CAT_Prod(ID_categoria);

alter table venda
	add constraint fk_cpf_cliente
    foreign key(cpf)
    references cliente(cpf);

alter table venda
	add constraint fk_ID_FUNC_VENDA
	foreign key (ID_FUNC)
	references funcionario(ID_FUNC);
    
alter table fornecer
	add constraint fk_cnpj_fornecedor
    foreign key (CNPJ)
    references fornecedor(cnpj);

alter table fornecer
	add constraint fk_id_prod
    foreign key (ID_produto)
    references produto(ID_produto);
    
alter table contem 
	add constraint fk_id_venda
    foreign key (ID_venda)
    references venda(ID_venda);




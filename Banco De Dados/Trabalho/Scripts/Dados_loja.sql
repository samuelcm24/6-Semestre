USE loja_cosmeticos;

-- Inserindo Dados na Tabela Cliente --

INSERT INTO CLIENTE (cpf, Nome_cliente, Endereco, Telefone)
VALUES
    ('00000000001', 'Ana Sousa', 'Rua A, 10', '66000000001'),
    ('00000000002', 'Lula', 'Rua B, 13', '66000000002'),
    ('00000000003', 'Bolsonaro mito', 'Rua C, 22', NULL);

INSERT INTO FUNCIONARIO (ID_FUNC, cpf, Nome_Func, Endereco, Telefone,
Cargo)
values
	(001, '12345678910', 'Pedro santos', 'Rua S', '66999181237', 'Vendedor'),
    (002, '00000000101', 'Marina', 'Rua Manoel', '66999457834', 'Venderedora');

INSERT INTO FORNECEDOR (CNPJ, Nome_Fornecedor, Telefone, Email)
VALUES
	('47549791389710', 'Distribuidora Araguaia', '64999786145', 'Dist_Araguaia@hotmail.com'),
    ('57489701800499', 'Dsitribuidora Roncador', '65992787110', 'Dist_Roncador@gmail.com');
    
INSERT INTO CAT_Prod (ID_categoria, Nome_categoria)
VALUES
    ('CAT001', 'Perfumaria'),
    ('CAT002', 'Cuidados com a pele'),
    ('CAT003', 'Cabelos');

-- 2. Produtos: as categorias referenciadas ja foram cadastradas.
INSERT INTO PRODUTO
    (ID_produto, Nome, Marca, Preco_unitario, QTD_prod_disponivel, ID_Categoria)
VALUES
    ('P001', 'Perfume floral', 'Aurora', 89.90, 20, 'CAT001'),
    ('P002', 'Colonia citrica', 'Aurora', 59.90, 15, 'CAT001'),
    ('P003', 'Hidratante corporal', 'Bela Vida', 29.90, 30, 'CAT002'),
    ('P004', 'Protetor solar FPS 50', 'Bela Vida', 49.90, 12, 'CAT002'),
    ('P005', 'Shampoo hidratante', 'Brisa', 19.90, 25, 'CAT003'),
    ('P006', 'Condicionador', 'Brisa', 21.90, 0, 'CAT003');

-- 3. Vendas: os clientes e funcionarios ja foram cadastrados.
INSERT INTO VENDA (ID_venda, DT_venda, CPF, ID_FUNC)
VALUES
    ('V001', '2026-11-14', '00000000001', 001),
    ('V002', '2026-11-15', '00000000002', 002),
    ('V003', '2026-11-16', '00000000001', 001),
    ('V004', '2026-11-16', '00000000003', 002);

-- 4. Associacoes entre fornecedores e produtos
-- P003 e P004 possuem dois fornecedores.
INSERT INTO FORNECER (CNPJ, ID_produto)
VALUES
    ('47549791389710', 'P001'),
    ('47549791389710', 'P002'),
    ('47549791389710', 'P003'),
    ('47549791389710', 'P004'),
    ('57489701800499', 'P003'),
    ('57489701800499', 'P004'),
    ('57489701800499', 'P005'),
    ('57489701800499', 'P006');

-- 5. Itens das vendas: as vendas e os produtos ja foram cadastrados.
INSERT INTO CONTEM (ID_venda, ID_Produto, QTD_vendida, Preco_venda)
VALUES
    ('V001', 'P001', 1, 89.90),
    ('V001', 'P003', 2, 29.90),
    ('V002', 'P005', 2, 19.90),
    ('V002', 'P006', 1, 21.90),
    ('V003', 'P003', 1, 29.90),
    ('V003', 'P004', 1, 49.90),
    ('V004', 'P001', 1, 89.90),
    ('V004', 'P005', 1, 19.90);
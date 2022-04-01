ALTER TABLE produto
    DROP COLUMN estoque_entrada_id,
    ADD COLUMN descricao varchar(255) NOT NULL,
    DROP COLUMN estoque_saida_id,
    ADD COLUMN preco decimal(10,2) NOT NULL,
    DROP COLUMN tamanho,
    DROP COLUMN quantidade_estoque,
	ADD COLUMN quantidade bigint(20) NOT NULL

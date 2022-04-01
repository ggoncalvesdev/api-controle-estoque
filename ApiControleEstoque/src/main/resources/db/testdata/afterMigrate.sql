set foreign_key_checks = 0;

delete from produto;
delete from categoria;

set foreign_key_checks = 1;

alter table produto auto_increment = 1;
alter table categoria auto_increment = 1;

insert into categoria (id, nome_categoria) values (1, 'calçados'), (2, 'camisas'), (3, 'shorts');

insert into produto (id, nome, categoria_id, descricao, preco, quantidade) values (1, 'chinelo havaiana', 1, 'chinelo havaiana branco', 20.00, 20);

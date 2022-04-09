set foreign_key_checks = 0;

delete from produto;
delete from categoria;
delete from grupo;
delete from grupo_permissao;
delete from permissao;
delete from usuario;
delete from usuario_grupo;

set foreign_key_checks = 1;

alter table produto auto_increment = 1;
alter table categoria auto_increment = 1;
alter table grupo auto_increment = 1;
alter table permissao auto_increment = 1;
alter table usuario auto_increment = 1;

insert into permissao (id, nome, descricao) values (1, 'CONSULTAR_PRODUTOS', 'Permite consultar produtos');
insert into permissao (id, nome, descricao) values (2, 'EDITAR_PRODUTOS', 'Permite editar produtos');

insert into categoria (id, nome_categoria) values (1, 'calçados'), (2, 'camisas'), (3, 'shorts');

insert into produto (id, nome, categoria_id, descricao, preco, quantidade) values (1, 'chinelo havaiana', 1, 'chinelo havaiana branco', 20.00, 20);
insert into produto (id, nome, categoria_id, descricao, preco, quantidade) values (2, 'camiseta', 2, 'camiseta branco', 10.00, 30);

insert into grupo (id, nome) values (1, 'Gerente'), (2, 'Vendedor'), (3, 'Secretária');

insert into grupo_permissao (grupo_id, permissao_id) values (1, 1), (1, 2), (2, 1), (2, 2), (3, 1); 

insert into usuario (id, nome, login, senha) values
(1, 'João da Silva', 'joao.ger@algafood.com', '123'),
(2, 'Maria Joaquina', 'maria.vnd@algafood.com', '123'),
(3, 'José Souza', 'jose.aux@algafood.com', '123'),
(4, 'Sebastião Martins', 'sebastiao.cad@algafood.com', '123'),
(5, 'Manoel Lima', 'manoel.loja@gmail.com', '123');

insert into usuario_grupo (usuario_id, grupo_id) values (1, 1), (1, 2), (2, 2);

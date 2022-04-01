CREATE TABLE `usuario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `login` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tipo_usuario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `caixa` bit(1) NOT NULL,
  `gerente` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `estoque_saida` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data` datetime(6) DEFAULT NULL,
  `justificativa` varchar(255) DEFAULT NULL,
  `voltou_estoque` bit(1) NOT NULL,
  `usuario_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoosryg6lv9l91uypwvhka1i0n` (`usuario_id`),
  CONSTRAINT `FKoosryg6lv9l91uypwvhka1i0n` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `estoque_entrada` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data` datetime(6) DEFAULT NULL,
  `quantidade_entrada` int NOT NULL,
  `usuario_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkh2wlaql9htrvns474xod5ui5` (`usuario_id`),
  CONSTRAINT `FKkh2wlaql9htrvns474xod5ui5` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `categoria` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome_categoria` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `produto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `quantidade_estoque` double NOT NULL,
  `tamanho` varchar(255) DEFAULT NULL,
  `categoria_id` bigint NOT NULL,
  `estoque_entrada_id` bigint NOT NULL,
  `estoque_saida_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKopu9jggwnamfv0c8k2ri3kx0a` (`categoria_id`),
  KEY `FKmk22sjvi3l30l8t7jfwuvl54l` (`estoque_entrada_id`),
  KEY `FKchqabl0xk5mlk5jrmlrg98gex` (`estoque_saida_id`),
  CONSTRAINT `FKchqabl0xk5mlk5jrmlrg98gex` FOREIGN KEY (`estoque_saida_id`) REFERENCES `estoque_saida` (`id`),
  CONSTRAINT `FKmk22sjvi3l30l8t7jfwuvl54l` FOREIGN KEY (`estoque_entrada_id`) REFERENCES `estoque_entrada` (`id`),
  CONSTRAINT `FKopu9jggwnamfv0c8k2ri3kx0a` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `conta` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `usuario_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmn9bk6wpmnlqyv5i3utmled4c` (`usuario_id`),
  CONSTRAINT `FKmn9bk6wpmnlqyv5i3utmled4c` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `permissao` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `usuario_permissao` (
  `tipo_usuario_id` bigint NOT NULL,
  `permissao_id` bigint NOT NULL,
  PRIMARY KEY (`tipo_usuario_id`,`permissao_id`),
  KEY `FKtcuagcmypmug2ddh2d5uol8s5` (`permissao_id`),
  CONSTRAINT `FKabw0ubbssdiyeuwwh91djxjyj` FOREIGN KEY (`tipo_usuario_id`) REFERENCES `tipo_usuario` (`id`),
  CONSTRAINT `FKtcuagcmypmug2ddh2d5uol8s5` FOREIGN KEY (`permissao_id`) REFERENCES `permissao` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `lists` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` date DEFAULT NULL,
  `updated_at` date DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `board_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_board_id_title` (`board_id`,`title`),
  CONSTRAINT `FK_lists_boards` FOREIGN KEY (`board_id`) REFERENCES `boards` (`id`)
);

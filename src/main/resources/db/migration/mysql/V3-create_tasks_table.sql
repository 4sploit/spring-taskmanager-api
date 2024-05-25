CREATE TABLE `tasks` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` date DEFAULT NULL,
  `updated_at` date DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `list_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_list_id` (`list_id`),
  CONSTRAINT `FK_tasks_lists` FOREIGN KEY (`list_id`) REFERENCES `lists` (`id`)
);

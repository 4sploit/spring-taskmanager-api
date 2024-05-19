package io.github.sploit.projects.taskmanager.common.configurations;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class LoadDatabase {
        private final JdbcTemplate jdbcTemplate;

        public LoadDatabase(JdbcTemplate jdbcTemplate) {
                this.jdbcTemplate = jdbcTemplate;
        }

        @Bean
        CommandLineRunner initDatabase() {
                return args -> this.seedData();
        }

        private void seedData() {
                jdbcTemplate.execute("SET session sql_mode='NO_AUTO_VALUE_ON_ZERO'");

                jdbcTemplate.execute("INSERT IGNORE INTO boards (id, created_at, title, updated_at) VALUES " +
                                "(1, '2024-01-01', 'Project Alpha', '2024-01-02'), " +
                                "(2, '2024-01-03', 'Project Beta', '2024-01-04'), " +
                                "(3, '2024-01-05', 'Project Gamma', '2024-01-06')");

                jdbcTemplate.execute("INSERT IGNORE INTO lists (id, created_at, title, updated_at, board_id) VALUES " +
                                "(1, '2024-01-01', 'To Do', '2024-01-02', 1), " +
                                "(2, '2024-01-03', 'In Progress', '2024-01-04', 1), " +
                                "(3, '2024-01-05', 'Done', '2024-01-06', 1), " +
                                "(4, '2024-01-07', 'Backlog', '2024-01-08', 2), " +
                                "(5, '2024-01-09', 'Next Up', '2024-01-10', 2), " +
                                "(6, '2024-01-11', 'Review', '2024-01-12', 3), " +
                                "(7, '2024-01-13', 'Completed', '2024-01-14', 3)");

                jdbcTemplate.execute(
                                "INSERT IGNORE INTO tasks (id, created_at, description, title, updated_at, list_id) VALUES "
                                                +
                                                "(1, '2024-01-01', 'Initial setup for Project Alpha', 'Setup', '2024-01-02', 1), "
                                                +
                                                "(2, '2024-01-03', 'Develop login module', 'Login Module', '2024-01-04', 2), "
                                                +
                                                "(3, '2024-01-05', 'Design homepage', 'Homepage Design', '2024-01-06', 2), "
                                                +
                                                "(4, '2024-01-07', 'Testing login module', 'Test Login', '2024-01-08', 3), "
                                                +
                                                "(5, '2024-01-09', 'Gather requirements for Project Beta', 'Requirements Gathering', '2024-01-10', 4), "
                                                +
                                                "(6, '2024-01-11', 'Implement user registration', 'User Registration', '2024-01-12', 5), "
                                                +
                                                "(7, '2024-01-13', 'Code review for registration module', 'Code Review', '2024-01-14', 6), "
                                                +
                                                "(8, '2024-01-15', 'Finalize documentation for Project Gamma', 'Documentation', '2024-01-16', 7)");

                jdbcTemplate.execute("SET session sql_mode=''");
        }
}

package io.github.sploit.projects.taskmanager;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import io.github.sploit.projects.taskmanager.common.configurations.LocaleProperties;

@Configuration
@EnableConfigurationProperties(LocaleProperties.class)
public class AppConfig {
}

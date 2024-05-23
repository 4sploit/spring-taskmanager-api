package io.github.sploit.projects.taskmanager.common.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "app.locale")
public class LocaleProperties {
    private String lang;
    private long cookieDurationInHours;
    private String basename;
    private boolean useMessageCodeAsDefaultMessage;
}

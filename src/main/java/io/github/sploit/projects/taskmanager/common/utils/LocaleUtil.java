package io.github.sploit.projects.taskmanager.common.utils;

import java.util.Locale;
import java.util.ResourceBundle;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import io.github.sploit.projects.taskmanager.common.configurations.LocaleProperties;

@Component
public class LocaleUtil {
    private final LocaleProperties localeProperties;

    public LocaleUtil(LocaleProperties localeProperties) {
        this.localeProperties = localeProperties;
    }

    public String getMessage(String key, @NonNull Locale locale) {
        ResourceBundle messages = ResourceBundle.getBundle(localeProperties.getBasename(), locale);
        return messages.getString(key);
    }

    public String getMessage(String key) {
        ResourceBundle messages = ResourceBundle.getBundle(localeProperties.getBasename(),
                Locale.forLanguageTag(localeProperties.getLang()));
        return messages.getString(key);
    }
}

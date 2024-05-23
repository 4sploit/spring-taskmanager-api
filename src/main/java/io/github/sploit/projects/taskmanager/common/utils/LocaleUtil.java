package io.github.sploit.projects.taskmanager.common.utils;

import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component
public class LocaleUtil {
    private final ReloadableResourceBundleMessageSource messageSource;

    public LocaleUtil(ReloadableResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(String messageCode) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(messageCode, null, locale);
    }
}

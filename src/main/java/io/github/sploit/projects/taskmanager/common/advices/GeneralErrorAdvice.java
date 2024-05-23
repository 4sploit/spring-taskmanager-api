package io.github.sploit.projects.taskmanager.common.advices;

import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.github.sploit.projects.taskmanager.common.constants.ErrorKeys;
import io.github.sploit.projects.taskmanager.common.constants.ErrorMessages;
import io.github.sploit.projects.taskmanager.common.errors.ApiError;
import io.github.sploit.projects.taskmanager.common.utils.LocaleUtil;

@RestControllerAdvice
public class GeneralErrorAdvice {
    private final LocaleUtil localeUtil;

    public GeneralErrorAdvice(LocaleUtil localeUtil) {
        this.localeUtil = localeUtil;
    }

    @ExceptionHandler(value = {DataAccessException.class})
    ResponseEntity<Object> generalErrorAdviceHandler(Exception ex) {
        Locale currentLocale = LocaleContextHolder.getLocale();
        return ResponseEntity.internalServerError().body(ApiError.builder()
                .key(localeUtil.getMessage(ErrorKeys.GENERAL_ERROR))
                .message(localeUtil.getMessage(ErrorMessages.GENERAL_ERROR, currentLocale))
                .build());
    }
}

package io.github.sploit.projects.taskmanager.common.advices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.github.sploit.projects.taskmanager.common.constants.ErrorTitles;
import io.github.sploit.projects.taskmanager.common.errors.GeneralError;

@RestControllerAdvice
public class GeneralErrorAdvice {
    Logger logger = LoggerFactory.getLogger(GeneralErrorAdvice.class);

    @ExceptionHandler(value = {DataAccessException.class})
	ResponseEntity<Object> generalErrorAdviceHandler(Exception ex) {
        logger.error(ErrorTitles.GENERAL, ex);

        return ResponseEntity.internalServerError()
                .body(
                    GeneralError.builder().build()
                );
	}
}

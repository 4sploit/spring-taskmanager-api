package io.github.sploit.projects.taskmanager.common.advices;

import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import io.github.sploit.projects.taskmanager.common.constants.ErrorKeys;
import io.github.sploit.projects.taskmanager.common.constants.ErrorMessages;
import io.github.sploit.projects.taskmanager.common.errors.ApiError;
import io.github.sploit.projects.taskmanager.common.errors.ErrorDetails;
import io.github.sploit.projects.taskmanager.common.utils.LocaleUtil;

@RestControllerAdvice
public class FieldNotValidAdvice {
        private final LocaleUtil localeUtil;

        public FieldNotValidAdvice(LocaleUtil localeUtil) {
                this.localeUtil = localeUtil;
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        ResponseEntity<ApiError> fieldNotValidAdviceHandler(MethodArgumentNotValidException ex) {
                Set<ErrorDetails> errors = ex.getBindingResult().getFieldErrors().stream()
                                .map(err -> ErrorDetails.builder().fieldName(err.getField())
                                                .message(err.getDefaultMessage()).build())
                                .collect(Collectors.toSet());

                return ResponseEntity.badRequest().body(ApiError.builder()
                                .key(localeUtil.getMessage(ErrorKeys.VALIDATION_ERROR))
                                .message(localeUtil.getMessage(ErrorMessages.VALIDATION_ERROR))
                                .errorDetails(errors).build());
        }
}

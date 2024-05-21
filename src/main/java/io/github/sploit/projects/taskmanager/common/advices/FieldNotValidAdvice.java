package io.github.sploit.projects.taskmanager.common.advices;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.github.sploit.projects.taskmanager.common.errors.ErrorDetails;
import io.github.sploit.projects.taskmanager.common.errors.ValidationError;

@RestControllerAdvice
public class FieldNotValidAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
	ResponseEntity<ValidationError> fieldNotValidAdviceHandler(MethodArgumentNotValidException ex) {
        ValidationError validationError = new ValidationError();

        Set<ErrorDetails> errors = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(err -> ErrorDetails.builder()
            .fieldName(err.getField())
            .message(err.getDefaultMessage())
            .build()
            ).collect(Collectors.toSet());
        
        validationError.setErrorDetails(errors);
        
        return ResponseEntity.badRequest().body(validationError);
	}
}

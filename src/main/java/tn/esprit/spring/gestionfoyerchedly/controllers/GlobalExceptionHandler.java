package tn.esprit.spring.gestionfoyerchedly.controllers;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, Object> handleNotFound(EntityNotFoundException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", "NotFound");
        body.put("message", ex.getMessage());
        return body;
    }

    @ExceptionHandler(ObjectOptimisticLockingFailureException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, Object> handleOptimistic(ObjectOptimisticLockingFailureException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", "OptimisticLock");
        body.put("message", ex.getMessage());
        return body;
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class, MethodArgumentNotValidException.class, DataIntegrityViolationException.class, IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleBadRequest(Exception ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", "BadRequest");
        body.put("message", ex.getMessage());
        return body;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handleGeneric(Exception ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", "ServerError");
        body.put("message", ex.getMessage());
        return body;
    }
}

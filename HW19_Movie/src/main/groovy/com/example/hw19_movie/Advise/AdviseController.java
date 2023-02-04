package com.example.hw19_movie.Advise;

import com.example.hw19_movie.ApiException.ApiException;
import jakarta.persistence.NonUniqueResultException;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class AdviseController {

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity ApiException(ApiException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }
//IllegalStateException

/*    @ExceptionHandler(value = IllegalStateException.class)
    public ResponseEntity IllegalStateException(IllegalStateException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }*/
//NonUniqueResultException

    @ExceptionHandler(value = NonUniqueResultException.class)
    public ResponseEntity NonUniqueResultException(NonUniqueResultException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }
    //UnsatisfiedDependencyException

    @ExceptionHandler(value = UnsatisfiedDependencyException.class)
    public ResponseEntity UnsatisfiedDependencyException(UnsatisfiedDependencyException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    // NullPointerException
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity NullPointerException(NullPointerException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }
    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ApiException>SQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(new ApiException(message));
    }


    // Server Validation Exception
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiException> MethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String message = e.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(new ApiException(message));
    }

    // Method not allowed Exception
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ApiException> HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        String message = e.getMessage();
        return ResponseEntity.status(400).body(new ApiException(message));
    }

}

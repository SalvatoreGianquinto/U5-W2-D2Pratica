package it.epicode.U5_W2_D2Pratica.exception;

import it.epicode.U5_W2_D2Pratica.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class PostExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError NotFoundExceptionHandler(NotFoundException e){
        ApiError apiError = new ApiError();
        apiError.setMessage(e.getMessage());
        apiError.setDataErrore(LocalDateTime.now());
        return apiError;
    }
}

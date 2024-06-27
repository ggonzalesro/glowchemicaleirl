package pe.glowchemicaleirl.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pe.glowchemicaleirl.exception.bean.ErrorMessage;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(RoleException.class)
    public ResponseEntity<?> rolNotAllowed(RoleException exception){
        ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(),HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);

    }

}

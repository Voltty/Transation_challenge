package picpay_challenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class InvalidUserException extends RuntimeException{
    private static long httpCode ;
    public InvalidUserException(String message, int httpCode) {
        super(message);
        this.httpCode = httpCode;
    }
}

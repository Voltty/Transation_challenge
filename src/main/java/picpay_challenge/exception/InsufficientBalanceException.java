package picpay_challenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class InsufficientBalanceException extends RuntimeException{
    public InsufficientBalanceException() {
        super("Not enough balance");
    }
}

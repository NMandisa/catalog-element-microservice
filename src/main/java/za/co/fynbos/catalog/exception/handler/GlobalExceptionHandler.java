package za.co.fynbos.catalog.exception.handler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import za.co.fynbos.catalog.response.ErrorDetailsResponse;

import java.time.LocalDateTime;

/**
 * @author Noxolo.Mkhungo
 */
@RestControllerAdvice(annotations ={RestController.class})
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetailsResponse> handleAllExceptions(Exception ex, WebRequest request) {
        ErrorDetailsResponse errorDetails = new ErrorDetailsResponse(LocalDateTime.now(),
                ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);//505

    }
}

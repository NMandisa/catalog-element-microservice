package za.co.fynbos.catalog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import za.co.fynbos.catalog.entity.ErrorResponseDetails;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorResponseDetails> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
        ErrorResponseDetails errorDetails = new ErrorResponseDetails(LocalDateTime.now(),
                ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(CatalogElementNotFoundException.class)
    public final ResponseEntity<ErrorResponseDetails> handleCatalogElementNotFoundException(Exception ex, WebRequest request) throws Exception {
        ErrorResponseDetails errorDetails = new ErrorResponseDetails(LocalDateTime.now(),
                ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);

    }
}

package za.co.fynbos.catalog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CatalogElementNotFoundException extends RuntimeException {
    public CatalogElementNotFoundException(String message) {
        super(message);
    }
}

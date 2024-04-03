package za.co.fynbos.catalog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CatalogElementNotFoundException extends RuntimeException implements Serializable {
    public CatalogElementNotFoundException(String message) {
        super("Catalog Element with "+ message +" Doesn't Exist");
    }
    public CatalogElementNotFoundException() {super();}
    public CatalogElementNotFoundException(String message, Throwable cause) {super(message,cause);}
}

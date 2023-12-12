package za.co.fynbos.catalog.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

/**
 * @author Noxolo.Mkhungo
 */
@MappedSuperclass
public abstract class Product {

    @Id
    @GeneratedValue
    private int id;
    public abstract Catalog getCatalog();
}

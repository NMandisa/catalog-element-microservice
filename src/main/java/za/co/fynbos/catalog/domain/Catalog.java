package za.co.fynbos.catalog.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.List;

/**
 * @author Noxolo.Mkhungo
 */
@MappedSuperclass
public abstract class Catalog {

    @Id
    @GeneratedValue
    private int id;

    public abstract List<? extends Product> getSaleProducts();
}

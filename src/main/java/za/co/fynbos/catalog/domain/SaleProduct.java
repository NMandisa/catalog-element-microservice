package za.co.fynbos.catalog.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * @author Noxolo.Mkhungo
 */
@Entity
public class SaleProduct extends Product{

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private ZACatalog catalog;
    @Override
    public ZACatalog getCatalog() {
        return catalog;
    }
}

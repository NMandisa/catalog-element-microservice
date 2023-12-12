package za.co.fynbos.catalog.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

/**
 * @author Noxolo.Mkhungo
 */
@Entity
public class ZACatalog extends Catalog{
    @OneToMany(mappedBy = "catalog")
    private List<SaleProduct> saleProducts;

    public  List<? extends Product> getSaleProducts() {
        return saleProducts;
    }
}

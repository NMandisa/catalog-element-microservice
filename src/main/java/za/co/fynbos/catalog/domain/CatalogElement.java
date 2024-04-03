package za.co.fynbos.catalog.domain;

import jakarta.persistence.*;
import za.co.fynbos.catalog.domain.enums.LifecycleStatus;

import java.io.Serializable;
@Entity
@Table(name = "tbl_catalog_element")
public class CatalogElement implements Serializable  {

    @Id
    @Column(name = "catalog_element_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lifecycle_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private LifecycleStatus status;

    public CatalogElement() {

    }

    public CatalogElement(LifecycleStatus status)
    {
        this.status=status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LifecycleStatus getStatus() {
        return status;
    }

    public void setStatus(LifecycleStatus status) {
        this.status = status;
    }
}

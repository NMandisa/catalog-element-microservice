package za.co.fynbos.catalog.dto;

import za.co.fynbos.catalog.domain.CatalogElement;
import za.co.fynbos.catalog.enums.LifecycleStatus;

public class CatalogElementUpdatedStatusDTO {

    private CatalogElement catalogElement;
    private LifecycleStatus oldStatus;
    private LifecycleStatus newStatus;

    public CatalogElementUpdatedStatusDTO(){
        super();
    }

    public CatalogElementUpdatedStatusDTO(CatalogElement catalogElement, LifecycleStatus oldStatus, LifecycleStatus newStatus){
        super();
        this.catalogElement=catalogElement;
        this.oldStatus =oldStatus;
        this.newStatus=newStatus;
    }

    @Override
    public String toString() {
        return "Catalog Element Updated Status" +
                "Catalog Element=" + catalogElement+
                ", Old Status=" + oldStatus +
                ", New Status=" + newStatus;
    }

    public CatalogElement getCatalogElement() {
        return catalogElement;
    }

    public void setCatalogElement(CatalogElement catalogElement) {
        this.catalogElement = catalogElement;
    }

    public LifecycleStatus getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(LifecycleStatus oldStatus) {
        this.oldStatus = oldStatus;
    }

    public LifecycleStatus getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(LifecycleStatus newStatus) {
        this.newStatus = newStatus;
    }
}

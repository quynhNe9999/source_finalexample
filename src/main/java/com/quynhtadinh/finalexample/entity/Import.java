package com.quynhtadinh.finalexample.entity;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Imports")
public class Import {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @Temporal(TemporalType.TIMESTAMP)
    private Date importDate;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "anImport")
    private Set<ImportDetail> importDetails;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Set<ImportDetail> getImportDetails() {
        return importDetails;
    }

    public void setImportDetails(Set<ImportDetail> importDetails) {
        this.importDetails = importDetails;
    }
}

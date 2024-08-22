package com.quynhtadinh.finalexample.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "import")
public class Import {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "import_id")
    private long import_id;
    @JoinColumn(name = "importDate")
    private Date importDate;
    @JoinColumn(name = "totalCost")
    private Float totalCost;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Suppliers supplier;

    public Suppliers getSupplier() {
        return supplier;
    }

    public void setSupplier(Suppliers supplier) {
        this.supplier = supplier;
    }

    public Float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Float totalCost) {
        this.totalCost = totalCost;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    public long getImport_id() {
        return import_id;
    }

    public void setImport_id(long import_id) {
        this.import_id = import_id;
    }

}


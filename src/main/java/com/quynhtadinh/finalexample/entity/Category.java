package com.quynhtadinh.finalexample.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateTao;
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "create_date", nullable = false)
//    private LocalDateTime createDate;

//    @ManyToOne
//    @JoinColumn(name = "supplier_id", nullable = false)
//    private Suppliers supplier;

}

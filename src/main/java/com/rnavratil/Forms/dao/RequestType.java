package com.rnavratil.Forms.dao;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "request_type")
@Table
public class RequestType {

    @Id
    @Column(
            name = "id", unique=true, nullable = false
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;

    @Size(min= 1, max= 30)
    @NotNull
    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;
}

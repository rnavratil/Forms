package com.rnavratil.Forms.dao;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name= "request_type")
@Table
public class RequestType {

    public RequestType() {
    }

    public RequestType(String name) {
        this.name = name;
    }

    @Id
    @Column(
            name = "id", unique = true, nullable = false
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Short id;

    @Size(min = 1, max = 30)
    @NotNull
    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

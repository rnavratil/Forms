package com.rnavratil.Forms.dao;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "request")
@Table
public class Request {

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

    @Size(min= 1, max= 30)
    @NotNull
    @Column(
        name = "name",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String surname;

    @NotNull
    @Column(
        name = "policy_number",
        nullable = false
    )
    private Integer policyNumber;

    @Size(min= 1, max= 5000)
    @NotNull
    @Column(
        name = "note",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String note;

    @NotNull
    @Column(
        name = "request_type_id",
        nullable = false
    )
    private Long requestTypeId;

    public Request() {
    }

    public Request(String name, String surname, Integer policyNumber, String note, Long requestTypeId) {
        this.name = name;
        this.surname = surname;
        this.policyNumber = policyNumber;
        this.note = note;
        this.requestTypeId = requestTypeId;
    }
}

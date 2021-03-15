package com.rnavratil.Forms.dao;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name= "request")
@Table
public class Request {


    @Id
    @Column(
            name = "id", unique = true, nullable = false
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
            name = "surname",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String surname;

    @NotNull
    @Column(
            name = "policy_number",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String policyNumber;

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

    public Request(String name, String surname, String policyNumber, String note, Long requestTypeId) {
        this.name = name;
        this.surname = surname;
        this.policyNumber = policyNumber;
        this.note = note;
        this.requestTypeId = requestTypeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getRequestTypeId() {
        return requestTypeId;
    }

    public void setRequestTypeId(Long requestTypeId) {
        this.requestTypeId = requestTypeId;
    }
}

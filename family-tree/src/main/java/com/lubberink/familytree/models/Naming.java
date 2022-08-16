package com.lubberink.familytree.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;


@Entity(name = "naming")
public class Naming implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "name_id", insertable = false, updatable = false )
    private Name name;

    @ManyToOne
    @JoinColumn(name = "nametype_id", insertable = false, updatable = false )
    private Nametype nametype;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "person_id", insertable = false, updatable = false)
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Nametype getNametype() {
        return nametype;
    }

    public void setNametype(Nametype nametype) {
        this.nametype = nametype;
    }
}

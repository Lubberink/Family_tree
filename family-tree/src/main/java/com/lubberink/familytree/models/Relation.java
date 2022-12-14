package com.lubberink.familytree.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lubberink.familytree.services.PersonService;

import javax.persistence.*;
import java.util.LinkedHashMap;
import java.util.Optional;

@Entity(name = "relation")
@JsonIgnoreProperties({"HibernateLazyInitializer", "handler"})
public class Relation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "person_id", insertable = false, updatable = false )
    private Person person;

    @ManyToOne
    @JoinColumn(name = "withperson_id", insertable = false, updatable = false)
    private Person withperson;

    @ManyToOne
    @JoinColumn(name = "relationtype_id", insertable = false, updatable = false )
    private RelationType relationtype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getWithPerson() {
        LinkedHashMap<String, Object> informationList = PersonInformation.getInstance().getInformationList();
        return PersonService.getPersonInformationString(withperson, informationList);
    }

    public void setWithperson(Person withperson) {
        this.withperson = withperson;
    }

    public RelationType getRelationtype() {
        return relationtype;
    }

    public void setRelationtype(RelationType relationtype) {
        this.relationtype = relationtype;
    }



    public Relation() {
    }


}

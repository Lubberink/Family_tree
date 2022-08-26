package com.lubberink.familytree.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "person")
@JsonIgnoreProperties({"HibernateLazyInitializer", "handler"})
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    char gender;

    @OneToMany(mappedBy = "person")
    private List<Relation> relations  = new ArrayList<>();

    @OneToMany(mappedBy = "withperson")
    private List<Relation> relations1  = new ArrayList<>();

    @OneToMany(mappedBy = "person")
    private List<Event> events = new ArrayList<>();

    @OneToMany(mappedBy = "person")
    private List<Naming> namings = new ArrayList<>();


    public Person(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public List<Relation> getRelations() {
        return relations;
    }

    public void setRelations(List<Relation> relations) {
        this.relations = relations;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Naming> getNamings() {
        return namings;
    }

    public void setNamings(List<Naming> namings) {
        this.namings = namings;
    }

    public List<Relation> getRelations1() {
        return relations1;
    }

    public void setRelations1(List<Relation> relations1) {
        this.relations1 = relations1;
    }
}

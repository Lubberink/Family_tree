package com.lubberink.familytree.services;

import com.lubberink.familytree.models.Name;
import com.lubberink.familytree.models.Naming;
import com.lubberink.familytree.models.Person;

import java.util.Optional;

public class NamingService {
    public NamingService() {
    }

    public static Optional<String> getNameByNameTypeForPerson(Person person, String nameTypeName){
        return person.getNamings().stream()
                .filter(naming -> naming.getNametype().getType().equals(nameTypeName))
                .map(Naming::getName)
                .map(Name::getName)
                .findFirst();
    }
}

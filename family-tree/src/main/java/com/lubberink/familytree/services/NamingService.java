package com.lubberink.familytree.services;

import com.lubberink.familytree.models.Name;
import com.lubberink.familytree.models.Naming;
import com.lubberink.familytree.models.Person;

public class NamingService {
    public NamingService() {
    }

    public static String getNameByTypeForPerson(Person person, String nameTypeName){
        return person.getNamings().stream()
                .filter(naming -> naming.getNametype().getType().equals(nameTypeName))
                .map(Naming::getName)
                .map(Name::getName)
                .findFirst().orElse("");
    }
}

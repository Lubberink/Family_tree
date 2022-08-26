package com.lubberink.familytree.services;

import com.lubberink.familytree.models.Event;
import com.lubberink.familytree.models.Naming;
import com.lubberink.familytree.models.Person;
import com.lubberink.familytree.models.PersonInformation;
import com.lubberink.familytree.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors;

public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public static String getPersonInformationString(Person person, LinkedHashMap<String, Object> informationList ){
       ArrayList<Optional> names = informationList.entrySet().stream()
                .collect(ArrayList::new, (set, entry) ->
                                set.add(entry.getValue() == Naming.class ?
                                        NamingService.getNameByNameTypeForPerson(person, entry.getKey()) : entry.getValue() == Event.class
                                        ? EventService.getEventDateByEventTypeForPerson(person, entry.getKey()) : null),
                        ArrayList::addAll);

       return names.stream()
               .filter(Optional::isPresent)
               .map(Optional::get)
               .map(Object::toString)
               .collect(Collectors.joining(", "));
    }

    public static List<String> getAllPersonsAsString(List<Person> personList, LinkedHashMap<String, Object> personAsStringInformationVisible){
        return personList.stream()
                .collect(ArrayList::new, (set, person) -> set.add(getPersonInformationString(person, personAsStringInformationVisible)), ArrayList::addAll);
    }
}

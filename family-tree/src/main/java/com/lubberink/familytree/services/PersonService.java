package com.lubberink.familytree.services;

import com.lubberink.familytree.models.Event;
import com.lubberink.familytree.models.Naming;
import com.lubberink.familytree.models.Person;
import com.lubberink.familytree.models.PersonInformation;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonService {

    public static String getPersonInformationString(Person person){
        LinkedHashMap<String, Object> informationList = PersonInformation.getInstance().getInformationList();

        List<String> infoString = informationList.entrySet().stream()
                .collect(ArrayList::new, (set, entry) ->
                                set.add(entry.getValue() == Naming.class ?
                                        NamingService.getNameByTypeForPerson(person, entry.getKey()) : entry.getValue() == Event.class
                                        ? EventService.getEventDateByEventTypeForPersonAsString(person, entry.getKey()) : ""),
                        ArrayList::addAll);
        return String.join(", ", infoString);
    }

}

package com.lubberink.familytree.services;

import com.lubberink.familytree.models.Event;
import com.lubberink.familytree.models.Name;
import com.lubberink.familytree.models.Naming;
import com.lubberink.familytree.models.Person;

import java.util.Date;
import java.util.Optional;

public class EventService {


    public EventService() {
    }

    public static Optional<Date> getEventDateByEventTypeForPerson(Person person, String eventTypeName){
        return person.getEvents().stream()
                .filter(event -> event.getEventtype().getType().equals(eventTypeName))
                .map(Event::getEventdate)
                .findFirst();
    }
}

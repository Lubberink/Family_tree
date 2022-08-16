package com.lubberink.familytree.services;

import com.lubberink.familytree.models.Event;
import com.lubberink.familytree.models.Name;
import com.lubberink.familytree.models.Naming;
import com.lubberink.familytree.models.Person;

import java.util.Date;

public class EventService {


    public EventService() {
    }

    public static Date getEventDateByEventTypeForPersonAsDate(Person person, String eventTypeName){
        return person.getEvents().stream()
                .filter(event -> event.getEventtype().getType().equals(eventTypeName))
                .map(Event::getEventdate)
                .findFirst().orElse(null);
    }

    public static String getEventDateByEventTypeForPersonAsString(Person person, String eventTypeName){
        String eventDate = getEventDateByEventTypeForPersonAsDate(person, eventTypeName).toString();
        return eventDate.equals("null") ? "" : eventDate;
    }
}

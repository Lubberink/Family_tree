package com.lubberink.familytree.models;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class PersonInformation {

    private static PersonInformation personInformation;

    private LinkedHashMap<String, Object> informationList;
    private LinkedHashMap<String, Object> personAsStringInformationVisible;

    public PersonInformation() {
        informationList = new LinkedHashMap<>();
        informationList.put("Voornaam", Naming.class);
        informationList.put("Achternaam", Naming.class);
        informationList.put("Geheime naam", Event.class);
        informationList.put("Geboorte", Event.class);

        personAsStringInformationVisible = new LinkedHashMap<>();
        personAsStringInformationVisible.put("Voornaam", Naming.class);
        personAsStringInformationVisible.put("Achternaam", Naming.class);
        personAsStringInformationVisible.put("Geboorte", Event.class);
    }

    public static PersonInformation getInstance(){
        if(personInformation == null){
            personInformation = new PersonInformation();
        }
        return personInformation;
    }

    public static PersonInformation getPersonInformation() {
        return personInformation;
    }

    public static void setPersonInformation(PersonInformation personInformation) {
        PersonInformation.personInformation = personInformation;
    }

    public LinkedHashMap<String, Object> getInformationList() {
        return informationList;
    }

    public void setInformationList(LinkedHashMap<String, Object> informationList) {
        this.informationList = informationList;
    }

    public LinkedHashMap<String, Object> getPersonAsStringInformationVisible() {
        return personAsStringInformationVisible;
    }

    public void setPersonAsStringInformationVisible(LinkedHashMap<String, Object> personAsStringInformationVisible) {
        this.personAsStringInformationVisible = personAsStringInformationVisible;
    }
}

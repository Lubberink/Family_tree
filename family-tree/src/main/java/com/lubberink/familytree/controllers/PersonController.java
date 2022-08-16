package com.lubberink.familytree.controllers;

import com.lubberink.familytree.models.Person;
import com.lubberink.familytree.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public List<Person> list(){
        return personRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = GET)
    @ResponseBody
    public Optional<Person> getPersonById(
            @PathVariable("id") long id){
        return personRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person create(@RequestBody final Person person){
        return personRepository.saveAndFlush(person);
    }
}

package com.lubberink.familytree.controllers;

import com.lubberink.familytree.models.Naming;
import com.lubberink.familytree.models.Person;
import com.lubberink.familytree.repositories.NamingRepository;
import com.lubberink.familytree.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/api/v1/naming")
public class NamingController {
    @Autowired
    private NamingRepository namingRepository;

    @GetMapping
    public List<Naming> list(){
        return namingRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = GET)
    @ResponseBody
    public Optional<Naming> getPersonById(
            @PathVariable("id") long id){
        return namingRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Naming create(@RequestBody final Naming naming){
        return namingRepository.saveAndFlush(naming);
    }

}

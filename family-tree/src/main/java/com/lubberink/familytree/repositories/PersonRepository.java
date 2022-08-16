package com.lubberink.familytree.repositories;

import com.lubberink.familytree.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}

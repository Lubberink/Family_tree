package com.lubberink.familytree.repositories;

import com.lubberink.familytree.models.Naming;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NamingRepository extends JpaRepository<Naming, Long> {
}

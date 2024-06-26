package com.progra.examen.repositories;


import com.progra.examen.entities.Authority;
import com.progra.examen.entities.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    public Authority findByName(AuthorityName name);
}
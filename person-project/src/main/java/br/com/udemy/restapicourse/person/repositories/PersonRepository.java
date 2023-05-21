package br.com.udemy.restapicourse.person.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.udemy.restapicourse.person.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{}

package br.com.udemy.restapicourse.person.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.udemy.restapicourse.person.models.Person;


public interface PersonRepository extends JpaRepository<Person, Long>{}

package br.com.udemy.restapicourse.person.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.udemy.restapicourse.person.data.vo.v1.PersonVO;
import br.com.udemy.restapicourse.person.data.vo.v2.PersonVOV2;
import br.com.udemy.restapicourse.person.services.PersonServices;



@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO findById(@PathVariable(value = "id") Long id) {
           return service.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonVO> findAll() {
           return service.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO create(@RequestBody PersonVO PersonVO) {
           return service.create(PersonVO);
    }

    @PostMapping(value = "/v2", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVOV2 createV2(@RequestBody PersonVOV2 PersonVOV2) {
           return service.createV2(PersonVOV2);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO update(@RequestBody PersonVO person) {
           return service.update(person);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") Long id) {
           service.delete(id);
    }
    

}


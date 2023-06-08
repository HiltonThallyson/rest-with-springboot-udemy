package br.com.udemy.restapicourse.person.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.udemy.restapicourse.person.data.vo.v1.PersonVO;
import br.com.udemy.restapicourse.person.exceptions.ResourceNotFoundException;
import br.com.udemy.restapicourse.person.mapper.MapStructMapper;
import br.com.udemy.restapicourse.person.models.Person;
import br.com.udemy.restapicourse.person.repositories.PersonRepository;

@Service
public class PersonServices {
    
    private Logger logger =  Logger.getLogger(PersonServices.class.getName());
    
    @Autowired
    private MapStructMapper mapper;

    @Autowired
    PersonRepository repository;

    public PersonVO findById(Long id) {
        logger.info("Finding one PersonVO!");
        
        return mapper.personToPersonVO(repository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("No records found for this id!")));
        
    }

    public List<PersonVO> findAll() {
        
        logger.info("Finding every PersonVO!");
        
        return mapper.listOfPersonToListOfPersonVO(repository.findAll());
    }

    public PersonVO create(PersonVO personVO) {
        logger.info("Creating one PersonVO!");
        Person person = mapper.personVOtoPerson(personVO);
        person = repository.save(person);
        personVO = mapper.personToPersonVO(person);
        return personVO;
    }

    public PersonVO update(PersonVO personVO) {
        logger.info("Updating one PersonVO!");

        Person entity = repository.findById(personVO.getId()).orElseThrow(
            () -> new ResourceNotFoundException("No records found for this ID!")
        );
        
        entity = mapper.personVOtoPerson(personVO);
        entity = repository.save(entity);
        
        return mapper.personToPersonVO(entity);
    }

    public void delete(Long id) {
        logger.info("Deleting one PersonVO!");

        Person entity = repository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("No records found for this ID!")
        );

        repository.delete(entity);
    }

    
}

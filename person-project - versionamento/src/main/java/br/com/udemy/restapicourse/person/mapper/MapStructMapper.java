package br.com.udemy.restapicourse.person.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.udemy.restapicourse.person.data.vo.v1.PersonVO;
import br.com.udemy.restapicourse.person.models.Person;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MapStructMapper {

    MapStructMapper INSTANCE = Mappers.getMapper(MapStructMapper.class);
    
    Person personVOtoPerson(PersonVO personVO);

    @InheritInverseConfiguration
    PersonVO personToPersonVO(Person person);

    List<Person> listOfPersonVOToListOfPerson(List<PersonVO> listOfPersonVO);

    @InheritInverseConfiguration
    List<PersonVO> listOfPersonToListOfPersonVO(List<Person> listOfPerson);
        
    
}

package br.com.udemy.restapicourse.person.mapper.v2;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.udemy.restapicourse.person.data.vo.v2.PersonVOV2;
import br.com.udemy.restapicourse.person.models.Person;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MapStructMapperV2 {

    MapStructMapperV2 INSTANCE = Mappers.getMapper(MapStructMapperV2.class);
    
    Person personVOV2toPerson(PersonVOV2 personVOV2);

    @InheritInverseConfiguration
    PersonVOV2 personToPersonVOV2(Person person);

    List<Person> listOfPersonVOV2ToListOfPerson(List<PersonVOV2> listOfPersonVOV2);

    @InheritInverseConfiguration
    List<PersonVOV2> listOfPersonToListOfPersonVOV2(List<Person> listOfPerson);
        
    
}

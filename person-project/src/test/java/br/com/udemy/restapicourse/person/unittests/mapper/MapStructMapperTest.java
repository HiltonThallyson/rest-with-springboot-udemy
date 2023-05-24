package br.com.udemy.restapicourse.person.unittests.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.udemy.restapicourse.person.data.vo.v1.PersonVO;
import br.com.udemy.restapicourse.person.mapper.MapStructMapper;
import br.com.udemy.restapicourse.person.models.Person;
import br.com.udemy.restapicourse.person.unittests.mapper.mocks.MockPerson;

public class MapStructMapperTest {
    
    MockPerson inputObject;

    MapStructMapper mapper;

    @BeforeEach
    public void setUp() {
        inputObject = new MockPerson();
        mapper = MapStructMapper.INSTANCE;
    }

    @Test
    public void parseEntityToVOTest() {
        PersonVO output = mapper.personToPersonVO(inputObject.mockEntity(0));
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Test0", output.getFirstName());
        assertEquals("Last Name Test0", output.getLastName());
        assertEquals("Address Test0", output.getAddress());
        assertEquals("Male", output.getGender());
    }

    @Test
    public void parseVOToEntityTest() {
        Person output = mapper.personVOtoPerson(inputObject.mockVO(0));
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Test0", output.getFirstName());
        assertEquals("Last Name Test0", output.getLastName());
        assertEquals("Address Test0", output.getAddress());
        assertEquals("Male", output.getGender());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<PersonVO> outputList = mapper.listOfPersonToListOfPersonVO(inputObject.mockEntityList());
        PersonVO outputZero = outputList.get(0);
        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Test0", outputZero.getFirstName());
        assertEquals("Last Name Test0", outputZero.getLastName());
        assertEquals("Address Test0", outputZero.getAddress());
        assertEquals("Male", outputZero.getGender());
    }

    @Test
    public void parseVOListToEntityListTest() {
        List<Person> outputList = mapper.listOfPersonVOToListOfPerson(inputObject.mockVOList());
        Person outputZero = outputList.get(0);
        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Test0", outputZero.getFirstName());
        assertEquals("Last Name Test0", outputZero.getLastName());
        assertEquals("Address Test0", outputZero.getAddress());
        assertEquals("Male", outputZero.getGender());
    }
}

package com.example.person.converter;

import com.example.person.dto.PersonDto;
import com.example.person.model.Person;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonDtoToPersonConverter implements Converter<PersonDto, Person> {
    @Override
    public Person convert(PersonDto personDto) {
        Person person = new Person();

        person.setId(personDto.getId());
        person.setName(personDto.getName());

        return person;
    }
}

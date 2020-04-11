package com.example.person.converter;

import com.example.person.dto.PersonDto;
import com.example.person.model.Person;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonToPersonDtoConverter implements Converter<Person, PersonDto> {
    @Override
    public PersonDto convert(Person person) {
        PersonDto personDto = new PersonDto();

        personDto.setId(person.getId());
        personDto.setName(person.getName());

        return personDto;
    }
}
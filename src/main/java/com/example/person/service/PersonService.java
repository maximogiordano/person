package com.example.person.service;

import com.example.person.dto.PageDto;
import com.example.person.dto.PersonDto;
import com.example.person.exception.PersonFetchException;
import com.example.person.exception.PersonNameAlreadyExistsException;
import com.example.person.exception.PersonNotFoundException;
import com.example.person.model.Person;
import com.example.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private ConversionService conversionService;

    public PersonDto create(PersonDto personDto) {
        if (personRepository.findByName(personDto.getName()).isPresent()) {
            throw new PersonNameAlreadyExistsException();
        }

        Person person = conversionService.convert(personDto, Person.class);
        person = personRepository.save(person);

        return conversionService.convert(person, PersonDto.class);
    }

    public PersonDto read(Long id) {
        return personRepository.findById(id)
                .map(person -> conversionService.convert(person, PersonDto.class))
                .orElseThrow(PersonNotFoundException::new);
    }

    public List<PersonDto> read(PageDto pageDto) {
        PageRequest pageRequest = PageRequest.of(pageDto.getPage(), pageDto.getSize(), Sort.by(pageDto.getSortedBy()));

        try {
            return personRepository.findAll(pageRequest)
                    .map(person -> conversionService.convert(person, PersonDto.class))
                    .getContent();
        } catch (Exception e) {
            throw new PersonFetchException(e);
        }
    }

    public PersonDto update(Long id, PersonDto personDto) {
        Person person = personRepository.findById(id)
                .orElseThrow(PersonNotFoundException::new);

        Optional<Person> personByNameOptional = personRepository.findByName(personDto.getName());

        if (personByNameOptional.isPresent() && !personByNameOptional.get().equals(person)) {
            throw new PersonNameAlreadyExistsException();
        }

        person.setName(personDto.getName());
        person = personRepository.save(person);

        return conversionService.convert(person, PersonDto.class);
    }

    public void delete(Long id) {
        if (!personRepository.findById(id).isPresent()) {
            throw new PersonNotFoundException();
        }

        personRepository.deleteById(id);
    }
}

package com.example.person.controller;

import com.example.person.dto.PageDto;
import com.example.person.dto.PersonDto;
import com.example.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("/persons")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDto create(@Valid @RequestBody PersonDto personDto) {
        return personService.create(personDto);
    }

    @GetMapping("/persons/{id}")
    public PersonDto read(@PathVariable Long id) {
        return personService.read(id);
    }

    @GetMapping("/persons")
    public List<PersonDto> read(@Valid PageDto pageDto) {
        return personService.read(pageDto);
    }

    @PutMapping("/persons/{id}")
    public PersonDto update(@PathVariable Long id, @Valid @RequestBody PersonDto personDto) {
        return personService.update(id, personDto);
    }

    @DeleteMapping("/persons/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        personService.delete(id);
    }
}

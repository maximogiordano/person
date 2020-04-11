package com.example.person.model;

import com.example.person.utils.Utils;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true, length = Utils.MAX_NAME)
    private String name;
}

package com.example.person.dto;

import com.example.person.utils.Utils;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Data
public class PersonDto {
    @Null
    private Long id;

    @NotBlank
    @Size(max = Utils.MAX_NAME)
    private String name;
}

package com.example.person.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class PageDto {
    @NotNull
    @Min(0)
    private Integer page;

    @NotNull
    @Min(1)
    private Integer size;

    @NotNull
    @Pattern(regexp = "id|name")
    private String sortedBy;
}

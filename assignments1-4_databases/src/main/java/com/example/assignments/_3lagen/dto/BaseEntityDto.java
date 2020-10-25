package com.example.assignments._3lagen.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class BaseEntityDto {

    private Long id;

    private LocalDateTime created;

    private LocalDateTime lastModified;
}

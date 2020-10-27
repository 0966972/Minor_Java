package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RekeningDto {
    @NotNull
    private String iban;
    @Min(value = 0)
    private float saldo;
    @NotNull
    private boolean geblokkeerd;
}

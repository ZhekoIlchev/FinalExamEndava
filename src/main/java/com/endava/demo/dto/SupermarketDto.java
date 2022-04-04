package com.endava.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class SupermarketDto {

    @NotBlank(message = "Name is required field.")
    private String name;

    @NotBlank(message = "Address is required field.")
    private String address;

    private String phoneNumber;

    private String workHours;
}
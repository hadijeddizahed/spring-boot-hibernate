package me.hadi.springboothibernate.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {

    private String name;
    private String lastName;
    private String email;
    private AddressDto address;
}

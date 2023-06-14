package com.arc.springbootblogarc.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDTO {
    private Long id;

    @NotEmpty(message = "Must enter your first name.")
    private String firstName;

    @NotEmpty(message = "Must enter your last name.")
    private String lastName;

    @NotEmpty(message = "Must enter an email address.")
    @Email
    private String email;

    @NotEmpty(message = "Must enter a password.")
    private String password;
}

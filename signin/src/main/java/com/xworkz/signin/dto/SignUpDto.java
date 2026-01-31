package com.xworkz.signin.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class SignUpDto {

    private String name;
    private String surname;
    private long phoneNumber;
    private String email;
    private String username;
    private String password;
    private String confirmPassword;

}

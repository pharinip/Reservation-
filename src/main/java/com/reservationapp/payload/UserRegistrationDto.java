package com.reservationapp.payload;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationDto {

    private long id;

    private String name;

    private String email;

    private String password;


    private byte[] profilePicture;
}

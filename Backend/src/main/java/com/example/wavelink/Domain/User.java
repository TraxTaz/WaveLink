package com.example.wavelink.Domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class User {

    private Long id;
    private String userName;
    private String password;
    private String bio;
}

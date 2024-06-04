package com.example.wavelink.Persistence.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "Users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @NotBlank
    @NotNull
    @Length (min = 4, max = 20)
    @Column(name = "username")
    private String username;

    @NotBlank
    @NotNull
    @Length(min = 8, max = 30)
    @Column(name = "password")
    private String password;

    @NotBlank
    @NotNull
    @Length(min = 4, max = 150)
    @Column(name = "bio")
    private String bio;
}

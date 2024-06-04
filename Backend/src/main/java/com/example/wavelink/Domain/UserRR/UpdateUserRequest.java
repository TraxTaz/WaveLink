package com.example.wavelink.Domain.UserRR;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UpdateUserRequest {

    @NotNull
    @Min(1)
    @Max(1000000)
    private Long id;

    @NotBlank
    private String userName;

    @NotBlank
    private String password;
}

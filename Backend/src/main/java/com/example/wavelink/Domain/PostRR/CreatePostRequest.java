package com.example.wavelink.Domain.PostRR;


import com.example.wavelink.Domain.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@Builder
public class CreatePostRequest {

    @NotBlank
    private String description;
    @NotNull
    private User user;
}
